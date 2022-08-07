package qa.stori.steps.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.stori.steps.basetest.BaseTest;

public class Hooks extends BaseTest {
    @Before
    public void setUp(){
        setUpDriver();
    }

    @After
    public void twerdown(Scenario scenario){
        getDriver().quit();
    }
}
