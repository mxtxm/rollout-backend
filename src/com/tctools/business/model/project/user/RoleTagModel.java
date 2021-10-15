package com.tctools.business.model.project.user;

import com.tctools.business.dto.project.workflow.user.*;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.*;


public class RoleTagModel {

    public static ResponseMessage insertRoleTag(Params params) throws InputException, ServerException {
        return CommonModelMongo.insert(params, new RoleTag());
    }

    public static ResponseMessage updateRoleTag(Params params) throws InputException, ServerException {
        return CommonModelMongo.update(params, new RoleTag());
    }

    public static Object getRoleTag(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAll(params, new RoleTag());
    }

    public static ResponseMessage insertSubRoleTag(Params params) throws InputException, ServerException {
        return CommonModelMongo.insert(params, new SubRoleTag());
    }

    public static ResponseMessage updateSubRoleTag(Params params) throws InputException, ServerException {
        return CommonModelMongo.update(params, new SubRoleTag());
    }

    public static Object getSubRoleTag(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAll(params, new SubRoleTag());
    }
}
