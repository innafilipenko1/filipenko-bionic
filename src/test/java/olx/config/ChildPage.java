package olx.config;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildPage extends AbstractPage {

    private static final By openChildWorldLink = By.id("cat-539");

    public ChildPage(WebDriver driver){
        super(driver);
    }

    public void openChildDressPage(){
        driver.findElement(openChildWorldLink).click();
    }

    public boolean isOpen(){
       return driver.findElement(openChildWorldLink).isDisplayed();
    }
}
