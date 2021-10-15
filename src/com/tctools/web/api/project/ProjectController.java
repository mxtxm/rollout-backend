package com.tctools.web.api.project;

import com.tctools.business.model.project.ProjectModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/project/insert",
    "/api/project/update",
    "/api/project/delete",
    "/api/project/get/by/id",

    "/api/projects/search",
})
public class ProjectController extends RouteToMethod {

    @Access({"ADMIN",})
    public void projectInsert(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectModel.insert(params));
    }

    @Access({"ADMIN",})
    public void projectUpdate(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectModel.update(params));
    }

    @Access({"ADMIN",})
    public void projectDelete(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, ProjectModel.delete(params));
    }

    @Access({"ADMIN", "USER",})
    public void projectGetById(Params params, HttpServletResponse response) throws ServerException, InputException, NoContentException {
        Response.writeJson(response, ProjectModel.getById(params));
    }

    @Access({"ADMIN", "USER",})
    public void projectsSearch(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, ProjectModel.search(params));
    }
}