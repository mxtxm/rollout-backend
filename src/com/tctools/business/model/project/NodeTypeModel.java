package com.tctools.business.model.project;

import com.tctools.business.dto.project.NodeType;
import com.vantar.business.CommonModelMongo;
import com.vantar.exception.*;
import com.vantar.web.*;


public class NodeTypeModel {

    public static ResponseMessage insert(Params params) throws InputException, ServerException {
        return CommonModelMongo.insert(params, new NodeType());
    }

    public static ResponseMessage update(Params params) throws InputException, ServerException {
        return CommonModelMongo.update(params, new NodeType());
    }

    public static ResponseMessage delete(Params params) throws InputException, ServerException {
        return CommonModelMongo.delete(params, new NodeType());
    }

    public static NodeType getById(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.getById(params, new NodeType());
    }

    public static Object search(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.search(params, new NodeType());
    }
}
