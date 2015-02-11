package class3;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by c2611 on 11.02.2015.
 */


public class Test1 {

    @Test
    public void someMethod(){
    }

    @Test
    public void readWordInFile(){

        BufferedReader br = null;
        String string = "test";
        //File file = new File(args[0]);

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("D:\\testing.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine = br.toString();
                System.out.println(sCurrentLine);
            }

           // String content = new Scanner(file).useDelimiter("\\Z").next();

            Assert.assertEquals(string, sCurrentLine);

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
