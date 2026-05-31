class Outer{
    int outervar = 10;

    class Inner{
        void display(){
            System.out.println("Outer Variable: "+outervar);
        }
    }
}

public class NestedIC{
    public static void main(String[] args){
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display(); // Outer Variable: 10
    }
} 