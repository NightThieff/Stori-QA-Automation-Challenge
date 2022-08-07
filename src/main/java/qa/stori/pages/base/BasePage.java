package qa.stori.pages.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import javax.lang.model.element.Element;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void Wait(int miliseconds) throws InterruptedException {
        Thread.sleep(miliseconds);
    }
    //Waits
    protected Wait getWait(int secondsToWait) {
        Wait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(secondsToWait))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(TimeoutException.class);
        return wait;
    }

    protected Wait getWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    //To be visible
    protected void waitToBeVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeVisibility(By locator) {
        getWait().until(ExpectedConditions.visibilityOf(findElementBy(locator)));
    }

    protected void waitToBeVisibility(WebElement element, int seconds) {
        getWait(seconds).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitToBeNotVisibility(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    //To be clickable
    protected void waitToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    //Get text
    protected String getText(WebElement element) {
        waitToBeVisibility(element);
        return element.getText();
    }

    protected String getText(By locator) {
        return getText(findElementBy(locator));
    }
    //Get class
    protected String getClass(WebElement element){
        return element.getAttribute("class");
    }

    //Click
    protected void click(WebElement element) {
        waitToBeClickable(element);
        element.click();
    }
    //Click
    protected void click(By locator) {
        waitToBeVisibility(locator);
        findElementBy(locator).click();
    }

    protected WebElement findElementBy(WebElement element,By locator) {
        int attemps=0;
        while (attemps<5) {
            try {
                return element.findElement(locator);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                attemps++;
            }
        }
        return null;
    }

    protected void goTo(String url){
        driver.get(url);
    }

    protected void enter(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected WebElement findElementBy(By locator){
        return driver.findElement(locator);
    }

    protected String getWindowTitle(){
        return driver.getTitle();
    }

    protected void refreshPage(){
        driver.navigate().refresh();
    }

    protected void switchTabByPosition(int position) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(position));
    }

    protected int getTabLength() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        return tabs.size();
    }

    protected void closeTab() {
        driver.close();

    }

    protected void comboSelect(WebElement element, String textDisplayed){
        waitToBeVisibility(element);
        Select combo = new Select (element);
        combo.selectByVisibleText(textDisplayed);
        combo.selectByIndex(1);
    }

    protected void comboSelect(WebElement element, int index){
        waitToBeVisibility(element);
        Select combo = new Select (element);
        combo.selectByIndex(index);
    }

    protected void autoseggestCombo(List element,  String finalText) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> options = element;
        for(WebElement option : options)
        {
            if(option.getText().equals(finalText))
            {
                option.click();
                break;
            }
        }
    }

    protected void scrollToAnElement(WebElement element){
        waitToBeVisibility(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    protected void alertAccept(){
        driver.switchTo().alert().accept();
    }
    protected void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    protected void switchToIframe(WebElement element){
        driver.switchTo().frame(element);
    }
    protected String getTextListIndex(List<WebElement> lista, int index){
        return getText(lista.get(index));
    }
    protected void takeScreenshot(String nameOfPhoto) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile , new File("C:/Stori-QA-Automation-Challenge/src/main/resources/"+nameOfPhoto+".png"));
    }

    protected int findTheNumberOfSameIntColumnTable(List<WebElement> elements,int number){
        int count = 0;
        for(WebElement element : elements) {
            int getNumber = Integer.valueOf(element.getText());
            if(getNumber == number)
            {
                count++;
            }
        }
        return count;
    }

    protected ArrayList<Integer> findTheIndexOfSameIntColumnTable(List<WebElement> elements,int number){
        ArrayList<Integer> index = new ArrayList<Integer>();
        for(int i = 0 ; i < elements.size() ; i++) {
            int getNumber = Integer.valueOf(elements.get(i).getText());
            if(getNumber == number)
            {
                index.add(i);
            }
        }
        return index;
    }
    protected void printColumnsTableWithIndexes(List<WebElement> elements, ArrayList<Integer> indexes){

            int index = 0;
            for(int i = 0 ; i < indexes.size() ; i++) {
                index = indexes.get(i);
                String textElement = elements.get(index).getText();
                System.out.println(textElement+"\n");
            }
    }

    protected ArrayList<Integer> findTheIndexOfSameStringColumnTable(List<WebElement> elements,String text){
        ArrayList<Integer> index = new ArrayList<Integer>();
        for(int i = 0 ; i < elements.size() ; i++) {
            String getText = elements.get(i).getText();
            if(getText.equals(text)) {
                index.add(i);
            }
        }
        return index;
    }

}
