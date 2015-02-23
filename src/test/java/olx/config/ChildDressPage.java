package olx.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c2611 on 23.02.2015.
 */
public class ChildDressPage extends AbstractPage{

    public ChildDressPage(WebDriver driver){
        super(driver);
    }

    public boolean isOpen(){
       return (driver.getCurrentUrl().contains("detskiy-mir/detskaya-odezhda/")
       && driver.findElement(By.id("main-category-choose-label")).getText().contains("Дитядий одяг"));    }


}
