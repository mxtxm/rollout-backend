package com.tctools.web.api.site;

import com.tctools.business.model.site.SiteTypeModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/site/types/get/all",
    "/api/site/types/get/all/keyval",
})
public class SiteTypeController extends RouteToMethod {

    @Access({"ADMIN", "USER",})
    public void siteTypesGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, SiteTypeModel.getAll(params));
    }

    @Access({"ADMIN", "USER",})
    public void siteTypesGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, SiteTypeModel.getAsKeyValue(params));
    }
}