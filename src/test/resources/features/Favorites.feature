@Favorites @Regression
Feature: Explore and Favorites Page Automation and Validation


@Positive @Smoke
Scenario Outline: Add a business to Favorites from Explore, validate pop-up and check list
Given User is on the Home dashboard page
When User clicks on the Explore navigation link
And User clicks on the Favorite or Heart icon for business 
Then a pop-up message should be displayed with text "<expectedPopupMessage>"
When User clicks on the menu at top right
When User navigates to the Favorites page via profile menu
Then the business should be displayed in the Favorites list

Examples:
| businessName | expectedPopupMessage |
| Aroma cafe          | Added to favorites |