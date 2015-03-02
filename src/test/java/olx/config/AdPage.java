package olx.config;

import org.openqa.selenium.By;
import webdriver.Browser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by ifilipenko on 3/2/2015.
 */
public class AdPage extends AbstractPage{

        public AdPage(Browser driver){
        super(driver);
    }

    private static By header =  By.id("add-title");
    private static By rubricList = By.xpath("//a/../dl[@id='targetrenderSelect1-0']");



    public void openAdPage(){
       driver.get("http://olx.ua/post-new-ad/");
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
