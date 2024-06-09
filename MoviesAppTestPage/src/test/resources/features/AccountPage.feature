Feature: Account page functionality
  Scenario: Test all the UI elements present on the web page
    Given I am on the home page
    When I Test navigation to the account page
    Then I test all UI elements on the page
  Scenario: Test the Logout functionality
    Given I am on the home page
    When I Test navigation to the account page
    And I test the logout functionality
