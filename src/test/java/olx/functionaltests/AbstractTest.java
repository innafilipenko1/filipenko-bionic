package olx.functionaltests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PropertyLoader;
import webdriver.Browser;
import webdriver.BrowserFactory;

import java.lang.reflect.Method;

/**
 * Created by c2611 on 23.02.2015.
 */

public class AbstractTest {
    public Browser driver;
    protected Logger logger;


    @BeforeMethod
    public void init() {
        driver = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
        logger = LoggerFactory.getLogger(getClass());
        logger.info("Test Started");
        //logger.info(method.getDeclaringClass().getCanonicalName() + "." + method.getName() + " Started");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void shutEvt(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info(method.getDeclaringClass().getCanonicalName() + "." + method.getName() + " Completed");
        }
        if (driver != null)
            driver.quit();
    }


}
