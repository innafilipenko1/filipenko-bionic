package olx.tests;

import olx.config.AbstractPage;
import olx.config.SimpleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by inna on 2/22/15.
 */


public class SimpleSearchTests extends AbstractTest{


    @Test
    public void checkSearchByName() {

        SimpleSearchPage ss =  new SimpleSearchPage(driver);
        ss.openSite();
        ss.doAndCheckSearchByInput("кот");

    }





}
