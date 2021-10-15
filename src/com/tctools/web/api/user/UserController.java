package com.tctools.web.api.user;

import com.tctools.business.dto.user.*;
import com.tctools.business.model.user.UserModel;
import com.vantar.exception.*;
import com.vantar.service.Services;
import com.vantar.service.auth.ServiceAuth;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/user/insert",
    "/api/user/update",
    "/api/user/delete",

    "/api/user/get/by/id",

    "/api/users/search",
    "/api/users/get/all",
    "/api/users/get/all/keyval",
})
public class UserController extends RouteToMethod {

    @Access({"ADMIN", "USER",})
    public void userInsert(Params params, HttpServletResponse response) throws InputException, ServerException {
        Response.writeJson(response, UserModel.insert(params));
    }

    @Access({"ADMIN", "USER",})
    public void userUpdate(Params params, HttpServletResponse response) throws InputException, ServerException {
        Response.writeJson(response, UserModel.update(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER",})
    public void userDelete(Params params, HttpServletResponse response) throws InputException, ServerException {
        Response.writeJson(response, UserModel.delete(params));
    }

    @Access({"ADMIN", "USER",})
    public void userGetById(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, UserModel.getUserById(params));
    }

    @Access({"ADMIN", "USER",})
    public void usersSearch(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, UserModel.search(params));
    }

    @Access({"ADMIN", "USER",})
    public void usersGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, UserModel.getAll(params));
    }

    @Access({"ADMIN", "USER",})
    public void usersGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, UserModel.getAsKeyValue(params));
    }
}