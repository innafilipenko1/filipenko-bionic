package olx.functionaltests;

import entities.Advertisement;
import olx._pages.AdvertisementPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;


/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertisementTest extends AbstractTest {

    @DataProvider
    public Object[][] positiveAd() {
        return new Object[][]{
                new Object[]{
                        "title"
                        , "35"
                        , "35"
                        , "64"
                        , "33"
                        , "2000"
                        , "3"
                        , "business"
                        , "2"
                        , "2"
                        , "Inna Inna"
                        , 1000
                },
        };
    }


    @Test
    public void createAdvertisement() throws AWTException {
        logger.info("using Advertisement entity correct=true values Started");
        AdvertisementPage adPage = new AdvertisementPage(driver);
        logger.info("open New Advertisement page");
        adPage.open();
        logger.info("createAdvertisement - filling out Advertisement fields");
        adPage.setAdvertisement(new Advertisement(true));
        Assert.assertTrue(adPage.isPreviewPageOpen());
        logger.info("createAdvertisement Finished");
    }

    @Test(dataProvider = "positiveAd")
    public void createAdvertisementTest(
              String title
            , String categoryId
            , String subCategoryId
            , String categoryTypeId
            , String dogBreedValueId
            , String dogBreedValue
            , String privatizationValueId //3
            , String privatizationValue //business
            , String regionValueId //1
            , String stateValueId //1
            , String contact
            , int price
    )
            throws AWTException {
        logger.info("createAdvertisementTest using DataProvider Started");
        Advertisement newAd = new Advertisement();
        newAd.title = title;
        newAd.categoryId = categoryId;
        newAd.subcategoryId = subCategoryId;
        newAd.categoryTypeId = categoryTypeId;
        newAd.dogBreedValueId = dogBreedValueId;
        newAd.dogBreedValue = dogBreedValue;
        newAd.privatizationValueId = privatizationValueId;
        newAd.privatizationValue = privatizationValue;
        newAd.regionValueId = regionValueId;
        newAd.stateValueId = stateValueId;
        newAd.contact = contact;
        newAd.price = price;
        AdvertisementPage adPage = new AdvertisementPage(driver);
        logger.info("Open Add New Advertisment page");
        adPage.open();
        logger.info("Filling out Advertisment fields");
        adPage.setAdvertisement(newAd);

        Assert.assertTrue(adPage.isPreviewPageOpen());
        logger.info("createAdvertisementTest Finished");
    }

}
