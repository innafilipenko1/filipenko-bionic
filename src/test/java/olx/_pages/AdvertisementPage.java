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

    private static final String PAGE_URL = "http://olx.ua/post-new-ad/";
    private static final By PAGE_TEXT = By.cssSelector("#newOffer > div > h1");
    private static final By TITLE_PATH = By.id("add-title");
    private static final By CATEGORY_PATH = By.cssSelector("#targetrenderSelect1-0>dt>a");
    private static final By CATEGORY_POPUP_PATH = By.id("cat-" + Advertisement.categoryId);
    private static final By SUBCATEGORY_PATH = By.xpath("//a[@data-category = '" + Advertisement.subcategoryId + "']");
    private static final By CATEGORY_PATH_TYPE = By.xpath("//a[@data-category = '" + Advertisement.categoryTypeId + "']");
    private static final By PRICE_PATH = By.className("paramPriceInput");
    private static final By DOG_BREED_PATH = By.id("targetparam137");
    private static final By DOG_BREED_VALUE_PATH = By.xpath("//*[@id='targetparam137']/dd/ul/li[" + Advertisement.dogBreedValueId + "]/a");
    private static final By DOG_BREED_LIST_PATH = By.id("param137");
    private static final By PRIVATIZATION_TYPE_LIST_PATH = By.id("id_private_business");
    private static final By PRIVATIZATION_TYPE_PATH = By.id("targetid_private_business");
    private static final By PRIVATIZATION_TYPE_VALUE_PATH = By.xpath("//dl[@id='targetid_private_business']/dd/ul/li[" + Advertisement.privatizationValueId + "]/a");
    private static final By PRIVATIZATION_DESC_PATH = By.name("data[description]");
    private static final By UPLOAD_IMAGE_PATH = By.id("add-file-1");
    private static final By REGION_LIST_PATH = By.xpath("//dl[@id='targetregion-id-select']/dt/a");
    private static final By REGION_VALUE_PATH = By.xpath("//*[@id='targetregion-id-select']/dd/ul/li[" + Advertisement.regionValueId + "]/a");
    private static final By STATE_LIST_PATH = By.xpath("//dl[@id='targetsubregion-id-select']/dt/a");
    private static final By STATE_VALUE_PATH = By.xpath("//*[@id='targetsubregion-id-select']/dd/ul/li[" + Advertisement.stateValueId + "]/a");
    private static final By CONTACT_PATH = By.cssSelector("#add-person");
    private static final By EMAIL_PATH = By.cssSelector("#add-email");
    public static final By AGREE_CHECKBOX_PATH = By.cssSelector("#accept > div > div.area.clr.margintop5 > div");
    private static final By PREVIEW_LINK_PATH = By.id("preview-link");


    public static final By TITLE_ERROR = By.xpath("//p/label[@for='add-title']");
    public static final By DESCRIPTION_ERROR = By.xpath("//p/label[@for='add-description']");
    public static final By CONTACT_ERROR = By.xpath("//p/label[@for='add-person']");
    public static final By EMAIL_ERROR = By.xpath("//p/label[@for='add-email']");
    public static final By AGREEMENT_ERROR = By.xpath("//p/label[@for='data[accept]']");

    public AdvertisementPage(Browser driver) {
        super(driver);
    }

    public void open() {
        browser.get(PAGE_URL);
    }

    public boolean isOpen() {
        return browser.findElement(PAGE_TEXT).isDisplayed();
    }

    public void setAdvertisement(Advertisement ad) {
        setTitle(ad.title);
        selectCategory();
        try {
            selectPhoto(Advertisement.photoFilePath);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        selectLocation();
        setContact(ad.contact);
        setEmail(ad.email);
        setAgreeCheckbox();
        setPreviewLink();
    }

    public void setTitle(String title) {
        browser.findElement(TITLE_PATH).sendKeys(title);
    }


    public void selectCategory() {
        browser.findElement(CATEGORY_PATH).click();
        browser.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        browser.findElement(CATEGORY_POPUP_PATH).click();
/*        Actions builder = new Actions(browser.driver);
        builder.doubleClick(browser.findElement(SUBCATEGORY_PATH));*/
        browser.findElement(SUBCATEGORY_PATH).click();
        browser.findElement(SUBCATEGORY_PATH).click();
        browser.findElement(CATEGORY_PATH_TYPE).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setPrice();
        setDogBreed();
        setPrivatizationType();
        setPrivatizationDescription();

    }

    public void setPrice() {
        browser.findElement(PRICE_PATH).sendKeys("" + Advertisement.price);
    }

    public void setDogBreed() {
        browser.findElement(DOG_BREED_PATH).click();
        browser.findElement(DOG_BREED_VALUE_PATH).click();
        Select dogBreedList = new Select(browser.findElement(DOG_BREED_LIST_PATH));
        Assert.assertEquals(Advertisement.dogBreedValue, dogBreedList.getFirstSelectedOption().getAttribute("value"));
    }

    public void setPrivatizationType() {
        browser.findElement(PRIVATIZATION_TYPE_PATH).click();
        browser.findElement(PRIVATIZATION_TYPE_VALUE_PATH).click();
        Select privatizationTypeList = new Select(browser.findElement(PRIVATIZATION_TYPE_LIST_PATH));
        Assert.assertEquals(Advertisement.privatizationValue, privatizationTypeList.getFirstSelectedOption().getAttribute("value"));
    }

    public void setPrivatizationDescription() {
        browser.findElement(PRIVATIZATION_DESC_PATH).sendKeys(Advertisement.privatizationDesc);
    }

    public void selectPhoto(String url) throws AWTException {
        browser.manage().timeouts().implicitlyWait(5000, TimeUnit.DAYS.SECONDS);
        browser.findElement(UPLOAD_IMAGE_PATH).click();
        setClipboardData(url);
        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(900);
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

    private static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void selectLocation() {
        browser.findElement(REGION_LIST_PATH).click();
        browser.findElement(REGION_VALUE_PATH).click();
        browser.findElement(STATE_LIST_PATH).click();
        browser.findElement(STATE_VALUE_PATH).click();
    }

    public void setContact(String contact) {
        browser.findElement(CONTACT_PATH).sendKeys(contact);
    }

    public void setEmail(String email) {
        browser.findElement(EMAIL_PATH).sendKeys(email);
    }

    public void setAgreeCheckbox() {
        browser.findElement(AGREE_CHECKBOX_PATH).click();
    }

    public void setPreviewLink() {
        browser.findElement(PREVIEW_LINK_PATH).click();
    }

    public boolean isPreviewPageOpen() {
        return browser.getCurrentUrl().contains("preview");

    }

    public boolean isError() {
        return (browser.findElement(TITLE_ERROR).isDisplayed() &&
                browser.findElement(DESCRIPTION_ERROR).isDisplayed() &&
                browser.findElement(CONTACT_ERROR).isDisplayed() &&
                browser.findElement(EMAIL_ERROR).isDisplayed() &&
                browser.findElement(AGREEMENT_ERROR).isDisplayed());


    }

}
