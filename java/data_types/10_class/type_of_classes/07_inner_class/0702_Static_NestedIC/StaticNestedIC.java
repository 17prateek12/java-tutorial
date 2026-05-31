class Outer{
    static int staticVar = 20;
    static class Inner{
        void show(){
            System.out.println("Static Variable: "+ staticVar);
        }
    }  
}

public class StaticNestedIC{
    public static void main(String[] args){
        Outer.Inner inner = new Outer.Inner();
        inner.show(); // Static Variable: 20
    }
}