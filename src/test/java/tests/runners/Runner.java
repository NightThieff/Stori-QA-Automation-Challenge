package tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= {"src/test/java/tests/features"},
        glue= {"qa.stori.steps"},
        //tags= "@Alerts",
        plugin={
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
