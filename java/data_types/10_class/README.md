# Class

### A Class is a user-defined blueprint or prototype from which objects are created. It represents the set of properties or methods that are common to all objects of one type. In general, class declarations can include these components, in order:

* Modifiers : A class can be public or has default access.

* Class name: The name should begin with an initial letter (capitalized by convention).

* Superclass(if any): The name of the class’s parent (superclass), if any, preceded by the keyword extends. A class can only extend (subclass) one parent.

* Interfaces(if any): A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword implements. A class can implement more than one interface.

* Body: The class body is surrounded by braces, { }.

## Basic Syntax
```
class ClassName {
    // Fields (Attributes)
    dataType fieldName;

    // Constructor
    ClassName() {
        // initialization
    }

    // Methods (Behaviors)
    returnType methodName() {
        // logic
    }
}

```

## Key Components of a Class

| Component          | Description                                                                                 |
| ------------------ | ------------------------------------------------------------------------------------------- |
| **Fields**         | Variables that hold the state/data of the object.                                           |
| **Methods**        | Functions that define the behavior of the object.                                           |
| **Constructor**    | A special method used to initialize objects.                                                |
| **`this` keyword** | Refers to the current object. Useful for distinguishing instance variables from parameters. |


## Access Modifiers

| Modifier    | Access Level                                 |
| ----------- | -------------------------------------------- |
| `public`    | Accessible everywhere                        |
| `private`   | Accessible only within the class             |
| `protected` | Accessible in the same package or subclasses |
| (default)   | Accessible in the same package only          |


## Types of Classes

| Type                    | Description                                                 |
| ----------------------- | ----------------------------------------------------------- |
| **Concrete class**      | A regular class that can be instantiated                    |
| **Abstract class**      | Cannot be instantiated. Used for inheritance                |
| **Final class**         | Cannot be extended/inherited                                |
| **Static nested class** | A class defined inside another class, with `static` keyword |
| **Inner class**         | Class inside another class, without `static`                |



## DeepCopy vs ShallowCopy in Class

### Shallow Copy : A shallow copy is a copy of an object where the new object is created, but it shares references to the same inner (non-primitive) objects as the original. Changes to those shared objects will affect both the original and the copy.

#### 📌 In Java, shallow copying copies:
* Primitive types (e.g., int, float) by value
* Reference types (e.g., objects, arrays) by reference

### Deep Copy : A deep copy is a copy of an object where the new object is created, along with copies of all objects it references. This means the original and the copy are completely independent, and changes in one do not affect the other.

#### 📌 In Java, deep copying:
* Recursively copies all nested objects
* Ensures full independence between original and copy

## How to implement shallow copy?

#### ✅ Method 1: By Assignment Operator `=`
For eg in ShallowCopyClass.java 
```
Car secondCar = mycar;
```
this how we do shallow copy

#### ✅ Method 2: Copy constructor with deepCopy
Another method of doing shallow is by copy constructor by copying variable reference rather than copying value.
```
class One {
    int n;

    One(int n) {
        this.n = n;
    }
}

class Two {
    One o;

    Two(One o) {
        this.o = o;
    }

    Two(Two other) {
        this.o = other.o;
    }

    void display() {
        System.out.println("Print value " + o.n);
    }
}

public class Main {
    public static void main(String[] args) {
        One obj1 = new One(42);
        Two obj2 = new Two(obj1);
        obj2.o.n = 23;
        Two obj3 = new Two(obj2);

        obj2.display(); 
        obj3.display(); 
    }
}
```
Output
```
Print value 23
Print value 23
```
<br />
In ShallowCopyClass.java 

```
Car(Car other) {
    this.model = other.model;       // Shallow copy of a String (safe because String is immutable)
    this.year = other.year;         // Copy of primitive value (int)
    this.engine = other.engine;     // Shallow copy of an object (reference is shared!)
}
```

* so `thirdCar.year = 2025;` only changes that object's copy

* Strings in Java are immutable.

* Even though you’re copying the reference (shallow), the string itself cannot be changed.

* If you do so,
```
thirdCar.model = "Maruti";
```
it just assigns a new string reference to thirdCar.model, not the original mycar.model.

<br />
<br />

