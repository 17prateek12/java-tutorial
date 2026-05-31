# Constructor

In Java, a constructor is a special method used to initialize objects. It is called automatically when an object of a class is created. Unlike regular methods, constructors have specific characteristics that distinguish them from other methods.

## Characteristic of Constructor
**1. Same name as the class:**
* The constructor must have the same name as the class it belongs to.
```
class Car {
    Car() {
        // constructor body
    }
}
```

**2. No return type:**
* Constructors do not have a return type.
```
Car() {  // Correct
    // ...
}

void Car() {  // Incorrect - this is a method, not a constructor
    // ...
}
```
**3. Automatically called**
* When you use the new keyword to create an object, the constructor is executed.
```
Car myCar = new Car();  // Car() constructor is called here
```

**4. Constructors cannot be static, final, or abstract.**

**5. You can’t call a constructor like a regular method — it is only invoked when an object is created.**

**6. If you define any constructor, the compiler does not create a default one.**


## Constructor vs Method
The below table demonstrates the key difference between Java Constructor and Java Methods.

| Features | Constructor | Method |
|----------|-------------|--------|
| Name     | Constructors must have the same name as the class name | Methods can have any valid name |
| Return Type | Constructors do not return any type | Methods have the return type or void if does not return any value. |
| Invocation | Constructors are called automatically with new keyword | Methods are called explicitly |
| Purpose | Constructors are used to initialize objects | Methods are used to perform operations |

## How new keyword call constructor in java?

**🧠 Step-by-Step: What Happens When You Use new**
Suppose you write this:
```
Car myCar = new Car();
```
Here’s what Java does internally:

### 🔹 1. Memory Allocation
The new keyword tells the Java Virtual Machine (JVM) to allocate memory on the heap for the object.

### 🔹 2. Object Initialization
After allocating memory, Java sets up the default values for instance variables (e.g., int → 0, boolean → false, object references → null).

### 🔹 3. Constructor Call
After setting up memory, the new keyword calls the constructor to initialize the object properly.
<br />
This is done via the bytecode instruction:
```
new        // Allocates memory
invokespecial  // Calls the constructor method <init>
```

**The constructor in bytecode is named <init> — it’s not a regular method but a special method for initialization.**

### 🔹 4. Reference is Returned
The result of the new expression is a reference to the memory location of the object. This is assigned to your variable (myCar in this case).

**🔧 Behind the Scenes (Bytecode Level)**

Let’s take this Java code:

```
Car car = new Car();
```
<br />
Java Compiler turns this into bytecode roughly like this:

```
// Pseudocode-like bytecode
0: new #2       // Create new object of type Car
3: dup          // Duplicate reference on stack
4: invokespecial #3  // Call Car.<init>() constructor
7: astore_1     // Store object reference in variable car
```

* `new` creates the object.
* `dup` duplicates the object reference for use.
* `invokespecial` calls the constructor (`<init>`).
* `astore_1` stores the reference into a local variable.

## Why Do We Need Constructors in Java

Constructors play a very important role, it ensures that an object is properly initialized before use.

What happens when we don't use constructors:

Without constructors:

* Objects might have undefined or default values.
* Extra initialization methods would be required.
* Risk of improper object state

## Why constructor name is same as of class name ?
Constructor name is always same as class name because it iseasy to identify there is no return type because implicitly java adds class as return type.

## Why constructor do not have return type ?
There can be methods with same name and even class as return type but they cannot be called constructors as they do not
obey the rules of constructor in same name without return type.

## Why constructor cannot be final ?
Constructors are different from usual methods I cannot be inherited. So it doesn't make sense to make them final because final is used to prevent overriding and if constructors cannot be inherited then there is no requirement for final.

## Why constructor cannot be abstract?
Since for abstract method, the responsibility of implementation is of child class .But constructors can't even be inherited so no point of making them abstract.

## Why constructor cannot be static ?
Since static methods can only access static variables and other static methods, so it won't be able to initialise the instance variable. We also won't be able to use constructor chaining and call super().

## Types of Constructors in Java
Now is the correct time to discuss the types of the constructor, so primarily there are three types of constructors in Java are mentioned below:

* Default Constructor
* Parameterized Constructor
* Copy Constructor

### 1. Default Constructor in Java
A constructor that has no parameters is known as default constructor.
A default constructor is invisible. And if we write a constructor with no arguments, the compiler does not create a default constructor. 
Once you define a constructor (with or without parameters), the compiler no longer provides the default constructor. Defining a parameterized constructor does not automatically create a no-argument constructor, we must explicitly define if needed. 
The default constructor can be implicit or explicit.

* `Implicit Default Constructor:` If no constructor is defined in a class, the Java compiler automatically provides a default constructor. This constructor doesn’t take any parameters and initializes the object with default values, such as 0 for numbers, null for objects.

* `Explicit Default Constructor:` If we define a constructor that takes no parameters, it's called an explicit default constructor. This constructor replaces the one the compiler would normally create automatically. Once you define any constructor (with or without parameters), the compiler no longer provides the default constructor for you.

### 2. Parameterized Constructor in Java
A constructor that has parameters is known as parameterized constructor. If we want to initialize fields of the class with our own values, then use a parameterized constructor.

### 3. Copy Constructor in Java
Unlike other constructors copy constructor is passed with another object which copies the data available from the passed object to the newly created object.

## 🔄 Constructor Overloading
Java allows multiple constructors in the same class with different parameter lists. This is called constructor overloading.

## `super()`

The `super` keyword in Java is used inside a constructor to call the constructor of the parent (superclass). It plays a crucial role in inheritance, ensuring that the base part of the object is properly initialized before the subclass adds its own behavior.

### 🧭 Purpose of super() in Constructor
When you create an object of a subclass, the constructor of the superclass must run first to initialize inherited properties. This is where super() comes in.

### 🧱 Basic Syntax

```
class Parent {
    Parent() {
        System.out.println("Parent constructor called");
    }
}

class Child extends Parent {
    Child() {
        super(); // Calls Parent's constructor
        System.out.println("Child constructor called");
    }
}
```

Output

```
Parent constructor called
Child constructor called
```

