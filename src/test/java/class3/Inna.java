package class3;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by c2611 on 11.02.2015.
 */
public class Inna {

    public static void main(String[] args) {
        BufferedReader br = null;
        String string = "test";

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("D:\\testing.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

            Assert.assertEquals(string, br.toString().equals(sCurrentLine));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
