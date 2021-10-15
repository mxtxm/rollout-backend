## get user log by id ##
get user by id
### url ###
"/api/user/log/get/by/id"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
* **Long id**: user id
### output ###
!!!DOCUMENT CREATION ERROR!!!### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission



## search user logs ##
### url ###
"/api/user/logs/search"
### access ###
 * ADMIN 
 * USER 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <a href='/admin/document/show/dtos#UserLog'>{UserLog}</a> : <a href='/admin/document/show?document=document--webservice--common--search.md'>SEE "search params"</a>
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#UserLog'>[{UserLog}]</a></br>    if pagination = true in params then {<br/>        List&lt;UserLog&gt; data: <a href='/admin/document/show/dtos#UserLog'>UserLog</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission
