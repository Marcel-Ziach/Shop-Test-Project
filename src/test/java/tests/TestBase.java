package tests;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    private static final String browser = PropertiesReader.read("browser");
    private static final String url = PropertiesReader.read("url");

    @BeforeMethod
    public void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-application-cache");

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-search-engine-choice-screen");
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--disable-application-cache");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--disable-search-engine-choice-screen");
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--disable-application-cache");

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(url);

    }

    @AfterMethod
    public void cleanUp() { driver.quit(); }

}
