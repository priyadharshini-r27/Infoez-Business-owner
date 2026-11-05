@Business
Feature: Add Business Functionality
@Home 
Scenario Outline: Successfully add a new business
Given User is on the Home page
When User clicks on the My Businesses button
And  User clicks on the Add Business button
And User verify the Add Business navigation
And User enters new business name "<BusinessName>"
And User enters new business description "<Description>"
And User enters new business city "<City>"
And User enters new business address "<Address>"
And User enters new business phone "<Phone>"
And User enters new business email "<Email>"
And User enters new business photo "<Photo>"
Then User verify the input fields "<BusinessName>" "<Description>" "<City>" "<Address>" "<Phone>" and "<Email>"
Then User clicks on submit new business button



Examples:
| BusinessName          | Description                     | City      | Address           | Phone      | Email |
| Aroma Cafe            | Fresh coffee and tasty snacks   | Bengaluru | 45 Indiranagar Rd | 9876543210 | contact@urbancafe.com |

Scenario:
Given User is on the Business dashboard page
When User verify the business count
When User verify the leads count

Scenario Outline: Edit the Business details
Given User is on the Business dashboard page
When User clicks on the My Businesses button
And User clicks on the edit button
And User enters business name"<businessname>"
And User enters business description"<description>"
Then User verify the input field "<businessname>" and "<description>"
Then User click on Save changes button



Examples:
|businessname| description|
|Sivam cafe |Authentic South Indian cuisine|

@Business
@leads
Scenario Outline: Leads
Given User is on the Business dashboard page
When User clicks on the Leads button
And User should be navigated to leads module