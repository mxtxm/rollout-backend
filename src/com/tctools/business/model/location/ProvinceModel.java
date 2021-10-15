package com.tctools.business.model.location;

import com.tctools.business.dto.location.Province;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.Params;
import java.util.*;


public class ProvinceModel {

    public static List<Province.Localed> getAll(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAllFromCache(params, Province.class, Province.Localed.class);
    }

    public static Map<String, String> getAsKeyValue(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAsKeyValue(params, new Province(), "id", "name");
    }
}