#### Why engine changes affect all?

```
this.engine = other.engine;
```
You're copying the reference to a mutable object (Engine).

All Car instances point to the same Engine object, so:

* thirdCar.engine.horsepower = 200;

* fourthCar.engine.owner = "Mansi";


These affect everyone using that engine.

<br />

🧪 Real-World Analogy
Think of:
* year as a personal birth year written on a sticky note. You copy the note.
* model as a label. You copy the label.
* engine as a shared engine on display. Everyone's car points to the same physical engine.
So if someone modifies the shared engine, all cars are affected. But changing a label or a sticky note only affects the car it’s stuck on.



<br />

| Field    | Type      | Copied As | Affects Others?  | Why?                            |
| -------- | --------- | --------- | ---------------- | ------------------------------- |
| `model`  | String    | Reference | ❌ No            | String is immutable; reassigned |
| `year`   | Primitive | Value     | ❌ No            | Independent value copy          |
| `engine` | Object    | Reference | ✅ Yes           | Shared mutable object           |


## How to implement Deep copy?

Command to run DeepCopyClass.java
```
javac -cp ".;commons-lang3-3.17.0.jar" DeepCopyClass.java
java -cp ".;commons-lang3-3.17.0.jar" DeepCopyClass
```

#### ✅ Method 1: Custom Deep Copy Method
```
Car deepCopy() {
    return new Car(this.model, this.year, new Engine(engine.horsepower, engine.owner));
}
```
✔️ Advantages:
* Fast and efficient (no serialization overhead).
* No dependencies.
* You control exactly how the deep copy is done.

❌ Disadvantages:
* Manual work: Must update the method if fields change.
* Error-prone in large or nested object graphs.
* Can’t be generalized easily for reuse.

#### ✅ Method 2: Copy Constructor
```
Car(Car other) {
    this.model = other.model;
    this.year = other.year;
    this.engine = new Engine(other.engine);
}
```
✔️ Advantages:
* Object-oriented and clean.
* Easy to read and maintain.
* Enables constructor chaining and safe instantiation.

❌ Disadvantages:
* Requires all inner classes (like Engine) to also have copy constructors.
* Becomes cumbersome for deeply nested objects.
* No generic solution—must write for each class.


#### ✅ Method 3: Using Cloneable Interface
```
CarTwo implements Cloneable
```
✔️ Advantages:
* Standard Java mechanism for object copying.
* Can support cloning in inheritance.

❌ Disadvantages:
* Cloneable is considered flawed and outdated.
* Must override clone() and manually deep copy references.
* super.clone() performs shallow copy, so it’s easy to make mistakes.
* Not recommended for new codebases.

#### ✅ Method 4: Using Apache Commons SerializationUtils.clone()
```
SerializationUtils.clone(myObject);
```
✔️ Advantages:
* One-liner deep copy.
* Automatically handles deep copying via serialization.
* Very easy to use.

❌ Disadvantages:
* Requires external library (org.apache.commons.lang3).
* All involved classes must implement Serializable.
* Slower due to serialization overhead.
* Not suitable for high-performance use cases.

#### ✅ Method 5: Manual Java Serialization for Deep Copy
```
deepCopy(obj)
```
✔️ Advantages:
* No third-party library needed.
* Generic utility that works on any Serializable object.
* Completely decouples from implementation structure.

❌ Disadvantages:
* Verbose code.
* All classes must be serializable.
* Performance hit due to I/O streams (even in memory).
* Fails silently if not careful with exception handling.


| Method                          | External Library | Recursively Deep?  | Performance | Good For                    |
| ------------------------------- | ---------------- | ------------------ | ----------- | --------------------------- |
| 1. Custom Method                | ❌                | ✅ (if implemented) | ✅ Very Fast | Simple objects              |
| 2. Copy Constructor             | ❌                | ✅                  | ✅ Very Fast | Object-oriented design      |
| 3. `Cloneable`                  | ❌                | ✅ (if done right)  | ⚠️ Risky    | Legacy systems, rarely used |
| 4. `SerializationUtils.clone()` | ✅ Apache Commons | ✅                  | ❌ Slower    | Quick prototyping           |
| 5. Java Serialization           | ❌                | ✅                  | ❌ Slower    | No extra libraries needed   |


