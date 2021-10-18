#Takealot 
###[https://www.takealot.com/](https://www.takealot.com/)
###Part 1 - UI Testing Scenario
##Implementation
    

I use **IntelliJ** IDE, **JAVA** as programming language, **Selenium** with **JUnit** as testing Framework and **Maven** as a build management tool.

For this task I created BDD Cucumber Framework based on POM(Page Object Model) design pattern,
because I wanted to have an organised and easy to maintain Framework. 

I have:
- under **pom.xml** file I keep all my dependencies;
- under **features** folder my scenarios written in Gherkin language;
- under **pages** folder I keep my locators and usefully methods;
- under **stepDefinition** package I write my coding logic written in JAVA ;
- under **Hooks** class I keep my **before**, **after** methods;
- I trigger my Framework using **Runner** class;
- I created **Configuration.properties** file to keep data in one place (browser, url, uri, authorizationKey, authorizationValue);
- under **utilities** package I keep classes which contains reusable methods:
  - **Driver** class where I initialise my driver using **Singleton Design Pattern**;  
  - **ConfigurationReader** is used to read **.properties** type of files;
  - **BrowserUtils** I keep some reusable methods.
- I generate detailed **html reports** using **maven-cucumber-reporting plugin** and I take **screenshots** for my failed test cases.

Before to start automation testing, I performed manual testing. 
For **Register.feature** I created one positive and one negative scenario where a used different data. 
For **AddToCart.feature** I created two scenarios. After I perform manual testing, I found that one of the products is not listed. 

I try to get all the products locators dynamically, so for different data I can use the same code.

As **improvement** if we need to test multiple data I can use **Scenario outline** in order to use multiple data with the same code, and I can come up with more scenarios to make sure that I cover as much as I can for the functionality. 

#OpenWeather
###[https://www.takealot.com/](https://www.takealot.com/)
###Part 2 - API Testing Scenario

I used **Postman** to perform manual testing and I use **RestAssured** library for automation.

I use the same Framework for the **API** testing and I perform five positive scenarios and I perform two negative scenario.

I use London as a city name when I sent **GET** request and I used the provided **Key** for authorization.
I used **path() method** and **JsonPath** for deserialization and I checked the **status code**, **content type** and **body**.

#Running Maven Commands

Although hardly a comprehensive list, these are the most common default lifecycle phases executed.

- validate: validate the project is correct and all necessary information is available
- compile: compile the source code of the project
- test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
- package: take the compiled code and package it in its distributable format, such as a JAR.
- integration-test: process and deploy the package if necessary into an environment where integration tests can be run
- verify: run any checks to verify the package is valid and meets quality criteria
- install: install the package into the local repository, for use as a dependency in other projects locally
- deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects

# CI/CD implementation

I configured the **pom.xml** file, so I will be able to run the test via command line. In order to be able to do this, I used **apache-maven plugin**.

The test that I have been working on will be part of the **regression suite** and some of them will be part of the **smoke suite**.

The integration of the tests into a CI/CD pipeline will be done using Jenkins (or any other CI/CD tool) by creating jobs and using the source code management in order to retrieve the code from **version control system** (ex: GitHub), and choosing **"top level maven command"** and running the specific suite by using the specific tag name (ex: @smoke, @regression). 



