class Outer{
    void outerMethod(){
        int number = 5;

        class LocalInner{
            void print(){
                System.out.println("Number: "+ number);
            }
        }

        LocalInner li = new LocalInner();
        li.print();
    }
}

public class LocalIC{
    public static void main(String[] args){
        new Outer().outerMethod(); // Number: 5
    }
}