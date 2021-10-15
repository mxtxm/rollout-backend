## insert new project ##
### url ###
"/api/project/insert"
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
"dto": "com.tctools.business.dto.project.RolloutProject",
"exclude": ["id"]
}}
### output ###
<<<insert>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.ProjectController",
"controllerMethod":"projectInsert"
}}





## update project ##
### url ###
"/api/project/update"
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
"dto": "com.tctools.business.dto.project.RolloutProject",
"key": ["id"]
}}
### output ###
<<<update>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.ProjectController",
"controllerMethod":"projectUpdate"
}}




## delete project ##
soft delete - hard delete can only be done using backend admin panel with ROOT access
### url ###
"/api/project/delete"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"dto": "com.tctools.business.dto.project.RolloutProject",
"exclude": ["all"],
"key": ["id"]
}}
### output ###
<<<delete>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.ProjectController",
"controllerMethod":"projectDelete"
}}




## get project ##
### url ###
"/api/project/get/by/id"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **Long id**: project id
### output ###
{{
"format":"object",
"dto": "com.tctools.business.dto.project.RolloutProject$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.ProjectController",
"controllerMethod":"projectGet"
}}




## search projects ##
### url ###
"/api/projects/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"searchParams": "com.tctools.business.dto.project.RolloutProject"
}}
### output ###
{{
"searchResult": "com.tctools.business.dto.project.RolloutProject$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.ProjectController",
"controllerMethod":"projectsSearch"
}}
