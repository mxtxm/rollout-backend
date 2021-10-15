package com.tctools.web.patch;

import com.vantar.web.RouteToMethod;
import org.slf4j.*;
import javax.servlet.annotation.*;

@WebServlet({

})
@MultipartConfig(
    location="/tmp",
    fileSizeThreshold=10*1024*1024,
    maxFileSize=10*1024*1024,
    maxRequestSize=10*1024*1024*5
)
public class PatchController extends RouteToMethod {

    public static final Logger log = LoggerFactory.getLogger(PatchController.class);

}