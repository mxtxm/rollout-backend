package com.tctools.web.api.user;

import com.tctools.business.dto.user.Role;
import com.tctools.business.dto.user.*;
import com.tctools.business.model.user.AuthModel;
import com.vantar.exception.*;
import com.vantar.service.Services;
import com.vantar.service.auth.ServiceAuth;
import com.vantar.util.object.EnumUtil;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/users/get/roles",

    "/api/user/signin",
    "/api/user/signout",

    "/api/user/get/current",
    "/api/user/change/password",
})
public class AuthController extends RouteToMethod {

    @Access({"ADMIN",})
    public void usersGetRoles(Params params, HttpServletResponse response) {
        User user = (User) Services.get(ServiceAuth.class).getCurrentUser(params);
        Response.writeJson(
            response,
            user.role.equals(Role.MANAGER) ?
                EnumUtil.getEnumValues(Role.values(), "ADMIN", "ROOT") :
                EnumUtil.getEnumValues(Role.values(), "ADMIN", "ROOT", "MANAGER")
        );
    }

    public void userSignin(Params params, HttpServletResponse response) throws ServerException, AuthException {
        Response.writeJson(response, AuthModel.signin(params));
    }

    public void userSignout(Params params, HttpServletResponse response) {
        AuthModel.signout(params);
        Response.writeSuccess(response);
    }

    @Access({"ADMIN", "USER",})
    public void userGetCurrent(Params params, HttpServletResponse response) throws NoContentException, ServerException {
        Response.writeJson(response, AuthModel.getCurrentUser(params));
    }

    @Access({"ADMIN", "USER",})
    public void userChangePassword(Params params, HttpServletResponse response) throws InputException, AuthException, ServerException {
        Response.writeJson(response, AuthModel.changePassword(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }
}