## Access Modifier

In Java, access modifiers define the visibility or accessibility of classes, methods, and variables from different parts of your code. Here's a detailed breakdown:

#### 1. `public`
* Accessible from everywhere — any other class in any package.
<br/>

**Use Case:** When you want something to be universally available.
```
┌──────────────┐
│  Class A     │  <-- public member
└──────────────┘
      ↓ Accessible
┌──────────────┐
│  Any Class   │ (any package)
└──────────────┘
```
```
public class MyClass {
    public int x; // accessible everywhere
}

```


#### 2. `protected`
* Accessible within the same package.
* Also accessible in subclasses, even if they are in different packages.


<br />

**Use Case:** When extending a class across packages but want to hide from the rest of the world.
```
mypackage:
┌──────────────┐
│  Class A     │
│ protected x  │
└──────────────┘
      ↓ Same package ✅
┌──────────────┐
│  Class B     │
└──────────────┘

otherpackage:
┌──────────────┐
│ Subclass C   │ extends A ✅
└──────────────┘

Non-subclass in another package ❌
```
```
class Parent {
    protected int value;
}

class Child extends Parent {
    void show() {
        System.out.println(value); // valid
    }
}
```

#### 3. `default` (no modifier)
* Accessible only within the same package.
* Not accessible outside the package.

<br />

**Use Case:** When the class or method is internal to the package and not part of public API.
```
mypackage:
┌──────────────┐
│  Class A     │
│  default int │
└──────────────┘
      ↓
┌──────────────┐
│  Class B     │ (same package) ✅
└──────────────┘

otherpackage:
┌──────────────┐
│  Class C     │ (different package) ❌
└──────────────┘
```
```
class MyClass { // default access
    int x; // default access
}
```

#### 4. `private`
* Accessible only within the class it is declared in.
* Not visible to subclasses or other classes, even in the same package.

<br />

**Use Case:** For encapsulation, hiding internal details of the class.
```
┌──────────────┐
│  Class A     │
│  ┌────────┐  │
│  │ private │  <-- Only accessible inside A
│  └────────┘  │
└──────────────┘
```

```
public class MyClass {
    private int secret;

    public void setSecret(int s) {
        secret = s; // allowed
    }
}
```
<br />

### 🏛️ Access Modifiers and Class Level
| Modifier    | Top-Level Classes | Inner Classes | Methods/Fields |
| ----------- | ----------------- | ------------- | -------------- |
| `public`    | ✅ Yes             | ✅ Yes         | ✅ Yes          |
| `protected` | ❌ No              | ✅ Yes         | ✅ Yes          |
| *default*   | ✅ Yes             | ✅ Yes         | ✅ Yes          |
| `private`   | ❌ No              | ✅ Yes         | ✅ Yes          |

<br />

### 🧩 Summary Table of Accessibility
| Access Level | Same Class | Same Package | Subclass (Different Package) | Other Packages |
| ------------ | ---------- | ------------ | ---------------------------- | -------------- |
| `public`     | ✅          | ✅            | ✅                            | ✅              |
| `protected`  | ✅          | ✅            | ✅                            | ❌              |
| *default*    | ✅          | ✅            | ❌                            | ❌              |
| `private`    | ✅          | ❌            | ❌                            | ❌              |


## Type of classes

#### 1. Final Class

* When a variable, function, or class is declared final, its value persists throughout the program.
* Declaring a method with the final keyword indicates that the method cannot be overridden by subclasses. That is a class that is marked final cannot be subclasses.
* This is very useful when creating immutable classes such as  String classes.
* A class cannot be mutated unless it is declared final.  If only all the members of the class is final then it can't be mutated otherwise it can be mutated

#### 2. Static Class

Static is a Java word that explains how objects are kept in memory. A static object belongs to that class rather than instances of that class. The primary function of the class is to provide blueprints for the inherited classes. A static class has only static members. An object cannot be created for a static class.

* In Java, the term static class typically refers to a static nested class, because only nested classes can be declared static.

##### 🔹 What is a Static Class?
In Java:
* Top-level classes (non-nested) cannot be declared static.
* Nested classes (defined inside another class) can be declared sta tic.


