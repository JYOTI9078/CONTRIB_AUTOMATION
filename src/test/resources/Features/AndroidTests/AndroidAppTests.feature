@mobiletests
Feature: Mobile Tests - Demo Feature

  Background:
    Given user has installed the EmploymentManagement


  Scenario Outline: Verify the login credential
    When enter the <username> and <password>
    Then user is on the Add Employee Details page
    Examples:
      |username|password|
      |admin   |password|



  Scenario: Verify the product page
    When enter the admin and password
    Then user is on the Add Employee Details page
    Then user adds an Employee with all the details
      |Tom  |Kenny |26 |somewhere  |Password1 |
    Then user will signout of the application





