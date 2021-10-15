package com.tctools.business.dto.user;

import com.tctools.common.Param;
import com.vantar.database.dto.*;
import com.vantar.service.auth.*;
import com.vantar.util.datetime.DateTime;
import com.vantar.util.file.FileUtil;
import com.vantar.util.string.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.*;

@Cache
@Mongo
@DeleteLogical
@Storage("users")
@Index({"username:1"})
public class User extends DtoBase implements CommonUser {

    public static final String EXTRA_UNREAD_MESSAGE_COUNT = "unreadMessageCount";

    public Long id;

    @Default("ENABLED")
    @Required
    public AccessStatus accessStatus;
    @Default("NewProda")
    @Required
    public AuthenticationType authenticationType;

    @Default("USER")
    @Required
    public Role role;
    public List<String> roleTags;

    @Required
    public String username;
    public String password;

    @Required
    public String firstName;
    @Required
    public String lastName;
    @Tags("none")
    public String fullName;
    public String email;
    public String mobile;

    public String organization;
    public String organizationRole;

    @PresentBy("Province")
    public List<Long> provinceIds;

    @CreateTime
    @Timestamp
    @Tags("none")
    public DateTime createT;
    @UpdateTime
    @Timestamp
    @Tags("none")
    public DateTime signinT;

    public String avatar;
    public String photo;

    public List<Map<String, String>> ability;
    public Map<String, String> extras;

    @NoStore
    public String accessToken;
    private boolean siginingIn;


    @Override
    public void afterFetchData() {
        if (Thread.currentThread().getStackTrace().length > 8
            && Thread.currentThread().getStackTrace()[7].getClassName().endsWith("ServiceDtoCache")) {
            return;
        }
        if (!siginingIn) {
            password = "";
        }
    }

    public boolean beforeInsert() {
        ability = new ArrayList<>(1);
        Map<String, String> abilityItem = new HashMap<>(2);
        abilityItem.put("action", "manage");
        abilityItem.put("subject", "all");
        ability.add(abilityItem);

        return beforeUpdate();
    }

    public boolean beforeUpdate() {
        avatar = getAvatarUrl();
        photo = getPhotoUrl();

        if (StringUtil.isNotEmpty(password)) {
            password = DigestUtils.sha1Hex(password);
        }
        if (firstName != null && lastName != null) {
            fullName = firstName + ' ' + lastName;
        }
        return true;
    }

    @Override
    public boolean passwordEquals(String password) {
        return this.password.equals(DigestUtils.sha1Hex(password));
    }

    @Override
    public void setToken(String token) {
        this.accessToken = token;
    }

    @Override
    public String getToken() {
        return accessToken;
    }

    @Override
    public AccessStatus getAccessStatus() {
        return accessStatus;
    }

    @Override
    public void nullPassword() {
        password = null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public CommonUserRole getRole() {
        return role;
    }

    @Override
    public void setSigningIn() {
        siginingIn = true;
    }

    public static User getTemporaryRoot() {
        User dummy = new User();
        dummy.id = 1L;
        dummy.role = Role.ROOT;
        dummy.accessStatus = AccessStatus.ENABLED;
        dummy.firstName = "Dummy";
        dummy.lastName = "Root";
        dummy.fullName = "Dummy Root";
        dummy.email = "dummy@root.com";
        dummy.mobile = "12345678";
        dummy.username = "root";
        dummy.password = "root";
        dummy.createT = new DateTime();
        dummy.signinT = new DateTime();
        return dummy;
    }

    public String getAvatarPath() {
        return id == null ? null : Param.USER_FILES + id + "/" + id + "-thumb.jpg";
    }

    public String getPhotoPath() {
        return id == null ? null : Param.USER_FILES + id + "/" + id + "-photo.jpg";
    }

    private String getAvatarUrl() {
        if (id == null || !FileUtil.exists(getAvatarPath())) {
            return null;
        }
        return Param.USERS_URL + id  + "/" + id + "-thumb.jpg";
    }

    private String getPhotoUrl() {
        if (id == null || !FileUtil.exists(getPhotoPath())) {
            return null;
        }
        return Param.USERS_URL + id  + "/" + id + "-photo.jpg";
    }
}
