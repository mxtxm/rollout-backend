package com.tctools.web.patch;

import com.tctools.business.dto.project.RolloutProject;
import com.tctools.business.dto.site.Site;
import com.vantar.business.CommonRepoMongo;
import com.vantar.exception.DatabaseException;
import com.vantar.web.*;
import org.slf4j.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@WebServlet({
    "/test/index",
})
@MultipartConfig(
    location="/tmp",
    fileSizeThreshold=10*1024*1024,
    maxFileSize=10*1024*1024,
    maxRequestSize=10*1024*1024*5
)
public class TestController extends RouteToMethod {

    public static final Logger log = LoggerFactory.getLogger(TestController.class);

    public void index(Params params, HttpServletResponse response) {
        RolloutProject p = new RolloutProject();
//        p.title = "title";
//        p.projectType = ProjectType.Location;
//        p.nodeTypeId = 12L;
//        p.active = true;
//
//        try {
//            CommonRepoMongo.insert(p);
//        } catch (DatabaseException e) {
//            e.printStackTrace();
//        }

        p.id = 1L;
        p.sites = new ArrayList<>();
        Site.Viewable s = new Site.Viewable();
        s.id = 2L;
        s.name = "koon";
        s.code = "TH12";
        p.sites.add(s);
        Site.Viewable s1 = new Site.Viewable();
        s1.id = 12L;
        s1.name = "poon";
        s1.code = "SS12";
        p.sites.add(s1);

        try {
            CommonRepoMongo.update(p);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}