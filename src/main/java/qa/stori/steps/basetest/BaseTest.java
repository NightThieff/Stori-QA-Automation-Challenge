package qa.stori.steps.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driver =  new ThreadLocal<>();

    public static void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver newDriver = new ChromeDriver(options);
        newDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        setDriver((WebDriver) newDriver);
    }

    public static void setDriver(WebDriver driver2){
        driver.set((driver2));
    }

    public WebDriver getDriver(){
        return driver.get();
    }
}
