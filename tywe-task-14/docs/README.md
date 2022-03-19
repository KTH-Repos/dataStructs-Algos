If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

## Answers to Task 14

### Task 1 - Inheritance
Exercise 9.11 (11.11)

Assume that you see the following lines of code:

```java
Device dev = new Printer();
dev.getName();
```

Printer is a subclass of Device. Which of these classes must have 
a definition of method getName for this code to compile?

Answer: The Device class must have a definition of method getName in 
its source code because type checking looks at the static type during
compilation time. 

Exercise 9.12 (11.12)

In the same situation as in the previous exercise, if both classes have 
an implementation of getName, which one will be executed?

Answer: The method in Printer will be executed becasue during runtime method
lookup starts in the dynamic class of the instance.

Exercise 9.13 (11.13)

Assume that you write a class Student that does not have a declared superclass. 
You do not write a toString method. Consider the following lines of code:

```java
Student st = new Student();
String s = st.toString();
```

Will these lines compile? If so, what exactly will happen when you try to execute?

Answer: Every object in java is a subclass of Object. The way toString()
is implemented in Object is that it extracts a string representation of 
the object, in thise case st. So when the second line is executed the variable
s will hold a string consisting of the name of the class(in this case,student)
the character @, and the hexadecimal representation of the hash code of
the object which shows where the object is located in the memory. 

Exercise 9.14 (11.14)

In the same situation as before (class Student, no toString method), will the 
following lines compile? Why?

```java
Student st = new Student();
System.out.println(st);
```

Answer: Yeah it will compile. The Student class is a subclass of the Object class with 
a toString method defined. So the compiler will not complain. 

Exercise 9.15 (11.15)

Assume that your class Student overrides toString so that it returns the student's name. 
You now have a list of students. Will the following code compile? If not, why not? If yes, 
what will it print? Explain in detail what happens.

```java
for (Object st : myList) {
    System.out.println(st);
}
```

Answer: Yes the code will compile. But this time the subclass overrides the toString method
in the Object class. When the second line is executed method lookup will first check the subclass
if it has an overriden toString method in its source code, which in this case the Student class
has such method. So the the second line will proceed to print out the name of each and every student
in the list. 

Exercise 9.16 (11.16)

Write a few lines of code that result in a situation where a variable x has the static type T and the 
dynamic type D.

Answer: If we assume D is a subclass of T, then we can write the following:
```java
T x = new D();
```

### Task 2 - LinkedList

2, Calculate the asymptotic worst-case-time for all public methods in your implementation. Express the time 
as a function of the number of elements n in the list.

get(), toString(), size() has a time complexity of O(n) because they all depend on the 
number of elements in the list.

The rest has a time complexity of O(1) because they don't depend on the number of elements
in the list.


