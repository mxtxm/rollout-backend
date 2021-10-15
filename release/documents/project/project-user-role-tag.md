## add project user role tag ##
### url ###
"/api/project/role/tag/insert"
### access ###
 * ADMIN 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#RoleTag'>RoleTag</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#RoleTag'>RoleTag</a> as described bellow)
* **String name:**
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





## update project user role tag ##
### url ###
"/api/project/role/tag/update"
### access ###
 * ADMIN 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#RoleTag'>RoleTag</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#RoleTag'>RoleTag</a> as described bellow)
* <strong class='key'>Long id:</strong> RoleTag id (primary key)  [update/delete condition]
* **String name:**
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




## get all role tags ##

### url ###
"/api/project/role/tags/get"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
### output ###
!!!DOCUMENT CREATION ERROR!!!### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission






## add project user sub role tag ##
### url ###
"/api/project/sub/role/tag/insert"
### access ###
 * ADMIN 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#SubRoleTag'>SubRoleTag</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#SubRoleTag'>SubRoleTag</a> as described bellow)
* **String roleTag:**
* **String name:**
* **Boolean allowPlanDate:**
* **Boolean allowActualDate:**
* **Boolean allowForecastDate:**
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





## update project user sub role tag ##
### url ###
"/api/project/sub/role/tag/update"
### access ###
 * ADMIN 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#SubRoleTag'>SubRoleTag</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#SubRoleTag'>SubRoleTag</a> as described bellow)
* <strong class='key'>Long id:</strong> SubRoleTag id (primary key)  [update/delete condition]
* **String roleTag:**
* **String name:**
* **Boolean allowPlanDate:**
* **Boolean allowActualDate:**
* **Boolean allowForecastDate:**
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





### url ###
"/api/project/sub/role/tags/get"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
### output ###
!!!DOCUMENT CREATION ERROR!!!### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission
