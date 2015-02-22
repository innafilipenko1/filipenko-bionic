package olx.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by inna on 2/22/15.
 */
public class SimpleSearchePage {

    private WebDriver driver;

    public SimpleSearchePage(WebDriver driver){
        this.driver = driver;
    }

    private String pageURL = "http://olx.ua/";

    private By searchLookup = By.id("headerSearch");
    private By searchButton = By.id("submit-searchmain");
    private By resultTable = By.id("offers_table");


    public void openSite(){

        driver.get(pageURL);

    }

   public void startSearch(String string){

       driver.findElement(searchLookup).sendKeys(string);
       driver.findElement(searchButton).click();

   }

    public void checkResultTable(){

        driver.findElement(resultTable);
        //http://stackoverflow.com/questions/6198947/how-to-get-text-from-each-cell-of-an-html-table

    }



}
