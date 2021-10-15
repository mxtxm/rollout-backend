## get user roles ##
* ROOT: access to whole system (critical system actions, backend and frontend) (only for develop team)
* ADMIN: access to everything on (backend and frontend) except critical backend items
* USER: can see everything, but access to project/milestone features depends on "ProjectUser" "roleTagForks"
### url ###
"/api/users/get/roles"
### access ###
 * ADMIN 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###

### output ###
    JSON
    {
        "ROOT",
        "ADMIN",
        "MANAGER",
        "USER",
    }
### exceptions ###
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## signin ##
### url ###
"/api/user/signin"
### access ###
PUBLIC
### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **String username**: email or mobile
* **String password**:
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
* String accessToken: obtained access token, subsequent requests must set this token to "X-Auth-Token" header 
### exceptions ###
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## signout ##
### url ###
"/api/user/signout"
### access ###
* PUBLIC
### method ###
GET
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###

### output ###

### exceptions ###




## get signed in user ##

### url ###
"/api/user/get/current"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
### output ###
{ <a href='/admin/document/show/dtos#User'>User</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#User'>User</a> as described bellow)
* Long id:
* **AccessStatus accessStatus:** default=null <a href='/admin/document/show/dtos#AccessStatus'>{AccessStatus} (see object reference document)</a>
* **AuthenticationType authenticationType:** default=null <a href='/admin/document/show/dtos#AuthenticationType'>{AuthenticationType} (see object reference document)</a>
* **Role role:** default=null <a href='/admin/document/show/dtos#Role'>{Role} (see object reference document)</a>
* List&lt;String&gt; roleTags:
* **String username:**
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





## change password ##
if "id" is not provided then signed in user's password will be changed. 
### url ###
"/api/user/change/password"
### access ###
 * ADMIN 
 * USER 

### method ###
POST
### headers ###
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
* **String X-Auth-Token**: auth token
### params ###
* **String password**
* Long id: if "id" is not provided then signature is assigned to signed in user. MANAGER can upload other user signature by sending "id".
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
