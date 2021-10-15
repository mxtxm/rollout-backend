package com.tctools.web.api.location;

import com.tctools.business.model.location.LocationTypeModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/location/type/get/all",
    "/api/location/type/get/all/keyval",
})
public class LocationTypeController extends RouteToMethod {

    public void locationTypeGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, LocationTypeModel.getAll(params));
    }

    public void locationTypeGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, LocationTypeModel.getAsKeyValue(params));
    }
}