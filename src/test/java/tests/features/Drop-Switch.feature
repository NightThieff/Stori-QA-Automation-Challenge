@Drop-Switch
Feature: Drop-Switch

  Scenario: TECHCHALLENGE TECHCH001 Validation of Dropdown and Switch Window
    Given Go to the Practicing Page
    And Enter the word Me and select Mexico
    And In the Dropdown Example select option two and then option three The user should be able to see the change
    And In the Switch Window Example, click the Open Window button
    And If the thirty day money back guarantee text is not shown it should fail
    Then Close the new window
