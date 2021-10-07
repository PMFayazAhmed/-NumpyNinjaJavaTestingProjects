Feature: InactiveUsers

  Scenario Outline: View Users of LMS
    Given Admin is in <WelcomePage>
    When Admin clicks on Users menu
    And Admin clicks on Manage Users submenu
    Then Admin lands on <pageURL>

    Examples: 
      | WelcomePage                 | pageURL                                     |
      | https://lmsportal.com/Admin | https://www.LMSportal.com/Admin/ManageUsers |

  Scenario Outline: View only Inactive Users
    Given Admin is in <pageURL> page
    When Admin clicks on Inactive Users radio button
    Then Admin is able to view the <count> inactive users in HTML table

    Examples: 
      | pageURL                                     | count |
      | https://www.LMSportal.com/Admin/ManageUsers |     5 |

  Scenario Outline: Filter and view Users by UserEmail
    Given Admin has entered "<UserEmail>" as the UserEmail filter criteria
    When Admin clicks the Search button
    Then Admin is able to see the information in the table view with row count as <nth>
    And User Email in the first cell of the table is "<UserEmail>"

    Examples: 
      | UserEmail     | nth |
      | abc@gmail.com |   1 |

  Scenario Outline: Choose the User to be marked as Active
    Given User Email in the first cell of the table is "<UserEmail>"
    When Admin clicks the Activate button on the <nth> row in the table
    Then Admin is able to see a confirmation popup in the screen for the user to be marked as Active

    Examples: 
      | UserEmail     | nth |
      | abc@gmail.com |   1 |

  Scenario Outline: Make the user status as Active
    Given Admin sees a popup confirmation on the screen
    When Admin clicks the Yes button in the popup
    Then Admin is able to make the user status as Active

  Scenario Outline: Check if the User is Active
    Given Admin has clicked on Registered Users radio button
    When Admin has entered "<UserEmail>" as the UserEmail filter criteria
    Then User Email in the <ueIth> column of the of the <nth> row is "<UserEmail>"

    Examples: 
      | UserEmail     | nth | ueIth |
      | abc@gmail.com |   1 |     1 |
