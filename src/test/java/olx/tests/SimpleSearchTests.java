package olx.tests;

import olx.config.SimpleSearchPage;
import org.testng.annotations.Test;

/**
 * Created by inna on 2/22/15.
 */


public class SimpleSearchTests extends AbstractTest{


    @Test
    public void checkSearchByName() {

        SimpleSearchPage ss =  new SimpleSearchPage(browser);
        ss.openSite();
        ss.doAndCheckSearchByInput("кот");

    }





}
