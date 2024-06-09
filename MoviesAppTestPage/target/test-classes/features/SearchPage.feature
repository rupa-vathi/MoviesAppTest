Feature: Search page functionality
  Scenario: Searching for movies by name
    Given I am on the home page
    When I navigate to search page
    And I search for "The GodFather" Movie
    Then I should see the count of movies displayed
    And I click on movie and redirect to the search movie details page
  Scenario: Search for non-existent movie
    Given I am on the home page
    When I navigate to search page
    And I search for non-existent Movie
    Then I should see not found container