package com.tctools.web.api.site;

import com.tctools.business.model.site.SiteModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/site/insert",
    "/api/site/update",
    "/api/site/delete",
    "/api/site/get",

    "/api/sites/search",
    "/api/sites/autocomplete",
    "/api/sites/near",
})
public class SiteController extends RouteToMethod {

    @Access({"ADMIN", "USER",})
    public void siteInsert(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, SiteModel.insert(params));
    }

    @Access({"ADMIN", "USER",})
    public void siteUpdate(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, SiteModel.update(params));
    }

    @Access({"ADMIN", "USER",})
    public void siteDelete(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, SiteModel.delete(params));
    }

    @Access({"ADMIN", "USER",})
    public void siteGet(Params params, HttpServletResponse response) throws ServerException, InputException, NoContentException {
        Response.writeJson(response, SiteModel.getByIdAndCode(params));
    }

    @Access({"ADMIN", "USER",})
    public void sitesSearch(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, SiteModel.search(params));
    }

    @Access({"ADMIN", "USER",})
    public void sitesAutocomplete(Params params, HttpServletResponse response) throws ServerException {
        Response.writeJson(response, SiteModel.autoComplete(params));
    }

    @Access({"ADMIN", "USER",})
    public void sitesNear(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, SiteModel.getNearSites(params));
    }
}