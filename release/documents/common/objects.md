# Dto objects #


<label id='Log'></label>
## Log ##
* Long id
* String tag
* String level
* String message
* DateTime createT

<label id='Settings'></label>
## Settings ##
* Long id
* String key
* String value

<label id='User'></label>
## User ##
* Long id
* AccessStatus accessStatus
* AuthenticationType authenticationType
* Role role
* String username
* String password
* String firstName
* String lastName
* String fullName
* String email
* String mobile
* String organization
* String organizationRole
* List&lt;Long&gt; provinceIds
* DateTime createT
* DateTime signinT
* String avatar
* List&lt;Map&gt; ability
* Map&lt;String, String&gt; extras

<label id='User-AccessStatus'></label>
##### enum: AccessStatus #####
* ENABLED
* PENDING
* DISABLED
* UNSUBSCRIBED



<label id='User-AuthenticationType'></label>
##### enum: AuthenticationType #####
* NewProda
* LDAP



<label id='User-Role'></label>
##### enum: Role #####
* ROOT
* ADMIN
* MANAGER
* USER



<label id='RoleTag'></label>
## RoleTag ##
* Long id
* String name

<label id='RoleTagFork'></label>
## RoleTagFork ##
* Long id
* String roleTag
* String name
* Boolean allowPlanDate
* Boolean allowActualDate
* Boolean allowForecastDate

<label id='UserLog'></label>
## UserLog ##
* Long id
* Long userId
* String action
* String className
* String object
* Map&lt;String, String&gt; headers
* String url
* String ip
* String description
* DateTime time

<label id='UserMessage'></label>
## UserMessage ##
* Long id
* Long userId
* Long senderId
* String senderName
* String message
* Boolean read
* DateTime createT

<label id='UserMessage-Viewable'></label>
#### UserMessage.Viewable ####
* Long id
* User user
* Long senderId
* String senderName
* String message
* String read
* DateTime createT

<label id='Region'></label>
## Region ##
* Long id
* Map&lt;String, String&gt; name

<label id='Region-Localed'></label>
#### Region.Localed ####
* Long id
* String name

<label id='Province'></label>
## Province ##
* Long id
* Map&lt;String, String&gt; name

<label id='Province-Localed'></label>
#### Province.Localed ####
* Long id
* String name

<label id='City'></label>
## City ##
* Long id
* Long provinceId
* Map&lt;String, String&gt; name

<label id='City-Localed'></label>
#### City.Localed ####
* Long id
* Long provinceId
* String name

<label id='District'></label>
## District ##
* Long id
* String name

<label id='LocationType'></label>
## LocationType ##
* Long id
* Map&lt;String, String&gt; name

<label id='LocationType-Localed'></label>
#### LocationType.Localed ####
* Long id
* String name

<label id='RolloutProject'></label>
## RolloutProject ##
* Long id
* String title
* ProjectType projectType
* Long nodeTypeId
* Boolean active
* Boolean enableRequest
* Boolean enableOverlap
* Integer maxRequestCount
* Integer estimateRequestCount
* String description
* List&lt;Long&gt; siteIds
* WorkFlowTemplate workFlowTemplate

<label id='RolloutProject-ProjectType'></label>
##### enum: ProjectType #####
* Location
* Technology
* LocationAndTechnology



<label id='RolloutProject-Viewable'></label>
#### RolloutProject.Viewable ####

<label id='NodeType'></label>
## NodeType ##
* Long id
* String title
* String description

<label id='Milestone'></label>
## Milestone ##
* Boolean isMain
* List&lt;Long&gt; dependencies
* Integer weight
* DateTime plan
* DateTime forecast
* DateTime actual
* String attachment
* List&lt;String&gt; history
* String comments
* ProjectType projectType
* Boolean allowAcceptReject
* Boolean allowNA

<label id='Milestone-ProjectType'></label>
##### enum: ProjectType #####
* Location
* Technology
* LocationAndTechnology



<label id='ProjectUser'></label>
## ProjectUser ##
* Long id
* Long userId
* Long projectId
* List&lt;String&gt; roleTags
* List&lt;String&gt; roleTagForks

<label id='WorkFlowTemplate'></label>
## WorkFlowTemplate ##
* Long id
* Long title
* Long description
* List&lt;WorkFlowTemplateStep&gt; steps

<label id='WorkFlowTemplateDropdown'></label>
## WorkFlowTemplateDropdown ##
* Long id
* Long title
* List&lt;String&gt; values

<label id='WorkFlowTemplateStep'></label>
## WorkFlowTemplateStep ##
* Long id
* Long title
* Long description
* WorkFlowTemplateStepType type
* List&lt;String&gt; roleTagForks
* List&lt;String&gt; values
* Boolean active
* Integer order

<label id='WorkFlowTemplateStep-WorkFlowTemplateStepType'></label>
##### enum: WorkFlowTemplateStepType #####
* Milestone
* FrequencyMilestone
* Input
* File
* Date
* Datetime
* Select
* MultiSelect



