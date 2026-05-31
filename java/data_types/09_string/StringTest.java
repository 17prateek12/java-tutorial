public class StringTest {
    public static void main(String[] args){
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "hello";
        String s4 = new String("Hello");
        String s5 = new String(s1);
        System.out.println("Checking memory equality for s1 and s2 "+ (s1==s2)); // true
        System.out.println("Checking memory equality for s1 and s3 "+ (s1==s3)); // false
        System.out.println("This will check value inside memory for s1 and s2 "+ s1.equals(s2)); // true
        System.out.println("This will check value inside memory for s1 and s3 "+ s1.equals(s3)); // false
        System.out.println("This will check value inside memory for s1 and s4 "+ s1.equals(s4)); // true
        System.out.println("Checking memory equality for s1 and s4 "+ (s1==s4)); // false
        System.out.println("Checking memory equality for s1 and s5 "+ (s1==s5)); // false
        System.out.println("This will check value inside memory for s1 and s5 "+ s1.equals(s5)); // true

        //----------------------------------------------------------Check for Mutation

        s1.concat(" World");
        System.out.println("String after concat "+ s1); // String after concat Hello // did not change

        //----------------------------------------------------------correct to mutate
        s1 = s1.concat(" World");
        System.out.println("String after concat new try "+ s1); // String after concat new try Hello World
        System.out.println("Checking memory equality for conact s1 and s2 "+ (s1==s2)); // false

        String s6 = s2.concat(" World");
        System.out.println("String s6 "+ s6); // String s6 Hello World
        System.out.println("String s1 "+ s1); // String s1 Hello World
        System.out.println("Checking memory equality for conact s1 and s6 "+ (s1==s6)); // false
        System.out.println("Checking memory equality for conact s2 and s6 "+ (s2==s6) + " s2 is "+s2+" and s6 "+s6);
        // Checking memory equality for conact s2 and s6 false s2 is Hello and s6 Hello World
        System.out.println("Check value for s1 and s6 "+ s1.equals(s6)); // Check value for s1 and s6 true

        String s7 = "Hello World";
        System.out.println("Memory check for s1 and s7 "+ (s1==s7)); // false
        System.out.println("Memory check for s6 and s7 "+ (s6==s7)); // false
        System.out.println("value check for s1 and s7 "+ s1.equals(s7)); // true
        System.out.println("value check for s6 and s7 "+ s6.equals(s7)); // true
    }
}
