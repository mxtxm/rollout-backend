## insert new project ##
### url ###
"/api/project/insert"
### access ###
 * ADMIN 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#RolloutProject'>RolloutProject</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#RolloutProject'>RolloutProject</a> as described bellow)
* **String title:**
* **ProjectType projectType:** <a href='/admin/document/show/dtos#ProjectType'>{ProjectType} (see object reference document)</a>
* **Long nodeTypeId:**
* **Boolean active:**
* Boolean enableRequest:
* Boolean enableOverlap:
* Integer maxRequestCount:
* Integer estimateRequestCount:
* String description:
* List&lt;Site.Viewable&gt; sites: <a href='/admin/document/show/dtos#Site-Viewable'>{Site.Viewable} (see object reference document)</a>
* WorkFlowTemplate workFlowTemplate: <a href='/admin/document/show/dtos#WorkFlowTemplate'>{WorkFlowTemplate} (see object reference document)</a>
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





## update project ##
### url ###
"/api/project/update"
### access ###
 * ADMIN 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
{ <a href='/admin/document/show/dtos#RolloutProject'>RolloutProject</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#RolloutProject'>RolloutProject</a> as described bellow)
* <strong class='key'>Long id:</strong> RolloutProject id (primary key)  [update/delete condition]
* **String title:**
* **ProjectType projectType:** <a href='/admin/document/show/dtos#ProjectType'>{ProjectType} (see object reference document)</a>
* **Long nodeTypeId:**
* **Boolean active:**
* Boolean enableRequest:
* Boolean enableOverlap:
* Integer maxRequestCount:
* Integer estimateRequestCount:
* String description:
* List&lt;Site.Viewable&gt; sites: <a href='/admin/document/show/dtos#Site-Viewable'>{Site.Viewable} (see object reference document)</a>
* WorkFlowTemplate workFlowTemplate: <a href='/admin/document/show/dtos#WorkFlowTemplate'>{WorkFlowTemplate} (see object reference document)</a>
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




## delete project ##
soft delete - hard delete can only be done using backend admin panel with ROOT access
### url ###
"/api/project/delete"
### access ###
 * ADMIN 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <strong class='key'>Long id:</strong> RolloutProject id (primary key)  [update/delete condition]
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




## get project ##
### url ###
"/api/project/get/by/id"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* **Long id**: project id
### output ###
{ <a href='/admin/document/show/dtos#Viewable'>Viewable</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#Viewable'>Viewable</a> as described bellow)
* Long id:
* String title:
* ProjectType projectType: <a href='/admin/document/show/dtos#ProjectType'>{ProjectType} (see object reference document)</a>
* NodeType nodeType: <a href='/admin/document/show/dtos#NodeType'>{NodeType} (see object reference document)</a>
* Boolean active:
* Boolean enableRequest:
* Boolean enableOverlap:
* Integer maxRequestCount:
* Integer estimateRequestCount:
* String description:
* List&lt;Site.Viewable&gt; sites: <a href='/admin/document/show/dtos#Site-Viewable'>{Site.Viewable} (see object reference document)</a>
* WorkFlowTemplate workFlowTemplate: <a href='/admin/document/show/dtos#WorkFlowTemplate'>{WorkFlowTemplate} (see object reference document)</a>
### exceptions ###




## search projects ##
### url ###
"/api/projects/search"
### access ###
PUBLIC
### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <a href='/admin/document/show/dtos#RolloutProject'>{RolloutProject}</a> : <a href='/admin/document/show?document=document--webservice--common--search.md'>SEE "search params"</a>
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#RolloutProject-Viewable'>[{RolloutProject.Viewable}]</a></br>    if pagination = true in params then {<br/>        List&lt;RolloutProject.Viewable&gt; data: <a href='/admin/document/show/dtos#RolloutProject-Viewable'>RolloutProject.Viewable</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission
