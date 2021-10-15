package com.tctools.business.dto.project;

import com.tctools.business.dto.project.workflow.template.WorkFlowTemplate;
import com.tctools.business.dto.site.Site;
import com.vantar.database.dto.*;
import java.util.List;

@DeleteLogical
@Mongo
public class RolloutProject extends DtoBase {

    public Long id;

    @Required
    public String title;
    @Required
    public ProjectType projectType;
    @Required
    public Long nodeTypeId;

    @Required
    public Boolean active;
    public Boolean enableRequest;
    public Boolean enableOverlap;

    public Integer maxRequestCount;
    public Integer estimateRequestCount;

    public String description;

    public List<Site.Viewable> sites;

    public WorkFlowTemplate workFlowTemplate;


    @Storage("RolloutProject")
    public static class Viewable extends DtoBase {
        public Long id;

        public String title;
        public ProjectType projectType;

        @FetchCache(dto = com.tctools.business.dto.project.NodeType.class, field = "nodeTypeId")
        public NodeType nodeType;

        public Boolean active;
        public Boolean enableRequest;
        public Boolean enableOverlap;

        public Integer maxRequestCount;
        public Integer estimateRequestCount;

        public String description;

        public List<Site.Viewable> sites;

        public WorkFlowTemplate workFlowTemplate;
    }
}