## get BtsOwnership list ##
### url ###
"/ui/site/bts/ownership/get"
### access ###
* VENDOR
* MANAGER
* TECHNICIAN
### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ... 
### params ###

### output ###
[ { <a href='/admin/document/show/dtos#BtsOwnership'>BtsOwnership</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#BtsOwnership'>BtsOwnership</a> as described bellow)
* Long id:
* **Map&lt;String, String&gt; name:** {"lang1": "valueForLang1", "lang2": "valueForLang2", ....}
### exceptions ###
* 401/403 AuthError/AuthPermissionError




## get BtsOwnership list as key value ##
### url ###
"/ui/site/bts/ownership/keyval"
### access ###
* VENDOR
* MANAGER
* TECHNICIAN
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
* 401/403 AuthError/AuthPermissionError
