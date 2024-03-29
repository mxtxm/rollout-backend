package com.tctools.business.admin.model;

import com.tctools.business.dto.user.Role;
import com.tctools.business.service.locale.AppLangKey;
import com.vantar.admin.model.*;
import com.vantar.database.dto.Dto;
import com.vantar.locale.Locale;
import com.vantar.util.file.FileUtil;
import com.vantar.web.Params;
import javax.servlet.http.HttpServletResponse;


public class AdminApp {

    static {
        AdminData.event = new AdminData.Event() {
            @Override
            public void beforeInsert(Dto dto) {

            }

            @Override
            public void afterInsert(Dto dto) {

            }

            @Override
            public void beforeUpdate(Dto dto) {

            }

            @Override
            public void afterUpdate(Dto dto) {

            }

            @Override
            public void beforeDelete(Dto dto) {

            }

            @Override
            public void afterDelete(Dto dto) {

            }
        };
    }

    public static void setTitle() {
        Admin.appTitle = Locale.getString(AppLangKey.APP_TITLE);
    }

    public static void extendMenu(Params params) {
        if (AdminAuth.hasAccess(params, Role.MANAGER)) {
            Admin.menu.put(Locale.getString(AppLangKey.ADMIN_IMPORT_EXPORT), "/admin/import/index");
        }
        Admin.menu.put(Locale.getString(AppLangKey.ADMIN_DUMMY_USERS), "/admin/users/dummy/index");
        Admin.menu.put(Locale.getString(AppLangKey.ADMIN_IMAGE_BROWSE), "/admin/image/browse");
    }

    public static void extendMonitoringLinks() {

    }

    public static void extendShortcuts() {

    }

    public static void factoryResetBefore() {

    }

    public static void factoryResetAfter() {
        FileUtil.makeDirectory("/opt/tc-tools/backup/");
        FileUtil.makeDirectory("/opt/tc-tools/documents/");
        FileUtil.makeDirectory("/opt/tc-tools/files/hse-audit/");
        FileUtil.makeDirectory("/opt/tc-tools/files/radiometric/");
        FileUtil.makeDirectory("/opt/tc-tools/files/temp/");
        FileUtil.makeDirectory("/opt/tc-tools/files/user/");
    }

    public static void index(Params params, HttpServletResponse response) {

    }
}
