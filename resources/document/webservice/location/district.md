## get district list ##
### url ###
"/api/districts/get/all"
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
"dto":"com.tctools.business.dto.location.District"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.location.DistrictController",
"controllerMethod":"districtsGetAll"
}}





## get district list as key value ##
### url ###
"/api/districts/get/all/keyval"
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
"controllerClass":"com.tctools.web.api.location.DistrictController",
"controllerMethod":"districtsGetAll"
}}
