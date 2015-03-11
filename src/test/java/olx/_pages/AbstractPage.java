package olx._pages;

import webdriver.Browser;

/**
 * Created by c2611 on 23.02.2015.
 */
public class AbstractPage {

    public Browser browser;

    public AbstractPage(Browser driver){
        this.browser = driver;
    }

    public void openSite(String string){
        browser.get(string);
    }
    

}
