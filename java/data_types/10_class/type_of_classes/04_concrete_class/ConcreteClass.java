abstract class Animal{
    abstract void sound();
}

class Dog extends Animal{
    @Override
    void sound(){
        System.out.print("Dog barks");
    }
}

public class ConcreteClass{
    public static void main(String[] args){
        Dog myDog = new Dog();
        myDog.sound(); 
    }
}