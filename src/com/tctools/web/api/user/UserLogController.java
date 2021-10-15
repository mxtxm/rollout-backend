package com.tctools.web.api.user;

import com.tctools.business.model.user.UserLogModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/user/log/get/by/id",
    "/api/user/logs/search",
})
public class UserLogController extends RouteToMethod {

    @Access({"ADMIN", "USER",})
    public void userLogGetById(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, UserLogModel.getUserById(params));
    }

    @Access({"ADMIN", "USER",})
    public void userLogsSearch(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, UserLogModel.search(params));
    }
}