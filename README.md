Industry Lab 09: Generics & Collections
==========
## Exercise One: Simple Generic Collections
1. What is the output of the following code?
```java
ArrayList list = new ArrayList();
Character letter = new Character('a');
list.add(letter);

if (list.get(0).equals("a")) {
	System.out.println("funny");
} else {
	System.out.println("Not funny");
}
```
```text



```

2. What is the output of the following code?
```java
ArrayList<Point> list = new ArrayList<Point>();
Point pt1 = new Point(3, 4);
list.add(pt1);
Point pt2 = list.get(0);
pt2.x = 23;
if (pt2 == pt1) {
	System.out.println("Same object");
} else {
	System.out.println("Different object");
}
```
```text



```

3. What is the error of the following code?
```java
ArrayList list = new ArrayList();
list.add('a');
list.add(0, 34);
String c1 = (String) list.get(1);
```
```text



```

## Exercise Two: An Array of Strings
```java
String[] array = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN"};
```

Given the array of strings above, convert the array of strings to an **ArrayList**. 

Then, write methods that make each string in the array list all lowercase. Implement the method in three different ways:
* Using a loop over the index values
* Using an enhanced for loop
* Using an iterator


## Exercise Three: Arrays to Lists
Examine the code in the `ex03` package. The **ExerciseThree_Arrays** class contains a complete program which has three methods:
* **union** – takes two arrays and returns an array containing all elements in the first array plus all elements in the second array.
* **intersection** – takes two arrays and returns an array containing all elements in the first array which are also in the second array.
* **difference** – takes two arrays and returns an array containing all elements in the first array which are not in the second array.

The class also contains a start method which creates some test arrays and runs them through each of these methods for testing purposes, and prints out the result.
As you can see from the implementations of some of those methods, arrays perhaps aren’t the most ideal data structures for doing this kind of thing! In two of the methods we even have to loop twice – once just to figure out how big the result array should be.

In the `ex03` package, there is also an **ExerciseThree_Lists** class which is intended to implement identical functionality to the first class, but do so using Lists instead of Arrays. The start method in this class is almost complete, except that two lines are commented out, as you’ve not implemented the corresponding methods yet.

For this exercise, implement the **union**, **intersection** and **difference** methods in the **ExerciseThree_Lists** class. A skeleton for the union method has already been provided.

Once that’s done, uncomment the two commented lines of code in the start method to run and test your program.

**Hint:** You should be able to write a lot less code in your three implementations compared to the Array implementations, by making use of appropriate **List** and **Collections** methods.

## Exercise Four: Pancakes
The restaurant, **PancakeTopia**, is a very unusual, yet popular restaurant. Every day for lunch, they make a certain number of pancakes at random and put them in a large **stack**. Customers who want some delicious pancake-y goodness for lunch form a large **queue** outside. In turn, the restaurant lets one customer into the restaurant, who sits down at the table and eats as many pancakes as they want from the top of the stack. One that person is done, the next person sits down, and so on, until **PancakeTopia** runs out of either pancakes or customers for the day. Sometimes, customers at the end of the queue might not get fed – but **PancakeTopia** remains in business since their pancakes are the best in the land – the reward is worth the risk!

In this exercise, we’ll complete a program which models a typical lunchtime at PancakeTopia. The nearly-complete application is located in the `ex04` package, and example outputs for the *complete* program (once you’ve made the necessary changes) can be found in the files `PancakeTopia-ExampleOutput-01.txt` and `PancakeTopia-ExampleOutput-02.txt`, which are located directly in the project directory. Here are the steps to go through to complete this exercise.

