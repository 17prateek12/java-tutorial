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

