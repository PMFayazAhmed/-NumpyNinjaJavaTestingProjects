Feature: End to End Tests for LMSAPI
  Description: The purpose of this is to create feature and step definitions for testing API
  
  LMS API URL: https://lms-program-rest-service.herokuapp.com

  Background: User uses Basic Authentication
    Given I am a authorised user

  Scenario Outline: Authorised User is able to add a program
    Given I enter details for a new Program
    When I use Http Post request
    Then The program is added
    And Status Code is 200

  Scenario Outline: Authorised User is able to get list of programs
    Given A List of programs are available
    When I Use http GET request
    Then I am able to see the list of programs
    And Status Code is 200

  Scenario Outline: Authorised User is able to remove a program
    Given A List of programs are available
    When I Use http DELETE request for <ProgramID>
    Then I am able to remove the program
    And Status Code is 200

    Examples: 
      | ProgramID |
      |      1740 |
