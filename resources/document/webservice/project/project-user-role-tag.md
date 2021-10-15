## add project user role tag ##
### url ###
"/api/project/role/tag/insert"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.RoleTag",
"exclude": ["id"]
}}
### output ###
<<<insert>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.RoleTagController",
"controllerMethod":"projectRoleTagInsert"
}}





## update project user role tag ##
### url ###
"/api/project/role/tag/update"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.RoleTag",
"key": ["id"]
}}
### output ###
<<<update>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.RoleTagController",
"controllerMethod":"projectRoleTagUpdate"
}}




## get all role tags ##

### url ###
"/api/project/role/tags/get"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
### output ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.user.RoleTag"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.RoleTagController",
"controllerMethod":"projectRoleTagsGet"
}}






## add project user sub role tag ##
### url ###
"/api/project/sub/role/tag/insert"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.SubRoleTag",
"exclude": ["id"]
}}
### output ###
<<<insert>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.RoleTagController",
"controllerMethod":"projectSubRoleTagInsert"
}}





## update project user sub role tag ##
### url ###
"/api/project/sub/role/tag/update"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.workflow.user.SubRoleTag",
"key": ["id"]
}}
### output ###
<<<update>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.RoleTagController",
"controllerMethod":"projectSubRoleTagUpdate"
}}





### url ###
"/api/project/sub/role/tags/get"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
### output ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.user.SubRoleTag"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.user.RoleTagController",
"controllerMethod":"projectSubRoleTagsGet"
}}
