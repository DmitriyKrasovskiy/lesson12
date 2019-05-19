package by.pvt.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("car.serial"));
            Object obj = objectInputStream.readObject(); //deserialization
            Car car2 = (Car)obj; //2 option how create object instance
            System.out.println(car2 + ":" +
                    car2.name + " " + car2.price + " " + car2.year);

            Class aClass = Class.forName("by.pvt.serial.Car");
            Car car3 = (Car)aClass.newInstance(); //3 option how create object
            System.out.println(car3 + ":"
                    + car3.name + " " + car3.price + " " + car3.year);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}