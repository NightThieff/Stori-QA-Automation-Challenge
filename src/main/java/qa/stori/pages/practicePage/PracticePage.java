package qa.stori.pages.practicePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import qa.stori.pages.base.BasePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PracticePage extends BasePage {
    public PracticePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input [@id = 'autocomplete']")
    WebElement textSuggessionClassExample;

    @FindBys(
            @FindBy(xpath = "//li[@class = 'ui-menu-item']"))
    List<WebElement> dropDownList;

    @FindBys(
            @FindBy(xpath = "//ul[@class = 'list-style-two']/li[2]"))
    List<WebElement> listOIframeText;

    @FindBy(xpath = "//select [@id = 'dropdown-class-example']")
    WebElement dropDownExample;

    @FindBy(xpath = "//button [@id = 'openwindow']")
    WebElement openWindowButton;

    @FindBy(xpath = "//div[@class ='sumome-react-wysiwyg-move-handle']/div/following::button[2]")
    WebElement popUpWin;

    @FindBy(xpath = "//div[@class ='row panel-icon']/child::div[2]/following::h3[6]/following::h3[2]")
    WebElement calendarText;

    @FindBy(xpath = "//input[@id='name']")
    WebElement switchToAlertExampleField;
    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alertButton;

    @FindBy(xpath = "//input[@id='confirmbtn']")
    WebElement confirmAlertButton;

    @FindBy(id = "courses-iframe")
    WebElement iframeM;

    @FindBy(xpath = "//a [@id = 'opentab']")
    WebElement switchTapExampleButton;

    @FindBy(xpath = "//a[@class = 'btn btn-primary view-all-courses-btn']")
    WebElement viewAllCoursesRedButton;

    @FindBys(
            @FindBy(xpath = "//table[@name= 'courses']/tbody/tr/td[3]"))
    List<WebElement> pricesColumn;

    @FindBys(
            @FindBy(xpath = "//table[@name= 'courses']/tbody/tr/td[2]"))
    List<WebElement> nameCoursesColumn;

    @FindBys(
            @FindBy(xpath = "//div[@class ='tableFixHead']/table/tbody/tr/td[2]"))
    List<WebElement> namePositionColumnFixedTable;

    @FindBys(
            @FindBy(xpath = "//div[@class ='tableFixHead']/table/tbody/tr/td[1]"))
    List<WebElement> nameNamesColumnFixedTable;

    public void printNameOfAllEnineers(){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        indexes = findTheIndexOfSameStringColumnTable(namePositionColumnFixedTable,"Engineer");
        printColumnsTableWithIndexes(nameNamesColumnFixedTable,indexes);
    }

    public void printNameOfCoursesThatAre25(){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        indexes = findTheIndexOfSameIntColumnTable(pricesColumn,25);
        printColumnsTableWithIndexes(nameCoursesColumn,indexes);
    }
    public int numberOfCoursesThatAre25(int price){
        return findTheNumberOfSameIntColumnTable(pricesColumn,price);
    }


    public void takeAnScreenShot(String nameOfPhoto) throws IOException {
        takeScreenshot(nameOfPhoto);
    }
    public void scrollToViewAllCoursesRedButton(){
        scrollToAnElement(viewAllCoursesRedButton);
    }
    public void pressSwitchTapExampleButton(){
        click(switchTapExampleButton);
    }

    public String getIframeText(){
        return getTextListIndex(listOIframeText,1);
    }
    public void switchToIframeWeb(){
        switchToIframe(iframeM);
    }
    public void pressAlertOk(){
        alertAccept();
    }
    public void pressConfirmAlertButton(){
        click(confirmAlertButton);
    }
    public String getTheAlertText(){
        return getAlertText();
    }
    public void pressAlertButton(){
        click(alertButton);
    }
    public void enterTextToAlertField(String text){
        enter(switchToAlertExampleField,text);
    }

    public String windonwTitle(){
        return getWindowTitle();
    }
    public String getCalendarText(){
       return getText(calendarText);
    }
    public void goToPracticePage() throws InterruptedException {
        goTo("https://rahulshettyacademy.com/AutomationPractice/");
    }
    public void enterTextToSuggessionClassExampleField(String text) throws InterruptedException {
        enter(textSuggessionClassExample,text);
    }
    public void noThanksPopUp(){
        click(popUpWin);
    }
    public void comboAutoSelect(String text) throws InterruptedException {
        autoseggestCombo(dropDownList, text);
    }

    public void selectOptionOfCombo(int index){
        comboSelect(dropDownExample,index);
    }
    public void pressOpenWindowButton(){
        click(openWindowButton);
    }

    public void switchToNewWindow() throws InterruptedException {
        switchTabByPosition(getTabLength()-1);
        Thread.sleep(2000);
    }
    public void switchToFirstWindow(){
        switchTabByPosition(0);
    }
    public void scrollTo30day(){
        scrollToAnElement(calendarText);
    }
    public void closeWindow(){
        closeTab();
    }

}
