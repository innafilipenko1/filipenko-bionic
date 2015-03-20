package olx._pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webdriver.Browser;


/**
 * Created by c2611 on 23.02.2015.
 */
public abstract class AbstractPage {
    protected Browser browser;
    protected Logger logger;

    public AbstractPage(Browser browser) {
        this.browser = browser;
        this.logger = LoggerFactory.getLogger(getClass());
    }

    public abstract boolean isOpen();

}

