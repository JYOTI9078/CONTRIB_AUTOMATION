@combinedTest
Feature: DB data to XML and SOAP request

  Scenario: Fetch DB data, update XML, set dates, and call API
    Given Validate database credentials
    When Establish a connection to the OSCQTZV database
    And Execute a query to fetch LCDV, CAR MODEL NAME, CAR MODEL RANGE, MARKET ID
    Then the connection should be successful
    And the query results should be returned
    Given The XML request file "C:\Users\TA40167\LITMUS01\LITMUS01\xml file\samplePayload.xml"
    And update XML field "lcdv16Code" with first DB value from column "LCDV"
    And update XML field "marketId" with first DB value from column "MARKET_ID"
    And update XML field "brandId" with property "BRAND_ID" 
    And set start date to "2026"-"03"-"11"
    And set end date to "2026"-"04"-"15"
    When send a POST request to "/ContribService.asmx"
    Then the API response status code should be 200
    And save the API response
    And the database connection should be closed

  Scenario Outline: UI flow
    Given The user should on login page
    When user click on brand
    #When user click on peugeot
    When User enter valid userID<UserName>
    #Then User able to select another account
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    When user navigate to profatibility tab
    Then user click on search tab
    Then user click on quick step

    Examples:
      |UserName|UserID|Password|
      |SG20658 |SG20658|Aries1301$DM|

  #Scenario: Second XML Request - positive test
    #Given I have the second XML request file "C:\Users\TA40167\LITMUS01\LITMUS01\xml file\DealsheetStudy.xml"
    #And I update second XML field "studyId" with extracted studyId
    #When I send a POST request with second XML to "/ContribService.asmx"
    #Then the second API response status code should be 200
    #And the second API response should be successful
    #And I save the second API response
    
    #Scenario Outline: UI flow after positive test
    #Given The user should on login page
    #When user click on brand
    #When user click on peugeot
    #When User enter valid userID<UserName>
    #Then User able to select another account
    #Then User able to select account
    #Then User able to enter userID<UserID> and Password<Password>
    #And User click on signin button
    #And User click yes button
    #When user navigate to profatibility tab
    #Then user click on search tab
    #Then user click on quick step

    #Examples:
     # |UserName|UserID|Password|
      #|SG20658 |SG20658|Aries1301$DM|
      
   #Scenario 2-dealsheet
   Scenario: Second XML Request - negative test
   Given I have the second XML request file "C:\Users\TA40167\LITMUS01\LITMUS01\xml file\DealsheetStudy.xml"
   And I update second XML field "studyId" with extracted studyId
   And update second XML field "brandId" with property "BRAND_ID"
   When I send a POST request with second XML to "/ContribService.asmx"
   Then the second API response status code should be 200
   And the second API response should contain error code "WS-FS00"
   And the second API response should contain error description "Technical Error"
   And I save the second API response

  Scenario Outline: UI flow after negative test
    Given The user should on login page
    When user click on brand
    #When user click on peugeot
    When User enter valid userID<UserName>
    #Then User able to select another account
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    When user navigate to profatibility tab
    Then user click on search tab
    Then user click on quick step

    Examples:
      |UserName|UserID|Password|
      |SG20658 |SG20658|Aries1301$DM|
      
    # Scenario -delete study  
    Scenario: Fetch DB data, update XML, set dates, and call API
    Given I have the third XML request file "C:\Users\TA40167\LITMUS01\LITMUS01\xml file\DeleteStudy.xml"
    And I update third XML field "studyId" with extracted studyId
    When I send a POST request with third XML to "/ContribService.asmx"
    Then the third API response status code should be 200
    And I save the third API response

  Scenario Outline: UI flow
    Given The user should on login page
    When user click on brand
    #When user click on peugeot
    When User enter valid userID<UserName>
    #Then User able to select another account
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button
    When user navigate to profatibility tab
    Then user click on search tab
    Then user click on quick step

    Examples:
      |UserName|UserID|Password|
      |SG20658 |SG20658|Aries1301$DM|
      