package com.tctools.business.dto.project.workflow.template;

import com.vantar.database.dto.*;
import java.util.List;

@Mongo
public class WorkFlowTemplateStep extends DtoBase {

    public Long id;

    public Long title;
    public Long description;

    public WorkFlowTemplateStepType type;
    public List<String> subRoleTags;

    // if dropdown, import values from WorkFlowTemplateDropdown
    public List<String> values;

    public Boolean active;
    public Integer order;

}