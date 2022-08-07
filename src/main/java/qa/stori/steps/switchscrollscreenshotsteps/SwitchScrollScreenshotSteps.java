package qa.stori.steps.switchscrollscreenshotsteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.stori.pages.practicePage.PracticePage;
import qa.stori.steps.basetest.BaseTest;



public class SwitchScrollScreenshotSteps extends BaseTest{
    PracticePage practicePage = new PracticePage(getDriver());
    @Given("^Enter to the Practice Page$")
    public void enter_to_the_practice_page() throws Throwable {
        practicePage.goToPracticePage();
    }

    @Then("^Don't close the window, Return to the first window$")
    public void dont_close_the_window_return_to_the_first_window() throws Throwable {

    }

    @And("^On the Switch Tab Example, click the Open Tab button$")
    public void on_the_switch_tab_example_click_the_open_tab_button() throws Throwable {
        practicePage.pressSwitchTapExampleButton();
    }

    @And("^On the new tab Scroll until you see the red button with the text attached to the document$")
    public void on_the_new_tab_scroll_until_you_see_the_red_button_with_the_text_attached_to_the_document() throws Throwable {
        practicePage.switchToNewWindow();
        practicePage.scrollToViewAllCoursesRedButton();
        practicePage.takeAnScreenShot("SwitchScrollScreenshotSteps");
    }

    @And("^Take a screenshot that includes the button and save it with the name of the test case$")
    public void take_a_screenshot_that_includes_the_button_and_save_it_with_the_name_of_the_test_case() throws Throwable {
        practicePage.switchToFirstWindow();
        Assert.assertEquals(practicePage.windonwTitle(), "Practice Page");
    }

}