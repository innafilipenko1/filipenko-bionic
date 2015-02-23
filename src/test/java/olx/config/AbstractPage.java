package olx.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by c2611 on 23.02.2015.
 */
public class AbstractPage {

    public WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public void openSite(String string){
        driver.get(string);
    }
    

}
