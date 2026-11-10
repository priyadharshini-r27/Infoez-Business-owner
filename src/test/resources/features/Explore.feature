@Explore
Feature: Infoez Explore Page

  Scenario Outline: Search shop by shop name
    Given user is on the Explore Page
    When Business owner click the Explore module
    And Business owner enter "<Shop Name>" in shop search field
    Then verify the "<status>" valid "<expected>" details

    Examples:
      | Shop Name  | status  | expected            |
      | Aroma cafe | valid   | Aroma Cafe          |
      | ARV        | invalid | No businesses found |

  Scenario Outline: Search shop by place
    Given user is on the Explore Page
    When Business owner click the Explore module
    And Business owner enter the shop place "<place>" search field
    Then Business owner should see shop from place "<place>" with "<Status>" and expected "<expected>"

    Examples:
      | place     | Status  | expected            |
      | Bengaluru | valid   | Bengaluru           |
      | Thanjavur | invalid | No businesses found |

  Scenario: Validate Explore page filters
    Given user is on the Explore Page
    When Business owner click the Explore module
    When user selects category filter Restaurants and Top rated and minirating
    And user selects categorys filter Beauty & spa and Most popular and minirating
    And user selects category filters Health & Medical and Recently added and Any
    Then filtered business listings should be displayed successfully
    And User validates that the businesses count header is displayed with text containing "Businesses"
    And User verifies that business cards are displayed in the list
