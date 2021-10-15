## add sites to project ##
add sites by site.id or site.code to project
### url ###
"/api/project/site/add"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **id (long)**: project id
* **siteids (string)**: site ids i.e: "2,32,442,9" or '[2,32,442,9]'
* **sitecodes (string)**: site codes i.e: "TH0001,TH0201,TH2201" or '["TH0001","TH0201","TH2201"]' 

* siteids or sitecodes is required 
### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "dto": (Object) { inserted-object },
        "value": [duplicated site-ids or site-codes],
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.site.ProjectSiteController",
"controllerMethod":"projectSiteAdd"
}}





## remove sites to project ##
remove sites by site.id or site.code from project
### url ###
"/api/project/site/remove"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **id (long)**: project id
* **siteids (string)**: site ids i.e: "2,32,442,9" or '[2,32,442,9]'
* **sitecodes (string)**: site codes i.e: "TH0001,TH0201,TH2201" or '["TH0001","TH0201","TH2201"]' 

* siteids or sitecodes is required 
### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "dto": (Object) { inserted-object },
        "successful": true
    }
### exceptions ###
{{
"action":"exception",
"controllerClass":"com.tctools.web.api.project.site.ProjectSiteController",
"controllerMethod":"projectSiteRemove"
}}
