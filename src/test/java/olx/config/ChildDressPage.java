package olx.config;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.Browser;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildDressPage extends AbstractPage {

    private By state = By.xpath("//span[@class='header block']");
    private By stateCSS = By.cssSelector("span:class='header block'");
    private By checkboxNew = By.xpath("//ul[contains(@class, 'abs select binded')]/li[3]/label[@data-value='new']");
    private By getCheckboxNewCSS = By.cssSelector("#f-new_state");
    private By firstElementesultList = By.xpath("//ul[contains(@class, 'abs select binded')]/li[3]/label[@data-value='new']");
    private By listElementCSS = By.cssSelector(".marginright5.link.linkWithHash.detailsLink>span");


    public ChildDressPage(Browser driver) {
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

    public Boolean checkResultListFilteredByNewState() {

        List<WebElement> elements = driver.findElements(By.cssSelector("a"));
        System.out.println(elements.toArray().toString());
        Boolean ok = false;
 /*       for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase("Нові")) {
                ok = true;}
        }
        driver.navigate().back();*/
        return ok;
    }


}

