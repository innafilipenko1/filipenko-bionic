package olx.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by inna on 3/1/15.
 */
public class TestTest{

    WebDriver driver;


    @Test
    public void setUp(){

        File file = new File("Macintosh HD/Users/inna/Dropbox/GitHub/filipenko-bionic/chromedriver2.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("google.com");
    }



}
