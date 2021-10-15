package com.tctools.web.api.location;

import com.tctools.business.model.location.ProvinceModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/api/provinces/get/all",
    "/api/provinces/all/keyval",
})
public class ProvinceController extends RouteToMethod {

    public void provincesGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, ProvinceModel.getAll(params));
    }

    public void provincesGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, ProvinceModel.getAsKeyValue(params));
    }
}