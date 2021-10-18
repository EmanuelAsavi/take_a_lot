@ui @smoke @regression
Feature:  Register a new user

  Scenario: As a new user I should be able to register
    Given User should be on the web page of the application
    When User click on "Register" module
    Then User should be on register page
    When User fill up the mandatory fields

      | First Name      | Agnes              |
      | Last Name       | Hawford            |
      | Email           | ahawford4@java.com |
      | Retype Email    | ahawford4@java.com |
      | Password        | Y2jpZG7Em8         |
      | Retype Password | Y2jpZG7Em8         |
      | Mobile Number   | 0776781608         |

    And User click on Register Now button
    Then User should be able to register


  Scenario Outline: User should NOT be able to register without filling out mandatory fields
    Given User should be on the web page of the application
    When User click on "Register" module
    Then User should be on register page
    When User does not fill out one or more mandatory fields "<First Name>", "<Last Name>", "<Email>", "<Retype Email>", "<Password>", "<Retype Password>", "<Mobile Number>"
    And User click on Register Now button
    Then User should not be able to register

    Examples:
      | First Name | Last Name | Email                    | Retype Email             | Password | Retype Password | Mobile Number |
      |            | Wohlers   | mwohlers3@bravesites.com | mwohlers3@bravesites.com | P9qMin   | P9qMin          | 0776781608    |
      | Melisa     |           | mwohlers3@bravesites.com | mwohlers3@bravesites.com | P9qMin   | P9qMin          | 0776781608    |
      | Melisa     | Wohlers   |                          | mwohlers3@bravesites.com | P9qMin   |                 | 0776781608    |







