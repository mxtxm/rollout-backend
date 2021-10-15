## insert new nodeType ##
### url ###
"/api/node/type/insert"
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
"dto": "com.tctools.business.dto.nodeType.NodeType",
"exclude": ["id"]
}}
### output ###
<<<insert>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.nodeType.NodeTypeController",
"controllerMethod":"nodeTypeInsert"
}}





## update nodeType ##
### url ###
"/api/node/type/update"
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
"dto": "com.tctools.business.dto.nodeType.NodeType",
"key": ["id"]
}}
### output ###
<<<update>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.nodeType.NodeTypeController",
"controllerMethod":"nodeTypeUpdate"
}}




## delete nodeType ##
soft delete - hard delete can only be done using backend admin panel with ROOT access
### url ###
"/api/node/type/delete"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"dto": "com.tctools.business.dto.nodeType.NodeType",
"exclude": ["all"],
"key": ["id"]
}}
### output ###
<<<delete>>>
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.nodeType.NodeTypeController",
"controllerMethod":"nodeTypeDelete"
}}




## get nodeType ##
get nodeType by id or code
### url ###
"/api/node/type/get"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* Long id: either id or code must be given
* String code: either id or code must be given
### output ###
{{
"format":"object",
"dto": "com.tctools.business.dto.nodeType.NodeType$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.nodeType.NodeTypeController",
"controllerMethod":"nodeTypeGet"
}}




## search nodeTypes ##
### url ###
"/api/nodeTypes/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"searchParams": "com.tctools.business.dto.nodeType.NodeType"
}}
### output ###
{{
"searchResult": "com.tctools.business.dto.nodeType.NodeType$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.nodeType.NodeTypeController",
"controllerMethod":"nodeTypesSearch"
}}
