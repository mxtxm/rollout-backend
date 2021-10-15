package com.tctools.business.model.site;

import com.tctools.business.dto.site.SiteClass;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.Params;
import java.util.*;


public class SiteClassModel {

    public static List<SiteClass.Localed> getAll(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAllFromCache(params, SiteClass.class, SiteClass.Localed.class);
    }

    public static Map<String, String> getAsKeyValue(Params params) throws ServerException, NoContentException {
        return CommonModelMongo.getAsKeyValue(params, new SiteClass(), "id", "name");
    }
}