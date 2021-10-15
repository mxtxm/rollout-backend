## get SiteType list ##
### url ###
"/ui/site/types/get/all"
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
"format":"list",
"dto":"com.tctools.business.dto.site.SiteType"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteTypeController",
"controllerMethod":"siteTypesGetAll"
}}




## get SiteType list as key value ##
### url ###
"/ui/site/types/get/all/keyval"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###

### output ###
    JSON
    {"1": "xxxxx", "2": "yyyyyy",...}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteTypeController",
"controllerMethod":"siteTypesGetAllKeyval"
}}
