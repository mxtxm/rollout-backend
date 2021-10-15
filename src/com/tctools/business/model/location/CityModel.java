package com.tctools.business.model.location;

import com.tctools.business.dto.location.City;
import com.vantar.business.CommonModelMongo;
import com.vantar.database.query.QueryBuilder;
import com.vantar.exception.*;
import com.vantar.locale.VantarKey;
import com.vantar.util.object.ObjectUtil;
import com.vantar.web.Params;
import java.util.*;


public class CityModel {

    public static List<City.Localed> getByProvince(Params params) throws InputException, ServerException, NoContentException {
        Long provinceId = params.getLong("provinceid");
        if (ObjectUtil.isIdInvalid(provinceId)) {
            throw new InputException(VantarKey.INVALID_ID, "provinceid");
        }
        QueryBuilder q = new QueryBuilder(new City(), new City.Localed());
        q.condition().equal("provinceId", provinceId);
        return CommonModelMongo.getData(params, q);
    }

    public static List<City.Localed> getAll(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAllFromCache(params, City.class, City.Localed.class);
    }

    public static Map<String, String> getAsKeyValue(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAsKeyValue(params, new City(), "id", "name");
    }
}