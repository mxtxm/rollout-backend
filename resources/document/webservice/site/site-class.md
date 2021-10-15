## get SiteClass list ##
### url ###
"/ui/site/classes/get/all"
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
"dto":"com.tctools.business.dto.site.SiteClass"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteClassController",
"controllerMethod":"siteClassesGetAll"
}}




## get SiteClass list as key value ##
### url ###
"/ui/site/classes/get/all/keyval"
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
"controllerClass":"com.tctools.web.api.site.SiteClassController",
"controllerMethod":"siteClassesGetAllKeyval"
}}
