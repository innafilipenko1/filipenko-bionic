package class3;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by c2611 on 11.02.2015.
 */

public class Test1 {

    @Test
    public void readWordInFile() {
        /*
        Check if the file content contains the word given.
        */

        String string = "test";

        try {

            String content = new String(readAllBytes(get("C://Users/ifilipenko/Downloads/testing.txt")));

            Assert.assertTrue(content.contains(string));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
