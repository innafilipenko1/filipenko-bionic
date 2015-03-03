package olx.functionaltests;

import olx.utils.PropertyLoader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */
public class AbstractTest {
    //https://code.google.com/p/chromedriver/issues/detail?id=679
    //https://code.google.com/p/selenium/issues/detail?id=7954

    /*       work -  "C:\\Users\\ifilipenko\\OneDrive\\tools\\webdriver\\chromedriver.exe"
             mac -  "/Users/inna/Dropbox/GitHub/filipenko-bionic/chromedriver2.exe"
             bionic  - "D:\\Tools\\chromedriver.exe"
      */
    protected Browser driver;

    @BeforeSuite
    public void init(){


        if (PropertyLoader.loadProperty("browser").equals("firefox"))
            driver = new Browser(new FirefoxDriver());
        else if (PropertyLoader.loadProperty("browser").equals("chrome")) {
            File file = new File("C:\\Users\\ifilipenko\\OneDrive\\tools\\webdriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new Browser(new ChromeDriver());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

/*
    @AfterSuite
    public void shutEvt(){
       if(driver != null) driver.quit();
    }
*/


}