<label id='Site'></label>
## Site ##
* Long id
* String code
* Map&lt;String, String&gt; name
* String controller
* DateTime setupDate
* DateTime contractStartDate
* String comments
* Long btsStatusId
* Long btsOwnershipId
* Long siteClassId
* Long siteTypeId
* Long siteOwnershipId
* Long btsInstallId
* String towerHeight
* String buildingHeight
* Long btsTowerTypeId
* String frequencyBand
* List&lt;Sector&gt; sectors
* Long regionId
* Long provinceId
* Long cityId
* Long districtId
* Long locationTypeId
* String address
* Location location
* Integer etcTransceiverCount
* CollocationType collocationType
* List&lt;Collocation&gt; collocations

<label id='Site-CollocationType'></label>
##### enum: CollocationType #####
* None
* Host
* Guest



<label id='Site-ViewableIdCode'></label>
#### Site.ViewableIdCode ####
* Long id
* String code

<label id='Site-ViewableTiny'></label>
#### Site.ViewableTiny ####
* Long id
* String code
* Long btsStatusId
* String name
* Localed province
* Localed city
* String address
* Location location

<label id='Site-Viewable'></label>
#### Site.Viewable ####
* Long id
* String code
* String name
* String controller
* DateTime setupDate
* String setupDateFa
* DateTime contractStartDate
* String contractStartDateFa
* String comments
* Localed btsStatus
* Localed btsOwnership
* Localed siteClass
* Localed siteType
* SiteOwnership siteOwnership
* Localed btsInstall
* BtsTowerType btsTowerType
* String buildingHeight
* String towerHeight
* String frequencyBand
* List&lt;com.tctools.business.dto.site.Sector$Viewable&gt; sectors
* Localed region
* Localed province
* Localed city
* District district
* Localed locationType
* String address
* Location location
* Integer etcTransceiverCount
* CollocationType
<label id='Viewable-CollocationType'></label>
 collocationType
* List&lt;com.tctools.business.dto.site.Collocation$Viewable&gt; collocations

<label id='SiteClass'></label>
## SiteClass ##
* Long id
* Map&lt;String, String&gt; name

<label id='SiteClass-Localed'></label>
#### SiteClass.Localed ####
* Long id
* String name

<label id='SiteType'></label>
## SiteType ##
* Long id
* Map&lt;String, String&gt; name

<label id='SiteType-Localed'></label>
#### SiteType.Localed ####
* Long id
* String name

<label id='SiteOwnership'></label>
## SiteOwnership ##
* Long id
* String name

<label id='BtsOwnership'></label>
## BtsOwnership ##
* Long id
* Map&lt;String, String&gt; name

<label id='BtsOwnership-Localed'></label>
#### BtsOwnership.Localed ####
* Long id
* String name

<label id='BtsShare'></label>
## BtsShare ##
* Long id
* Map&lt;String, String&gt; name

<label id='BtsShare-Localed'></label>
#### BtsShare.Localed ####
* Long id
* String name

<label id='BtsStatus'></label>
## BtsStatus ##
* Long id
* Map&lt;String, String&gt; name

<label id='BtsStatus-Localed'></label>
#### BtsStatus.Localed ####
* Long id
* String name

<label id='BtsTowerType'></label>
## BtsTowerType ##
* Long id
* String name

<label id='BtsInstall'></label>
## BtsInstall ##
* Long id
* Map&lt;String, String&gt; name

<label id='BtsInstall-Localed'></label>
#### BtsInstall.Localed ####
* Long id
* String name

<label id='SectorOptimization'></label>
## SectorOptimization ##
* Long id
* String name

<label id='Operator'></label>
## Operator ##
* Long id
* Map&lt;String, String&gt; name

<label id='Operator-Localized'></label>
#### Operator.Localized ####
* Long id
* String name

<label id='MongoSequence'></label>
## MongoSequence ##
* Long id
* String n
* Long c

<label id='Sector'></label>
## Sector ##
* Boolean selected
* String title
* Integer antennaCount
* Long locationTypeId
* Long sectorOptimizationId
* String antennaType
* Integer azimuth
* Double height
* Double onSiteHeight
* Integer mechanicalTilt
* Integer electricalTilt
* Boolean isOmni
* Boolean isDirectional

<label id='Sector-Viewable'></label>
#### Sector.Viewable ####
* Boolean selected
* String title
* Integer antennaCount
* Localed locationType
* SectorOptimization sectorOptimization
* String antennaType
* Integer azimuth
* Double height
* Double onSiteHeight
* Integer mechanicalTilt
* Integer electricalTilt

<label id='Collocation'></label>
## Collocation ##
* CollocationType type
* Long operatorId

<label id='Collocation-CollocationType'></label>
##### enum: CollocationType #####
* None
* Host
* Guest



<label id='Collocation-Viewable'></label>
#### Collocation.Viewable ####
* CollocationType
<label id='Viewable-CollocationType'></label>
 type
* Localized operator
