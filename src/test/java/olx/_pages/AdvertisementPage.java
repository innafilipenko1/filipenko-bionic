package olx._pages;

import entities.Advertisement;
import org.openqa.selenium.By;

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
    private static final By privatizationTypePath = By.id("targetid_private_business");
    private static final By privatizationDescPath = By.name("data[description]");


    private static final By state = By.xpath(".//*[@id='targetparam13']/dt/a");
    private static final By chooseState = By.xpath(".//*[@id='targetparam13']/dd/ul/li[3]/a");
    private static final By email = By.id("add-email");

    public AdvertisementPage(Browser driver) {
        super(driver);
    }

    public void openAdPage() {
        driver.get("http://olx.ua/post-new-ad/");
    }


    public void setAdv(Advertisement adv) {
        driver.findElement(TitlePath).sendKeys(adv.title);
        selectCategory();
        try {
            selectPhoto();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        selectLocation();
        driver.findElement(By.cssSelector("#add-person")).sendKeys("Your majesty");
        driver.findElement(By.cssSelector("#add-email")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("#accept > div > div.area.clr.margintop5 > div")).click();
        driver.findElement(By.id("preview-link")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("preview"));

    }

    public void selectCategory() {

        driver.findElement(CategoryPath).click();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        driver.findElement(categoryAnimalsPath).click();

        driver.findElement(subcategoryAnimalsPath).click();
        driver.findElement(subcategoryAnimalsPath).click();

        driver.findElement(dogPath).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(pricePath).sendKeys("5000");

        //select from the list Dog Breed
        driver.findElement(dogBreedPath).click();
        driver.findElement(dogBreedValuePath).click();
        Assert.assertTrue(driver.findElement(dogBreedListPath).isSelected());

        //select from the list Privatization Type
        driver.findElement(privatizationTypePath).click();
        driver.findElement(By.xpath("//dl[@id='targetid_private_business']/dd/ul/li[2]/a")).click();

    /*
        Select dogBreed = new Select(driver.findElement(dogBreedListPath));
        dogBreed.selectByValue("8496");*/

        driver.findElement(privatizationDescPath).sendKeys("I like labrador retrievers!!!" +
                "I need to add 50 symbols because of stupid validation on the form.");

    }

    public void selectPhoto() throws AWTException {

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.DAYS.SECONDS);
        driver.findElement(By.id("add-file-1")).click();
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
        driver.findElement(By.xpath("//dl[@id='targetregion-id-select']/dt/a")).click();
        driver.findElement(By.xpath("//*[@id='targetregion-id-select']/dd/ul/li[10]/a")).click();

        driver.findElement(By.xpath("//dl[@id='targetsubregion-id-select']/dt/a")).click();
        driver.findElement(By.xpath("//*[@id='targetsubregion-id-select']/dd/ul/li[20]/a")).click();
    }


    public boolean isError() {
        return false;
    }






 /*   WebElement selectList = driver.findElement(By.id("continents"));
    Select select = new Select(selectList);
    select.selectByVisibleText("Africa");
    System.out.println(select.getFirstSelectedOption().getText());*/



/*    String forName = "qazxswedcbvfrtgbnhyujmkiololpQAZXSWEDCVFRTGBNHYUJMKIOLP_";
    Random random = new Random();
    String userName = "";
    for (int i = 0; i < 10 ; i++) {
        int n = random.nextInt(forName.length());
        userName = userName + forName.charAt(n);
    }
    System.out.println(userName);*/
}
