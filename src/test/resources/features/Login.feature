@Login
Feature: Sign in Functionality

  Scenario Outline: Business Owner sign in validation
    Given User is on signin page
    When user enters Business Owner email "<email>"
    And User enter password "<password>"
    And clicks on the Sign in button
    Then user should navigate to home page "<result>" and "<Message>"

    Examples:
      | email              | password     | result  | Message               |
      |                    |              | Empty   | Email                 |
      |                    | Owner@123    | Empty   | Email                 |
      | owner@infoez.com   |              | Empty   | Password              |
      | invalidemail.com   | Owner@123    | failed  | please include an '@' |
      | unknown@infoez.com | Owner@123    | invalid | invalid credentials   |
      | owner@infoez.com   | WrongPass123 | invalid | invalid credentials   |
      | owner@infoez.com   | Owner@123    | valid   | valid                 |
