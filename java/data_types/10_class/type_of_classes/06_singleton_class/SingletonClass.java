//// Lazy Initialization
//class Singleton{
//     // Step 1: Create a private static variable to hold the one instance
//     private static Singleton single_instance;
//
//     // Step 2: Make the Constructor private to prevent instantiation
//     private Singleton(){
//        System.out.println("Singleton instance created.");
//     }
//
//     // Step 3: Provide a public static method to get the instance
//     public static Singleton getInstance(){
//        if(single_instance==null){
//            single_instance = new Singleton(); // create if does not exist
//        }
//        return single_instance;
//     }
//
//     public void showMessage(){
//        System.out.println("Hello from Singleton!");
//     }
//}


//// Thread-Safe Singleton (Synchronized Method)
//class Singleton {
//    private static Singleton instance;
//
//    private Singleton() {}
//
//    public static synchronized Singleton getInstance() {
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }
//
//    public void showMessage(){
//        System.out.println("Hello from Singleton!");
//     }
//}



//  Double-Checked Locking (Recommended for Lazy + Thread-safe)
//class Singleton {
//    private static volatile Singleton instance;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null)
//                    instance = new Singleton();
//            }
//        }
//        return instance;
//    }
//
//    public void showMessage(){
//       System.out.println("Hello from Singleton!");
//    }
//}


// Eager Initialization
/* class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    public void showMessage(){
       System.out.println("Hello from Singleton!");
    }
} */


// Static Block Initialization
/* class Singleton {
    private static final Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

     public void showMessage(){
       System.out.println("Hello from Singleton!");
    }
} */


// Bill Pugh Singleton (Best Recommended)
/* class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

      public void showMessage(){
       System.out.println("Hello from Singleton!");
    }
} */

// Enum Singleton (Best for Serialization + Reflection Protection)
enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something...");
    }

     public void showMessage(){
       System.out.println("Hello from Singleton!");
    }
}


public class SingletonClass{
    public static void main(String[] args){
       // Singleton s1 = Singleton.getInstance();
       // Singleton s2 = Singleton.getInstance();

       Singleton s1 = Singleton.INSTANCE;
       Singleton s2 = Singleton.INSTANCE;

       s1.doSomething(); // Doing something...
       s2.showMessage(); // Hello from Singleton!
        
        
    //s1.showMessage(); // Hello from Singleton!

        System.out.println("Are both instance the same? "+ (s1==s2)); // Are both instance the same? true
    }
}