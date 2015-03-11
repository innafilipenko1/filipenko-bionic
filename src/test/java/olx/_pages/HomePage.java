package olx._pages;

import org.openqa.selenium.By;
import webdriver.Browser;

/**
 * Created by c2611 on 23.02.2015.
 */
public class HomePage extends AbstractPage {

    public HomePage(Browser driver){
        super(driver);
    }

    public void open(){
        browser.get("http://olx.ua/uk/");
    }

    public void openChildWorld(){
        browser.findElement(By.cssSelector("a[data-code='detskiy-mir']")).click();
    }





}
