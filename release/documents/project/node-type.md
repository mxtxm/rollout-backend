## insert new nodeType ##
### url ###
"/api/node/type/insert"
### access ###
PUBLIC
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
!!!DOCUMENT CREATION ERROR!!!### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "dto": (Object) { inserted-object },
        "value": (long) inserted-id,
        "successful": (boolean) true/false
    }

### exceptions ###





## update nodeType ##
### url ###
"/api/node/type/update"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
!!!DOCUMENT CREATION ERROR!!!### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "dto": (Object) { updated-object },
        "successful": (boolean) true/false
    }

### exceptions ###




## delete nodeType ##
soft delete - hard delete can only be done using backend admin panel with ROOT access
### url ###
"/api/node/type/delete"
### access ###
<<<access>>>
### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
!!!DOCUMENT CREATION ERROR!!!### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "successful": (boolean) true/false
    }

### exceptions ###




## get nodeType ##
get nodeType by id or code
### url ###
"/api/node/type/get"
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
!!!DOCUMENT CREATION ERROR!!!### exceptions ###




## search nodeTypes ##
### url ###
"/api/nodeTypes/search"
### access ###
<<<access>>>
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <a href='/admin/document/show/dtos#NodeType'>{NodeType}</a> : <a href='/admin/document/show?document=document--webservice--common--search.md'>SEE "search params"</a>
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#NodeType-Viewable'>[{NodeType.Viewable}]</a></br>    if pagination = true in params then {<br/>        List&lt;NodeType.Viewable&gt; data: <a href='/admin/document/show/dtos#NodeType-Viewable'>NodeType.Viewable</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
