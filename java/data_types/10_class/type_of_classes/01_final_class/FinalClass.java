final class Base {
    void Display(){
        System.out.print("Method for base class");
    }
}

class Extended extends Base {
    void Display(){
        System.out.print("Method of Extended class");
    }
}

public class FinalClass {
    public static void main(String[] args){
        Extended d =  new Extended();
        d.Display();
    }
}

// final class → cannot be extended (no inheritance).

// final method → cannot be overridden.

// final variable → cannot be reassigned.