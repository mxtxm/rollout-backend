package com.tctools.business.model.user;

import com.tctools.business.dto.user.Role;
import com.tctools.business.dto.user.*;
import com.vantar.business.CommonRepoMongo;
import com.vantar.database.common.ValidationError;
import com.vantar.exception.*;
import com.vantar.locale.VantarKey;
import com.vantar.service.Services;
import com.vantar.service.auth.ServiceAuth;
import com.vantar.util.object.ObjectUtil;
import com.vantar.util.string.StringUtil;
import com.vantar.web.*;


public class AuthModel {

    public static User signin(Params params) throws AuthException, ServerException {
        User user = (User) Services.get(ServiceAuth.class).signin(params);

        return user;
    }

    public static void signout(Params params) {
        Services.get(ServiceAuth.class).signout(params);
    }

    public static User getCurrentUser(Params params) throws NoContentException, ServerException {
        return (User) ServiceAuth.getCurrentSignedInUser(params);
    }

    public static ResponseMessage changePassword(Params params, User user) throws InputException, ServerException, AuthException {
        Long id = params.getLong("id");
        if (ObjectUtil.isIdValid(id)) {
            if (user.role == Role.MANAGER || user.role == Role.ADMIN || user.role == Role.ROOT) {
                user.id = id;
            } else {
                throw new AuthException(VantarKey.NO_ACCESS);
            }
        }

        User u = new User();
        u.id = user.id;
        u.password = params.getString("password");
        if (StringUtil.isEmpty(u.password)) {
            throw new InputException(new ValidationError("password", VantarKey.REQUIRED));
        }

        try {
            CommonRepoMongo.update(user);
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.UPDATE_FAIL);
        }
        return new ResponseMessage(VantarKey.UPDATE_SUCCESS);
    }
}