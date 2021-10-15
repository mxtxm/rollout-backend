## get city list ##
### url ###
"/api/cities/get/all"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ... 
### params ###

### output ###
{{
"format":"list",
"dto":"com.tctools.business.dto.location.City"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.location.CityController",
"controllerMethod":"citiesGetAll"
}}




## get city list as key value as key value ##
if lang is not provided value will be all lang values glued by "-"
### url ###
"/api/cities/get/all/keyval"
### access ###
<<<access>>>
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
"controllerClass":"com.tctools.web.api.location.CityController",
"controllerMethod":"citiesGetAll"
}}
