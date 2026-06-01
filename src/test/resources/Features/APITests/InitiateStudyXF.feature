@combinedTestXF
Feature: DB data to XML and SOAP request

  Scenario Outline: Fetch DB data, update XML, set dates, call API and verify in UI
    Given Validate database credentials for XF order
    When Establish a connection to the OSCQTZV database for XF order
    And Execute a query to fetch LCDV, MARKET ID for XF order
    Then the connection should be successful for XF order
    And the query results should be returned for XF order
    Given The XML request file "C:\ContribAutomationAPI\LITMUS0112\xml file\samplePayload.xml" for XF order
    And update XML field "lcdv16Code" with first DB value from column "LCDV" for XF order
    And update XML field "marketId" with first DB value from column "MARKET_ID" for XF order
    And set start date to "2026"-"03"-"11" for XF order
    And set end date to "2026"-"04"-"15" for XF order
    When send a POST request to "/ContribService.asmx" for XF order
    Then the API response status code should be 200 for XF order
    And save the API response for XF order
    And the database connection should be closed for XF order

    Given The user should on login page
    When user click on citroen
    When User enter valid userID<UserName>
    Then User able to select another account
    Then User able to select account
    Then User able to enter userID<UserID> and Password<Password>
    And User click on signin button
    And User click yes button 
    When user navigate to profatibility tab for XF order
    Then user click on search tab for XF order
    Then user click on quick step for XF order

    Examples: 
        |UserName|UserID|Password|
        |SG20658 |SG20658|Aries1301$DM|
    
               
# -------- Second XML Request --------
    #Given I have the second XML request file "C:\ContribAutomationAPI\LITMUS0112\xml file\DealsheetStudy.xml" for XF order
    #And I update second XML field "studyId" with extracted studyId for XF order
    #When I send a POST request with second XML to "/ContribService.asmx" for XF order
    #Then the second API response status code should be 200 for XF order
    #And the second API response should be successful for XF order
    #And I save the second API response for XF order
#for negative test
#Then the second API response status code should be 200 for XF order
#And the second API response should contain error code "WS-FS00" for XF order
#And the second API response should contain error description "Technical Error" for XF order
#And I save the second API response
#
    #Given The user should on login page
    #When user click on citroen
    #When User enter valid userID<UserName>
    #Then User able to select another account
    #Then User able to select account
    #Then User able to enter userID<UserID> and Password<Password>
    #And User click on signin button
    #And User click yes button
    #
    #When user navigate to profatibility tab for XF order
    #Then user click on search tab for XF order
    #Then user click on quick step for XF order
    #
    #Examples: 
        #|UserName|UserID|Password|
        #|SG20658 |SG20658|Aries1301$DM|
    
 # -------- Third XML Request --------
#Given I have the third XML request file "C:\ContribAutomationAPI\LITMUS0112\xml file\DeleteStudy.xml" for XF order
#And I update third XML field "studyId" with extracted studyId for XF order
#When I send a POST request with third XML to "/ContribService.asmx" for XF order
#Then the third API response status code should be 200 for XF order
#And I save the third API response for XF order
   #
    #
 #@API_StudyIdVarification
  #Scenario Outline: Check the Study number
    #Given The user should on login page for XF order
    #When user click on citroen for XF order
    #When User enter valid userID<UserName> for XF order
    #Then User able to select another account for XF order
    #Then User able to select account for XF order
    #Then User able to enter userID<UserID> and Password<Password> for XF order
    #And User click on signin button for XF order
    #And User click yes button for XF order
    #
    #When user navigate to profatibility tab for XF order
    #Then user click on search tab for XF order
    #Then user click on quick step for XF order
    #
    #Examples: 
        #|UserName|UserID|Password|
        #|SG20658 |SG20658|Aries1301$DM|