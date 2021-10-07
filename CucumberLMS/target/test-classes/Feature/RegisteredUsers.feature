Feature: RegisteredUsers

  Scenario Outline: View Users of LMS
    Given Admin is in <WelcomePage>
    When Admin clicks on Users menu
    And Admin clicks on Manage Users submenu
    Then Admin lands on <pageURL>

    Examples: 
      | WelcomePage                 | pageURL                                     |
      | https://lmsportal.com/Admin | https://www.LMSportal.com/Admin/ManageUsers |

  Scenario Outline: View only Registered Users
    Given Admin is in <pageURL> page
    When Admin clicks on Registered Users radio button
    Then Admin is able to view the <count> registered users in HTML table

    Examples: 
      | pageURL                                     | count |
      | https://www.LMSportal.com/Admin/ManageUsers |    10 |

  Scenario Outline: View fields to edit any User
    Given Admin is able to view the users
    When Admin clicks on Edit button in the <nth> row
    Then Admin is able to view dropdown elements in UserRole, Program and Batch columns

    Examples: 
      | nth |
      |   2 |

  Scenario Outline: Edit User Role value for a User
    Given Admin has cliked on Edit button in the <nth> row
    When Admin clicks on dropdown in UserRole column
    And Admin selects <UserRole> value
    Then Admin is able to set a new value for User Role

    Examples: 
      | nth | UserRole |
      |   2 | Student  |

  Scenario Outline: Edit Batch value for a User
    Given Admin has cliked on Edit button in the <nth> row
    When Admin clicks on dropdown in Batch column
    And Admin selects <Batch> value
    Then Admin is able to set a new value for Batch

    Examples: 
      | nth | Batch |
      |   2 |    40 |

  Scenario Outline: Edit Program value for a User
    Given Admin has cliked on Edit button in the <nth> row
    When Admin clicks on dropdown in Program column
    And Admin selects <Program> value
    Then Admin is able to set a new value for Program

    Examples: 
      | nth | Program |
      |   2 | SDET    |

  Scenario Outline: Save the changes made for the updated row
    Given Admin has selected new values for <UserRole>, <Program> and <Batch> for the <nth> row
    When Admin clicks on Save button
    Then Admin is able to see the updated values in the <nth> row

    Examples: 
      | nth | Program | Batch | UserRole |
      |   2 | SDET    |    40 | Student  |

  Scenario Outline: Filter and view Users by UserEmail
    Given Admin has entered <UserEmail> as the UserEmail filter criteria
    When Admin clicks the Search button
    Then Admin is able to see the information in the table view with row count as <nth>
    And User Email in the first cell of the table is <UserEmail>

    Examples: 
      | UserEmail     | nth |
      | abc@gmail.com |   1 |

  Scenario Outline: Filter and view Users by Batch
    Given Admin has entered <Batch> as the Batch filter criteria
    When Admin clicks the Search button
    Then Admin is able to see the information in the table view with row count as <nth>
    And Batch in the <ith> column of every row of the table is <Batch>

    Examples: 
      | Batch | nth | ith |
      |    40 |  10 |  16 |

  Scenario Outline: Filter and view Users by Program
    Given Admin has entered <Program> as the Program filter criteria
    When Admin clicks the Search button
    Then Admin is able to see the information in the table view with row count as <nth>
    And Program in the <ith> column of every row of the table is <Program>

    Examples: 
      | Program | nth  | ith |
      | SDET    | 1000 |  17 |

  Scenario Outline: Filter and view Users by UserEmail,Program and Batch
    Given Admin has mentioned <UserEmail> as the UserEmail filter criteria
    And Admin has mentioned <Batch> as the Batch filter criteria
    And Admin has mentioned <Program> as the Program filter criteria
    When Admin clicks on Search button
    Then Admin is able to see the information in the table view with filtered criteria <Program> and <Batch> and <UserEmail>

    Examples: 
      | Program | Batch | UserEmail     | nth |
      | SDET    |    40 | abc@gmail.com |   1 |

  Scenario Outline: Choose the User to be marked as Inactive
    Given Admin has selected "<UserEmail>" as the UserEmail filter criteria
    And Admin clicks on Search button
    When Admin clicks the Delete button on the <nth> row in the table
    Then Admin is able to see a confirmation popup in the screen

    Examples: 
      | UserEmail     | nth |
      | abc@gmail.com |   1 |

  Scenario Outline: Mark the User as Inactive
    Given Admin sees a confirmation popup in the screen
    When Admin clicks the Yes button in popup screen
    Then Admin is able to make the user status as Inactive

  Scenario Outline: Check if the User is Inactive
    Given Admin has clicked on Inactive Users radio button
    When Admin enters "<UserEmail>" as the UserEmail filter criteria and clicks on Search button
    Then User Email in the <ueIth> column of the <nth> row is "<UserEmail>"

    Examples: 
      | UserEmail     | nth | ueIth |
      | abc@gmail.com |   1 |     1 |
