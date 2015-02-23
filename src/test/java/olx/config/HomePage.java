package olx.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c2611 on 23.02.2015.
 */
public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("http://olx.ua/uk/");
    }

    public void openChildWorld(){
        driver.findElement(By.cssSelector("a[data-code='detskiy-mir']")).click();
    }





}
