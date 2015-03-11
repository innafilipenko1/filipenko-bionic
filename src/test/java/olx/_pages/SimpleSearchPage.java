package olx._pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.Browser;

import java.util.List;

/**
 * Created by inna on 2/22/15.
 */
public class SimpleSearchPage extends AbstractPage{


    public SimpleSearchPage(Browser driver){
        super (driver);
    }

    private String pageURL = "http://olx.ua/";

    private By searchLookup = By.id("headerSearch");
    private By searchButton = By.id("submit-searchmain");
    public static final By resultTable = By.id("offers_table");
    public static final By resultTabelElement = By.className("marginright5 link linkWithHash detailsLink");
    private By tableElementLinkText = By.xpath("//table[@id='offers_table']/tbody/tr//h3/a/span");


    public void openSite(){

        browser.get(pageURL);

    }

   public void doAndCheckSearchByInput(String string){

       browser.findElement(searchLookup).sendKeys(string);
       browser.findElement(searchButton).click();
       checkResultTable(string);

   }

    public void checkResultTable(String string){

        List<WebElement> offersTable = browser.findElement(resultTable).findElements(tableElementLinkText);

        for(WebElement trElement : offersTable){

            Assert.assertTrue(org.apache.commons.lang3.StringUtils.containsIgnoreCase(trElement.getText(), string));

        }
    }



}
