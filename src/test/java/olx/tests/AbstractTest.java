package olx.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;

import java.io.File;

/**
 * Created by c2611 on 23.02.2015.
 */
public class AbstractTest {

    protected Browser driver;

    @BeforeSuite
    public void init(){
        //File file = new File("D://Tools//chromedriver.exe");

        driver = new Browser(new FirefoxDriver());
    }

    @AfterSuite
    public void shutEvt(){
       if(driver != null) driver.quit();
    }


}
