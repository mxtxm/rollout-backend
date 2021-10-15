package com.tctools.business.model.location;

import com.tctools.business.dto.location.District;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.Params;
import java.util.*;


public class DistrictModel {

    public static List<District> getAll(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAll(params, new District());
    }

    public static Map<String, String> getAsKeyValue(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAsKeyValue(params, new District(), "id", "name");
    }
}