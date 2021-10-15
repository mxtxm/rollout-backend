## insert new user ##
### url ###
"/api/user/insert"
### access ###
 * ADMIN 
 * USER 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **AccessStatus accessStatus:** default=null <a href='/admin/document/show/dtos#AccessStatus'>{AccessStatus} (see object reference document)</a>
* **AuthenticationType authenticationType:** default=null <a href='/admin/document/show/dtos#AuthenticationType'>{AuthenticationType} (see object reference document)</a>
* **String username:**
* String password:
* **String firstName:**
* **String lastName:**
* String email:
* String mobile:
* String organization:
* String organizationRole:
* List&lt;Long&gt; provinceIds:
### output ###
    JSON
    {
        "code": 200,
        "message": "success message",
        "value": inserted-id (long),
        "successful": true
    }
### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## user update ##
### url ###
"/api/user/update"
### access ###
 * ADMIN 
 * USER 

### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
* Long id:
* **AccessStatus accessStatus:** default=null <a href='/admin/document/show/dtos#AccessStatus'>{AccessStatus} (see object reference document)</a>
* **AuthenticationType authenticationType:** default=null <a href='/admin/document/show/dtos#AuthenticationType'>{AuthenticationType} (see object reference document)</a>
* **String username:**
* String password:
* **String firstName:**
* **String lastName:**
* String email:
* String mobile:
* String organization:
* String organizationRole:
* List&lt;Long&gt; provinceIds:
### output ###
    JSON
    {
        "code": 200,
        "message"; "update success message",
        "successful": true
    }
### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission





## delete user ##
### url ###
"/api/user/delete"
### access ###
 * ADMIN 
 * USER 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <strong class='key'>Long id:</strong> User id (primary key)  [update/delete condition]
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



## get user by id ##
get user by id
### url ###
"/api/user/get/by/id"
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
{ <a href='/admin/document/show/dtos#User'>User</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#User'>User</a> as described bellow)
* Long id:
* **AccessStatus accessStatus:** default=null <a href='/admin/document/show/dtos#AccessStatus'>{AccessStatus} (see object reference document)</a>
* **AuthenticationType authenticationType:** default=null <a href='/admin/document/show/dtos#AuthenticationType'>{AuthenticationType} (see object reference document)</a>
* **Role role:** default=null <a href='/admin/document/show/dtos#Role'>{Role} (see object reference document)</a>
* List&lt;String&gt; roleTags:
* **String username:**
* String password:
* **String firstName:**
* **String lastName:**
* String fullName:
* String email:
* String mobile:
* String organization:
* String organizationRole:
* List&lt;Long&gt; provinceIds:
* DateTime createT:
* DateTime signinT:
* String avatar:
* String photo:
* List&lt;Map&gt; ability:
* Map&lt;String, String&gt; extras:
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission



## search users ##
### url ###
"/api/users/search"
### access ###
 * ADMIN 
 * USER 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <a href='/admin/document/show/dtos#User'>{User}</a> : <a href='/admin/document/show?document=document--webservice--common--search.md'>SEE "search params"</a>
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#User'>[{User}]</a></br>    if pagination = true in params then {<br/>        List&lt;User&gt; data: <a href='/admin/document/show/dtos#User'>User</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission



## get all users ##

### url ###
"/api/users/all"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###

### output ###
[ { <a href='/admin/document/show/dtos#User'>User</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#User'>User</a> as described bellow)
* Long id:
* **AccessStatus accessStatus:** default=null <a href='/admin/document/show/dtos#AccessStatus'>{AccessStatus} (see object reference document)</a>
* **AuthenticationType authenticationType:** default=null <a href='/admin/document/show/dtos#AuthenticationType'>{AuthenticationType} (see object reference document)</a>
* **Role role:** default=null <a href='/admin/document/show/dtos#Role'>{Role} (see object reference document)</a>
* List&lt;String&gt; roleTags:
* **String username:**
* String password:
* **String firstName:**
* **String lastName:**
* String fullName:
* String email:
* String mobile:
* String organization:
* String organizationRole:
* List&lt;Long&gt; provinceIds:
* DateTime createT:
* DateTime signinT:
* String avatar:
* String photo:
* List&lt;Map&gt; ability:
* Map&lt;String, String&gt; extras:
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get users as key value ##

### url ###
"/api/users/all/keyval"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
{ <a href='/admin/document/show/dtos#User'>User</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#User'>User</a> as described bellow)
* Long id:
* **AccessStatus accessStatus:** default=null <a href='/admin/document/show/dtos#AccessStatus'>{AccessStatus} (see object reference document)</a>
* **AuthenticationType authenticationType:** default=null <a href='/admin/document/show/dtos#AuthenticationType'>{AuthenticationType} (see object reference document)</a>
* **Role role:** default=null <a href='/admin/document/show/dtos#Role'>{Role} (see object reference document)</a>
* List&lt;String&gt; roleTags:
* **String username:**
* String password:
* **String firstName:**
* **String lastName:**
* String fullName:
* String email:
* String mobile:
* String organization:
* String organizationRole:
* List&lt;Long&gt; provinceIds:
* DateTime createT:
* DateTime signinT:
* String avatar:
* String photo:
* List&lt;Map&gt; ability:
* Map&lt;String, String&gt; extras:
### output ###
    JSON
    [User.id: User.fullName, ...]
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission



## Upload user avatar image ##
updates previous image
### url ###
"/api/user/avatar/submit"
### access ###
 * ADMIN 
 * USER 

### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
* **File file**: jpg image file
* Long id: if "id" is not provided then signature is assigned to signed in user. MANAGER can upload other user signature by sending "id".
### output ###
    JSON
    {
        "code": 200,
        "message"; "update success message",
        "successful": true,
        "value": signature-url
    }
### exceptions ###
* **400** (client side error) Invalid input params
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission


