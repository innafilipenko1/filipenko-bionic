package olx.functionaltests;

import entities.Advertisement;
import olx._pages.AdvertisementPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import webdriver.Browser;

import java.awt.*;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertismentTest extends AbstractTest {


    @Test
    public void createAdvertisement() throws AWTException {

        AdvertisementPage adPage = new AdvertisementPage(driver);
        adPage.openAdPage();
        adPage.setAdv(new Advertisement(true));


    }


}