### Step 1: Understanding
Have a look at the code and see what’s there. Try to get an idea of how everything fits together. Perhaps try to draw some quick UML diagrams to assist you. This is often a good first step when trying to learn any new system.
### Step 2: Getting the customers to form a queue
In the PancakeApp class, you’ll have noticed a method called **createCustomerQueue()** which creates a random number of customers, and should add those customers to a queue. For this step, complete this method. Firstly, initialize the queue variable to something other than **null**. Secondly, call one of **queue**’s methods at the marked location to add the generated customer to that queue. Remember that queues are `First-In-First-Out (FIFO)` – meaning, the first customer to line up will be the first to get served.
Next, in **PancakeShop’s serveLunch()** method, there’s a loop where we want to continually get the customer at the front of the queue. Complete that line by using an appropriate **poll** statement. Remember that we should be de-queuing customers in the same order that we queue them.

### Step 3: Stacking those pancakes
In **PancakeShop’s createPancakes()** method, we are creating a random number of Pancakes. Complete the method so that created pancakes get added to the top of the pancakes stack. Remember that stacks are `Last-In-First-Out (LIFO)` – meaning, the last pancake to be added to the stack will be the first one that’s eaten by a customer.
### Step 4: Eat pancakes!
We now have a queue of customers and a stack of pancakes. It’s time to teach the customers how to eat! This is handled in the **Customer’s eat()** method, which is largely unimplemented at this point. In this method, customers are handed a stack of pancakes and should try to eat as many pancakes from the top of the stack as will fit in their belly. If there’s not enough pancakes for them, they should complain (by throwing a tantrum / **Exception**).
Further details about what the method should do can be seen in the provided comments and by examining the provided example outputs.

## Bonus Exercise One: A Predicate interface
Take a look at the code that’s located in the ex01 package. You’ll find the following classes & interfaces there to begin with:
* **IPredicate** – an interface with a single method, which takes an Object and returns a boolean based on whether some condition (i.e. predicate) about that object is true or false.
* **OddNumbersPredicate** – an **IPredicate** implementation which checks if objects are odd Integers.
* **UpperCaseStringPredicate** – an **IPredicate** implementation which checks if objects are Strings completely in upper-case.
* **ExerciseOne** – the main class for this exercise. Contains a method called **filterList**, which takes a List of **Objects** and an **IPredicate**, and removes objects from the list which don’t match the predicate. Also contains a start method which creates a couple of lists and attempts to filter them using relevant predicates.

If you run the program as-is, you’ll notice that it crashes. This is because, the way we’ve written the program, the compiler is happily allowing us to put incorrect types of items into lists, and supply incorrect predicates to the **filterList** method. There are examples of both of these problems in the start method.

For this exercise, we’ll start by removing and fixing the lines of code currently causing the program to crash, then we’ll modify the program to make use of Java generics to greatly reduce the chances this kind of error will occur in the future.

### Step 1: Fix existing code
If we examine the start method, we’ll see that we’re trying to add things to the lists which aren’t of the correct types. Start by commenting those lines out (don’t delete them entirely – once we’ve made other changes we can try to uncomment them again and see that the compiler won’t allow it).

From there, have a look at the lines in the start method where we’re trying to filter the lists. The developer of this program has made a mistake here. Correct the error that they’ve made.

Once we’ve made these changes, the program should run correctly and produce the desired output. Now we’ll modify the program so the compiler won’t allow us to make these kinds of errors again.

### Step 2: Make IPredicate generic
If we look at the **IPredicate** interface, we’ll see that the test method can accept any kind of **Object**. This is error-prone as it forces any implementing class to deal with any kind of input, and if they forget, errors may occur.

For this step, change **IPredicate** into a `generic interface`. Add a type parameter (e.g. **<** **T** **>** ) to the interface declaration, and modify the **test** method signature accordingly.

### Step 3: Modify OddNumbersPredicate and UpperCaseStringPredicate
Now that we’ve changed the IPredicate interface, we need to modify any classes which implement it accordingly. In this case, that’s **OddNumbersPredicate** and **UpperCaseStringPredicate**.

Modify **OddNumbersPredicate** so that it implements the Integer version of our generic **IPredicate** method – i.e. **IPredicate<Integer>**. Change the **test** method signature accordingly. Also, remove any casting which is happening in that method as it should no longer be necessary.

