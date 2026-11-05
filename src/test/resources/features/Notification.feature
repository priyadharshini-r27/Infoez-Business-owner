@Notifications @
Feature: User Notifications Page Automation and Validation



Scenario: Navigate to Notifications page 
Given User is on the Home dashboard page
When User clicks on the profile menu at top right
And User clicks on the Notifications from the dropdown menu
Then User should be successfully navigated to the Notifications page
When User clicks on "Mark read" for the first notification
Then the notification background colour should change to indicate it is read