package com.tctools.business.model.location;

import com.tctools.business.dto.location.Region;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.Params;
import java.util.*;


public class RegionModel {

    public static List<Region.Localed> getAll(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAllFromCache(params, Region.class, Region.Localed.class);
    }

    public static Map<String, String> getAsKeyValue(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAsKeyValue(params, new Region(), "id", "name");
    }
}