package olx.functionaltests;

import entities.Advertisement;
import olx._pages.AdvertisementPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertismentTest extends AbstractTest {

    @DataProvider
    public Object[][] positiveAd(Advertisement ad) {
        return new Object[][] {
                new Object[] {ad.setCorrectTitle(), "email" , "smth"},
                new Object[] {"another", "newOne" , "correctOne"}
        };
    }


    @Test(dataProvider = "positiveAd")
    public void createAdvertisement(String title, String categoryId ) throws AWTException
    {
        
        Advertisement newAd = new Advertisement();
        newAd.title = title;

        AdvertisementPage adPage = new AdvertisementPage(driver);
        adPage.openAdPage();
        adPage.setAdv(new Advertisement(true));
        Assert.assertTrue(adPage.isPreviewPageOpen());
    }

    @Test
    public void createAdvertisement( ) throws AWTException
    {

        AdvertisementPage adPage = new AdvertisementPage(driver);
        adPage.openAdPage();
        adPage.selectCategory();
    }

}
