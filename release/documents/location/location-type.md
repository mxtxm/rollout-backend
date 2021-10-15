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
[ { <a href='/admin/document/show/dtos#LocationType'>LocationType</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#LocationType'>LocationType</a> as described bellow)
* Long id:
* **Map&lt;String, String&gt; name:** {"lang1": "valueForLang1", "lang2": "valueForLang2", ....}
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported





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
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
