package entities;


import utils.DataGenerator;
import utils.PropertyLoader;

import java.io.File;

/**
 * Created by ifilipenko on 3/3/2015.
 */
public class Advertisement {

    //default values
    public static  String title = "title";
    public static  String categoryId = "35";
    public static  String subcategoryId = "35";
    public static  String categoryTypeId = "64";
    public static  String dogBreedValueId = "33";
    public static  String dogBreedValue = "2000";
    public static  String privatizationValueId = "2";
    public static  String privatizationValue = "private";
    public static  String regionValueId = "10";
    public static  String stateValueId = "20";
    public static  String privatizationDesc = "I like labrador retrievers!!! I need to add 50 symbols because of stupid validation on the form.";
    public static  String photoFilePath = new File(getDefaultPhotoPath()).getAbsolutePath();
    public static  String contact = "Your majesty";
    public static  String email = "test@gmail.com";
    public static  int price = 5000;


    public  Advertisement(){}

    public Advertisement(Boolean correct)
    {
        if (correct)
        {
            title = DataGenerator.getRandomString(5);
            categoryId = "35";
            subcategoryId = "35";
            categoryTypeId = "64";
            dogBreedValueId = "33";
            dogBreedValue = "2000";
            privatizationValueId = "2";
            privatizationValue = "private";
            regionValueId = "10";
            stateValueId = "20";
            privatizationDesc = DataGenerator.getRandomString(60);
            contact = DataGenerator.getRandomString(20);
            email = DataGenerator.getRandomEmail();
            price = DataGenerator.getRandomInt(5);
        }
        else
        {
            title = DataGenerator.getRandomString(4);
            categoryId = "35";
            subcategoryId = "35";
            categoryTypeId = "64";
            dogBreedValueId = "33";
            dogBreedValue = "2000";
            privatizationValueId = "2";
            privatizationValue = "private";
            regionValueId = "10";
            stateValueId = "20";
            privatizationDesc = DataGenerator.getRandomString(40);
            contact = DataGenerator.getRandomString(2);
            email = DataGenerator.getRandomString(4);
            price = 0;
        }
    }

    private static String getDefaultPhotoPath()
    {
        String projectPath = PropertyLoader.loadProperty("project.path");
        String filePath = "/src/main/resources/LoginError.png";
        return projectPath + filePath;
    }
}
