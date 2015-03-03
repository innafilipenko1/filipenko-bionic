package entities;

import olx.utils.PropertyLoader;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class Advertisement {

    public String title = "title";
    public String rubric = "";
    public String desc = "";
    public String photoFilePath = new File(PropertyLoader.loadProperty("project.path") + "src/test/resources/testData.file").getAbsolutePath();
    public String region = "";
    public String user = "";
    public String email = "";
    public String phone = "";
    public String icq = "";
    public String skype = "";

    public String setCorrectTitle(){
        return title = RandomStringUtils.randomAlphabetic(6);
    }

    public Advertisement(Boolean correct){
        if (correct) {
            title = "12345";
        }
        else {
            title = "123";
            email = "asd";
        }
    }
}
