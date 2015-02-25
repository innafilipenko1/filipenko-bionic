package olx.config;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildDressPage extends AbstractPage {

    private By state = By.xpath("//span[@class='header block']");
    private By checkboxNew = By.xpath("//ul[contains(@class, 'abs select binded')]/li[3]/label[@data-value='new']");
    private By firstElementesultList = By.xpath("//ul[contains(@class, 'abs select binded')]/li[3]/label[@data-value='new']");


    public ChildDressPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return (driver.getCurrentUrl().contains("detskaya-odezhda/")
                && driver.findElement(By.id("main-category-choose-label")).getText().contains("Дитячий одяг"));
    }

    public void selectNewState() {

        Assert.assertTrue(driver.findElement(state).isDisplayed());
        driver.findElement(state).click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.DAYS.MICROSECONDS);
        Assert.assertTrue(driver.findElement(checkboxNew).isDisplayed());
        driver.findElement(checkboxNew).click();

    }

    public void checkResultListFilteredByNewState(){

        List<WebElement> offersTable = driver.findElement(SimpleSearchPage.resultTable).findElements(SimpleSearchPage.resultTabelElement);

        for (int i = 0; i < 2 ; i++) {

            offersTable.get(i).click();
            Assert.assertTrue(driver.getCurrentUrl().contains("/obyavlenie/"));
            //Assert.assertTrue(driver.findElement(By.xpath("")));

        }




    }

}
