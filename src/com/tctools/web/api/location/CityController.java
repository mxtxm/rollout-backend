package com.tctools.web.api.location;

import com.tctools.business.model.location.CityModel;
import com.vantar.exception.*;
import com.vantar.web.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet({
    "/api/cities/get/by/province",
    "/api/cities/get/all",
    "/api/cities/get/all/keyval",
})
public class CityController extends RouteToMethod {

    public void citiesGetByProvince(Params params, HttpServletResponse response) throws ServerException, InputException, NoContentException {
        Response.writeJson(response, CityModel.getByProvince(params));
    }

    public void citiesGetAll(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, CityModel.getAll(params));
    }

    public void citiesGetAllKeyval(Params params, HttpServletResponse response) throws ServerException, NoContentException {
        Response.writeJson(response, CityModel.getAsKeyValue(params));
    }
}