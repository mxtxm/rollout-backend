## insert new site ##
### url ###
"/api/site/insert"
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
"dto": "com.tctools.business.dto.site.Site",
"exclude": ["id"]
}}
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "value": inserted record,
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteController",
"controllerMethod":"siteInsert"
}}





## update site ##
### url ###
"/api/site/update"
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
"dto": "com.tctools.business.dto.site.Site",
"key": ["id"]
}}
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteController",
"controllerMethod":"siteUpdate"
}}




## delete site ##
soft delete - hard delete can only be done using backend admin panel with ROOT access
### url ###
"/api/site/delete"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"dto": "com.tctools.business.dto.site.Site",
"exclude": ["all"],
"key": ["id"]
}}
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteController",
"controllerMethod":"siteDelete"
}}




## get site ##
get site by id or code
### url ###
"/api/site/get"
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
"dto": "com.tctools.business.dto.site.Site$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteController",
"controllerMethod":"siteGet"
}}




## search sites ##
### url ###
"/api/sites/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{{
"searchParams": "com.tctools.business.dto.site.Site"
}}
### output ###
{{
"searchResult": "com.tctools.business.dto.site.Site$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteController",
"controllerMethod":"sitesSearch"
}}




## site select auto complete ##
autocomplete search on site code
### url ###
"/api/sites/autocomplete"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **String code**: part of site code
### output ###
{{
"searchResult": "com.tctools.business.dto.site.Site$ViewableTiny"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteController",
"controllerMethod":"sitesAutocomplete"
}}





## get sites near a point ##
### url ###
"/api/sites/near"
### access ###
<<<access>>>
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **Double latitude**:
* **Double longitude**:
* Double radius: in meters, default=1000m
### output ###
{{
"searchResult": "com.tctools.business.dto.site.Site$Viewable"
}}
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.site.SiteController",
"controllerMethod":"sitesNear"
}}
