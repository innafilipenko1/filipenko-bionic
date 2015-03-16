package olx.functionaltests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyLoader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;
import webdriver.BrowserFactory;

/**
 * Created by c2611 on 23.02.2015.
 */


public class AbstractTest {

     public Browser driver;

    @BeforeClass
    public void init(){

        driver = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
        driver.manage().window().maximize();

    }

    @AfterClass
    public void shutEvt(){
       if(driver != null) driver.quit();
    }


}
