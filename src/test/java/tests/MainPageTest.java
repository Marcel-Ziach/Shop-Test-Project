package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageTest extends TestBase {

    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
    }

    @Test (priority = 10, enabled = true, description = "Checks whether the title of the main page is correct.")
    public void mainPageTitleVerification() throws InterruptedException {

        String expectedMainPageTitle = mainPage.getExpectedMainPageTitle();
        Assert.assertEquals(mainPage.getActualMainPageTitle(), expectedMainPageTitle);

    }

    @Test (priority = 30, enabled = true, description = "Checks visibility of an element on the main page as well as the correctness of the text.")
    public void checkShopHeadingTextIsDisplayedAndCorrect() throws InterruptedException {

        String expectedShopHeadingText = mainPage.getExpectedShopHeadingText();
        Assert.assertEquals(mainPage.getActualShopHeadingText(), expectedShopHeadingText);

    }
}
