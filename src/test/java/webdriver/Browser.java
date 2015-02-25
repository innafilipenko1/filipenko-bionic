package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by c2611 on 25.02.2015.
 */
public class Browser implements WebDriver {

    WebDriver browser;

    public Browser(WebDriver driver){
        this.browser = driver;
    }


    @Override
    public void get(String s) {

        browser.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(browser, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(browser, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return browser.findElement(by);
    }

    @Override
    public String getPageSource() {
        return getPageSource();
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return switchTo();
    }

    @Override
    public Navigation navigate() {
        return navigate();
    }

    @Override
    public Options manage() {
        return manage();
    }
}
