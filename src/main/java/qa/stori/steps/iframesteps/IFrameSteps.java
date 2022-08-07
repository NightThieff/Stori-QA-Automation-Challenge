package qa.stori.steps.iframesteps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.stori.pages.practicePage.PracticePage;
import qa.stori.steps.basetest.BaseTest;


public class IFrameSteps extends BaseTest {
    PracticePage practicePage = new PracticePage(getDriver());
    String text = "";

    @Given("^Go to Practice Page$")
    public void go_to_practice_page() throws Throwable {
        practicePage.goToPracticePage();
    }

    @Then("^Print the text$")
    public void print_the_text() throws Throwable {
        System.out.println(text);
    }

    @And("^In the iFrame example, get the text highlighted in blue$")
    public void in_the_iframe_example_get_the_text_highlighted_in_blue() throws Throwable {
        practicePage.switchToIframeWeb();
        text = practicePage.getIframeText();
    }

}