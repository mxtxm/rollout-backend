package com.tctools.business.model.user;

import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.service.log.dto.UserLog;
import com.vantar.web.Params;


public class UserLogModel {

    public static UserLog getUserById(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.getById(params, new UserLog());
    }

    public static Object search(Params params) throws InputException, ServerException, NoContentException {
        UserLog log = new UserLog();
        return CommonModelMongo.search(params, log, log);
    }
}