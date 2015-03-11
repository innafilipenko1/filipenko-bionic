package olx.functionaltests;

import olx._pages.AdvertisementPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import webdriver.Browser;

import java.io.File;

/**
 * Created by inna on 3/1/15.
 */
public class TestTest extends AbstractTest{

    Browser driver;

    @Test
    public void test(){
        AdvertisementPage adPage = new AdvertisementPage(driver);
        adPage.openAdPage();

       Actions builder = new Actions(driver);





    }



}