Modify **UpperCaseStringPredicate** in the same way.

### Step 4: Modify the strings and ints lists so they can only accept the correct stuff
In the **start** method, we can see that **strings** and **ints** are declared as **List<Object>**. That’s not good – we want these lists to only accept items which are **Strings** or **Integers**, respectively.

Modify the declarations of these two variables to ensure that this happens.

### Step 5: Make the filterList method generic
We want to ensure that, if we pass a **List<Integer>** into the **filterList** method, for example, we can only pass an **IPredicate<Integer>**, not any other kind of **IPredicate**. We can do this by turning **filterList** into a `generic method`.

We didn’t cover generic methods in the lecture, but they are way to make a single method generic, without making an entire class generic. For more information about generic methods and to see their syntax, have a look at the material covered in [this Java tutorial page](https://docs.oracle.com/javase/tutorial/extra/generics/methods.html).

Once you’re familiar with the syntax for generic methods, add a type parameter (e.g. **<** **T** **>** ) to the **filterList** method, and change the **list** and **predicate** arguments to only accept lists and predicates of the matching type parameter. You’ll also need to modify a couple of lines of code within the method itself to refer to your type parameter rather than **Object**.

### Step 6: See that your program is less error-prone!
Uncomment the lines you commented out in step 1. You’ll see that the program won’t compile. Similarly, if you re-introduce the error you fixed in step 1, the program will also not compile.

This is now a lot more preferable – it’s almost always better to have things break at compile-time (when you can immediately see what’s wrong and fix it) rather than run-time (when your customers may not know what to do to fix the crashes they see)!

## Bonus Exercise Two: Lots of Shapes
Examine the code in the `ex02` package. You’ll see the following classes:
1. **Shape** – Represents some kind of shape. Shapes have, among other things:
    * An area which can be obtained with the `getArea()` method
    * A perimeter which can be obtained with the `getPerimeter()` method
    * Information which can be obtained using the `toString()` method
2. **Circle, Rectangle & RegularPolygon** – Types of Shape.
3. **ShapeBox** – A box designed to hold many shapes. Has methods to add a single shape, add many shapes at once, get the total perimeter of all shapes in the box, get the total area of all shapes in the box, and get information regarding the box and all shapes inside. * **ExeriseTwo** – the main program entry point. The **start** method creates a **ShapeBox** and adds some individual shapes to it. It also creates lists of **Circles**, **Rectangles**, and **RegularPolygons** and attempts to add those to the box.

The program as it stands is incomplete. There are several methods which aren’t complete and some commented lines which should be uncommented, but won’t currently work with the rest of the program.

In this exercise we’ll complete the implementation of this program.

### Step 1: Use a generic wildcard
There are three lines of code in the **ExerciseTwo.start()** method which are commented out. If we uncomment those, we’ll see that the program doesn’t compile. To make the program compile with those lines, we’ll need to change the method signature of **ShapeBox’s addShapes** method to use a `wildcard`. The wildcard should allow **List<Rectangle>s**, **List<Circle>s** etc. to be added in addition to **List<Shape>** which it already allows.

### Step 2: Calculating the total perimeter
Complete **ShapeBox’s getTotalPerimeter()** method, which should add up the perimeter of all shapes in the storage list and return the sum. For this method, use a normal for-loop, as you would do when using an array.

`Remember: The ith element of a list can be obtained with the get(i) method.`

### Step 3: Calculating the total area
Complete **ShapeBox’s getTotalArea()** method, which should add up the area of all shapes in the **storage** list and return the sum. For this method, use an *enhanced for-loop*.

### Step 4: Complete ShapeBox’s toString() method
Complete the **toString()** method so that it loops through all shapes in the **storage** list and concatenates information about each shape to the given info string. Information about a shape can be obtained using its own **toString()** method. For this question, you should iterate through the list using an **Iterator**.




