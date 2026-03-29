package pages;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*****Variables*****/

    private static final String expectedShopHeadingText = PropertiesReader.read("expectedShopHeadingText");
    private static final String expectedMainPageTitle = PropertiesReader.read("expectedMainPageTitle");
    private static final String expectedMainPageUrl = PropertiesReader.read("expectedMainPageUrl");

    /*****Web-element Repository*****/

    @FindBy(xpath = "//h1[text()='Selenium Shop']")
    private WebElement actualShopHeadingText;

    @FindBy(id = "menu-item-134")
    private WebElement surveyButton;

    /*****Operations on Web-elements******/

    public void surveyButtonClick () { surveyButton.click(); }

    public String getExpectedShopHeadingText () { return expectedShopHeadingText; }

    public String getActualShopHeadingText () {
        return actualShopHeadingText.getText();
    }

    public String getExpectedMainPageTitle() { return expectedMainPageTitle; }

    public String getActualMainPageTitle() { return driver.getTitle(); }

    public String getExpectedMainPageUrl() { return expectedMainPageUrl; }

    public String getActualMainPageUrl() { return driver.getCurrentUrl(); }

}
