package DZ121_32;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.io.EOFException;


public class DZ121_32 {

    public static void main(String[] args) {

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("numbers.txt")));
        for(int i = 0; i<20; i++){
            dataOutputStream.writeDouble(Math.random()*20);
        }
        dataOutputStream.flush();
        dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Double> binarynumbers = new ArrayList<>();
        try {
            DataInputStream dataInputStream = new DataInputStream(
                    new BufferedInputStream(new FileInputStream("binarynumbers.txt")));

            while (true) {
                try {
                    binarynumbers.add(dataInputStream.readDouble());
                } catch (EOFException e) {
                    System.out.println("afqk yt yfqlty");
               //    e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double midar = 0;
        double sum = 0;
            for (int i = 0; i < binarynumbers.size(); i++) {
                BigDecimal num = new BigDecimal(binarynumbers.get(i));
                BigDecimal num2 = num.setScale(2, RoundingMode.HALF_EVEN);
                System.out.println(num2);
                sum += binarynumbers.get(i);
                midar = sum/binarynumbers.size();
            }
            BigDecimal sum2 = new BigDecimal(midar);

            System.out.println("Среднее арифметическое=" + " " + sum2.setScale(2, RoundingMode.HALF_EVEN));
        }
    }


