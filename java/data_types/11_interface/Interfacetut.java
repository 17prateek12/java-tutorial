// public class Landanimal{
//     public boolean canBreath(){
//         return true;
//     }
// }


// public class Wateranimal{
//     public boolean canBreath(){
//         return true;
//     }
// }

// public class Crocodile extends Landanimal, Wateranimal{
//     @Override
//     public boolean canBreath(){
//         return true;
//     }
// }

// will give error
// Interfacetut.java:14: error: '{' expected
// public class Crocodile extends Landanimal, Wateranimal{
//                                          ^
// 1 error


interface Landanimal{
    boolean canBreath();
}


interface Wateranimal{
    boolean canBreath();
}

class Crocodile implements Landanimal, Wateranimal{
    @Override
    public boolean canBreath(){
        return true;
    }
}

public class Interfacetut{
    public static void main(String[] args) {
        Crocodile obj = new Crocodile();
        System.out.println(obj.canBreath());
    }
}