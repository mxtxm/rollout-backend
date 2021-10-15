package com.tctools.business.dto.project.workflow.user;

import com.vantar.database.dto.*;

@Cache
@Mongo
@DeleteLogical
public class RoleTag extends DtoBase {

    public Long id;

    @Required
    public String name;
}
