package com.tctools.web.api.project;

import com.tctools.business.model.project.NodeTypeModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/node/type/insert",
    "/api/node/typeupdate",
    "/api/node/type/delete",
    "/api/node/type/get/by/id",

    "/api/node/types/search",
})
public class NodeTypeController extends RouteToMethod {

    @Access({"ADMIN",})
    public void nodeTypeInsert(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, NodeTypeModel.insert(params));
    }

    @Access({"ADMIN",})
    public void nodeTypeUpdate(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, NodeTypeModel.update(params));
    }

    @Access({"ADMIN",})
    public void nodeTypeDelete(Params params, HttpServletResponse response) throws ServerException, InputException {
        Response.writeJson(response, NodeTypeModel.delete(params));
    }

    @Access({"ADMIN",})
    public void nodeTypeGet(Params params, HttpServletResponse response) throws ServerException, InputException, NoContentException {
        Response.writeJson(response, NodeTypeModel.getById(params));
    }

    @Access({"ADMIN",})
    public void nodeTypesSearch(Params params, HttpServletResponse response) throws ServerException, NoContentException, InputException {
        Response.writeJson(response, NodeTypeModel.search(params));
    }
}