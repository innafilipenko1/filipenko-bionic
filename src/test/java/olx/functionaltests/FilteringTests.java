package olx.functionaltests;


import olx._pages.ChildDressPage;
import olx._pages.ChildPage;
import olx._pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by c2611 on 23.02.2015.
 */
public class FilteringTests extends AbstractTest {

    @Test
    public void filterForNewStateTest() {
        openChildrenWorld();
        openChildDressPage();
        sortByNew();
    }

    public void openChildrenWorld() {
        HomePage homePage = new HomePage(driver);
        logger.info("Open OLX Home page");
        homePage.open();
        Assert.assertTrue(homePage.isOpen(), "Home page is not open");
        logger.info("Open Child World page");
        homePage.openChildWorld();
        ChildPage childPage = new ChildPage(driver);
        Assert.assertTrue(childPage.isOpen(), "Child Page is not open");
    }

    public void openChildDressPage() {
        ChildPage childPage = new ChildPage(driver);
        logger.info("Open Child Dress page");
        childPage.openChildDressPage();
        ChildDressPage childDressPage = new ChildDressPage(driver);
        Assert.assertTrue(childDressPage.isOpen(), "Child Dress page is not open");
    }

    public void sortByNew() {
        ChildDressPage childDressPage = new ChildDressPage(driver);
        logger.info("Filter result list by New state");
        childDressPage.filterOutByNewState();
        Assert.assertTrue(childDressPage.checkElementHasNewState(), "Not sorted by New!");
    }


}
