package com.tctools.business.model.user;

import com.tctools.business.dto.user.*;
import com.vantar.business.*;
import com.vantar.database.dto.Dto;
import com.vantar.database.nosql.mongo.MongoSearch;
import com.vantar.database.query.QueryBuilder;
import com.vantar.exception.*;
import com.vantar.locale.VantarKey;
import com.vantar.util.object.ObjectUtil;
import com.vantar.web.*;
import java.util.List;


public class UserMessageModel {

    public static ResponseMessage insert(Params params, User user) throws InputException, ServerException {
        return CommonModelMongo.insertJson(params, new UserMessage(), new CommonModel.WriteEvent() {
            @Override
            public void beforeWrite(Dto dto) {
                ((UserMessage) dto).senderId = user.id;
                ((UserMessage) dto).senderName = user.fullName;
            }

            @Override
            public void afterWrite(Dto dto) throws ServerException {
                long userId = ((UserMessage) dto).userId;
                UserModel.updateExtras(userId, User.EXTRA_UNREAD_MESSAGE_COUNT, getUnreadCount(userId));
            }
        });
    }

    public static ResponseMessage delete(Params params) throws InputException, ServerException {
        return CommonModelMongo.delete(params, new UserMessage());
    }

    public static UserMessage.Viewable getById(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.getById(params, new UserMessage.Viewable());
    }

    public static ResponseMessage setRead(Params params, User user) throws ServerException, InputException {
        UserMessage message = new UserMessage();
        message.id = params.getLong("id");
        if (ObjectUtil.isIdInvalid(message.id)) {
            throw new InputException(VantarKey.INVALID_ID, "UserMessage.id");
        }
        message.userId = user.id;
        message.read = true;

        try {
            CommonRepoMongo.update(message);
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.UPDATE_FAIL);
        }
        return new ResponseMessage(VantarKey.UPDATE_SUCCESS);
    }

    public static Object search(Params params) throws ServerException, NoContentException, InputException {
        return CommonModelMongo.search(params, new UserMessage(), new UserMessage.Viewable());
    }

    public static List<UserMessage> getAll(Params params, User user) throws ServerException, NoContentException {
        return get(params, user, null);
    }

    public static List<UserMessage> getUnread(Params params, User user) throws ServerException, NoContentException {
        return get(params, user, false);
    }

    public static List<UserMessage> getRead(Params params, User user) throws ServerException, NoContentException {
        return get(params, user, true);
    }

    private static List<UserMessage> get(Params params, User user, Boolean read) throws ServerException, NoContentException {
        QueryBuilder q = new QueryBuilder(new UserMessage(), new UserMessage.Viewable());
        q.sort("id:desc");
        q.condition().equal("userId", user.id);
        if (read != null) {
            q.condition().equal("read", read);
        }

        return CommonModelMongo.getData(params, q);
    }

    public static Long getUnreadCount(User user) {
        return getUnreadCount(user.id);
    }

    private static long getUnreadCount(long userId) {
        QueryBuilder q = new QueryBuilder(new UserMessage());
        q.condition()
            .equal("userId", userId)
            .equal("read", false);
        try {
            return MongoSearch.count(q);
        } catch (DatabaseException e) {
            return 0;
        }
    }

    public static List<UserMessage> getSent(Params params, User user) throws ServerException, NoContentException {
        QueryBuilder q = new QueryBuilder(new UserMessage(), new UserMessage.Viewable());
        q.sort("id:desc");
        q.condition().equal("senderId", user.id);
        return CommonModelMongo.getData(params, q);
    }
}
