import org.apache.commons.lang3.SerializationUtils;
import java.io.Serializable;
import java.io.*;

class Engine {
    int horsepower;
    String owner;

    Engine(int horsepower, String owner) {
        this.horsepower = horsepower;
        this.owner = owner;
    }

    // Copy constructor
    Engine(Engine other) {
        this.horsepower = other.horsepower;
        this.owner = other.owner;
    }
}


class Car {
    String model;
    int year;
    Engine engine;

    Car(String model, int year, Engine engine){
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    // Method 1: Deep Copy using a custom method
    Car deepCopy(){
        return new Car(this.model, this.year, new Engine(engine.horsepower, engine.owner));
    }

    // Method 2: Deep Copy using copy constructor
     Car(Car other){
        this.model = other.model;
        this.year = other.year;
        this.engine = new Engine(other.engine);
    } 

    void display(){
        System.out.println(model + " " + year + " " + engine.horsepower + " " + engine.owner);
    }
}

// Method 3: Deep copy using cloneable
class CarTwo implements Cloneable{
    Engine engine;
    String model;
    int year;

    CarTwo(String model, int year, Engine engine){
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public CarTwo clone(){
        try{
            CarTwo cloned = (CarTwo) super.clone();
            cloned.engine = new Engine(engine.horsepower, engine.owner);
            return cloned;
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    void display(){
        System.out.println(model + " " + year + " " + engine.horsepower + " " + engine.owner);
    }
}

 // Method 4: Using Apache Commons SerializationUtils
class EngineSerializer implements Serializable {
    int horsepower;
    String owner;

    EngineSerializer(int horsepower, String owner) {
        this.horsepower = horsepower;
        this.owner = owner;
    }
}

class CarSerializer implements Serializable {
    String model;
    int year;
    EngineSerializer engine;

    CarSerializer(String model, int year, EngineSerializer engine){
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    void display(){
        System.out.println(model + " " + year + " " + engine.horsepower + " " + engine.owner);
    }
}

// Method 5 : Using Java Serialization
class DeepCopyUtil {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepCopy(T obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(obj);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            return (T) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class DeepCopyClass{
    public static void main(String[] args){
        Engine engine = new Engine(120, "Prateek");
        Car mycar = new Car("Alto",2006, engine);

        // Method 1: Deep Copy using a custom method
        Car copiedCar = mycar.deepCopy();
        copiedCar.model = "Toyota";
        copiedCar.year = 2024;
        copiedCar.engine.owner = "Mansi";

        // Method 2: Deep Copy using copy constructor
        Car thirdCarCopied = new Car(mycar);
        thirdCarCopied.year = 2030;
        thirdCarCopied.engine.horsepower = 200;


        System.out.print("Original Object "); // Original Object Alto 2006
        mycar.display();

        System.out.print("Copied object "); // Copied object Toyota 2024 
        copiedCar.display();

        System.out.print("Third object using copy constructor "); // Third object using copy constructor Alto 2030 200 Prateek
        thirdCarCopied.display();

        CarTwo newCar = new CarTwo("Alto",2006, engine);
        System.out.print("Print new car ");
        newCar.display();

        // Method 3: Deep copy using cloneable
        CarTwo newCarCopied = newCar.clone();
        newCarCopied.year = 2040;
        newCarCopied.engine.horsepower = 300;
        System.out.print("Print new Copied Car "); // Print new Copied Car Alto 2040 300 Prateek
        newCarCopied.display();

        // Method 4: Using Apache Commons SerializationUtils
        EngineSerializer engineser = new EngineSerializer(120, "Prateek");
        CarSerializer mycarserial = new CarSerializer("Alto",2006, engineser);
        System.out.print("Print Serialized original car "); // Print Serialized original car Alto 2006 120 Prateek
        mycarserial.display();

        CarSerializer apacheCopied = SerializationUtils.clone(mycarserial);
        apacheCopied.year = 2050;
        apacheCopied.engine.owner = "Pulkit";
        System.out.print("Print Copied car using Apache SerializationUtils ");  // Print Copied car using Apache SerializationUtils Alto 2050 120 Pulkit
        apacheCopied.display();


        // Method 5 : Using Java Serialization
        CarSerializer serialCopied = DeepCopyUtil.deepCopy(mycarserial);
        serialCopied.engine.horsepower = 1200;
        serialCopied.year = 2010;
        System.out.print("Print Copied object using Java Seriliazation "); // Print Copied object using Java Seriliazation Alto 2010 1200 Prateek
        serialCopied.display();


    }
}