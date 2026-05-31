class CarModifier {
    public String brand = "DefaultBrand";  // public accessible everywhere
    protected String model = "DefaultModel"; // Protected - accessible in same package or subclass
    String fuelType = "Petrol"; // // Default/package-private - accessible within same package
    private int year = 2000; // Private - only accessible in this class

    public CarModifier(String model, int year){
        this.model = model;
        this.year = year;
    }

    public void showPublic(){
        System.out.println("Public Brand: "+ brand);
    }

    protected void showProtected(){
        System.out.println("Protected Model: "+ model);
    }

    void showDefault(){
        System.out.println("Defualt fuel Type: "+ fuelType);
    }

    private void showPrivate(){
        System.out.println("Private Year: "+year);
    }

    public void showAll(){
        showPublic();
        showProtected();
        showDefault();
        showPrivate();
    }
}

public class AccessModifierClass{
    public static void main(String[] args){
        CarModifier mycar = new CarModifier("Alto", 2006);

        System.out.println("Access Public Brand: "+ mycar.brand); // Access Public Brand: DefaultBrand
        System.out.println("Access Protected Model: "+ mycar.model); // Access Protected Model: Alto
        System.out.println("Access Default Fuel: "+ mycar.fuelType); // Access Default Fuel: Petrol
        // System.out.println("Access Private year: "+mycar.year); // AccessModifierClass.java:43: error: year has private access in CarModifier

        // Accessing method
        mycar.showPublic(); // Public Brand: DefaultBrand
        mycar.showProtected(); // Protected Model: Alto
        // mycar.showPrivate(); // AccessModifierClass.java:48: error: showPrivate() has private access in CarModifier
        mycar.showDefault(); // Defualt fuel Type: Petrol

        mycar.showAll();
        // Public Brand: DefaultBrand
        // Protected Model: Alto
        // Defualt fuel Type: Petrol
        // Private Year: 2006
    }
}