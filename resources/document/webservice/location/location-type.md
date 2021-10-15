## get location type list ##
### url ###
"/api/location/type/get/all"
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
"dto":"com.tctools.business.dto.location.LocationType"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.location.LocationTypeController",
"controllerMethod":"locationTypeGetAll"
}}





## get location type list as key value ##
### url ###
"/api/location/type/get/all/keyval"
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
"controllerClass":"com.tctools.web.api.location.LocationTypeController",
"controllerMethod":"locationTypeGetAllKeyval"
}}
