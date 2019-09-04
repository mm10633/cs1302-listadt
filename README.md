# CSCI 1302 - List ADT v2019.fa

![Unrelated image from page 177 of "Punch" (1841)](https://i.imgur.com/7TdqL1v.jpg)

~**FRI 2019-09-26 (Sep 26) @ 11:55 PM EST**~

This document contains the description for the List ADT project
assigned to the students in the Fall 2019 CSCI 1302 classes
at the University of Georgia.

**Read the entirety of this file before beginning your project.**

**Seriously. Read this entire file *before* starting.**

## Table of Contents

* [Academic Honesty](#academic-honesty)
* [Updates](#updates)
* [Project Description](#project-description)
* [Project Requirements & Grading](#project-requirements--grading)
  * [Functional Requirements](#functional-requirements)
  * [Non-Functional Requirements](#non-functional-requirements)
  * [Absolute Requirements](#absolute-requirements)
* [How to Download the Project](#how-to-download-the-project)
* [Submission Instructions](#submission-instructions)
* [Appendix - FAQ](#appendix---faq)

## Academic Honesty

**You agree to the Academic Honesty policy as outlined in the course syllabus.**
In accordance with this notice, I must caution you **not** to 
fork this repository on GitHub if you have an account. Doing so will more than
likely make your copy of the project publicly visible. Please follow the 
instructions contained in the 
[How to Download the Project](#how-to-download-the-project)
section below in order to do your development on nike. Furthermore, you must adhere
to the copyright notice and licensing information at the bottom of this document.

## Updates

If there has been an update and you have already cloned the project to Nike, 
then you can update your copy of the project using the <code>$ git pull</code>
command while inside of your project directory.

## Project Description

In this project, you will be providing two different implementations of
a `StringList` interface, which defines different operations that one
should be able to do with a *list of strings*. A list is simply an object that represents 
an ordered collection of elements. The list implementation can decide how the
elements are stored internally so long as users are able to interact with
those elements via the methods defined in the interface. In this way, a list
is an example of an *abstract data type* (ADT). To put it another way: while 
the implementor needs to undertand the specific details of the implementation
(in order to write the code to make it happen), the user of a list does not. 
The users simply interact with objects of the list implementation through
the methods defined in the interface. 

**In order to truly understand this project,**  you must take a step back and think about how 
a list object and its storage are separate things. A list uses its storage to actually store 
its elements. For example, the size of a list does not have to be the same as the size of its 
storage, although the storage is likely at least as big as the list. Until you understand those 
last couple sentences, the project will likely seem more confusing than it actually is. 

Each implementation will be a concrete class with specific functional
and non-functional requirements. These classes need to implement `StringList`
either directly or via a common abstract parent class.

For this project, you will *NOT* have access to the `.java` files for the
interface. Instead, you will have access to the generated API documentation
for the interface <a href="http://cobweb.cs.uga.edu/~mec/cs1302/listadt-api/">here</a>.
Implementors should make sure that each method functions or behaves as described
by the interface's API documentation, except in cases where a functional requirement 
changes the behavior of the method.

Implementors are always free to implement additional methods in addition
to the ones defined by the interface. However, they should not assume that
users (e.g., graders) will use them (even if declared with `public` visibility), 
since they are not defined in the interface. These additional methods may help
avoid redundancy and promote code reuse within an implementation.

### Suggested Reading

* LDC Ch. 9 (Polymorhism)
* [API Documentation for `StringList`](http://cobweb.cs.uga.edu/~mec/cs1302/listadt-api/)

### Learning Outcomes

* Implement classes according to an interface (1302-LO1).
* Utilitze polymorphism in a software project (1302-LO3-LO4).
* Test your implementation using unit tests (1302-LO9).

## Project Requirements & Grading

This assignment is worth 100 points. The lowest possible grade is 0, and the 
highest possible grade is 110 (due to extra credit).

### Functional Requirements

A functional requirement is *added* to your point total if satisfied.
There will be no partial credit for any of the requirements that simply 
require the presence of a method related to a particular functionality. 
The actual functionality is tested using test cases.

* **`ArrayStringList`:** Create the `cs1302.list.ArrayStringList` class such
  that it properly implements the `cs1302.listadt.StringList` interface with additional
  requirements listed below.

  * You must explicitly define and document  default constructor for this class. 
	The initial size of an `ArrayStringList` is `0` regardless of the list's
	underlying storage--remember, the list's internal storage and the list 
	itself are two different things. Here is the signature:
	
	```java
	public ArrayStringList();
	```

  * You must explicitly define and document a copy constructor for this class.
	It should make the new list a deep copy of the other list. Therefore, the initial 
	size and element values of the new list should be the other list. The other
	list can be any implementation of the `StringList` interface. Here is
	the signature:
	
	```java
	public ArrayStringList(StringList other);
	```
	
  * There is a requirement related to this class's storage included
    in the [Absolute Requirements](#absolute-requirements) section.

  * **Extra Credit (5 points):** Override the `iterator()` method for your
    `ArrayStringList` class as described in the `StringList` interface. This _may_ 
    require you to create an additional class that implements another interface.
    Some web searching might reccommend an anonymous inner class. Please do not do this.
    If you choose to do this extra credit, then you should create a regular class
    that properly implements the desired interface. 
    In addition to properly overriding `iterator()`, to receive points for this 
    extra credit, you must include a file called `EXTRA.md` in your immediate project 
    directory and place the text `[EC2]` on a single line within the file. In this
    file, you should have one line for each extra credit that you want the the grader
    to check. 

    **NOTE:** You do not need to implement the `iterator()` method if you
    are not doing the extra credit.

* **`LinkedStringList`:** Create the `cs1302.list.LinkedStringList` class such
  that it properly implements the `cs1302.listadt.StringList` interface 
  with additional requirements listed below. 

  * You must explicitly define and document  default constructor for this class. 
	The initial size of a `LinkedStringList` is `0` regardless of the list's
	underlying storage--remember, the list's internal storage and the list 
	itself are two different things. Here is the signature:
	
	```java
	public LinkedStringList();
	```

  * You must explicitly define and document a copy constructor for this class.
	It should make the new list a deep copy of the other list. Therefore, the initial 
	size and element values of the new list should be the other list. The other
	list can be any implementation of the `StringList` interface. Here is
	the signature:
	
	```java
	public LinkedStringList(StringList other);
	```
	
  * There is a requirement related to this class's storage included
    in the [Absolute Requirements](#absolute-requirements) section.

  * **Extra Credit (5 points):** Override the `iterator()` method for your
    `LinkedStringList` class as described in the `StringList` interface. This _may_ 
    require you to create an additional class that implements another interface.
    Some web searching might reccommend an anonymous inner class. Please do not do this.
    If you choose to do this extra credit, then you should create a regular class
    that properly implements the desired interface. 
    In addition to properly overriding `iterator()`, to receive points for this 
    extra credit, you must include a file called `EXTRA.md` in your immediate project 
    directory and place the text `[EC2]` on a single line within the file. In this
    file, you should have one line for each extra credit that you want the the grader
    to check. 

    **NOTE:** You do not need to implement the `iterator()` method if you
    are not doing the extra credit.

* **(100 points) Test Cases**: The bulk of this project will be graded
  based on 50 JUnit test cases, each worth 2 points. This is the same as
  someone using the classes you wrote based purely on the interface
  definitions. If you implement the interface correctly, then you should
  pass the associated test cases. 
  
### Non-Functional Requirements

A non-functional requirement is *subtracted* from your point total if
not satisfied. In order to emphasize the importance of these requirements,
non-compliance results in the full point amount being subtracted from your
point total. That is, they are all or nothing. 

* **(0 points) [RECOMMENDED] No Static Variables:** Use of static variables
  is not appropriate for this assignment. However, static constants are 
  perfectly fine.
  
* **(20 points) Code Style Guidelines:** You should be consistent with the style 
  aspect of your code in order to promote readability. Every `.java` file that
  you include as part of your submission for this project must be in valid style 
  as defined in the [CS1302 Code Style Guide](https://github.com/cs1302uga/cs1302-styleguide).
  All of the individual code style guidelines listed in that document are part 
  of this single non-functional requirement. Like the other non-functional
  requirements, this requirement is all or nothing. 
  
  **NOTE:** The [CS1302 Code Style Guide](https://github.com/cs1302uga/cs1302-styleguide)
  includes instructions on how to use the `checkstyle` program to check
  your code for compliance on Nike.  

* **In-line Documentation (10 points):** Code blocks should be adequately documented
  using in-line comments. This is especially necessary when a block of code
  is not immediately understood by a reader (e.g., yourself or the grader).

### Absolute Requirements

An absolute requirement is similar to a non-functional requirement, except that violating
it will result in an immediate zero for the assignment. In many cases, a violation
will prevent the graders from evaluating your functional requirements. No attempts will be
made to modify your submission to evaluate other requirements.

* **Project Directory Structure:** The location of the default
  package for the source code should be a direct subdirectory of 
  `cs1302-listadt` called `src`. When the project is compiled, 
  the `-d` option should be used with `javac` to make the default package 
  for compiled code a direct subdirectory of `cs1302-listadt` 
  called `bin`. 
  
  If you follow this structure, then you would type the following to compile 
  your code, assuming you are in the top-level project 
  directory `cs1302-listadt`:
  
  ```
  $ javac -cp listadt.jar -d bin src/cs1302/list/ArrayStringList.java
  $ javac -cp listadt.jar -d bin src/cs1302/list/LinkedStringList.java
  ```
  
  Remember, when you compile `.java` files individually, there might be 
  dependencies between the files. In such cases, the order in which you
  compile the code matters. Also, if more than one default package is needed
  (e.g., `listadt.jar` and some other directory like `bin`), then a colon `:` 
  can be used to separate each path in a list of multiple paths supplied
  to `-cp` (e.g., `-cp listadt.jar:bin`). For more information, see 
  ["Setting the Classpath"](https://github.com/cs1302uga/cs1302-tutorials/blob/master/packages.md#setting-the-class-path) 
  in the package tutorial.

* __Development Environment:__ This project must be implemented 
  in Java 8, and it *must compile and run* correctly on Nike using the specific
  version of Java 8 that is setup according to the instructions provided
  by your instructor. 
  
  If you decide to introduce additional `.java` files into your project,
  then they are expected to fulfill all non-functional and absolute requirements, 
  even if the main parts of the project do not use them. You may assume
  graders will compile your source code in an order that satisfies
  compilation dependencies. You should remove any `.java` files that you
  do not need before submission. 
  
* **`cs1302.list.ArrayStringList` Storage Requirement:**
  You must use a basic Java array for this class's storage. The initial
  size of the array does not have to be the same size as the initial size
  of the list. Whenever the size of the list is about to exceed the size
  of its array, the list should dynamically allocate a new array of a larger
  size and copy the contents over--please consider writing and documenting
  a private support method to do this. If you use Java's `java.util.ArrayList` 
  class or something similar, then that will result in an immediate violation
  of this non-functional requirement, regardless of any use of a regular
  array elsewhere in the class. This requirement also prohibits any use of 
  third-party implementations of list or list-like interfaces.

* **`cs1302.list.LinkedStringList` Storage Requirement:**
  You must use a sequence of `cs1302.listadt.StringList.Node` objects
  for this class's storage. Unlike the array-based implementation in
  `ArrayStringList`, this type of storage is not limited to the number
  of elements that can fit into an array (because there is not an array).
  Instead, it's limited only by the available memory for the Java program
  using the `LinkedStringList` object. You may find sections 13.1 and
  13.2 of the LDC textbook useful reference material for this class.
  If you use Java's `java.util.LinkedList` class or something similar, then that 
  will result in an immediate violation of this non-functional requirement, 
  regardless of any use of any `Node` objects elsewhere in the class.
  This requirement also prohibits any use of third-party implementations 
  of list or list-like interfaces.

### Grading

This project will be graded using unit tests, none of which will be made 
available before the project deadline. You can test your implementations yourself
via interface polymorphism.

## How to Download the Project

On Nike, execute the following terminal command in order to download the project
files into sub-directory within your present working directory:

```
$ git clone --depth 1 https://github.com/cs1302uga/cs1302-listadt.git
```

This should create a directory called `cs1302-listadt` in
your present working directory that contains a clone of the 
project's respository. Take a look around.

If any updates to the project files are announced by your instructor, you can
merge those changes into your copy by changing into your project's directory
on Nike and issuing the following terminal command:

```
$ git pull
```

If you have any problems with these download procedures, then please contact
your instructor.

## Submission Instructions

You will be submitting your project via Nike before the deadline indicated
near the top of this document. Make sure your project files
are on `nike.cs.uga.edu`. Change into the parent directory of your
project directory. If you've followed the instructions provided in this document, 
then the name of your project directory is likely `cs1302-listadt`. 
While in your project's parent directory, execute the following command: 

```
$ submit cs1302-listadt cs1302a
```

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

```
$ tar zcvf cs1302-listadt.tar.gz cs1302-listadt
$ mutt -s "[cs1302] cs1302-listadt" -a cs1302-listadt.tar.gz -- your@email.com < /dev/null
```

If you have any problems submitting your project then please send a private
post to your instructor via the course Piazza as soon as possible. However, 
creating a post about something like this the day or night the project is due 
is probably not the best idea.

# Appendix - FAQ

Below are some frequently asked questions related to this project.
   
1. **Can I technically implement the methods first before I implement them correctly?**

   You may wish to write out the method signatures for the methods you are
   implementing from the interface with empty bodies in an attempt to get started.
   You will quickly discover that the methods that have a non-void return
   value actually need to return something. If you don't put a return statement,
   then this complicates trying to compile and test one method at a time.
   
   It is possible to _temporarily_ include a `throw` statement in the method
   until you commit to writing the return statement. I reccommend throwing
   an instance of [`UnsupportedOperationException`](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html)
   if you choose to do this. For example, you might write something like this for the `get(int)`
   method:
   ```
   public String get(int index) {
       throw new UnsupportedOperationException("not yet implemented");
   } // get
   ```
   
1. **How can I remove redundancy between my two implementations of the interface?**

   You may find yourself implementing a method the eact same way in both classes. This is an
   excellent opportunity to promote code reuse via inheritance! While not a requirement,
   proper use of a single parent class containing methods and variables common to both
   implementations can _vastly_ reduce the amount of code that you need to write for this
   project. It is a beautiful compromise that illustrates the trade-off between more planning
   versus more code writing and debugging.

1. **What is `listadt.jar`?**

   In Java, `.jar` files are Java™ Archive (JAR) files that bundle multiple files into a single 
   compressed file. Typically a JAR file contains the package directories and `.class` files
   for a library. This is just like the `bin` directory that you are used to, except it's all
   bundled into a single file. For example, the `listadt.jar` file contains the package directories
   and `.class` files for `cs1302.listadt.StringList`. If you are in the same directory as
   `listadt.jar`, then you can use the following command to take peek into the archive:
   
   ```
   $ jar -tf listadt.jar
   ```
   
   You shold notice that the top-level directory in the JAR file is `cs1302`, which means that
   the JAR file itself can serve as the default package for compiled code--this is why we
   use with `-cp` in examples given elsewhere in this project description.

Have a question? Please post it on the course Piazza.

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>

