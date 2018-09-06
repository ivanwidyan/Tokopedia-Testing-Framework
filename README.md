## Tokopedia-Testing-Framework
Testing Framework for Tokopedia Android and Web App

[![tokopedia-icon](https://user-images.githubusercontent.com/12959761/45135869-c2d4bf00-b1cb-11e8-8d25-6e734980197a.png)](https://www.tokopedia.com)

This Tokopedia framework is Java implementation of the [Appium](https://github.com/appium/appium)
framework and [Selenium](https://github.com/SeleniumHQ/selenium) software-testing framework with [TestNG](https://github.com/cbeust/testng) 
testing framework to create easy automate testing for Tokopedia Android Application which written in Java & XML.

This testing framework is applying the automation build using [Maven](https://maven.apache.org/) and [Jenkins](https://jenkins.io/) 
with GitHub to help manage the deployment process so continuous integration for testing can be achieved.

### Development Technology
Included in `pom.xml` for maven dependency
* [Selenium](https://github.com/SeleniumHQ/selenium)
* [Appium](https://github.com/appium/appium)
* [TestNG](https://github.com/cbeust/testng)

### Build Automation Tools
* GitHub
* [Maven](https://maven.apache.org/)
* [Jenkins](https://jenkins.io/)

### Supported Platforms
* Android
* Web Application

### Framework Features
* Wait Get Element By ID, ClassName, XPath, CSSSelector
* Wait for Click Element By ID, ClassName, XPath, CSSSelector
* Wait to Send Keys Element By ID, ClassName, XPath, CSSSelector
* Wait to Get Elements By ID, ClassName, XPath, CSSSelector
* Wait Get Elements By ID, ClassName, XPath, CSSSelector (Support index)
* Wait Click Elements By ID, ClassName, XPath, CSSSelector (Support Index)
* Tap By Coordinates
* Swipe Vertically, Horizontally, & By Coordinates

### Suites Capabilities:
* Test Suites (Collection of Test Cases)
* Multiple Test Suites
* Parallel Execution (Multithreading) Test
* Multiplatform Parallel Execution Test (e.g. Android & Web at the same time)

### Functionality Capabilities:
**Splash Screen: (Android Only)**
* Skip Splash Screen

**Home: (Android & Web)**
* Search

**Search: (Android & Web)**
* Order By
* Select

**Summary: (Android & Web)**
* Buy

### Examples
**Item Purchase:**
* Multiplatform Parallel Execution and Multithreading - Test PR_IT_001 & PR_IT_002
[![Parallel_Test](https://user-images.githubusercontent.com/12959761/45136116-de8c9500-b1cc-11e8-91dc-2e5878119488.png)](https://youtu.be/msIWDudQ6Ew)

### Authors
Ivan Widyan - Creator & Developer (ivanwidyan@yahoo.com)