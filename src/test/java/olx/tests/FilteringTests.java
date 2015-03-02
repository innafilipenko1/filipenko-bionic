package olx.tests;


import olx.config.ChildDressPage;
import olx.config.ChildPage;
import olx.config.HomePage;
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

    @Test
    public void filterForNewStateTest() {
        openChildWorld();
        openChildDressPage();
        sortByNew();
    }


    public void openChildWorld() {
        HomePage homePage = new HomePage(browser);
        browser.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        homePage.open();
        homePage.openChildWorld();
        ChildPage childPage = new ChildPage(browser);
        Assert.assertTrue(childPage.isOpen());
    }

    public void openChildDressPage() {
        ChildPage childPage = new ChildPage(browser);
        childPage.openChildDressPage();
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.isOpen());
    }

    public void sortByNew(){
        ChildDressPage childDressPage = new ChildDressPage(browser);
        childDressPage.checkNewState();
        //!!!!!!Assert.assertTrue(childDressPage.checkNewState(), "Sorted by New!");
    }



}
