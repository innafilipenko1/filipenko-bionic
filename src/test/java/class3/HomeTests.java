package class3;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by inna on 2/14/15.
 */
public class HomeTests {

     /*
    Написать тест который будет проверять
    что в строке содержится число типа real (0.0) разделенное точкой.
    Обязательно использовать regexp
     */

    @Test
    public void checkStringForRealNumber(){

        String string = "-52.25";

        Assert.assertTrue(string.matches("(-?)\\d*(\\.)\\d*"));

    }


    @Test
    public void checkStringForRealNumber1(){

        String string = "This line has a real number such as 0.23";
        String test = "";

        String[] splitString = (string.split("\\s+"));

        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].contains(".")) {
                test = splitString[i];
            }
        }
        Assert.assertTrue(test.matches("\\d\\.\\d{2}"));


    }



}
