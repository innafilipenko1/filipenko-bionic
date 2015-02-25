package olx.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import webdriver.Browser;

/**
 * Created by c2611 on 23.02.2015.
 */
public class AbstractPage {

    public Browser driver;

    public AbstractPage(Browser driver){
        this.driver = driver;
    }

    public void openSite(String string){
        driver.get(string);
    }
    

}
