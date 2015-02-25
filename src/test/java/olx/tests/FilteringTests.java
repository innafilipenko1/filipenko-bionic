package olx.tests;


import olx.config.ChildDressPage;
import olx.config.ChildPage;
import olx.config.HomePage;
import olx.config.SimpleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by c2611 on 23.02.2015.
 */
public class FilteringTests extends AbstractTest {

    @Test
    public void visualFilterTest() {
        openChildWorld();
        openChildDressPage();

    }

    public void openChildWorld() {
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        homePage.open();
        homePage.openChildWorld();
        ChildPage childPage = new ChildPage(driver);
        Assert.assertTrue(childPage.isOpen());
    }

    public void openChildDressPage() {
        ChildPage childPage = new ChildPage(driver);
        childPage.openChildDressPage();
        ChildDressPage childDressPage = new ChildDressPage(driver);
        Assert.assertTrue(childDressPage.isOpen());
    }

    @Test
    public void filterForNewStateTest() {
        openChildWorld();
        openChildDressPage();
        ChildDressPage childDressPage = new ChildDressPage(driver);
        childDressPage.selectNewState();
        childDressPage.checkResultListFilteredByNewState();
        Assert.assertTrue(childDressPage.checkResultListFilteredByNewState());



    }


}
