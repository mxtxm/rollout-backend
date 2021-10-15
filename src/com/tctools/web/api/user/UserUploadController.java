package com.tctools.web.api.user;

import com.tctools.business.dto.user.*;
import com.tctools.business.model.user.UserModel;
import com.vantar.exception.*;
import com.vantar.service.Services;
import com.vantar.service.auth.ServiceAuth;
import com.vantar.web.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/user/avatar/submit",
})
@MultipartConfig(
    location="/tmp",
    fileSizeThreshold=10*1024*1024,
    maxFileSize=10*1024*1024,
    maxRequestSize=10*1024*1024*5
)
public class UserUploadController extends RouteToMethod {

    @Access({"ADMIN", "USER"})
    public void userAvatarSubmit(Params params, HttpServletResponse response) throws InputException, ServerException {
        Response.writeJson(response, UserModel.submitAvatar(params, (User) Services.get(ServiceAuth.class).getCurrentUser(params)));
    }

}