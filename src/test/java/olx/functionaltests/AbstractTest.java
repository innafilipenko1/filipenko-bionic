package olx.functionaltests;

import utils.PropertyLoader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;
import webdriver.BrowserFactory;

/**
 * Created by c2611 on 23.02.2015.
 */


public class AbstractTest {

     protected Browser driver;

    @BeforeSuite
    public void init(){

        driver = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void shutEvt(){
       if(driver != null) driver.quit();
    }


}
