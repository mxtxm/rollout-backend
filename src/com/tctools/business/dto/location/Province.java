package com.tctools.business.dto.location;

import com.vantar.database.dto.*;
import java.util.Map;

// استان
@Cache
@Mongo
@DeleteLogical
public class Province extends DtoBase {

    public Long id;

    @Localized
    @Required
    public Map<String, String> name;


    @Storage("Province")
    public static class Localed extends DtoBase {

        public Long id;
        @DeLocalized
        public String name;

    }
}