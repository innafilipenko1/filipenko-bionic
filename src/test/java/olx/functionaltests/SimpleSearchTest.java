package olx.functionaltests;

import entities.Search;
import olx._pages.HomePage;
import olx._pages.SimpleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by inna on 2/22/15.
 */


public class SimpleSearchTest extends AbstractTest {

    @Test
    public void checkSearchByName() {
        HomePage homePage = new HomePage(driver);
        logger.info("Open OLX Home page");
        homePage.open();
        Assert.assertTrue(homePage.isOpen(), "Home page is open");
        SimpleSearchPage ss = new SimpleSearchPage(driver);
        logger.info("Start searching");
        ss.applySearch(Search.INPUT);
        Assert.assertTrue(ss.getResultTable(Search.INPUT), "Result table is filtered by" +Search.INPUT );
    }
}
