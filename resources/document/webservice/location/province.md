## get province list ##
### url ###
"/api/provinces/get/all"
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
"dto":"com.tctools.business.dto.location.Province"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.location.ProvinceController",
"controllerMethod":"provincesGetAllKeyval"
}}




## get province list as key value ##
if lang is not provided value will be all lang values glued by "-"
### url ###
"/api/provinces/get/all/keyval"
### access ###
PUBLIC
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###

### output ###
    JSON
    {"1": "Tehran", "2": "Kerman",...}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.location.ProvinceController",
"controllerMethod":"provincesGetAllKeyval"
}}
