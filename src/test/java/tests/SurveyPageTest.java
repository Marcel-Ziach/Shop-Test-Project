package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SurveyPage;

public class SurveyPageTest extends TestBase {

    private SurveyPage surveyPage;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        surveyPage = new SurveyPage(driver);

        mainPage = new MainPage(driver);
        mainPage.surveyButtonClick();
    }

    @Test(priority = 30, enabled = true, description = "Checks if Survey Window is Displayed.")
    public void checkIfSurveyWindowIsDisplayed() throws InterruptedException {

        Assert.assertTrue(surveyPage.isSurveyWindowDisplayed(), "Page not loaded correctly. Survey Window is not Displayed.");

    }
}