@CreateAccount
Feature: Create Account functionality

  Scenario Outline: Create Business account
    Given the user navigates to the Infoez login page
    When the user clicks on the "Create one" link
    When the user selects the "Business" account type option
    And the user enters the full name "<fullname>"
    And the user enters the email "<email>"
    And the user enters the phone number "<phone>"
    And the user enters the password "<password>"
    Then user validates registration input fields "<fullname>" "<email>" and "<phone>"
    And the user clicks on the "Create account" button
    Then the page outcome should match "<result>" and "<Message>"

    Examples:
      | fullname | email                  | phone      | password  | result | Message                                                                                   |
      |          |                        |            |           | Empty  |                                                                                           |
      | Sam      |                        |            |           | Empty  | Email                                                                                     |
      | Sam      | invalidemailformat     |            | Owner@123 | failed | please include an '@'                                                                     |
      | Sam      | newbusiness@infoez.com |            | short     | failed | Please lengthen this text to 6 characters or more (you are currently using 5 characters). |
      | Sam      | newmaiilids@infoez.com | 9876543210 | Owner@123 | valid  | Welcome to Infoez                                                                          |
