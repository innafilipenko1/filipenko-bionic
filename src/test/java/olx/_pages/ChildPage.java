package olx._pages;


import org.openqa.selenium.By;
import webdriver.Browser;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildPage extends AbstractPage {

    private static final By CHILD_WORLD_LINK = By.id("cat-539");

    public ChildPage(Browser driver){
        super(driver);
    }

    public boolean isOpen(){
        return browser.getCurrentUrl().contains("maincategories/");
    }

    public void openChildDressPage(){
        browser.findElement(CHILD_WORLD_LINK).click();
    }


}
