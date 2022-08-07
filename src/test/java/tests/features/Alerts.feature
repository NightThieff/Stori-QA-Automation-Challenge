
@Alerts
Feature: Alerts

  Scenario: TECHCHALLENGE TECHCH003 Validation of Alerts
    Given Go to the Practice Page
    And In the Switch To Alert Example, type this String “Stori Card” and click the Alert button
    And Print the text in the alert and click on OK
    And Type again this String “Stori Card” on the same field and click on the Confirm button and print the text
    Then Make sure that the String shown equals to the text of the document and click on OK