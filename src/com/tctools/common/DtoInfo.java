package com.tctools.common;

import com.tctools.business.dto.location.*;
import com.tctools.business.dto.project.*;
import com.tctools.business.dto.project.workflow.template.*;
import com.tctools.business.dto.project.workflow.user.*;
import com.tctools.business.dto.site.*;
import com.tctools.business.dto.system.*;
import com.tctools.business.dto.user.*;
import com.vantar.database.dto.DtoDictionary;
import com.vantar.service.log.dto.*;


public class DtoInfo {

    public static void start() {
        // base
        DtoDictionary.setCategory("داده های پایه");
        DtoDictionary.add( "لاگ", Log.class);
        DtoDictionary.add( "تنظیمات", Settings.class);

        // user
        DtoDictionary.setCategory("کاربران");
        DtoDictionary.add("کاربران", User.class, "insert-exclude:signinT,token;present:id,fullName");
        DtoDictionary.add( "گروه نقش", RoleTag.class);
        DtoDictionary.add( "نقش", SubRoleTag.class);
        DtoDictionary.add( "لاگ کاربران", UserLog.class);
        DtoDictionary.add( "پیام", UserMessage.class);

        // location
        DtoDictionary.setCategory("مکان");
        DtoDictionary.add("منطقه", Region.class);
        DtoDictionary.add("استان", Province.class);
        DtoDictionary.add("شهر", City.class);
        DtoDictionary.add("بخش", District.class);
        DtoDictionary.add("تعلق مکانی طراحی", LocationType.class);

        // project
        DtoDictionary.setCategory("پروژه");
        DtoDictionary.add("پروژه", RolloutProject.class);
        DtoDictionary.add("نوع نود", NodeType.class);
        DtoDictionary.add("مایلستون", Milestone.class);
        DtoDictionary.add("پروژه کاربر", ProjectUser.class);
        DtoDictionary.add("تمپلیت", WorkFlowTemplate.class);
        DtoDictionary.add("تمپلیت - دراپ داون", WorkFlowTemplateDropdown.class);
        DtoDictionary.add("مرحله", WorkFlowTemplateStep.class);

        // site
        DtoDictionary.setCategory("Site");
        DtoDictionary.add("سایت", Site.class);
        DtoDictionary.add("کلاس سایت", SiteClass.class);
        DtoDictionary.add("تیپ سایت", SiteType.class);

        // mongo
        DtoDictionary.setCategory("MONGO");
        DtoDictionary.add("Sequences", MongoSequence.class);

        // no store
        DtoDictionary.setCategory("nostore");
    }
}