package by.pvt.iostream;

import java.io.File;
import java.util.Arrays;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        byte[] bytes = {1,2,3,4,5};
        Example fileExample = new Example();
        fileExample.writeToFile(bytes, "readme.txt");
        fileExample.writeToFile("test".getBytes(), "readme.txt");

        byte[] inputBytes = fileExample.readFromFile("readme.txt");
        System.out.println(new String(inputBytes));
        System.out.println(Arrays.toString(inputBytes));

        fileExample.readStringFromFile(
                "c:" + File.separator +  "java" +
                        File.separator + "coople.xml");
    }
}