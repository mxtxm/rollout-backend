package com.tctools.business.dto.user;

import com.vantar.database.dto.*;
import com.vantar.util.datetime.DateTime;

@Mongo
@DeleteLogical
@Index({"userId:1", "senderId:1", "createT:1", "read:1"})
public class UserMessage extends DtoBase {

    public Long id;

    @Required
    public Long userId;

    public Long senderId;
    public String senderName;

    @Required
    public String message;

    @Required
    @Default("false")
    public Boolean read;

    @CreateTime
    @Timestamp
    @Tags("none")
    public DateTime createT;


    @Storage("UserMessage")
    public static class Viewable extends DtoBase {
        public Long id;

        @FetchCache(dto = com.tctools.business.dto.user.User.class, field = "userId")
        public User user;

        public Long senderId;
        public String senderName;

        public String message;

        public String read;

        public DateTime createT;
    }
}
