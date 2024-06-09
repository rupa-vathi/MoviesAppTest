Feature: Login page Functionality
  I would like to test the login page UI
  I would like to test the login page functionalities

  Scenario:Test the login page UI
    Given I am on the login page
    Then I test the Website logo image should be displayed
    And I test the Heading text should be "Login"
    And I test the Username label text should be "USERNAME"
    And I test the Password label text should be "PASSWORD"
    And I test the "Login" button should be present
  Scenario: Test the Login Page Functionalities
    Given I am on the login page
    When I attempt to login with empty input fields
    Then I should see an error message
Scenario: Test with empty username
    Given I am on the login page
    When I enter a valid password
    Then I should see an error message
 Scenario: Test with empty password
  Given I am on the login page
    When I enter a valid username
    Then I should see an error message
  Scenario: Test with invalid credentials
   Given I am on the login page
    When I enter invalid credentials
Scenario: Test with valid credentials
    Given I am on the login page
    And I enter valid credentials




