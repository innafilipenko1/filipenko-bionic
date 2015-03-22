package olx._pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.Browser;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildDressPage extends AbstractPage {

    private static final By STATE_PATH = By.xpath("//div[@class='filter-item rel']/a");
    private static final By NEW_CHECKBOX_PATH = By.cssSelector("#f-new_state");
    private static final By LIST_ELEMENT_PATH = By.cssSelector(".marginright5.link.linkWithHash.detailsLink");


    public ChildDressPage(Browser driver) {
        super(driver);
    }

    public boolean isOpen() {
        return (browser.getCurrentUrl().contains("detskaya-odezhda/")
                && browser.findElement(By.id("main-category-choose-label")).getText().contains("Дитячий одяг"));
    }

    public void filterOutByNewState() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        browser.findElement(STATE_PATH).click();
        browser.manage().timeouts().implicitlyWait(100, TimeUnit.DAYS.MICROSECONDS);
        browser.findElement(NEW_CHECKBOX_PATH).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        browser.findElement(LIST_ELEMENT_PATH).click();

    }

    public boolean checkElementHasNewState(){
        List<WebElement> elements = browser.findElements(By.cssSelector("a"));

        Boolean ok = false;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase("Нові")) {
                ok = true;
            }
        }
        return ok;
    }


}

