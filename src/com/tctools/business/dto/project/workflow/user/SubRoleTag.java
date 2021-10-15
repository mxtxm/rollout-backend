package com.tctools.business.dto.project.workflow.user;

import com.vantar.database.dto.*;

@Cache
@Mongo
@DeleteLogical
public class SubRoleTag extends DtoBase {

    public Long id;

    @Required
    public String roleTag;
    @Required
    public String name;

    @Required
    public Boolean allowPlanDate;
    @Required
    public Boolean allowActualDate;
    @Required
    public Boolean allowForecastDate;
}
