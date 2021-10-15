package com.tctools.web.api.user;

import com.tctools.business.dto.user.*;
import com.tctools.business.model.user.UserMessageModel;
import com.vantar.exception.*;
import com.vantar.service.Services;
import com.vantar.service.auth.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/user/message/insert",
    "/api/user/message/delete",
    "/api/user/message/get/by/id",
    "/api/user/message/set/read",

    "/api/user/messages/search",
    "/api/user/messages/get/all",
    "/api/user/messages/get/unread",
    "/api/user/messages/get/read",
    "/api/user/messages/count/unread",
    "/api/user/messages/get/sent",
})
public class UserMessageController extends RouteToMethod {

    @Access({"ADMIN", "USER"})
    public void userMessageInsert(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, UserMessageModel.insert(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER"})
    public void userMessageDelete(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, UserMessageModel.delete(params));
    }

    @Access({"ADMIN", "USER"})
    public void userMessageGetById(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, UserMessageModel.getById(params));
    }

    @Access({"ADMIN", "USER"})
    public void userMessageSetRead(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, UserMessageModel.setRead(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER"})
    public void userMessagesSearch(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, UserMessageModel.search(params));
    }

    @Access({"ADMIN", "USER"})
    public void userMessagesGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, UserMessageModel.getAll(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER"})
    public void userMessagesGetUnread(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, UserMessageModel.getUnread(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER"})
    public void userMessagesGetRead(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, UserMessageModel.getRead(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER"})
    public void userMessagesCountUnread(Params params, HttpServletResponse response) throws AuthException {
        Response.writeString(response, UserMessageModel.getUnreadCount((User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

    @Access({"ADMIN", "USER"})
    public void userMessagesGetSent(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, UserMessageModel.getSent(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }
}