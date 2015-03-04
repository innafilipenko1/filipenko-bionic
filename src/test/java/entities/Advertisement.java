package entities;

import olx.utils.PropertyLoader;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class Advertisement {

    public static  String title = "title";
    public static  String rubric = "";
    public static  String desc = "";
    public static  String photoFilePath = new File(PropertyLoader.loadProperty("project.path") + "/src/test/resources/LoginError.png").getAbsolutePath();
    public static  String region = "";
    public static  String user = "";
    public static  String email = "";
    public static  String phone = "";
    public static  String icq = "";
    public static  String skype = "";

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
