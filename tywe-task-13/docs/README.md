If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

### Answers for task 13
Exercise Inh.1

a. Which of the following assignments are legal, and why or why not?

```java 
Person p1 = new Student(); 
```
This is a legal assignment because Student is a subclass of person. 

```java
Person p2 = new PhDStudent();
```
This is a legal assignment because phDStudent is a subclass of student which
in its turn is a subclass of person.

```java
PhDStudent phd1 = new Student();
```
This is not a legal assignment because phDStudent is a subclass of student. So
a Student object cannot be assigned to a phDStudent variable.

```java
Teacher t1 = new Person();
```
This is not a legal assignment because Teacher is a subclass of Person.
So a Person object cannot be assigned to a Teacher variable. 

```java
Student s1 = new PhDStudent();
```
This is a legal assignment because phDStudent is a subclass of Student. 

b. Suppose that we have the following legal declarations and assignments:

```java
Person p1 = new Person();

Person p2 = new Person();

PhDStudent phd1 = new PhDStudent();

Teacher t1 = new Teacher();

Student s1 = new Student();
```

Based on those just mentioned, which of the following assignments are legal, and why or why not?

```java
s1 = p1;
```
This is not a legal assignment because s1 is an object of Student
which is a subclass of Person. So an object of Person cannot be assigned
to a student variable. 

```java
s1 = p2;
```
This is not a legal assignment because s2 is an object of Student
which is a subclass of Person. So an object of Person cannot be assigned
to a Student variable. 

```java
p1 = s1;
```
This is a legal assignment because s1 is an object of Student which is
a subclass of Person.

```java
t1 = s1;
```
This is not a legal assignment because t1 and s1 are objects of two different classes
that have no relation to each other at all. 

```java
s1 = phd1;
```
This is a legal assignment because phd1 is an object of phDStudent which
is a sublcass of student.

```java
phd1 = s1;
```
This is not a legal assignment because phd1 is an object of phDStudent which is
a subclass of student. So an object of student cannot be assigned to a phDStudent
variable. 

Exercise Inh.3

1, What behaviour happens if you removed the extends Post from the class definition 
of EventPost then call NewsFeed.addPost? Explain why you think this happens.

Answer: The EventPost object cannot be passed into NewsFeed.addPost() because that method
can only take in object types of Post, which in this case doesn't work because we have 
removed the inheritance relationship between Post and EventPost. So the EventPost object is
incompatible. 

2, What behaviour happens if you removed super() from the constructor of EventPost 
then call NewsFeed.show? Explain why you think this happens.

Answer: Because the constrctor for the superclass takes in a parameter the compiler issues an
error when super() is removed in the constructor for EventPost. Normally removing super() would work
as long as the there are no parameters. But because the compiler cannot guess what parameter values
should be passed remvoing super() doesn't work in this case. 

3, What behaviour happens if you removed super.display() from the display methods 
EventPost? then call NewsFeed.show? Explain why you think this happens.

Answer: Only the display() of EventPost prints on the screen. The author, time and comments
is not printed because super.displa() is not implemented in NewsFeed.show(). This works because EventPost
is a subclass of Post and can be accessed in NewsFeed.show() which calls in its turn the post.display().

4, When we have two classes with an inheritance relationship and they have a method 
with the same signature, what is this called?
Answer: Overriding. 

Exercise Ind.2

Argument for correctness using loop invariant and time complexity of expIterative

Loop Invariant: Before the kth iteration of the loop, the variable res contains the power 
to the base x of the first 1,2,….,(k-1) integers as exponents. 

Initialization: The loop invariant is true before the first iteration of the loop (true for i=0). 
Before the iteration of the first pass of the loop, res is initialized to 1 which gives correct output 
when the loop ends (because any number multiplied by 1 gives the number itself). Thus, the variable res 
holds the correct result before the first iteration.  

Update: Before the kth iteration of the loop, the loop invariant tells us that res = x^i, where i = 1,2,…,(k-1). 
During the k+1st iteration, we execute res=res*x, so that res now holds the power to the base x of the first k-1 
integers plus the kth integer.This is equal to res = x^k. Thus, before the start of the k+1st iteration, the variable 
res holds the power to the base x of the k integers as exponents. 

Conclusion: Thus, before the start of the nth iteration, the variable res holds the power to the base x of the first n-1 
integers as exponents. This is the desired outcome of the algorithm and proved that res contains x^n.

The time complexity of expIterative is O(n). 


                                                          
