package olx.negativetests;

import entities.Advertisement;
import olx.functionaltests.AbstractTest;
import olx._pages.AdvertisementPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertisementTest extends AbstractTest {

    @DataProvider
    public Object[][] negativeAd() {
        return new Object[][] {
                new Object[] {"title", "email" , "smth"},
                new Object[] {"another", "newOne" , "correctOne"},
        };
    }

    @Test(dataProvider = "negativeAd")
    public void createAdv(String title, String email, String smth)
    {
        driver.get("http://olx.ua/uk/post-new-ad/");
        Advertisement adv = new Advertisement(false);
        adv.title = title;
        adv.email = email;
        adv.icq = smth;
        AdvertisementPage advPage = new AdvertisementPage(driver);
       // advPage.setAdv(adv);
        Assert.assertTrue(advPage.isError());
    }
}
