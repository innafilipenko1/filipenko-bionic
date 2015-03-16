package olx._pages;

import entities.Advertisement;
import org.openqa.selenium.By;

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

    private static final String pageURL = "http://olx.ua/post-new-ad/";

    private static final By TitlePath = By.id("add-title");
    private static final By CategoryPath = By.cssSelector("#targetrenderSelect1-0>dt>a");

    private static final By categoryPath = By.id("cat-"+Advertisement.categoryId);
    private static final By subcategoryPath = By.xpath("//a[@data-category = '"+Advertisement.subcategoryId+"']");
    private static final By categoryTypePath = By.xpath("//a[@data-category = '"+Advertisement.categoryTypeId+"']");
    private static final By pricePath = By.className("paramPriceInput");
    private static final By dogBreedPath = By.id("targetparam137");
    private static final By dogBreedValuePath = By.xpath("//*[@id='targetparam137']/dd/ul/li["+Advertisement.dogBreedValueId+"]/a");
    private static final By dogBreedListPath = By.id("param137");

    private static final By privatizationTypeListPath = By.id("id_private_business");
    private static final By privatizationTypePath = By.id("targetid_private_business");
    private static final By privatizationTypeValuePath = By.xpath("//dl[@id='targetid_private_business']/dd/ul/li["+Advertisement.privatizationValueId+"]/a");
    private static final By privatizationDescPath = By.name("data[description]");

    private static final By uploadImagePath = By.id("add-file-1");

    private static final By regionListPath = By.xpath("//dl[@id='targetregion-id-select']/dt/a");
    private static final By regionValuePath = By.xpath("//*[@id='targetregion-id-select']/dd/ul/li["+Advertisement.regionValueId+"]/a");
    private static final By stateListPath = By.xpath("//dl[@id='targetsubregion-id-select']/dt/a");
    private static final By stateValuePath = By.xpath("//*[@id='targetsubregion-id-select']/dd/ul/li["+Advertisement.stateValueId+"]/a");

    private static final By contactPath = By.cssSelector("#add-person");
    private static final By emailPath = By.cssSelector("#add-email");

    public static final By agreeCheckBox = By.cssSelector("#accept > div > div.area.clr.margintop5 > div");
    private static final By previewLink = By.id("preview-link");


    public AdvertisementPage(Browser driver) {
        super(driver);
    }

    public void openAdPage() {
        browser.get(pageURL);
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
        browser.findElement(contactPath).sendKeys(Advertisement.contact);
        browser.findElement(emailPath).sendKeys(Advertisement.email);
        browser.findElement(agreeCheckBox).click();
        browser.findElement(previewLink).click();
    }

    public void selectCategory() {
        browser.findElement(CategoryPath).click();

        browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        browser.findElement(categoryPath).click();

/*        Actions builder = new Actions(browser.driver);
        builder.doubleClick(browser.findElement(subcategoryPath));*/

        browser.findElement(subcategoryPath).click();
        browser.findElement(subcategoryPath).click();

        browser.findElement(categoryTypePath).click();
/*        browser.findElement(categoryTypePath).click();*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        browser.findElement(pricePath).sendKeys(""+Advertisement.setPrice());

        //select from the list Dog Breed
        browser.findElement(dogBreedPath).click();
        browser.findElement(dogBreedValuePath).click();
        Select dogBreedList = new Select(browser.findElement(dogBreedListPath));
        Assert.assertEquals(Advertisement.dogBreedValue, dogBreedList.getFirstSelectedOption().getAttribute("value"));

        //select from the list Privatization Type
        browser.findElement(privatizationTypePath).click();
        browser.findElement(privatizationTypeValuePath).click();
        Select privatizationTypeList = new Select(browser.findElement(privatizationTypeListPath));
        Assert.assertEquals(Advertisement.privatizationValue, privatizationTypeList.getFirstSelectedOption().getAttribute("value"));

    /*
        Select dogBreed = new Select(browser.findElement(dogBreedListPath));
        dogBreed.selectByValue("8496");*/

        browser.findElement(privatizationDescPath).sendKeys(Advertisement.privatizationDesc);

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
            Thread.sleep(5000);
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


    public boolean isPreviewPageOpen() {
        return browser.getCurrentUrl().contains("preview");

    }

    public boolean isError() {
       return (browser.findElement(By.xpath("//p/label[@for='add-title']")).isDisplayed() &&
        browser.findElement(By.xpath("//p/label[@for='add-description']")).isDisplayed() &&
        browser.findElement(By.xpath("//p/label[@for='add-person']")).isDisplayed() &&
        browser.findElement(By.xpath("//p/label[@for='add-email']")).isDisplayed() &&
        browser.findElement(By.xpath("//p/label[@for='data[accept]']")).isDisplayed());



    }

}
