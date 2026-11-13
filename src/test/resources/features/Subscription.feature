@Subscription 
Feature: Subscription Page Automation and Validation

Background:
Given User is logged in and on the Home page


Scenario: Navigate to Subscription page, select a plan and validate popup message
When User clicks on the profile dropdown menu
And User clicks on the Subscription option from the menu
Then User should be successfully navigated to the Subscription page
When User clicks on Choose plan for the Starter plan
Then a subscription pop-up message should be displayed 
