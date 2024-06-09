Feature: Popular Page Details

  Scenario: Test whether the movies are displayed
    Given I am on the home page
    When I navigate to popular page
    Then I verify the list of movies displayed in popular page
  Scenario: Verify movie details page
    Given I am on the home page
    When I navigate to popular page
    Then I click on movie and redirect to the movie details page
