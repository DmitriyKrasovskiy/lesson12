package by.pvt.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 */

class Car implements Serializable {
    private static final long serialVersionUID = 2L;

    String name;
    int price;
    int weight;

    static int year = 2016;
}

public class ExampleSerial {

    public static void main(String[] args) {
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("car.serial"));

            Car car1 = new Car(); //1 option! how to create object instance
            car1.name = "BMW X6";
            car1.price = 150000;
            Car.year = 2016;
            objectOutputStream.writeObject(car1); //serialization
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("car.serial"));
            Object obj = objectInputStream.readObject(); //deserialization
            Car car2 = (Car)obj;
            System.out.println(car2.name + " " + car2.price + " " + car2.year);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}