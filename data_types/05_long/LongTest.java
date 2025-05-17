public class LongTest {
    public static void main( String[] args){
        long a = 21474839470l;
        long t = -3000000000l;
        System.out.println("Value of a "+ a); // Value of a 21474839470
        System.out.println("Value of t "+ t); // Value of t -3000000000
        System.out.println("Aremethic operation in long  "+ (a+t)); // Aremethic operation in int 18474839470
        System.out.println("Aremethic operation in long "+ (a-t)); // Aremethic operation in int 24474839470
        System.out.println("Aremethic operation in long "+ (a*t)); // Aremethic operation in int -9084286188871345152
        System.out.println("Aremethic operation in long "+ (a/t)); // Aremethic operation in int -7
        System.out.println("Aremethic operation in long "+ a+t); // Aremethic operation in int 21474839470-3000000000
    }
}

