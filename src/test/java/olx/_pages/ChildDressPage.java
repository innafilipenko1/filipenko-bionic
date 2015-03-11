package olx._pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.Browser;

import java.util.List;

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
        return (browser.getCurrentUrl().contains("detskaya-odezhda/")
                && browser.findElement(By.id("main-category-choose-label")).getText().contains("Дитячий одяг"));
    }


    public Boolean checkNewState() {


        if (browser.findElement(state).isDisplayed()){
            browser.findElement(state).click();
        }
//        browser.manage().timeouts().implicitlyWait(100, TimeUnit.DAYS.MICROSECONDS);

        if (browser.findElement(getCheckboxNewCSS).isDisplayed()){
            browser.findElement(getCheckboxNewCSS).click();
        }

        browser.findElement(listElementCSS).click();

        List<WebElement> elements = browser.findElements(By.cssSelector("a"));

        Boolean ok = false;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase("Нові")) {
                ok = true;}
        }
        //browser.navigate().back();
        return ok;
    }



}

