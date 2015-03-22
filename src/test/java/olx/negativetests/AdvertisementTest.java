package olx.negativetests;

import entities.Advertisement;
import olx.functionaltests.AbstractTest;
import olx._pages.AdvertisementPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertisementTest extends AbstractTest {

    Logger logger = LoggerFactory.getLogger(AdvertisementTest.class);

    @DataProvider
    public Object[][] negativeAd() {
        return new Object[][]{
                new Object[]{
                        "123"
                        , "Test"
                        , "In"
                        , "test"
                },
        };
    }

    @Test(dataProvider = "negativeAd")
    public void createAdv(
            String title
            , String privatizationDesc
            , String contact
            , String email
    ) {
        Advertisement newAd = new Advertisement();
        newAd.title = title;
        newAd.privatizationDesc = privatizationDesc;
        newAd.contact = contact;
        newAd.email = email;
        AdvertisementPage adPage = new AdvertisementPage(driver);
        logger.info("Open Add New Advertisement page");
        adPage.open();
        logger.info("Fill out Advertisement fields");
        logger.info("Use DataProvider values");
        adPage.setAdvertisement(newAd);
        logger.info("Check Error Hints presence on the form");
        Assert.assertTrue(adPage.isError());
    }
}
