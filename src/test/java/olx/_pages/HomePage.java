package olx._pages;

import org.openqa.selenium.By;
import webdriver.Browser;

/**
 * Created by c2611 on 23.02.2015.
 */
public class HomePage extends AbstractPage {

    private static final String HOME_ULR = "http://olx.ua/uk/";
    private static final By HOME_TEXT = By.xpath(".//*[@id='body-container']/div/div/div[2]/div/p[1]");
    private static final By CHILD_WORLD_PATH = By.cssSelector("a[data-code='detskiy-mir']");


    public HomePage(Browser driver) {
        super(driver);
    }

    public void open() {
        browser.get(HOME_ULR);
    }

    public boolean isOpen() {
        return browser.findElement(HOME_TEXT).isDisplayed();
    }

    public void openChildWorld() {
        browser.findElement(CHILD_WORLD_PATH).click();
    }


}
