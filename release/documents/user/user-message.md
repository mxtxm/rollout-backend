## insert new user message ##
### url ###
"/api/user/message/insert"
### access ###
 * ADMIN 
 * USER 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* Long id:
* **Long userId:**
* Long senderId:
* String senderName:
* **String message:**
* **Boolean read:** default=false
* DateTime createT:
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



## delete user message ##
### url ###
"/api/user/message/delete"
### access ###
 * ADMIN 
 * USER 

### method ###
POST
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <strong class='key'>Long id:</strong> UserMessage id (primary key)  [update/delete condition]
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



## get user message by id ##
get user message by id
### url ###
"/api/user/message/get/by/id"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
* **Long id**: user message id
### output ###
{ <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> } (the JSON may contain fields of object <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> as described bellow)
* Long id:
* **Long userId:**
* Long senderId:
* String senderName:
* **String message:**
* **Boolean read:** default=false
* DateTime createT:
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## set message read ##

### url ###
"/api/user/message/set/read"
### access ###
 * ADMIN 
 * USER 

### method ###
GET
### headers ###
* **String X-Auth-Token**: auth token
### params ###
* **Long id**: user message id
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



## search users ##
### url ###
"/api/user/messages/search"
### access ###
 * ADMIN 
 * USER 

### method ###
POST JSON
### headers ###
* **String X-Auth-Token**: auth token
* String X-Lang: (default=SYSTEM-DEFINED-LANG) "fa" or "en" or ...
### params ###
* <a href='/admin/document/show/dtos#UserMessage'>{UserMessage}</a> : <a href='/admin/document/show?document=document--webservice--common--search.md'>SEE "search params"</a>
### output ###
<pre>JSON<br/>    if pagination = false in params then <a href='/admin/document/show/dtos#UserMessage'>[{UserMessage}]</a></br>    if pagination = true in params then {<br/>        List&lt;UserMessage&gt; data: <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a><br/>        int page: page number<br/>        int length: records per page<br/>        long total: total number of records<br/>    }</pre><br/>
### exceptions ###
* **400** (client side error) Invalid input params
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission



## get all user's messages ##

### url ###
"/api/user/messages/all"
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
[ { <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> as described bellow)
* Long id:
* **Long userId:**
* Long senderId:
* String senderName:
* **String message:**
* **Boolean read:** default=false
* DateTime createT:
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get user's read messages ##

### url ###
"/api/user/messages/get/read"
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
[ { <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> as described bellow)
* Long id:
* **Long userId:**
* Long senderId:
* String senderName:
* **String message:**
* **Boolean read:** default=false
* DateTime createT:
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get user's read messages ##

### url ###
"/api/user/messages/get/unread"
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
[ { <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> as described bellow)
* Long id:
* **Long userId:**
* Long senderId:
* String senderName:
* **String message:**
* **Boolean read:** default=false
* DateTime createT:
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get user's unread message count ##

### url ###
"/api/user/messages/count/unread"
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
    String: number of unread messages 
### exceptions ###
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission




## get user's sent messages ##

### url ###
"/api/user/messages/get/sent"
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
[ { <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> } ] (the JSON list may contain fields of object <a href='/admin/document/show/dtos#UserMessage'>UserMessage</a> as described bellow)
* Long id:
* **Long userId:**
* Long senderId:
* String senderName:
* **String message:**
* **Boolean read:** default=false
* DateTime createT:
### exceptions ###
* **204** (no content) There is no data available for the request
* **500** (server side error) Unexpected backend server error, must be reported
* **401** (client side error / unauthorized) user is not signed in or invalid/expired access token
* **403** (client side error / forbidden) user does not have permission
