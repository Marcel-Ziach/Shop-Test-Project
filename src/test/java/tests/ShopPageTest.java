package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ShopPage;

public class ShopPageTest extends TestBase {

    private ShopPage shopPage;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        shopPage = new ShopPage(driver);

        mainPage = new MainPage(driver);
        mainPage.shopButtonClick();
    }

    @Test(priority = 10, enabled = true, description = "Checks if the Shop Page title is correct.")
    public void shopPageTitleVerification() throws InterruptedException {

        String expectedShopPageTitle = shopPage.getExpectedShopPageTitle();
        Assert.assertEquals(shopPage.getActualShopPageTitle(), expectedShopPageTitle);

    }

    @Test(priority = 30, enabled = true, description = "Checks if Product Window is Displayed.")
    public void checkIfProductWindowIsDisplayed() throws InterruptedException {

        Assert.assertTrue(shopPage.isProductWindowDisplayed(), "Page not loaded correctly. Product Window is not Displayed.");

    }

}