package qa.stori.steps.tablefixedsteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.stori.pages.practicePage.PracticePage;
import qa.stori.steps.basetest.BaseTest;

public class TableFixedSteps extends BaseTest{
    PracticePage practicePage = new PracticePage(getDriver());

    @Given("^Enter on the Practice Page$")
    public void enter_on_the_practice_page() throws Throwable {
        practicePage.goToPracticePage();
    }

    @Then("^In the Web Table Fixed header, print the names of all the Engineers$")
    public void in_the_web_table_fixed_header_print_the_names_of_all_the_engineers() throws Throwable {
        practicePage.printNameOfAllEnineers();
    }

}