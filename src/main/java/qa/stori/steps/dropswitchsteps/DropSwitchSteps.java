package qa.stori.steps.dropswitchsteps;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.stori.pages.practicePage.PracticePage;
import qa.stori.steps.basetest.BaseTest;




public class DropSwitchSteps extends BaseTest{

    PracticePage practicePage = new PracticePage(getDriver());

    @Given("^Go to the Practicing Page$")
    public void go_to_the_practicing_page() throws Throwable {
        practicePage.goToPracticePage();
    }

    @Then("Close the new window")
    public void close_the_new_window() throws Throwable {
        practicePage.closeWindow();
        practicePage.switchToFirstWindow();
        Assert.assertEquals(practicePage.windonwTitle(), "Practice Page");

    }

    @And("Enter the word Me and select Mexico")
    public void enter_the_word_something_and_select_mexico() throws Throwable {
        practicePage.enterTextToSuggessionClassExampleField("me");
        practicePage.comboAutoSelect("Mexico");
    }

    @And("In the Dropdown Example select option two and then option three The user should be able to see the change")
    public void in_the_dropdown_example_select_option_2_and_then_option_3_the_user_should_be_able_to_see_the_change() throws Throwable {
        practicePage.selectOptionOfCombo(2);
        Thread.sleep(1000);
        practicePage.selectOptionOfCombo(3);
        Thread.sleep(1000);
    }

    @And("In the Switch Window Example, click the Open Window button")
    public void in_the_switch_window_example_click_the_open_window_button() throws Throwable {
        practicePage.pressOpenWindowButton();
        practicePage.switchToNewWindow();
        practicePage.noThanksPopUp();
        practicePage.scrollTo30day();
    }

    @And("If the thirty day money back guarantee text is not shown it should fail")
    public void if_the_something_text_is_not_shown_it_should_fail() throws Throwable {
        String expectedText = "30 DAY MONEY BACK GUARANTEE";
        Assert.assertEquals(practicePage.getCalendarText(), expectedText);
    }

}