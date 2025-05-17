class Engine{
    int horsepower;
    String owner;

    Engine(int horsepower, String owner){
        this.horsepower = horsepower;
        this.owner = owner;
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
    
    Car(Car other){
        this.model = other.model;
        this.year = other.year;
        this.engine = other.engine;
    }

    void display(){
        System.out.println("Model: "+model + " Year release: " + year+ " -Engine HP: "+engine.horsepower+" Owned by "+engine.owner);
    }
}


public class ShallowCopyClass {
        public static void main(String[] args){
        Engine engine1 = new Engine(120,"Prateek");
        Car mycar = new Car("Alto",2006,engine1);
        
        //----------------------------------Shallow Copy through Assignment operator =
        Car secondCar = mycar; 
        secondCar.year = 2025;
        secondCar.engine.owner = "Yashu";


        //---------------------------------Shallow Copy of original through Copy Constructor
        Car thirdCar = new Car(mycar);
        thirdCar.engine.horsepower = 200;
        thirdCar.model = "Maruti";
        thirdCar.engine.owner = "Mansi";


        //----------------------------------Shallow copy of second car through copy contructor
        Car fourthCar = new Car(secondCar);
        fourthCar.model = "Tayota"; 
        fourthCar.engine.horsepower = 400;
        fourthCar.year = 2040;


        System.out.print("First object created ");
        mycar.display();
        // First object created Model: Alto Year release: 2025 -Engine HP: 400 Owned by Mansi

        System.out.print("Shallow copy of first object ");
        secondCar.display();
        // Shallow copy of first object Model: Alto Year release: 2025 -Engine HP: 400 Owned by Mansi

        System.out.print("Shallow Copy of original through constructor ");
        thirdCar.display();
        // Shallow Copy of original through constructor Model: Maruti Year release: 2025 -Engine HP: 400 Owned by Mansi

        System.out.print("Shallow Copy of second through constructor ");
        fourthCar.display();
        // Shallow Copy of second through constructor Model: Tayota Year release: 2040 -Engine HP: 400 Owned by Mansi
       
    }
}