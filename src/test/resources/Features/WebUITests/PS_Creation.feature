@AP_TestCase

Feature: The Profitability Study Creation
#Feature: Login Page 

@Login
  Scenario: Login with valid credential & MFA Process
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    #Then User should redirect to the home page
    Examples:
        |UserName|Password|UserID |
        |SD51978 |Gd009988|SD51978|
        
@AP_ClientCreation
  Scenario Outline: Verify the behaviour of Clinet Creation
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button    
    
    When user navigate to contrib admin tab
    Then user click on Configuration User sub tab
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    When user should able to see the pa study
    Then user click on creation
    Then user able to see the Head of profitabilty study page
    When user click on Create Amendment
    Then user able to see the create a client page
    When user click on country
      | index |
      | 0     |
    Then user fill the client full name filed<ClientName>
    Then user click on cancel btn
    Then user able to see the Head of profitabilty study page 
    
    When user click on Create Amendment
    Then user able to see the create a client page
    When user click on country
      | index |
      | 0     |
    #Then user fill the client full name filed<ClientName>
    #When user click on Create Btn
   
   Then User able to see the new created client on PS study creation Page
   When user click on delete btn
   Then user click on country
      | index |
      | 0                   |
    And user click on client
      #| clientsPrasent |
     # |          38561 |
   Then user click on cancel btn
   Then user able to see the Head of profitabilty study page 
   When user click on delete btn
   Then user click on country
      | index |
      | 0     |
    And user click on client
     #| clientsPrasent |
      #|          38561 |
   Then user click on delete option
   When user click ok for delete confirmation
  # Then user able to see client deleted massage in Head of profitabilty study page 
   
    
    Examples: 
      |ClientName|UserName|UserID|Password|
      |NRTtest   |SD51978 |SD51978|Gd009988|
      
