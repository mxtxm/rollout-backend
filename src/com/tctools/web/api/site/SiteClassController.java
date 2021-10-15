package com.tctools.web.api.site;

import com.tctools.business.model.site.SiteClassModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/site/classes/get/all",
    "/api/site/classes/get/all/keyval",
})
public class SiteClassController extends RouteToMethod {

    @Access({"ADMIN", "USER",})
    public void siteClassesGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, SiteClassModel.getAll(params));
    }

    @Access({"ADMIN", "USER",})
    public void siteClassesGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, SiteClassModel.getAsKeyValue(params));
    }
}