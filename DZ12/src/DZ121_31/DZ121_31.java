package DZ121_31;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class DZ121_31 {


    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        Pattern pattern = Pattern.compile("-?\\d+");
        double sum = 0;
        double sum1 = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/work/lesson12/readme2.txt"));
            while (bufferedReader.ready()) {
                res.append(bufferedReader.readLine());
                res.append('\n');
            }
            System.out.println("Исходный текст:"); //печать исходного файла
            System.out.println(res);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//          выбираем числа, формируем из них массив
            ArrayList<Double> numbers = new ArrayList<>();
            Matcher matcher = pattern.matcher(res);
            while (matcher.find()) {
                numbers.add(Double.parseDouble(matcher.group()));
            }
            System.out.println("Выборка чисел массива:" + " " +numbers);

            for (Double i : numbers) {
                sum += i;
                }
            System.out.println("Сумма чисел массива=" + " " + sum);


//            отсеиваем дублирующие значения при помощи LinkedHashSet
        numbers = new ArrayList<Double>(new LinkedHashSet<Double>(numbers));
        System.out.println("Числовой массив без задвоений:" + " " +numbers);

        for (Double i : numbers) {
            sum1 += i;
        }
        System.out.println("Сумма чисел массива без задвоений=" + " " + sum1);


        }
    }



