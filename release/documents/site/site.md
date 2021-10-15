## insert new site ##
### url ###
"/api/site/insert"
### access ###
 * ADMIN 
 * USER 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#Site'>Site</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#Site'>Site</a> as described bellow)
* **String code:**
* Map&lt;String, String&gt; name: {"lang1": "valueForLang1", "lang2": "valueForLang2", ....}
* Long siteClassId:
* Long siteTypeId:
* Long regionId:
* **Long provinceId:**
* **Long cityId:**
* Long districtId:
* Long locationTypeId:
* String address:
* **Location location:** {"latitude": double, "longitude": double}
* String candidate:
* List&lt;String&gt; frequency:
* List&lt;String&gt; technology:
* String description:
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "value": inserted record,
        "successful": true
    }
### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission





## update site ##
### url ###
"/api/site/update"
### access ###
 * ADMIN 
 * USER 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#Site'>Site</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#Site'>Site</a> as described bellow)
* <strong class='key'>Long id:</strong> Site id (primary key)  [update/delete condition]
* **String code:**
* Map&lt;String, String&gt; name: {"lang1": "valueForLang1", "lang2": "valueForLang2", ....}
* Long siteClassId:
* Long siteTypeId:
* Long regionId:
* **Long provinceId:**
* **Long cityId:**
* Long districtId:
* Long locationTypeId:
* String address:
* **Location location:** {"latitude": double, "longitude": double}
* String candidate:
* List&lt;String&gt; frequency:
* List&lt;String&gt; technology:
* String description:
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "successful": true
    }
### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## delete site ##
soft delete - hard delete can only be done using backend admin panel with ROOT access
### url ###
"/api/site/delete"
### access ###
 * ADMIN 
 * USER 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <strong class='key'>Long id:</strong> Site id (primary key)  [update/delete condition]
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "successful": true
    }
### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get site ##
get site by id or code
### url ###
"/api/site/get"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* Long id: either id or code must be given
* String code: either id or code must be given
### output ###
{ <a href='/admin/document/show/dtos#Viewable'>Viewable</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#Viewable'>Viewable</a> as described bellow)
* Long id:
* String code:
* String name: value is set based on selected locale.
* Localed siteClass: <a href='/admin/document/show/dtos#SiteClass-Localed'>{SiteClass.Localed} (see object reference document)</a>
* Localed siteType: <a href='/admin/document/show/dtos#SiteType-Localed'>{SiteType.Localed} (see object reference document)</a>
* String frequencyBand:
* Localed region: <a href='/admin/document/show/dtos#Region-Localed'>{Region.Localed} (see object reference document)</a>
* Localed province: <a href='/admin/document/show/dtos#Province-Localed'>{Province.Localed} (see object reference document)</a>
* Localed city: <a href='/admin/document/show/dtos#City-Localed'>{City.Localed} (see object reference document)</a>
* District district: <a href='/admin/document/show/dtos#District'>{District} (see object reference document)</a>
* Localed locationType: <a href='/admin/document/show/dtos#LocationType-Localed'>{LocationType.Localed} (see object reference document)</a>
* String address:
* Location location: {"latitude": double, "longitude": double}
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## search sites ##
### url ###
"/api/sites/search"
### access ###
 * ADMIN 
 * USER 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <a href='/admin/document/show/dtos#Site'>{Site}</a> : <a href='/admin/document/show?document=document--webservice--common--search.md'>SEE "search params"</a>
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#Site-Viewable'>[{Site.Viewable}]</a></br>    if pagination = true in params then {<br/>        List&lt;Site.Viewable&gt; data: <a href='/admin/document/show/dtos#Site-Viewable'>Site.Viewable</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## site select auto complete ##
autocomplete search on site code
### url ###
"/api/sites/autocomplete"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **String code**: part of site code
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#Site-ViewableTiny'>[{Site.ViewableTiny}]</a></br>    if pagination = true in params then {<br/>        List&lt;Site.ViewableTiny&gt; data: <a href='/admin/document/show/dtos#Site-ViewableTiny'>Site.ViewableTiny</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission





## get sites near a point ##
### url ###
"/api/sites/near"
### access ###
 * ADMIN 
 * USER 

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
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#Site-Viewable'>[{Site.Viewable}]</a></br>    if pagination = true in params then {<br/>        List&lt;Site.Viewable&gt; data: <a href='/admin/document/show/dtos#Site-Viewable'>Site.Viewable</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission
