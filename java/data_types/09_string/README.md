# String

* String cannot be in single quote, always should be in double quote
<br />

* First s1 initialize Hello, and it will go to string pool in heap memory, and got some memory, now when s2 got initalize, string s2 
will check for Hello in string pool and if its present then s1 and s2 will refer to the same memory, otherwise different memory like
s1 and s3 because both hello and Hello are different.
<br />

* new keyword allocate new memory
<br />

* Strings are defined as an array of characters. The difference between a character array and a string in Java is, that the string
is designed to hold a sequence of characters in a single variable whereas, a character array is a collection of separate char-type
entities.
<br />

* String in java are immutable
<br />

* concat always return new object that's why s1 and s6 even have same value but have different 