package com.tctools.business.model.project;

import com.tctools.business.dto.project.RolloutProject;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.*;


public class ProjectModel {

    public static ResponseMessage insert(Params params) throws InputException, ServerException {
        return CommonModelMongo.insertJson(params, new RolloutProject());
    }

    public static ResponseMessage update(Params params) throws InputException, ServerException {
        return CommonModelMongo.updateJson(params, new RolloutProject());
    }

    public static ResponseMessage delete(Params params) throws InputException, ServerException {
        return CommonModelMongo.delete(params, new RolloutProject());
    }

    public static RolloutProject.Viewable getById(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.getById(params, new RolloutProject.Viewable());
    }

    public static Object search(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.search(params, new RolloutProject(), new RolloutProject.Viewable());
    }
}
