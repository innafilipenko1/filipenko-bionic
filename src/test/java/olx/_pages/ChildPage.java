package olx._pages;


import org.openqa.selenium.By;
import webdriver.Browser;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildPage extends AbstractPage {

    private static final By openChildWorldLink = By.id("cat-539");



    public ChildPage(Browser driver){
        super(driver);
    }

    public void openChildDressPage(){
        browser.findElement(openChildWorldLink).click();
    }

    public boolean isOpen(){
       return browser.findElement(openChildWorldLink).isDisplayed();
    }
}
