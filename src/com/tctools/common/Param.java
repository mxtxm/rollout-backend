package com.tctools.common;

import com.vantar.common.VantarParam;


public class Param extends VantarParam {

    public static final String FILE_UPLOAD = "file";

    public static final String TEMP_DIR = "/opt/rollout/files/temp/";
    public static final String USER_FILES = "/opt/rollout/files/user/";

    public static final long FILE_USER_IMAGE_MIN_SIZE = 10 * 1024;
    public static final long FILE_USER_IMAGE_MAX_SIZE = 1024 * 1024;
    public static final int USER_IMAGE_SMALL_WIDTH = 100;

    public static final String USERS_URL = "/static/user/";

}
