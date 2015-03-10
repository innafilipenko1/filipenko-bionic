package olx.functionaltests;

import olx.utils.PropertyLoader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;
import webdriver.BrowserFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */


public class AbstractTest {

     protected Browser driver;

    @BeforeSuite
    public void init(){

        driver = BrowserFactory.create(PropertyLoader.loadProperty("browser"));

    }

    @AfterSuite
    public void shutEvt(){
       if(driver != null) driver.quit();
    }


}
