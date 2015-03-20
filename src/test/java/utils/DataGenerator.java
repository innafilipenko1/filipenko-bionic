package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Created by ifilipenko on 3/17/2015.
 */
public class DataGenerator {
    private static Random random = new Random();

    public static int getRandomInt(int bound){
        return random.nextInt(bound);
    }

    public static String getRandomString(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length).toLowerCase();
    }

    public static String getRandomStringUpperCase(int length)
    {
        return RandomStringUtils.randomAlphanumeric(length).toUpperCase();
    }

    public static String getRandomEmail()
    {
        return getRandomString(10) + "@" + getRandomString(5) + ".com";
    }
}
