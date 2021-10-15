package com.tctools.business.dto.project;

import com.vantar.database.dto.*;

@Cache
@Mongo
public class NodeType extends DtoBase {

    public Long id;

    @Required
    public String title;
    public String description;

}