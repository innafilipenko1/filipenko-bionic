package olx.functionaltests;

import olx._pages.SimpleSearchPage;
import org.testng.annotations.Test;

/**
 * Created by inna on 2/22/15.
 */


public class SimpleSearchTests extends AbstractTest{


    @Test
    public void checkSearchByName() {

        SimpleSearchPage ss =  new SimpleSearchPage(driver);
        ss.openSite();
        ss.doAndCheckSearchByInput("кот");

    }





}
