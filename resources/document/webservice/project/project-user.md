## add user to project ##
### url ###
"/api/project/user/add"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.ProjectUser",
"exclude": ["id", "roleTags"]
}}
### output ###
<<<insert>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.ProjectUserController",
"controllerMethod":"projectUserAdd"
}}



## update user / project ##
use to update role tags
### url ###
"/api/project/user/update"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.ProjectUser",
"exclude": ["projectId", "userId", "roleTags"],
"key": ["id"]
}}
### output ###
<<<update>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.ProjectUserController",
"controllerMethod":"projectUserUpdate"
}}





## remove user from project ##
either by (id) or by (projectId, userId)
### url ###
"/api/project/user/remove"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.ProjectUser",
"exclude": ["roleTags", "subRoleTags"]
}}
### output ###
<<<delete>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.ProjectUserController",
"controllerMethod":"projectUserRemove"
}}




## get user role tags in a project ##
### url ###
"/api/project/user/get/role/tags"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **Long projectid**:
* Long userid (default=signed in user): 
### output ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.ProjectUser$ViewableTags"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.ProjectUserController",
"controllerMethod":"projectUserGetRoleTags"
}}




## get all users and their role tags in a project ##
### url ###
"/api/project/users/get"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **Long projectid**:
### output ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.ProjectUser$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.ProjectUserController",
"controllerMethod":"projectUsersGet"
}}




## search project users ##
### url ###
"/api/project/users/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"searchParams": "com.tctools.business.dto.project.workflow.user.ProjectUser"
}}
### output ###
{{
"searchResult": "com.tctools.business.dto.project.workflow.user.ProjectUser$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.ProjectUserController",
"controllerMethod":"projectUserssearch"
}}
