package com.tctools.web.api.project.site;

import com.tctools.business.model.project.site.ProjectSiteModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/project/site/add",
    "/api/project/site/remove",
})
public class ProjectSiteController extends RouteToMethod {

    @Access({"ADMIN",})
    public void projectSiteAdd(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectSiteModel.add(params));
    }

    @Access({"ADMIN",})
    public void projectSiteDelete(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectSiteModel.remove(params));
    }
}