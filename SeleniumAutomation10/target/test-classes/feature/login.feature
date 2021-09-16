Feature: Login feature
Scenario Outline: scenario for login
    Given Open Browser
    And user is on login page
    When user enters <username> and <password>
    And click on login button
    Then user is navigated to home page
    Examples:
      | username | password |
      | Pooja    |    12345 |
      | Mahesh   |    12345 |