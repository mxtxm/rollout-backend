## get region type list ##
### url ###
"/api/regions/get/all"
### access ###
PUBLIC
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###

### output ###
{{
"format":"list",
"dto":"com.tctools.business.dto.location.Region"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.location.RegionController",
"controllerMethod":"regionsGetAll"
}}




## get region type list as key value ##
### url ###
"/api/regions/get/all/keyval"
### access ###
PUBLIC
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###

### output ###
    JSON
    {1: "value1", 2: "value2", ...}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.location.RegionController",
"controllerMethod":"regionsGetAllKeyval"
}}
