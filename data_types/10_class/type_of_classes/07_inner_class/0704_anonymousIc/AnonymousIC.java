abstract class Animal{
    abstract void sound();
}

public class AnonymousIC{
    public static void main(String[] args){
        Animal a =  new Animal(){
            void sound(){
                System.out.println("Roar");
            }
        };
        a.sound(); // Roar
    }
}