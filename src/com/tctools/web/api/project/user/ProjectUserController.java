package com.tctools.web.api.project.user;

import com.tctools.business.dto.user.User;
import com.tctools.business.model.project.user.ProjectUserModel;
import com.vantar.exception.*;
import com.vantar.service.Services;
import com.vantar.service.auth.ServiceAuth;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/project/user/add",
    "/api/project/user/update",
    "/api/project/user/remove",

    "/api/project/user/get/role/tags",

    "/api/project/users/get",
    "/api/project/users/search",
})
public class ProjectUserController extends RouteToMethod {

    @Access({"ADMIN",})
    public void projectUserAdd(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectUserModel.add(params));
    }

    @Access({"ADMIN",})
    public void projectUserUpdate(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectUserModel.update(params));
    }

    @Access({"ADMIN",})
    public void projectUserRemove(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectUserModel.remove(params));
    }

    @Access({"ADMIN", "USER",})
    public void projectUserGetRoleTags(Params params, HttpServletResponse response) throws ServerException, InputException, NoContentException {
        Response.writeJson(response, ProjectUserModel.getRoleTags(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER",})
    public void projectUsersGet(Params params, HttpServletResponse response) throws ServerException, InputException, NoContentException {
        Response.writeJson(response, ProjectUserModel.getUsers(params));
    }

    @Access({"ADMIN", "USER",})
    public void projectUsersSearch(Params params, HttpServletResponse response) throws ServerException, InputException, NoContentException {
        Response.writeJson(response, ProjectUserModel.searchUsers(params));
    }
}