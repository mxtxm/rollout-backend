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
[ { <a href='/admin/document/show/dtos#District'>District</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#District'>District</a> as described bellow)
* Long id:
* **String name:**
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported





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
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