#### 3. Abstract Class
In Java, an abstract class is a class that cannot be instantiated on its own and is meant to be inherited by other classes. It can have abstract methods (methods without a body) as well as concrete methods (with body). It's used to define a base class with shared behavior and to enforce implementation in derived classes.

##### 🔷 Key Points:

* Use `abstract` keyword.
* Can have both abstract and non-abstract methods.
* Cannot be instantiated.
* Subclasses must implement all abstract methods unless the subclass is also abstract.

```
         Animal (abstract)
         /          \
     Dog           Cat
```

##### ✅ Use Cases of Abstract Classes:
* Define a base class for a family of related types.
* When you want to provide partial implementation of functionality.
* When multiple derived classes must override certain behavior.

#### 4. Concrete Class
A concrete class is a regular class in Java that provides complete implementation for all its methods. Unlike abstract classes, a concrete class can be instantiated directly.

✅ Key Features of Concrete Class:
* Not marked with the abstract keyword.
* Implements all methods (no abstract methods).
* Can be used to create objects.
* Can extend abstract classes or implement interfaces, but must provide full method implementations.

#### 5. POJO Class
POJO stands for Plain Old Java Object. It's a simple Java class used to represent data. A POJO class does not extend or implement any specialized classes/interfaces (like Serializable, Remote, etc. – unless explicitly needed), and it mainly focuses on encapsulating data with getters and setters.


✅ Key Characteristics of a POJO

| Feature          | Description                                                                          |
| ---------------- | ------------------------------------------------------------------------------------ |
| Simplicity       | No business logic, just fields and methods                                           |
| No inheritance   | Doesn’t extend any class or implement interfaces (except if needed)                  |
| Private fields   | All variables are usually `private`                                                  |
| Public accessors | Uses `getters` and `setters` for field access                                        |
| No annotations   | Should not depend on frameworks or annotations (unless converted to JavaBeans, etc.) |


🧠 Why Use POJOs?
* Clean structure for data modeling
* Easier to test
* Easily serializable (with frameworks like Jackson, Gson)
* Used widely in REST APIs, ORM tools like Hibernate, etc.


#### 6. Singleton class

A singleton class is one that has just one object at any one moment. Even yet, if we try to create an instance again, the newly created instance refers to the previous one. Any modification we make to the class through any instance impacts the variables in that specific instance as well.
<br />
<br />
It's useful when exactly one object is needed to coordinate actions across a system — like for logging, database access, config settings, etc.

✅ Key Characteristics
* Private constructor: To prevent external instantiation.
* Private static instance: Holds the single object.
* Public static method: Returns the instance.


#### 6. Inner class

An inner class is a class defined within another class. It helps logically group classes that are only used in one place, increases encapsulation, and can lead to more readable and maintainable code.

🔸 Types of Inner Classes in Java.
<br />
Java supports 4 main types of inner classes:

* Non-static Inner Class
* Static Nested Class
* Local Inner Class
* Anonymous Inner Class

##### 🧩 6.1 Non-static Inner Class/Nested Inner Class

* Belongs to an instance of the outer class.
* Can access all members (including private) of the outer class.

##### 🧩 6.2. Static Nested Class
* Declared with static keyword.
* Can access only static members of the outer class.
* Does not require an outer class instance.

##### 🧩 6.3. Local Inner Class
* Defined inside a method.
* Scope is limited to the method.
* Can access final or effectively final variables of the method.

##### 🧩 6.4. Anonymous Inner Class
* A class without a name.
* Used for instantiating interface or abstract class on the spot.
* Common in GUI programming and event handling.



```
+------------------+
|     Outer Class  |
|                  |
| +--------------+ |
| | Inner Class  | |  ← Non-static Inner Class
| +--------------+ |
|                  |
| +--------------+ |
| | static class | |  ← Static Nested Class
| +--------------+ |
|                  |
| +--------------+ |
| | void method()| |
| |  {           | |
| |   class LI   | |  ← Local Inner Class
| |  }           | |
| +--------------+ |
|                  |
| Interface/Abstract|
| Class Reference → |
|  new Class() {   |  ← Anonymous Inner Class
|     ...          |
|  }               |
+------------------+

```