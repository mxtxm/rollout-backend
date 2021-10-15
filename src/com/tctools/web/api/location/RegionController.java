package com.tctools.web.api.location;

import com.tctools.business.model.location.RegionModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/regions/get/all",
    "/api/regions/get/all/keyval",
})
public class RegionController extends RouteToMethod {

    public void regionsGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, RegionModel.getAll(params));
    }

    public void regionsGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, RegionModel.getAsKeyValue(params));
    }
}