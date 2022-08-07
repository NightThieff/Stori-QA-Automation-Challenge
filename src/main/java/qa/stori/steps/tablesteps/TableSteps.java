package qa.stori.steps.tablesteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.stori.pages.practicePage.PracticePage;
import qa.stori.steps.basetest.BaseTest;

public class TableSteps extends BaseTest{
    PracticePage practicePage = new PracticePage(getDriver());

    @Given("^Enter to the Practicing Page$")
    public void enter_to_the_practicing_page() throws Throwable {
        practicePage.goToPracticePage();
    }

    @Then("^Print their course names$")
    public void print_their_course_names() throws Throwable {
        practicePage.printNameOfCoursesThatAre25();
    }

    @And("^In the Web Table Example, print the number of courses that are twenty five dollars$")
    public void in_the_web_table_example_print_the_number_of_courses_that_are_twenty_five_dollars() throws Throwable {
       System.out.println("Number of courses: "+practicePage.numberOfCoursesThatAre25(25));
    }

}