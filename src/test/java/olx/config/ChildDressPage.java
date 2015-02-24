package olx.config;


import org.apache.xerces.dom3.as.ASElementDeclaration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildDressPage extends AbstractPage {

    private static final By state = By.xpath("//span[@class='header block']");
    private static final By checkboxNew = By.xpath("//ul[contains(@class, 'abs select binded')]/li[3]/label[@data-value='new']");


    public ChildDressPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return (driver.getCurrentUrl().contains("detskaya-odezhda/")
                && driver.findElement(By.id("main-category-choose-label")).getText().contains("Дитячий одяг"));
    }

    public void selectState() {

        Assert.assertTrue(driver.findElement(state).isDisplayed());
        driver.findElement(state).click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.DAYS.MICROSECONDS);
        Assert.assertTrue(driver.findElement(checkboxNew).isDisplayed());
        driver.findElement(checkboxNew).click();




    }

}