@ProfitabilityStudies
  Scenario Outline: Check the Study number
  #Given User enter valid userID<UserName>
    #When user click on next button
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button    
    When user navigate to contrib admin tab
    Then user click on Configuration User sub tab
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    #When user is on the home page
    And user check the vehicle is presant or not
    And user able to see the text message
    When user should able to see the pa study
    Then user click on creation
    Then user able to see the Head of profitabilty study page
    When user click on country
    #  | selectedcountryvalue |
     # | AT                   |
       | index |
       | 0    |
    And user click on client
      #| clientsPrasent |
      #|          38561 |
    And user enter the status code<scode>
    Then user select the valid start date<ValidStartdate>
    And user select the valid end date<ValidEnddate>
    #Then user select the starting date
    #|smonthdate|
    #|Nov 2025|
    #And user select the ending date
    #|emonthDate|
    #|Nov 2025|
    Then user click on validate button
    When user click on model range
      #| range   |
      #| 1PP6&DE |
    And user select the valid version date
      #| value |
      #| F0    |
      
    When user click on cancel btn
    Then user able to see the Head of profitabilty study page
    
    When user click on country
      | selectedcountryvalue |
      | 0                 |
    And user click on client
      #| clientsPrasent |
     # |          38561 |
    And user enter the status code<scode>
    Then user select the valid start date<ValidStartdate>
    And user select the valid end date<ValidEnddate>
     Then user click on validate button
    When user click on model range
     # | range   |
     # | 1PP6&DE |
    And user select the valid version date
      #| value |
     # | F0    |
 
    And user click on searching
    Then user able to see the version lists
    When user select the version checkbox from version list
    #|  Checkboxtext   |
    #|408 ALL 12E MHEV BP6|
    Then user able to click on add the versions in basket
    #And user click on options
    #Then user select the option check boxes
    #|Optioncode|
    #| ZHX5     |
    #And user can validate
    Then user select the versions in list
    #|versionText     |
    #|1PP6CBPJHWBYA0F0|
    
    Then user click on versiondelete btn
    And user click on options
    Then user select the option check boxes
    #|Optioncode|
    #| ZHX5     |
    And user can validate
 
    Then user click on add this versions into profitability
    Then user select the Invoicing
    Then user select the B2B under channel
    Then user send volume number<volume>
    And user click on International customer volume bonus
    And user click on national customer volume bonus
    Then user click on National customer range bonus
    Then user click on Noleaser
    And user click on save draft
    Then user click on save this profitability study
    Then user able to see the profitability study number
    When user select the export option
      | SelExport |
      | Unit  |
    Then user click on export btn
    When user select the export option
      | SelExport |
      | Detailed  |
    Then user click on export btn
    When user click on Modify PF study
    Then user click on add version
    Then user select the modelrange of modification
    #| range   |
    #| 1PK9&DE |
    And user click on modifiaction versions
    And user click on searching
    Then user select the found version
    #|  Checkboxtext   |
    #|RIFTER ALL ELECT|
    Then user able to click on add the versions in basket
    And user click on options
    Then user select the options for modification
    #|optioncode|
    #| JA12     |
    Then user click the optionvalidate button
    Then user select the versioncode check box
    #|versionText     |
    #|1PK9AFTZIFB0A0B0|
    Then user click on add this versions into pf study
    
    Then user click on add this versions into pf study
    Then user click on cancel modification btn
     
    
    When user click on Modify PF study
    Then user click on add version
    Then user select the modelrange of modification
    #| range   |
    #| 2PXE&DE |
    And user click on modifiaction versions
    And user click on searching
    Then user select the found version
    #|  Checkboxtext   |
    #|BX FT300 LT L2H1 22H|
    Then user able to click on add the versions in basket
    And user click on options
    Then user select the options for modification
    #|optioncode|
    #| LL02     |
    Then user click the optionvalidate button
    
    When user click on choice of the car families btn
    Then user able to see car family page
    Then user click on CarFamily validate btn
    
    Then user select the versioncode check box
    #|versionText     |
    #|2PXE3DHOGKB0A013|
    Then user click on add this versions into pf study
    When user click on choice of the car families btn
    Then user able to see car family page
    Then user click on CarFamily validate btn
    When user click on choice of the car families btn
    Then user able to see car family page
    Then user click on cancel btn
 
    Then user send the volume numbers<volumes>
    And user click on International customer volume bonus
    And user click on national customer volume bonus
    Then user click on National customer range bonus
    Then user click on Noleaser
    And user click on save draft
    Then user click on save this profitability study for modification
    Then user click on history Link text
    And user click on back button1
    Then user click on see version
    And user click on the back button2
    Then user clcik on copy Link text
    And user enter status code01<scode>
    And user click on validate button1
    #@PFSearch
    #Scenario: PFSearch table
    Then user able to see the pfs number
    And user click on search
    Then user able to see the Profitability study search page
    Then user click on Quick search
    Then user enter pfs
    Then user click on start searching
    And user click on code

    Examples: 
      |UserName|Password|UserID | scode | volume | volumes |UserName|ValidStartdate|ValidEnddate|
      |SD51978 |Gd009988|SD51978|    01 |      1 |       2 |SD51978 |11/1/2025     |11/30/2025  |

  @ReferanceTable
  Scenario Outline: Reference table
    #Given User enter valid userID<UserName>
    #When user click on next button
    Given The user should on login page   
    When user click on peugeot    
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    When user navigate to contrib admin tab
    Then user click on Configuration User sub tab
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user select the subsidiary data from reference table
    Then user select the Subsidiary Data country
    | RTCountry |
    | DE        |
     
    Then user select the provisinol rate
    And user check the searching for the provisional rates
    Then user select the add new  line
    Then user validate the new line
    Then user select the network remuneration section
    Then user click create new file option
    Then user select country
    | RTCountry |
    | DE        |
    Then user select modelrange
    Then user select engine
    And user send the percentage<per> and amount<amt>
    Then user can validatenrr
    Then user click on back
    Then user select the Network remaining margin in RT
    Then user click create new file option
    Then user select country
    | RTCountry |
    | DE        |
    Then user select modelrange
    Then user select engine
    And user enters the nm perc<perc>
    Then user can validatenrr
    Then user click on back
    Then user select the country and modelrange and Engine 
    And user click on searechnr
    Then user select the Friction factor in RT
    Then user can validatenrr
    And user select the Budget RBCV from RT
    
    Then user select the International customer volume bonus from RT
    Then user click on addnewline ib
    Then user enter description<description> and amount<amount>
    #Then user enters description and amount
    And user click on validateib
    #Then user enteres the customer Data<data>
    Then user enteres the customer Data
    And user click on searchib in Reference Table
    #pfpending
    When user should able to see the pa study
    Then user click on creation
    Then user able to see the Head of profitabilty study page
    When user click on country
      | index |
      | 0     |
    And user click on client
    And user enter the status code<scode>
    Then user select the valid start date<ValidStartdate>
    And user select the valid end date<ValidEnddate>
    Then user click on validate button
    When user click on model range
    And user select the valid version date
    And user click on searching
    Then user able to see the version lists
    When user select the version checkbox from version list
    Then user able to click on add the versions in basket
    And user click on options
    Then user select the option check boxes
    And user can validate
    Then user select the versions in list
    Then user click on add this versions into profitability
    Then user click on International Bonus seacrh
    Then user enteres the customer Data
    And user click on searchib
    
    Then user select the Leasers International Bonus on volume from RT
    #Then user enteres the customer Data<data>
    #Then user enteres the customer Data
    #And user click on searchib
    #And user click on searchib in Reference Table
    Then user click on addnewline ib
    Then user enter description<description> and amount<amount>
    And user click on validateib
    Then user enteres the customer Data
    And user click on searchib in Reference Table
    
    When user should able to see the pa study
    Then user click on creation
    Then user able to see the Head of profitabilty study page
    When user click on country
      | index|
      | 0                   |
    And user click on client
    And user enter the status code<scode>
    Then user select the valid start date<ValidStartdate>
    And user select the valid end date<ValidEnddate>
    Then user click on validate button
    When user click on model range
    And user select the valid version date
    And user click on searching
    Then user able to see the version lists
    When user select the version checkbox from version list
    Then user able to click on add the versions in basket
    And user click on options
    Then user select the option check boxes
    And user can validate
    Then user select the versions in list
    Then user click on add this versions into profitability
    Then user click on Leasers International Bonus seacrh
    Then user enteres the customer Data
    And user click on searchib

    Examples: 
      |UserName|Password|UserID | per | amt  | perc |description|amount|UserName|scode |ValidStartdate|ValidEnddate|
      |SD51978 |Gd009988|SD51978|  25 | 2233 |   22 |IB Bonus   |  70  |SD51978 | 01   |11/1/2025     |11/30/2025  |

  @Administration
  Scenario Outline: contrib administration
    #Given User enter valid userID<UserName>
    #When user click on next button
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user can select the contrib lock from CA
    And user click on validateib
    Then user select the translation from CA
    Then user select the Application Messages from CA
    And user can validate
    Then user select the purge version from CA
    Then user select search and versions
      #| CountryP | ModelrangeP | vversions |
      #| DE       | 1PP5&DE     | TODAY     |
    And user click on searching
    Then user select the filing option from CA
    Then user click on multicreteria country and Activity
    |mcountry|Activity|
    |DE      |1    |
    Then user click on yellow arrow button
    Then user select the client
    Then user click on start searching
    Then user stores the Pfs Number
    Then user click on Quick search
    Then user enter pfs no<pfs>
    #Then user enter pfs no
    Then user click on start searching
    When user click on archiveS
    Then user click on unarchive
    And user click on code
    Then user select the Profitability study removal from CA
    Then user click on multicreteria country and Activity
    |mcountry|Activity|
    |ES      |1       |
    Then user click on start searching
    Then user click on Quick search
    #Then user enter pfs no
    Then user enter pfs no<pfs>
    Then user click on start searching
    And user click on checkbox of ps removal
    
    Then user select the creation of manual version from CA
    #Then user upload the manual version file
    #Then user click on validate manual version
    Then user select the budget RBCV Family from CA
    
    
    Examples:
    |UserName|Password|UserID |UserName|pfs       |
    |SD51978 |Gd009988|SD51978|SD51978 |FRGSNC0002|
    
    @SAMARA
    Scenario Outline: Check for the samara
    Given The user should on login page   
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    When user navigate to contrib admin tab
    Then user click on Configuration User sub tab

    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    When user should able to see the pa study
    Then user click on creation
    When user click on country
      | selectedcountryvalue |
      | 0                 |
    And user click on client
      ##| clientsPrasent |
      ##|          20926 |
    And user enter the status code<scode>
   ## Then user select the starting date
   # #|smonthdate|
    ###|July 2025|
   # #And user select the ending date
    #|emonthDate|
   # #|July 2025|
    Then user select the valid start date<ValidStartdate>
    
    And user select the valid end date<ValidEnddate>
    Then user click on validate button
    When user click on model range
      ##| range   |
      ##| 1PP5&DE |
    And user select the valid version date
     # #| value |
     # #| E0 |
    And user click on searching
    When user select the version checkbox from version list
    ##|  Checkboxtext   |
   # #|308 5P STYL ELECT|
    Then user click on similar versions
    When user select the version checkbox from version list
    ##|  Checkboxtext   |
    ##|308 5P STYL ELECT|
    
    When user should able to see the pa study
    And user click on search
    Then user click on multicreteria country and Activity
     |mcountry|Activity|
     |DE      |1       |
    Then user click on start searching
    Then user click on Quick search
    Then user enter pfs no<pfs>
    ##Then user enter pfs number
    Then user click on start searching
    And user click on code
    Then user click on History
    Then user click on back button
    And user click on see versions
    Then user click on back button
    #Then user click on cancel modification btn
    When user select the export option
      | SelExport |
      | Unit  |
    Then user click on export btn
    When user select the export option
      | SelExport |
      | Detailed  |
    Then user click on export btn
    ##When user select the export option
      ##| SelExport |
      ##| Workflow  |
   # #Then user click on export btn
    Then user click on copy
    #Then user able to see head of profitability study
    And user click on cancel button 
    
    And user click on Modify PF study
    Then user click on modify add version
    Then user click on modify see versions
    And user click on Refresh pstudy
    And user click on validateib
    Then user click validate refreshbtn
    
    Then user click on Estimated rate radio button
    Then user click on Estimated rate Textlink
    And user click on cancel button
    
    Then user click on copy data
    And user click on paste
    Then user click Refresh version
    And user click on validateib
    Then user click on Version Validate
    Then user click on Recalculate version
    And user click on Add options
    And user can validate
    Then user click on Subsidiary bonuses
    And user click on add line
    Then user enter subdescription<subdescription> and subamount<subamount>
    And user click on validateib
    Then user click on modify Header
    And user change the status code<mscode>
    Then user click on validate button
    
    
    
    Examples: 
      |UserName|Password|UserID | scode |ValidStartdate|ValidEnddate|pfs       |subdescription |subamount|mscode|
      |SD51978 |Gd009988|SD51978|01     |11/1/2025     |11/30/2025  |ITGCAR0008|LeasureBonusAP |1200     |02    |
    
    
    @Admin1
    Scenario Outline: contrib administration Application Maintenance
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|
      
    @Admin2
    Scenario Outline: contrib administration Application Maintenance Title Message
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user should enters the Title message
    
    
    Examples: 
     |UserName|Password|UserID |
     |SD51978 |Gd009988|SD51978|
      
    @Admin3
    Scenario Outline: contrib administration Application Maintenance Message Body
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user should enters the Title message
    Then user should enters the Message body
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|
      
      
      
     @Admin4
    Scenario Outline: contrib administration Application Maintenance Start Date
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user should enters the Title message
    Then user should enters the Message body
    Then user click on start date
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|
    
   @Admin5
   Scenario Outline: contrib administration Application Maintenance End Date
   Given The user should on login page
   When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user should enters the Title message
    Then user should enters the Message body
    Then user click on start date
    Then user click on End date
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|
      
    @Admin5
    Scenario Outline: contrib administration Application Maintenance Schedule
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user should enters the Title message
    Then user should enters the Message body
    Then user click on start date
    Then user click on End date
    Then user click on Schedule
    
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|
      
    @Admin6
    Scenario Outline: contrib administration Application Maintenance Schedule
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user should enters the Title message
    Then user should enters the Message body
    Then user click on start date
    Then user click on End date
    Then user click on Schedule
    Then user verify the HomePage Texts
    
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978| 
      
    @AdminTableVerification
    Scenario Outline: contrib administration Application Maintenance AdminTableVerification
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user verify The Scheduled sections
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|   
      
    @AdminStatusColoum
    Scenario Outline: contrib administration Application Maintenance Status Coloum
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user navigate to contrib admin tab
    Then user select the user configuration on contrib administration
    Then user able to select the language in dropdown
    |SelectLanguage|
    |en            |
    Then user click on validate btn
    Then user click on Application Maintenance
    Then user verify The Status colum
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|
      
      
    @CommonUrl
    Scenario Outline: contrib Common Url
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user verify the welecome contrib
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|  
     
     @CommonUrl6
    Scenario Outline: contrib Common Url urlsix
    Given The user should on login page
    #When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then verify getsupport hyperlink
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|
      
     @CommonUrl9
    Scenario Outline: contrib Common Url urlnine
    Given The user should on login page
    #When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then verify CONTRIB Guide hyperlink
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978| 
      
    @CommonUrl5
    Scenario Outline: contrib Common Url urlfive
    Given The user should on login page
    #When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then verify home page text
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|    
      
    @CommonUrl3_brandLogoAP
    Scenario Outline: contrib Common Url urlthird
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then user verify the logo of brand
    
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978| 
      
    @CommonUrl4
    Scenario Outline: contrib Common Url urlfour
    Given The user should on login page
   # When user click on peugeot
   Then user verify one brand is selected
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    
    
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978| 
      
    @CommonUrl10
    Scenario Outline: contrib Common Url urltenth
    Given The user should on login page
    #When user click on peugeot
    Then user verify that logos for all brands are displayed on the Home Page correctly
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    
    
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|   
      
    @CommonUrl7
    Scenario Outline: contrib Common Url urlseventh
    Given The user should on login page
    #When user click on peugeot
    Then the correct logo should be displayed for each CONTRIB brand on the Home Page 
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    
    
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978| 
      
    @CommonUrl8
    Scenario Outline: contrib Common Urleith
    Given The user should on login page
    When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then Verify that the  Welcome to CONTRIB  hyperlink
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978| 
      
    @CommonUrl11
    Scenario Outline: contrib Common Urleleven
    Given The user should on login page
    #When user click on peugeot
    When User enter valid userID<UserName>
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    Then Verify that real-time status indicators are displayed and updated correctly on the home page
    
    Examples: 
      |UserName|Password|UserID |
      |SD51978 |Gd009988|SD51978|        
