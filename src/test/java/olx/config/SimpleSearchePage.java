package olx.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

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
    private By tableElement = By.xpath("//table[@id='offers_table']/tbody/tr");


    public void openSite(){

        driver.get(pageURL);

    }

   public void startSearch(String string){

       driver.findElement(searchLookup).sendKeys(string);
       driver.findElement(searchButton).click();

   }

    public void checkResultTable(){

//http://stackoverflow.com/questions/6198947/how-to-get-text-from-each-cell-of-an-html-table
        driver.findElement(resultTable);
        List<WebElement> offersTable = driver.findElement(resultTable).findElements(tableElement);
        int row_num,col_num;
        row_num=1;
        for(WebElement trElement : offersTable)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS="+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
                System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
                col_num++;
            }
            row_num++;
        }




    }



}
