package com.tctools.business.dto.project.workflow.user;

import com.tctools.business.dto.user.User;
import com.vantar.database.dto.*;
import java.util.List;

@Mongo
@DeleteLogical
@Index({"userId:1", "projectId:1",})
public class ProjectUser extends DtoBase {

    public Long id;

    @Required
    public Long userId;
    @Required
    public Long projectId;

    public List<String> roleTags;
    public List<String> subRoleTags;


    @Override
    public boolean beforeInsert() {
        //todo: set roletags from subroletags and set user.roletags
        return true;
    }

    @Override
    public boolean beforeUpdate() {
        return beforeInsert();
    }




    @Storage("ProjectUser")
    public static class Viewable extends DtoBase {

        public Long id;

        @FetchCache(dto = com.tctools.business.dto.user.User.class, field = "userId")
        public User user;

        public List<String> roleTags;
        public List<String> subRoleTags;
    }




    @Storage("ProjectUser")
    public static class ViewableTags extends DtoBase {

        public Long id;

        public List<String> roleTags;
        public List<String> subRoleTags;
    }
}
