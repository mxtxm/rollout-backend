package com.tctools.business.dto.project.workflow.template;

import com.tctools.business.dto.project.ProjectType;
import com.vantar.database.dto.*;
import com.vantar.util.datetime.DateTime;
import java.util.List;

@Mongo
public class Milestone extends DtoBase {

    public Boolean isMain;
    // milestone ids
    public List<Long> dependencies;
    public Integer weight;

    public DateTime plan;
    public DateTime forecast;
    public DateTime actual;

    public String attachment;
    public List<String> history;

    public String comments;

    public ProjectType projectType;

    public Boolean allowAcceptReject;
    public Boolean allowNA;

}
