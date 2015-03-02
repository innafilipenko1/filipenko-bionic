package olx.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import webdriver.Browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */
public class AbstractTest {

    protected Browser browser;

    @BeforeSuite
    public void init(){
        //browser = new Browser(new FirefoxDriver());
        //https://code.google.com/p/chromedriver/issues/detail?id=679
        //https://code.google.com/p/selenium/issues/detail?id=7954

        File file = new File("C:\\Users\\ifilipenko\\OneDrive\\tools\\webdriver\\chromedriver.exe");
       // File file = new File("/Users/inna/Dropbox/GitHub/filipenko-bionic/chromedriver2.exe");
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        browser = new Browser(new ChromeDriver());
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

/*
    @AfterSuite
    public void shutEvt(){
       if(browser != null) browser.quit();
    }
*/


}
