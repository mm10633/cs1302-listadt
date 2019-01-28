# CSCI 1302 - List ADT v2019.sp

![Unrelated image from page 177 of "Punch" (1841)](https://i.imgur.com/7TdqL1v.jpg)

**FRI 2018-MM-DD (MON DD) @ 11:55 PM EST**.

This document contains the description for the List ADT project
assigned to the students in the Spring 2019 CSCI 1302 classes
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
* [How to Download the Project](#how-to-download-the-project)
* [Submission Instructions](#submission-instructions)
* [Appendix - FAQ](#appendix---faq)

## Academic Honesty

You agree to the Academic Honesty policy as outlined in the course syllabus. 
In accordance with this notice, I must caution you **not** to 
fork this repository on GitHub if you have an account. Doing so will more than
likely make your copy of the project publicly visible. Please follow the 
instructions contained in the 
[How to Download the Project](#how-to-download-the-project)
section below in order to do your development on nike. Furthermore, you must adhere
 to the copyright notice and licensing information at the bottom of this document.

## Updates

Updates will be posted here.
If there has been an update and you have already cloned the project to Nike, 
then you can update your copy of the project using the <code>$ git pull</code>
command while inside of your project directory.

## Project Description

In this project, you will be providing two different implementations of
a ```StringList``` interface, which defines different operations that one
should be able to do with a *list of strings*. A list is simply an object that represents 
an ordered collection of elements. The list implementation can decide how the
elements are stored internally so long as users are able to interact with
those elements via the methods defined in the interface. In this way, a list
is an example of an *abstract data type* (ADT). To put it another way: while 
the implementor needs to undertand the specific details of the implementation
(in order to write the code to make it happen), the user of a list does not. 
The users simply interact with objects of the list implementation through
the methods defined in the interface. 

Each implementation will be a concrete class with specific functional
and non-functional requirements. These classes need to implement `StringList`
and override its methods to provide their functionality. 

In addition to the Javadoc comments in 
<a href="src/main/java/cs1302/lists/GenList.java">`cs1302.lists.GenList`</a>,
the HTML documention for the `GenList<T>` interface is available 
<a href="http://cobweb.cs.uga.edu/~mec/cs1302/lists-apidocs/cs1302/lists/GenList.html">here</a>.
Implementors should make sure that each method functions or behaves as described
by API documentation in the interface, except in cases where a functional requirement 
changes the behavior of the method. Whenever an overridden method's behavor differs from
how it's described in the `StringList` interface, this new behavor should be 
documented using Javadoc. 

Implementors are always free to implement additional methods in addition
to the ones defined by the interface. However, they should not assume that
users will use them (even if declared with `public` visibility), since
they are not defined in the interface. These additional methods may help
avoid redundancy and promote code reuse within an implementation.

### Suggested Reading

* LDC Ch. 9 (Polymorhism)

### Learning Outcomes

* Implement classes according to an interface (1302-LO1).
* Utilitze polymorphism in a software project (1302-LO3-LO4).
* Test your implementation using unit tests (1302-LO9).

## Project Requirements & Grading

This assignment is worth 100 points. The lowest possible grade is 0, and the 
highest possible grade is 105 (due to extra credit).

### Functional Requirements

* **(100 points) Test Cases**: The bulk of this project will be graded
  based on 50 JUnit test cases, each worth 2 points. This is the same as
  someone using the classes you wrote based purely on the interface
  definitions. If you implement the interface correctly, then you should
  pass the associated test cases. 
  
  Some test cases are presented here with the skeleton project in
  [`/test`](/test). You can run the test cases
  with the following command:
  ```
  TODO UPDATE
  ```

### Non-Functional Requirements

TODO - mostly same as latin-squares except no scanner req and do require full javadoc

### Grading

This project will be graded using unit tests, most of which will not be made 
available before the project deadline. 

## How to Download the Project

On Nike, execute the following terminal command in order to download the project
files into sub-directory within your present working directory:

```
$ git clone https://github.com/cs1302uga/cs1302-listadt.git
```

This should create a directory called `cs1302-listadt` in
your present working directory that contains a clone of the 
project's respository. Take a look around.

To compile: TODO

To test: TODO

If any updates to the project files are announced by your instructor, you can
merge those changes into your copy by changing into your project's directory
on Nike and issuing the following terminal command:

```
$ git pull
```

If you have any problems with any of these procedures, then please contact
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
   public T get(int index) throws IndexOutOfBoundsException {
       throw new UnsupportedOperationException("not yet implemented");
   } // get
   ```

Have a question? Please post it on the course Piazza.

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
