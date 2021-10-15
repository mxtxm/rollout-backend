package com.tctools.business.model.site;

import com.tctools.business.dto.site.SiteType;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.Params;
import java.util.*;


public class SiteTypeModel {

    public static List<SiteType.Localed> getAll(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAllFromCache(params, SiteType.class, SiteType.Localed.class);
    }

    public static Map<String, String> getAsKeyValue(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAsKeyValue(params, new SiteType(), "id", "name");
    }
}