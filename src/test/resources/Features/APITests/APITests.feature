@apitests
Feature: API Tests

  @apitest1
  Scenario Outline: Verify Github user details
    When user makes a GET User api call for <Username>
    Then verify response is returned for <Username>
    Examples:
      | Username     |
      | biswajitguha |

  @apitest2
  Scenario Outline: Create a new repository for the Github user
    When user makes a POST api call to create a repository <RepoName>
    Then verify the repository <RepoName> is created successfully in <Username> profile
    Examples:
      | Username      | RepoName            |
      | biswajitguha  | my-test-repository  |

  @apitest3
  Scenario Outline: Delete the test repository from Github user's profile
    When user makes a DELETE api call to delete repository <RepoName> from <Username> profile
    Then verify the repository <RepoName> is deleted successfully from <Username> profile
    Examples:
      | Username      | RepoName            |
      | biswajitguha  | my-test-repository  |