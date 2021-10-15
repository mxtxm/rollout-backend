## get user roles ##
* ROOT: access to whole system (critical system actions, backend and frontend) (only for develop team)
* ADMIN: access to everything on (backend and frontend) except critical backend items
* USER: can see everything, but access to project/milestone features depends on "ProjectUser" "roleTagForks"
### url ###
"/api/users/get/roles"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###

### output ###
{{
"format":"object",
"enumClass":"com.tctools.business.dto.user.Role"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.AuthController",
"controllerMethod":"usersGetRoles"
}}




## signin ##
### url ###
"/api/user/signin"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **String username**: email or mobile
* **String password**:
### output ###
{{
"format":"object",
"dto":"com.tctools.business.dto.user.User"
}}
* String accessToken: obtained access token, subsequent requests must set this token to "X-Auth-Token" header 
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.AuthController",
"controllerMethod":"userSignin"
}}




## signout ##
### url ###
"/api/user/signout"
### access ###
* PUBLIC
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###

### output ###

### exceptions ###




## get signed in user ##

### url ###
"/api/user/get/current"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
### output ###
{{
"format":"object",
"dto":"com.tctools.business.dto.user.User",
"exclude":["password"]
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.AuthController",
"controllerMethod":"userGetCurrent"
}}





## change password ##
if "id" is not provided then signed in user's password will be changed. 
### url ###
"/api/user/change/password"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
* **String password**
* Long id: if "id" is not provided then signature is assigned to signed in user. MANAGER can upload other user signature by sending "id".
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
"controllerClass":"com.tctools.web.api.user.AuthController",
"controllerMethod":"userChangePassword"
}}
