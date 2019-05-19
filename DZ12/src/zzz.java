



import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class zzz {
    public static void main(String[] args) {

        try{
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream("numbers.txt")));
            for(int i = 0; i<20; i++){
                dataOutputStream.writeDouble(Math.random()*20);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException ex){
            System.out.println("some exception");
        }
        ArrayList<Double> numbers = new ArrayList<>();
        try{
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(new FileInputStream("numbers.txt")));

            while (true){
                try{
                    numbers.add(dis.readDouble());
                } catch (IOException e){

                    break;
                }
            }

        } catch (FileNotFoundException e ){
            System.out.println("File not found");
        }
        double sum = 0;
        for (int i = 0; i<numbers.size(); i++){
            BigDecimal num = new BigDecimal(numbers.get(i));
            BigDecimal num2 = num.setScale(4,RoundingMode.HALF_EVEN);
            //num.setScale(4, RoundingMode.HALF_EVEN);
            System.out.println(num2);
            sum+=numbers.get(i);
        }
        BigDecimal sum2 = new BigDecimal(sum);

        System.out.println("Average of numbers is "+sum2.setScale(4, RoundingMode.HALF_EVEN));
    }
}