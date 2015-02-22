package olx.tests;

import olx.config.SimpleSearchePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by inna on 2/22/15.
 */


public class SimpleSearchTests {

    public WebDriver driver;
    private SimpleSearchePage ss;

    @BeforeSuite
    public void init() {

        driver = new FirefoxDriver();
        ss = new SimpleSearchePage(driver);
    }


    @Test
    public void checkSearchByName() {

        ss.openSite();
        ss.startSearch("кот");
        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("кот"));

    }


    @AfterSuite
    public void shutEvent() {

        driver.quit();
    }


}
