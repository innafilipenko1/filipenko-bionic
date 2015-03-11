package olx.functionaltests;

import olx._pages.AdvertisementPage;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertismentTest extends AbstractTest {


    @Test
    public void createAdvertisement() throws AWTException {

        AdvertisementPage adPage = new AdvertisementPage(driver);
        adPage.openAdPage();
        adPage.selectCategory();
        //adPage.setAdv(new Advertisement(true));
    }


}
