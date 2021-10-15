package com.tctools.business.admin.web;

import com.tctools.business.admin.model.*;
import com.vantar.web.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;


@WebServlet({
    "/admin/import/index",
    "/admin/import/sites",
})
@MultipartConfig(
    location="/tmp",
    fileSizeThreshold=100*1024*1024,
    maxFileSize=100*1024*1024,
    maxRequestSize=100*1024*1024*5
)
public class AdminImportExportController extends RouteToMethod {

    public void importIndex(Params params, HttpServletResponse response) {
        AdminImportExport.index(params, response);
    }

    public void importSites(Params params, HttpServletResponse response) {
        AdminSiteImport.importSites(params, response);
    }
}
