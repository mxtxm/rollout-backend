package com.tctools.business.model.project.user;

import com.tctools.business.dto.project.workflow.user.ProjectUser;
import com.tctools.business.dto.user.User;
import com.vantar.business.*;
import com.vantar.database.query.QueryBuilder;
import com.vantar.exception.*;
import com.vantar.locale.VantarKey;
import com.vantar.util.object.ObjectUtil;
import com.vantar.web.*;
import java.util.List;


public class ProjectUserModel {

    public static ResponseMessage add(Params params) throws InputException, ServerException {
        return CommonModelMongo.insertJson(params, new ProjectUser());
    }

    public static ResponseMessage update(Params params) throws InputException, ServerException {
        return CommonModelMongo.insertJson(params, new ProjectUser());
    }

    public static ResponseMessage remove(Params params) throws InputException, ServerException {
        return CommonModelMongo.insertJson(params, new ProjectUser());
    }

    public static ProjectUser getRoleTags(Params params, User user) throws InputException, ServerException, NoContentException {
        Long projectId = params.getLong("projectid");
        Long userId = params.getLong("userid", user.id);
        if (ObjectUtil.isIdInvalid(projectId) || ObjectUtil.isIdInvalid(userId)) {
            throw new InputException(VantarKey.INVALID_ID, "projectid / userid");
        }

        QueryBuilder q = new QueryBuilder(new ProjectUser(), new ProjectUser.ViewableTags());
        q.condition().equal("userId", userId).equal("projectId", projectId);

        try {
            return CommonRepoMongo.getFirst(q, params.getLang());
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.FETCH_FAIL);
        }
    }

    public static List<ProjectUser> getUsers(Params params) throws InputException, ServerException, NoContentException {
        Long projectId = params.getLong("projectid");
        if (ObjectUtil.isIdInvalid(projectId)) {
            throw new InputException(VantarKey.INVALID_ID, "projectid");
        }

        QueryBuilder q = new QueryBuilder(new ProjectUser(), new ProjectUser.Viewable());
        q.condition().equal("projectId", projectId);

        try {
            return CommonRepoMongo.getData(q, params.getLang());
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.FETCH_FAIL);
        }
    }

    public static Object searchUsers(Params params) throws InputException, ServerException, NoContentException {
        return CommonModelMongo.search(params, new ProjectUser(), new ProjectUser.Viewable());
    }
}
