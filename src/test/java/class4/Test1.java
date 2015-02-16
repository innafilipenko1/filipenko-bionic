package class4;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by c2611 on 16.02.2015.
 */
public class Test1 {

    @BeforeTest
    public void writeToFile() {

        StringBuffer sb = new StringBuffer("8");
        try {
            FileWriter fwriter = new FileWriter(new File("D://testing.txt"));
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            bwriter.write(sb.toString());
            bwriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void checkIfRealNumberInFile() {

        try {
            String content = new String(readAllBytes(get("D://testing.txt")));
            System.out.println(content);

            Assert.assertTrue(content.matches("(-?)\\d*(\\.)\\d*"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void deleteFile(){
        File file = new File("D://testing.txt");
        file.delete();
    }



}

