## add sites to project ##
add sites by site.id or site.code to project
### url ###
"/api/project/site/add"
### access ###
 * ADMIN 

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
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission





## remove sites to project ##
remove sites by site.id or site.code from project
### url ###
"/api/project/site/remove"
### access ###
PUBLIC
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
