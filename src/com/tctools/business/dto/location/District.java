package com.tctools.business.dto.location;

import com.vantar.database.dto.*;

// بخش
@Cache
@Mongo
@DeleteLogical
public class District extends DtoBase {

    public Long id;

    @Required
    public String name;

}