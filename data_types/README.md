# Data Types

**In Java, data types define the type of data a variable can hold. Java is a strongly typed language, which means every variable must be declared with a data type.**

**Java has two main categories of data types:**
<br />
<br />
**1. Primitive Data Types: These are the basic built-in types used to store simple value**
 <br/>
* Stored on the stack 
* Primitive data types are faster

| Type      | Size    | Example                | Description                                  |
| --------- | ------- | ---------------------- | -------------------------------------------- |
|  byte     | 1 byte  |  byte b = 10;          | Small integer (-128 to 127)                  |
|  short    | 2 bytes |  short s = 2000;       | Medium integer                               |
|  int      | 4 bytes |  int i = 100;          | Standard integer (default for whole numbers) |
|  long     | 8 bytes |  long l = 123456789L;  | Large integer                                |
|  float    | 4 bytes |  float f = 3.14f;      | Decimal (less precision)                     |
|  double   | 8 bytes |  double d = 3.14159;   | Decimal (more precision, default)            |
|  char     | 2 bytes |  char c = 'A';         | Single character (Unicode)                   |
|  boolean  | 1 bit   |  boolean b = true;     |  true  or  false  values                     |

<br />

**2. Non-Primitive (Reference) Data Types: These are not built-in and refer to objects.**
<br/>
* Stored on heap
* Non-primitive data types are slower

| Type       | Example                      | Description                         |
| ---------- | ---------------------------- | ----------------------------------- |
|  String    |  String name = "John";       | A sequence of characters            |
| Arrays     |  int[] nums = {1, 2, 3};     | Collection of elements of same type |
| Classes    |  Student s = new Student();  | Custom object data types            |
| Interfaces |  Runnable r = ...;           | Abstract reference types            |
 

### Why Data Types Matter in Java?

Data types matter in Java because of the following reasons, which are listed below:

* Memory Efficiency: Choosing the right type (byte vs int) saves memory.
* Performance: Proper types reduce runtime errors.
* Code Clarity: Explicit typing makes code more readable.


### Why is the Size of char 2 bytes in Java?
```
Unlike languages such as C or C++ that use the ASCII character set, Java uses the Unicode character set to support internationalization. Unicode requires more than 8 bits to represent a wide range of characters from different languages, including Latin, Greek, Cyrillic, Chinese, Arabic, and more. As a result, Java uses 2 bytes to store a char, ensuring it can represent any Unicode character.
```