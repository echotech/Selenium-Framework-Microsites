#Automation For APiO Microsites

This repo contains test suites for the APiO microsites. It is built using Java, Selenium, TestNG, and Maven.

##Prerequisites
**Java 8** - [Download Here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

**Maven** - [Download Here](https://maven.apache.org/install.html)

##How to use

This project was written in intellij IDEA so it should be easy to import there. Most other IDEs should work as well. 
To use, just go to the Tests.java file and run the test cases. You can run them individually by clicking the run icon 
next to the individual test or as an entire suite by running the Tests.java class.

##Structure
This was written using the Page object Model. With that in mind, there a few files to be aware of.
The **page** package should contain all the page object classes. The elements and methods for that page
are located in that file.

**TestBase** contains the setup/teardown methods that can be run before/after each test/suite of tests.

**Helpers** contains the methods that help do things within a page. These methods can be used to avoid repeating work.

**Tests** extends testbase and contains the actual tests that will be run as part of the suite.

<3


