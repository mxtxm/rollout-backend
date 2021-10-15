package com.tctools.web.api.location;

import com.tctools.business.model.location.DistrictModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/districts/get/all",
    "/api/districts/get/all/keyval",
})
public class DistrictController extends RouteToMethod {

    public void districtsGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, DistrictModel.getAll(params));
    }

    public void districtsGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, DistrictModel.getAsKeyValue(params));
    }
}