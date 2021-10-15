package com.tctools.business.admin.model;

import com.tctools.business.service.locale.AppLangKey;
import com.vantar.admin.model.Admin;
import com.vantar.locale.*;
import com.vantar.web.*;
import javax.servlet.http.HttpServletResponse;


public class AdminImportExport {

    public static void index(Params params, HttpServletResponse response) {
        WebUi ui = Admin.getUi(Locale.getString(AppLangKey.ADMIN_IMPORT_EXPORT), params, response);
        if (ui == null) {
            return;
        }

        ui  .addHeading(Locale.getString(VantarKey.ADMIN_IMPORT))

            .addEmptyLine()


            .addEmptyLine()

            .addEmptyLine()
            .addHeading(Locale.getString(AppLangKey.ADMIN_FIX))
        ;

        ui.finish();
    }
}
