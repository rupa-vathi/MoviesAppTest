Feature: Movies details page functionality
  Scenario: Test the Movie Details On Home Page
    Given I am on the home page
    When I click on any one movie on home page
    Then I test all the UI elements present in it
    And I test the footer section
  Scenario: Test the Movie Details On Popular Page
    Given I am on the home page
    When I navigate to popular page
    When I click on any one movie on popular page
    Then I test all the UI elements present in it
    And I test the footer section

