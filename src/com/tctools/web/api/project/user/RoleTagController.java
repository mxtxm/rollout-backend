package com.tctools.web.api.project.user;

import com.tctools.business.model.project.user.RoleTagModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/project/role/tag/insert",
    "/api/project/role/tag/update",
    "/api/project/role/tags/get",

    "/api/project/sub/role/tag/insert",
    "/api/project/sub/role/tag/update",
    "/api/project/sub/role/tags/get",
})
public class RoleTagController extends RouteToMethod {

    @Access({"ADMIN",})
    public void projectRoleTagInsert(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, RoleTagModel.insertRoleTag(params));
    }

    @Access({"ADMIN",})
    public void projectRoleTagUpdate(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, RoleTagModel.updateRoleTag(params));
    }

    @Access({"ADMIN", "USER",})
    public void projectRoleTagsGet(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, RoleTagModel.getRoleTag(params));
    }

    @Access({"ADMIN",})
    public void projectSubRoleTagInsert(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, RoleTagModel.insertSubRoleTag(params));
    }

    @Access({"ADMIN",})
    public void projectSubRoleTagUpdate(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, RoleTagModel.updateSubRoleTag(params));
    }

    @Access({"ADMIN", "USER",})
    public void projectSubRoleTagsGet(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, RoleTagModel.getSubRoleTag(params));
    }
}