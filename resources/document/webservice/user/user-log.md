## get user log by id ##
get user by id
### url ###
"/api/user/log/get/by/id"
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
"dto":"com.tctools.business.dto.user.UserLog"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserLogController",
"controllerMethod":"userLogGetById"
}}



## search user logs ##
### url ###
"/api/user/logs/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"searchParams": "com.tctools.business.dto.user.UserLog"
}}
### output ###
{{
"searchResult": "com.tctools.business.dto.user.UserLog"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.user.UserLogController",
"controllerMethod":"userLogsSearch"
}}
