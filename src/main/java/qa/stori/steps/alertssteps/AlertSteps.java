package qa.stori.steps.alertssteps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.stori.pages.practicePage.PracticePage;
import qa.stori.steps.basetest.BaseTest;


public class AlertSteps extends BaseTest {
    PracticePage practicePage = new PracticePage(getDriver());
    String shownOnAlert = "";

    @Given("^Go to the Practice Page$")
    public void go_to_the_practice_page() throws Throwable {
        practicePage.goToPracticePage();
    }

    @Then("^Make sure that the String shown equals to the text of the document and click on OK$")
    public void make_sure_that_the_string_shown_equals_to_the_text_of_the_document_and_click_on_ok() throws Throwable {
        Assert.assertEquals(shownOnAlert, "Hello Stori Card, Are you sure you want to confirm?");
        practicePage.pressAlertOk();
    }

    @And("^In the Switch To Alert Example, type this String “Stori Card” and click the Alert button$")
    public void in_the_switch_to_alert_example_type_this_string_stori_card_and_click_the_alert_button() throws Throwable {
        practicePage.enterTextToAlertField("Stori Card");
        practicePage.pressAlertButton();
    }

    @And("^Print the text in the alert and click on OK$")
    public void print_the_text_in_the_alert_and_click_on_ok() throws Throwable {
        System.out.println(practicePage.getTheAlertText());
        practicePage.pressAlertOk();
    }

    @And("^Type again this String “Stori Card” on the same field and click on the Confirm button and print the text$")
    public void type_again_this_string_stori_card_on_the_same_field_and_click_on_the_confirm_button_and_print_the_text() throws Throwable {
        practicePage.enterTextToAlertField("Stori Card");
        practicePage.pressConfirmAlertButton();
        shownOnAlert = practicePage.getTheAlertText();
        System.out.println(shownOnAlert);
    }

}