package pages;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurveyPage {

    private WebDriver driver;

    public SurveyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*****Variables*****/

    private static final String expectedSurveyPageTitle = PropertiesReader.read("expectedSurveyPageTitle");

    /*****Web-element Repository*****/

    @FindBy(xpath = "//div[text()='Ankieta sprzedażowa']")
    private WebElement surveyWindow;

    /*****Operations on Web-elements******/

    public boolean isSurveyWindowDisplayed() {

        boolean status = false;

        if (surveyWindow.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public String getExpectedSurveyPageTitle() { return expectedSurveyPageTitle; }

    public String getActualSurveyPageTitle() { return driver.getTitle(); }

}
