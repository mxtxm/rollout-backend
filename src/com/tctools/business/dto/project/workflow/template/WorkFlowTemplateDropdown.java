package com.tctools.business.dto.project.workflow.template;

import com.vantar.database.dto.*;
import java.util.List;

@Mongo
public class WorkFlowTemplateDropdown extends DtoBase {

    public Long id;

    @Required
    public Long title;

    public List<String> values;
}