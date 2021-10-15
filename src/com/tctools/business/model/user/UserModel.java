package com.tctools.business.model.user;

import com.tctools.business.dto.user.Role;
import com.tctools.business.dto.user.*;
import com.tctools.common.Param;
import com.tctools.common.util.ImageEdit;
import com.vantar.business.*;
import com.vantar.database.common.ValidationError;
import com.vantar.database.dto.Dto;
import com.vantar.database.nosql.mongo.*;
import com.vantar.database.query.QueryBuilder;
import com.vantar.exception.*;
import com.vantar.locale.VantarKey;
import com.vantar.service.Services;
import com.vantar.service.cache.ServiceDtoCache;
import com.vantar.web.*;
import java.util.*;


public class UserModel {

    public static ResponseMessage insert(Params params) throws ServerException, InputException {
        User user = new User();
        user.setExclude("emailVerified", "mobileVerified", "createT", "signinT");
        return CommonModelMongo.insert(params, user);
    }

    public static ResponseMessage update(Params params, User creator) throws ServerException, InputException {
        User user = new User();
        user.setExclude(
            creator.role.equals(Role.ADMIN) ?
                new String[] {"emailVerified", "mobileVerified", "createT", "signinT",} :
                new String[] {"role", "emailVerified", "mobileVerified", "createT", "signinT",}
        );
        return CommonModelMongo.update(params, user, new CommonModel.WriteEvent() {
            @Override
            public void beforeWrite(Dto dto) {
                User u = (User) dto;
                if (u.id == null) {
                    dto.setId(creator.id);
                }
            }

            @Override
            public void afterWrite(Dto dto) {

            }
        });
    }

    public static ResponseMessage delete(Params params) throws ServerException, InputException {
        User user = new User();
        return CommonModelMongo.delete(params, user);
    }

    public static void updateExtras(long userId, String key, Object value) throws ServerException {
        ServiceDtoCache cache = Services.get(ServiceDtoCache.class);
        if (cache == null) {
            throw new ServiceException(ServiceDtoCache.class);
        }

        User user = cache.getDto(User.class, userId);
        if (user.extras == null) {
            user.extras = new HashMap<>();
        }
        user.extras.put(key, value.toString());

        try {
            user.password = null;
            Mongo.update(user);
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.UPDATE_FAIL);
        }
    }

    public static User getUserById(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.getById(params, new User());
    }

    public static Object search(Params params) throws InputException, ServerException, NoContentException {
        User user = new User();
        return CommonModelMongo.search(params, user, user);
    }

    public static List<User> getAll(Params params) throws ServerException, NoContentException {
        QueryBuilder q = new QueryBuilder(new User());
        q.condition().equal("accessStatus", "ENABLED");
        return CommonModelMongo.getData(params, q);
    }

    public static Map<String, String> getAsKeyValue(Params param) throws ServerException, NoContentException {
        QueryBuilder q = new QueryBuilder(new User());
        q.condition().equal("accessStatus", "ENABLED");
        try {
            return MongoSearch.getData(q).setLocale(param.getLang()).asKeyValue("id", "fullName");
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.FETCH_FAIL);
        }
    }

    public static ResponseMessage submitAvatar(Params params, User user) throws InputException, ServerException {
        Params.Uploaded uploaded = params.upload(Param.FILE_UPLOAD);
        if (!uploaded.isUploaded() || uploaded.isIoError()) {
            throw new InputException(uploaded.getError());
        }

        List<ValidationError> errors = new ArrayList<>(2);
        if (!uploaded.isType("jpeg")) {
            errors.add(new ValidationError(Param.FILE_UPLOAD, VantarKey.FILE_TYPE, "jpg"));
        }
        if (uploaded.getSize() < Param.FILE_USER_IMAGE_MIN_SIZE || uploaded.getSize() > Param.FILE_USER_IMAGE_MAX_SIZE) {
            errors.add(
                new ValidationError(
                    Param.FILE_UPLOAD,
                    VantarKey.FILE_SIZE,
                    Param.FILE_USER_IMAGE_MIN_SIZE /1024 + "KB ~ " + Param.FILE_USER_IMAGE_MAX_SIZE /1024 + "KB"
                )
            );
        }
        if (!errors.isEmpty()) {
            throw new InputException(errors);
        }

        String photoPath = user.getPhotoPath();
        if (uploaded.moveTo(photoPath)) {
            ImageEdit.resize(photoPath, user.getAvatarPath(), Param.USER_IMAGE_SMALL_WIDTH);
        }

        try {
            user.password = null;
            CommonRepoMongo.update(user);
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.UPDATE_FAIL);
        }

        return new ResponseMessage(VantarKey.UPDATE_SUCCESS, user.avatar);
    }
}