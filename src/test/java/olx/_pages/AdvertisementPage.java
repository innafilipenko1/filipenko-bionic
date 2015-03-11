package olx._pages;

import entities.Advertisement;
import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import webdriver.Browser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertisementPage extends AbstractPage {

    private static final By createAdvertisementLink = By.id("post-new-ad");
    private static final By TitlePath = By.id("add-title");
    private static final By CategoryPath = By.cssSelector("#targetrenderSelect1-0>dt>a");

    private static final By categoryAnimalsPath = By.id("cat-35");
    private static final By subcategoryAnimalsPath = By.xpath("//a[@data-category = '35']");
    private static final By dogPath = By.xpath("//a[@data-category = '64']");
    private static final By pricePath = By.className("paramPriceInput");
    private static final By dogBreedPath = By.id("parameter-div-dog_breed");
    private static final By dogBreedValuePath = By.xpath("//*[@id='targetparam137']/dd/ul/li[33]/a");
    private static final By dogBreedListPath = By.id("param137");

    private static final By privatizationTypeListPath = By.id("id_private_business");
    private static final By privatizationTypePath = By.id("targetid_private_business");
    private static final By privatizationTypeValuePath = By.xpath("//dl[@id='targetid_private_business']/dd/ul/li[2]/a");
    private static final By privatizationDescPath = By.name("data[description]");

    private static final By uploadImagePath = By.id("add-file-1");

    private static final By regionListPath = By.xpath("//dl[@id='targetregion-id-select']/dt/a");
    private static final By regionValuePath = By.xpath("//*[@id='targetregion-id-select']/dd/ul/li[10]/a");
    private static final By stateListPath = By.xpath("//dl[@id='targetsubregion-id-select']/dt/a");
    private static final By stateValuePath = By.xpath("//*[@id='targetsubregion-id-select']/dd/ul/li[20]/a");

    private static final By contactPath = By.cssSelector("#add-person");
    private static final By emailPath = By.cssSelector("#add-email");

    public AdvertisementPage(Browser driver) {
        super(driver);
    }

    public void openAdPage() {
        browser.get("http://olx.ua/post-new-ad/");
    }

    public void setAdv(Advertisement adv) {
        browser.findElement(TitlePath).sendKeys(adv.title);
        selectCategory();
        try {
            selectPhoto();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        selectLocation();
        browser.findElement(contactPath).sendKeys("Your majesty");
        browser.findElement(emailPath).sendKeys("test@gmail.com");
        browser.findElement(By.cssSelector("#accept > div > div.area.clr.margintop5 > div")).click();
        browser.findElement(By.id("preview-link")).click();
        Assert.assertTrue(browser.getCurrentUrl().contains("preview"));

    }

    public void selectCategory() {

        browser.findElement(CategoryPath).click();

        browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        browser.findElement(categoryAnimalsPath).click();

        Actions builder = new Actions(browser.driver);
        builder.doubleClick(browser.findElement(subcategoryAnimalsPath));

        browser.findElement(dogPath).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        browser.findElement(pricePath).sendKeys("5000");

        //select from the list Dog Breed
        Select dogBreedList = new Select(browser.findElement(dogBreedListPath));
        browser.findElement(dogBreedPath).click();
        browser.findElement(dogBreedValuePath).click();
        Assert.assertEquals("2000", dogBreedList.getFirstSelectedOption().getAttribute("value"));

        //select from the list Privatization Type
        Select privatizationTypeList = new Select(browser.findElement(privatizationTypeListPath));
        browser.findElement(privatizationTypePath).click();
        browser.findElement(privatizationTypeValuePath).click();
        Assert.assertEquals("private",privatizationTypeList.getFirstSelectedOption().getAttribute("value"));

    /*
        Select dogBreed = new Select(browser.findElement(dogBreedListPath));
        dogBreed.selectByValue("8496");*/

        browser.findElement(privatizationDescPath).sendKeys("I like labrador retrievers!!!" +
                "I need to add 50 symbols because of stupid validation on the form.");

    }

    public void selectPhoto() throws AWTException {

        browser.manage().timeouts().implicitlyWait(5000, TimeUnit.DAYS.SECONDS);
        browser.findElement(uploadImagePath).click();
        StringSelection ss = new StringSelection(Advertisement.photoFilePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void selectLocation() {
        browser.findElement(regionListPath).click();
        browser.findElement(regionValuePath).click();
        browser.findElement(stateListPath).click();
        browser.findElement(stateValuePath).click();
    }

    public boolean isError() {
        return false;
    }



/*    String forName = "qazxswedcbvfrtgbnhyujmkiololpQAZXSWEDCVFRTGBNHYUJMKIOLP_";
    Random random = new Random();
    String userName = "";
    for (int i = 0; i < 10 ; i++) {
        int n = random.nextInt(forName.length());
        userName = userName + forName.charAt(n);
    }
    System.out.println(userName);*/
}
