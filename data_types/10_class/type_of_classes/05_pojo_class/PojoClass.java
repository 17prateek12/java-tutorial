class Student{
    private String name;
    private int age;

    //public Student(){} // defualt constructor

    //public Student(String name, int age){
    //    this.name = name;
    //    this.age = age;
    //}

    // Getter for name
    public String getName(){
        return name;
    }

    // Setter for name
    public void setName(String name){
        this.name = name;
    }

    // Getter for age
    public int getAge(){
        return age;
    }

    // Setter for age
    public void setAge(int age){
        this.age = age;
    }
}

public class PojoClass{
    public static void main(String[] args){
        Student s = new Student();
        s.setName("Prateek");
        s.setAge(25);

        System.out.println("Name "+ s.getName());
        System.out.println("Age "+ s.getAge());
    }
}