package com.tctools.business.model.location;

import com.tctools.business.dto.location.LocationType;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.Params;
import java.util.*;


public class LocationTypeModel {

    public static List<LocationType.Localed> getAll(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAllFromCache(params, LocationType.class, LocationType.Localed.class);
    }

    public static Map<String, String> getAsKeyValue(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAsKeyValue(params, new LocationType(), "id", "name");
    }
}