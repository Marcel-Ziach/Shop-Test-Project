package pages;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    private WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*****Variables*****/

    private static final String expectedShopPageTitle = PropertiesReader.read("expectedShopPageTitle");

    /*****Web-element Repository*****/

    @FindBy(xpath = "//ul[contains(@class,'products')]")
    private WebElement productWindow;

    /*****Operations on Web-elements******/

    public boolean isProductWindowDisplayed() {

        boolean status = false;

        if (productWindow.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public String getExpectedShopPageTitle() { return expectedShopPageTitle; }

    public String getActualShopPageTitle() { return driver.getTitle(); }

}