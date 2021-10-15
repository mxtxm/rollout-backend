package com.tctools.business.dto.project.workflow.template;

import com.vantar.database.dto.*;
import java.util.List;

@Mongo
public class WorkFlowTemplate extends DtoBase {

    public Long id;

    @Required
    public Long title;
    @Required
    public Long description;

    public List<WorkFlowTemplateStep> steps;

}