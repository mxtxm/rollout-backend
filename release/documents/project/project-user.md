## add user to project ##
### url ###
"/api/project/user/add"
### access ###
 * ADMIN 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#ProjectUser'>ProjectUser</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#ProjectUser'>ProjectUser</a> as described bellow)
* **Long userId:**
* **Long projectId:**
* List&lt;String&gt; subRoleTags:
### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "dto": (Object) { inserted-object },
        "value": (long) inserted-id,
        "successful": (boolean) true/false
    }

### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission



## update user / project ##
use to update role tags
### url ###
"/api/project/user/update"
### access ###
 * ADMIN 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#ProjectUser'>ProjectUser</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#ProjectUser'>ProjectUser</a> as described bellow)
* <strong class='key'>Long id:</strong> ProjectUser id (primary key)  [update/delete condition]
* List&lt;String&gt; subRoleTags:
### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "dto": (Object) { updated-object },
        "successful": (boolean) true/false
    }

### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission





## remove user from project ##
either by (id) or by (projectId, userId)
### url ###
"/api/project/user/remove"
### access ###
 * ADMIN 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#ProjectUser'>ProjectUser</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#ProjectUser'>ProjectUser</a> as described bellow)
* Long id:
* **Long userId:**
* **Long projectId:**
### output ###
    JSON
    {
        "code": (int) status code 200/4xx/5xx,
        "message": (String) "message, i.e. success or user validation errors",
        "successful": (boolean) true/false
    }

### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get user role tags in a project ##
### url ###
"/api/project/user/get/role/tags"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **Long projectid**:
* Long userid (default=signed in user): 
### output ###
{ <a href='/admin/document/show/dtos#ViewableTags'>ViewableTags</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#ViewableTags'>ViewableTags</a> as described bellow)
* Long id:
* List&lt;String&gt; roleTags:
* List&lt;String&gt; subRoleTags:
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get all users and their role tags in a project ##
### url ###
"/api/project/users/get"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **Long projectid**:
### output ###
{ <a href='/admin/document/show/dtos#Viewable'>Viewable</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#Viewable'>Viewable</a> as described bellow)
* Long id:
* User user: <a href='/admin/document/show/dtos#User'>{User} (see object reference document)</a>
* List&lt;String&gt; roleTags:
* List&lt;String&gt; subRoleTags:
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## search project users ##
### url ###
"/api/project/users/search"
### access ###
PUBLIC
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <a href='/admin/document/show/dtos#ProjectUser'>{ProjectUser}</a> : <a href='/admin/document/show?document=document--webservice--common--search.md'>SEE "search params"</a>
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#ProjectUser-Viewable'>[{ProjectUser.Viewable}]</a></br>    if pagination = true in params then {<br/>        List&lt;ProjectUser.Viewable&gt; data: <a href='/admin/document/show/dtos#ProjectUser-Viewable'>ProjectUser.Viewable</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
