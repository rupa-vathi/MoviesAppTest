Feature: Home Page Functionality Verification

  Scenario: Verify Home Page Elements

    Given I am on the home page
    When I view the heading texts of each section
    Then I check if the play button is displayed

  Scenario: Verify Movies Section

    Given I am on the home page
    Then I should see the Movies displayed

  Scenario: Verify Contact Us Section

    Given I am on the home page
    Then I should see the Contact Us section displayed