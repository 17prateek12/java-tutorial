abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    // Abstract method (no body)
    abstract void sound();

    // Concrete method
    void eat() {
        System.out.println(name + " is eating...");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println(name + " says Woof!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println(name + " says Meow!");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");

        dog.eat();
        dog.sound();

        cat.eat();
        cat.sound();
        /*
        Buddy is eating...
        Buddy says Woof!
        Whiskers is eating...
        Whiskers says Meow!
*/
    }
}
