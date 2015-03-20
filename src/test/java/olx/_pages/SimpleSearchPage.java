package olx._pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.Browser;

import java.util.List;

/**
 * Created by inna on 2/22/15.
 */
public class SimpleSearchPage extends AbstractPage {

    private static final By SEARCH_LOOKUP = By.id("headerSearch");
    private static final By SEARCH_BUTTON = By.id("submit-searchmain");
    private static final By RESULT_TABLE = By.id("offers_table");
    private static final By TABLE_ELEMENT_LINK = By.xpath("//table[@id='offers_table']/tbody/tr//h3/a/span");


    public SimpleSearchPage(Browser driver) {
        super(driver);
    }

    public boolean isOpen() {
        return browser.getCurrentUrl().contains("list");
    }

    public void applySearch(String string) {
        browser.findElement(SEARCH_LOOKUP).sendKeys(string);
        browser.findElement(SEARCH_BUTTON).click();
    }

    public boolean getResultTable(String string) {
        List<WebElement> offersTable = browser.findElement(RESULT_TABLE).findElements(TABLE_ELEMENT_LINK);

        Boolean ok = false;
        for (WebElement trElement : offersTable) {
             if (trElement.getText().contains(string))
                 ok = true;
        }
        return ok;
    }


}
