class Calculator{
    int add(int a, int b){
        return a + b;
    }

    int subtract(int a, int b){
        return a -b;
    }
}

public class CalConcreteExample{
    public static void main(String[] args){
        Calculator calc = new Calculator();
        System.out.println("ADD : "+ calc.add(5,3));
        System.out.println("SUBTRACT : "+ calc.subtract(5,3));
    }
}