## insert new user ##
### url ###
"/api/user/insert"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"dto":"com.tctools.business.dto.user.User",
"exclude": ["id", "role", "fullName", "emailVerified", "mobileVerified", "createT", "signinT", "ability", "extras", "photo", "avatar", "roleTags"]
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
"controllerClass":"com.tctools.web.api.user.UserController",
"controllerMethod":"userInsert"
}}




## user update ##
### url ###
"/api/user/update"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
{{
"dto":"com.tctools.business.dto.user.User",
"exclude": ["role", "fullName", "emailVerified", "mobileVerified", "createT", "signinT", "ability", "extras", "photo", "avatar", "roleTags"]
}}
### output ###
    JSON
    {
        "code": 200,
        "message"; "update success message",
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserController",
"controllerMethod":"userUpdate"
}}





## delete user ##
### url ###
"/api/user/delete"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"dto":"com.tctools.business.dto.user.User",
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
"controllerClass":"com.tctools.web.api.user.UserController",
"controllerMethod":"userDelete"
}}



## get user by id ##
get user by id
### url ###
"/api/user/get/by/id"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
* **Long id**: user id
### output ###
{{
"format":"object",
"dto":"com.tctools.business.dto.user.User"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserController",
"controllerMethod":"userGetById"
}}



## search users ##
### url ###
"/api/users/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"searchParams": "com.tctools.business.dto.user.User"
}}
### output ###
{{
"searchResult": "com.tctools.business.dto.user.User"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserController",
"controllerMethod":"usersSearch"
}}



## get all users ##

### url ###
"/api/users/all"
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
"dto":"com.tctools.business.dto.user.User"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserController",
"controllerMethod":"usersGetAll"
}}




## get users as key value ##

### url ###
"/api/users/all/keyval"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
{{
"format":"object",
"dto":"com.tctools.business.dto.user.User"
}}
### output ###
    JSON
    [User.id: User.fullName, ...]
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserController",
"controllerMethod":"usersGetAllKeyval"
}}



## Upload user avatar image ##
updates previous image
### url ###
"/api/user/avatar/submit"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
* **File file**: jpg image file
* Long id: if "id" is not provided then signature is assigned to signed in user. MANAGER can upload other user signature by sending "id".
### output ###
    JSON
    {
        "code": 200,
        "message"; "update success message",
        "successful": true,
        "value": signature-url
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserUploadController",
"controllerMethod":"userAvatarSubmit"
}}


