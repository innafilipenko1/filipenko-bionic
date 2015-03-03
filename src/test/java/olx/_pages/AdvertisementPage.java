package olx._pages;

import com.gargoylesoftware.htmlunit.util.StringUtils;
import entities.Advertisement;
import org.openqa.selenium.By;
import webdriver.Browser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class AdvertisementPage extends AbstractPage{

    private static final By createAdvertisementLink = By.id("post-new-ad");
    private static final By advTitlePath = By.id("add-title");
    private static final By advCategoryPath = By.cssSelector("#targetrenderSelect1-0>dt>a");
    private static final By categoryAnimalsPath = By.id("cat-35");
    private static final By dogPath = By.xpath("//a[@data-category = '64']/span");
    private static final By pricePath = By.className("paramPriceInput");
    private static final By dogBreedPath = By.id("targetparam137");
    private static final By privatizationTypePath = By.id("targetid_private_business");
    private static final By privatizationDescPath = By.name("data[description]");
    private static final By state = By.xpath(".//*[@id='targetparam13']/dt/a");
    private static final By chooseState = By.xpath(".//*[@id='targetparam13']/dd/ul/li[3]/a");
    private static final By email = By.id("add-email");

    public AdvertisementPage(Browser driver) {
        super(driver);
    }

    public void openAdPage(){
        driver.get("http://olx.ua/post-new-ad/");
    }

    public void setAdv(Advertisement adv) throws AWTException, InterruptedException {
        driver.findElement(advTitlePath).sendKeys(adv.title);
        selectPhoto();
        //selectDogCategory();


    }

    public void selectDogCategory(){

        driver.findElement(advCategoryPath).click();
        driver.findElement(categoryAnimalsPath).click();
        driver.findElement(dogPath).click();

        //driver.findElement(pricePath).sendKeys("5000");

      /*  WebElement dogBreadList = driver.findElement(dogBreedPath);
        Select dogBreed = new Select(dogBreadList);
        dogBreed.selectByValue("2000");

        WebElement privatizationTypeList = driver.findElement(privatizationTypePath);
        Select privatizationType = new Select(privatizationTypeList);
        privatizationType.selectByValue("private");

        driver.findElement(privatizationDescPath).sendKeys("I like labrador retrievers!!!'");*/

    }

    public void selectPhoto() throws AWTException {

        driver.findElement(By.id("add-file-1")).click();
        String photoPath = "LoginError.png";
        StringSelection ss = new StringSelection(photoPath);
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

    }



    public boolean isError()
    {
        return false;
    }






 /*   WebElement selectList = driver.findElement(By.id("continents"));
    Select select = new Select(selectList);
    select.selectByVisibleText("Africa");
    System.out.println(select.getFirstSelectedOption().getText());*/

/*    attaching a file
    WebElement uploadPhoto = driver.findElement(By.id("photo"));
    uploadPhoto.click();
    Thread.sleep(2000);
    //uploadPhoto.sendKeys("C:/Users/ifilipenko/Dropbox/Books/LoginError.png");

    // StringSelection ss = new StringSelection("C:/Users/ifilipenko/Dropbox/Books/LoginError.png");
    StringSelection ss = new StringSelection("LoginError.png");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    //        imitate mouse events like ENTER, CTRL+C, CTRL+V
    Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);*/


/*    String forName = "qazxswedcbvfrtgbnhyujmkiololpQAZXSWEDCVFRTGBNHYUJMKIOLP_";
    Random random = new Random();
    String userName = "";
    for (int i = 0; i < 10 ; i++) {
        int n = random.nextInt(forName.length());
        userName = userName + forName.charAt(n);
    }
    System.out.println(userName);*/
}
