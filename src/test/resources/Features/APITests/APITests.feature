@apitests
Feature: API Tests

  @apitest1
  Scenario Outline: Verify Reqres user details
    When user makes a GET User api call for the endpoint <Endpoint>
    Then verify the response code is 200
    And verify the total <totalcount>
    Examples:
      | Endpoint   | totalcount |
      | /api/users | 12         |

  @apitest2
  Scenario Outline: Create a new user is Reqres
    When user makes a POST api call to create a user with input <Input> for the endpoint <Endpoint>
    Then verify the response code is 201
    And verify the id is generated
    Examples:
      | Endpoint   | Input                                |
      | /api/users | {"name": "morpheus","job": "leader"} |
