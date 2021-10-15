## insert new user message ##
### url ###
"/api/user/message/insert"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"dto":"com.tctools.business.dto.user.UserMessage"
}}
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "value": inserted-id (long),
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessageInsert"
}}



## delete user message ##
### url ###
"/api/user/message/delete"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"dto":"com.tctools.business.dto.user.UserMessage",
"exclude": ["all"],
"key": ["id"]
}}
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessageDelete"
}}



## get user message by id ##
get user message by id
### url ###
"/api/user/message/get/by/id"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
* **Long id**: user message id
### output ###
{{
"format":"object",
"dto":"com.tctools.business.dto.user.UserMessage"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessageGetById"
}}




## set message read ##

### url ###
"/api/user/message/set/read"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
* **Long id**: user message id
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessageSetRead"
}}



## search users ##
### url ###
"/api/user/messages/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"searchParams": "com.tctools.business.dto.user.UserMessage"
}}
### output ###
{{
"searchResult": "com.tctools.business.dto.user.UserMessage"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessagesSearch"
}}



## get all user's messages ##

### url ###
"/api/user/messages/all"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
### output ###
{{
"format":"list",
"dto":"com.tctools.business.dto.user.UserMessage"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessagesGetAll"
}}




## get user's read messages ##

### url ###
"/api/user/messages/get/read"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
### output ###
{{
"format":"list",
"dto":"com.tctools.business.dto.user.UserMessage"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessagesGetRead"
}}




## get user's read messages ##

### url ###
"/api/user/messages/get/unread"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
### output ###
{{
"format":"list",
"dto":"com.tctools.business.dto.user.UserMessage"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessagesGetUnread"
}}




## get user's unread message count ##

### url ###
"/api/user/messages/count/unread"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
### output ###
    String: number of unread messages 
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessagesCountUnread"
}}




## get user's sent messages ##

### url ###
"/api/user/messages/get/sent"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
### output ###
{{
"format":"list",
"dto":"com.tctools.business.dto.user.UserMessage"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserMessageController",
"controllerMethod":"userMessagesGetSent"
}}
