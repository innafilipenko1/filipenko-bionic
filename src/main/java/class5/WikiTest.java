package class5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


/**
 * Created by c2611 on 18.02.2015.
 */
public class WikiTest {

    public WebDriver driver;

    @BeforeSuite
    public void initDriver() {

        driver = new FirefoxDriver();
    }

    @Test(enabled = false)
    public void TestWiki() {

        driver.get("https://en.wikipedia.org/wiki");
        Assert.assertTrue(driver.findElement(By.className("mw-wiki-logo")).isDisplayed());

    }

    @Test
    public void loginToGit(){

        driver.get("https://github.com/");
        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("login_field")).sendKeys("innafilipenko1");
        driver.findElement(By.id("password")).sendKeys("pAss3ceR");
        driver.findElement(By.name("commit")).click();

        Assert.assertTrue(driver.findElement(By.className("css-truncate-target")).isEnabled());
        String string = driver.findElement(By.className("css-truncate-target")).getText();
        Assert.assertTrue(string.equals("innafilipenko1"));

    }

    @AfterSuite
    public void shutEvent() {

        driver.quit();
    }


}
