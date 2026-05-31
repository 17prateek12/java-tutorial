class Car {
    String model;
    int year;

    Car(String model, int year){
        this.model = model;
        this.year = year;
    }

    void display(){
        System.out.println(model + " " + year);
    }
}

public class ClassTest{
    public static void main(String[] args){
        Car mycar = new Car("Alto",2006);
        Car newCar = new Car("Tayota",2020);
        
        System.out.print("First object created ");
        mycar.display();
        System.out.print("Second new object created");
        newCar.display();
    }
}