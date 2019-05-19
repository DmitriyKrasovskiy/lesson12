package DZ121_30;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DZ121_30 {

    public static void main(String[] args) {

        FileReader myFile = null;
        BufferedReader buff = null;
        int count = 0;
        String line = new String();
        ArrayList<Object> array = new ArrayList<>();
        Pattern pattern = Pattern.compile("[,\\.:(;\\?!)]"); //паттерн знаки препинания

        try {
            myFile = new FileReader("c:/work/lesson12/readme1.txt");
            buff = new BufferedReader(myFile);

            while ((line = buff.readLine()) != null) {

                System.out.println(line);

                char[] m = line.toCharArray();

                for (int i = 0; i < m.length; i++) {
                    array.add(m[i]);
                }
                System.out.println();

                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
                //подсчет знаков препинания
            }


        } // конец цикла while
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(array);
                System.out.println("Знаков препинания в тексте:" + " " + count);

       /* Matcher matcher = pattern.matcher(array);
        while (matcher.find()) {
            count++;*/


        }
       /* catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                buff.close();
                myFile.close();
            }catch(IOException e1){
                e1.printStackTrace();*/
            }



     // конец метода main


