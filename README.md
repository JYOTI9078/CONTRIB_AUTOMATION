<h1 align="center"> LITMUS 1.0</h1>
<p align="center">
    Java-BDD Framework for Web & API Test Automation
    <br/>
</p>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#folder-structure">Folder Structure</a></li>
        <li><a href="#pre-requisites">Pre-requisites</a></li>
        <li><a href="#setup">Setup</a></li>
        <li><a href="#writing-your-first-test-scenario">Writing your first test scenario</a> </li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a>
    <ul>
        <li><a href="#runner-file">Runner File</a></li>
        <li><a href="#yaml-configuration">YAML configuration</a></li>
        <li><a href="#ci-cd-integration">CI/CD integration</a></li>
      </ul>
    </li>
    <li><a href="#reports">Reports</a>
    <ul>
        <li><a href="#robot-reports">Robot Reports</a></li>
        <li><a href="#allure-reports">Allure Reports</a></li>
      </ul>
    </li>
    <li><a href="#further-reading">Further Reading</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a> </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>
<br/>

## About the project

This is a multipurpose kickstarter framework built on Java and Cucumber. The framework has BDD at its core
as it allows the user to write tests in plain English using Gherkin.

```
Scenario Outline: Verify the login functionality
    Given user has opened the homepage in browser
    When user enters the <username> and <password>
    Then user should be successfully logged in
    Example:
       | username   | password  |
       | user1      | pwd123    |
```

## Getting Started

### Folder Structure

The framework uses the following folder structure for various script development and framework enhancement modules.
Please refer the structure to understand how the packages and files are organized.

```
pom.xml                             # For managing maven dependencies, build management and commandline arguments for runtime 
input-data                          # All the test-data files created by testers should be put here    
src
└───main
│   └───java                    
│   │   └───basetest           ┐
│   │   └───constants          ├    # Framework packages which are maintained by the CoE team
│   │   └───driver             ┘
│   │   └───pageFactory             # Add all your page classes in this package
│   │   │   └───PageClass           # Default page class which MUST BE extended by every page-object class in the test project
│   │   │   └───PageObjectManager   # For creating and managing objects of every page class.
│   │   └───utils                   # Various utility libraries which can be used by both framework developers and testers
│   └───resources
│       └───log4j2.xml
└───test                     
    └───java
    │   └───runner                  
    │   │   └───TestRunner          # Main Runner class for this cucumber framework. Used for running tests locally
    │   └───stepdefinitions         # Add all your step-definition classes here
    │       └───CommonSteps         # A step-definition class for performing common actions such before and after test tasks etc.
    └───resources
        └───Configs                 # All the project configurations are maintained here. Create as many required for each environment of your project
        │   └───qa.properties       
        │   └───dev.properties      
        └───Features                # All feature files consisting of test scenarios are kept in this folder.
logs                                # Metric and execution logs displayed here
target                              # Execution results will be shown under this folder
└───cucumber-html-reports           # HTML reports will be created under this folder
    └───overview.html               # Look for this file to open and view the execution reports.
README.md
Contributing.md

```

The folders that need to be maintained

- By automation testers

```
pom.xml
input-data/testdata.xlsx
src/test/java/stepdefinitions
src/test/resources/Configs
src/test/resources/Features
src/main/java/pageFactory
```

- By COE developers

```
pom.xml
src/main/java/basetest
src/main/java/driver
src/main/java/utils
src/main/java/pageFactory/PageClass.java
src/test/java/runner/TestRunner.java
```

## Framework Installation & Setup

### Pre-requisites

- Install [Java 1.8][java-1.8]
- Install [Maven][maven]
- Set Java and Maven in the [classpath][classpath]
- Install [Git][git] and clone this repository
- Install [IntelliJ Idea][intellij] (preferred) or any other compatible IDE
- Install all recommended [IntelliJ plugins][intellij-plugins]. Install the corresponding plugins if you're using any
  other IDE.

### Setup

- Open the [qa.properties][qa-properties] file in src/test/resources/Configs folder and update the configuration details
  such as:
  <br/> Execution Server
  <br/> Grid details
  <br/> Test browser
  <br/> Application Base URL
- Open [pom.xml](pom.xml) and navigate to the plugin `org.apache.maven.plugins` under the `<build>` section. Update the
  name of your properties file in the `envName` variable.
  <br/> For instance, if your properties file name is qa.properties, then set the value of `envName` to _qa_.

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    ...
    <configuration>
        <systemPropertyVariables>
            <envName>qa</envName>
```

- If you wish to execute the test cases in any other environment such as dev or staging, then clone the qa.properties
  file, rename it appropriately, and update all the values corresponding to your new environment.
  Correspondingly, set the value of `envName` in pom.xml to the same name.
- For running your tests in **Headless Mode**, set the value of `healessMode` to _true_.

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    ...
    <configuration>
        <systemPropertyVariables>
            ...
            <headlessMode>true</headlessMode>
```

### Writing your first test scenario

Once the framework installation and setup is complete, you are now ready to start writing your test scripts.

- First create a new feature file in _src/test/resources/Features_ folder. Right-click on the Features folder and create a
  new file. Give it an appropriate name and make sure the file name ends with _.feature_. IntelliJ will automatically
  detect it as a cucumber feature file (given that you have installed all the plugins correctly).
- Write your test scenarios in this feature file. Refer [Further Reading](#further-reading) to know more about writing test scenarios using Gherkin.
- Then create a new Java class in _src/test/java/stepdefinitions_.

## Further Reading

- Know more about [Cucumber Frameworks][cucumber-frameworks]
- Use of [Page Object Manager][page-object-manager] in a BDD framework
- Know more about [Gherkin][gherkin]
- How to write [Gherkin test scenarios][gherkin-test-scenarios]
- Writing [Step Definitions][step-definitions]
- Know more about [Web Driver Manager][webdrivermanager]
- Why should you run your tests in [Headless Mode][headless-mode]?
- [Parallel execution][parallel-execution] using Cucumber
- Know more about [Cucumber HTML Reports][cucumber-reporting]
- How to configure Cucumber HTML Report in [Jenkins][cucumber-report-jenkins]

## Roadmap

- [x] Base framework
    - [x] Environment management
    - [x] Test input management
    - [ ] Parallel execution
    - [x] Cucumber HTML report integration
    - [ ] Serenity report integration
- [x] Web Automation
    - [x] Web driver management
    - [x] Local execution
    - [x] Grid execution
    - [x] Multi-browser support
    - [ ] Browserstack/Saucelabs integration
- [x] API Automation
    - [ ] API authentication support
- [ ] Mobile Automation
    - [ ] Android - Browsers
    - [ ] Android - App
    - [ ] Android - Emulators
    - [ ] iOS - Browsers
    - [ ] iOS - App
    - [ ] iOS - Emulators
- [ ] Desktop app Automation
- [ ] CQA analytics extraction
- [ ] Analytics management
- [ ] Automated manual efforts estimator
- [ ] Applitools integration
- [ ] Add commonly used selenium operations into keywords
    - [ ] Dropdown management
    - [ ] List traversal and searching
    - [ ] List comparison
    - [ ] Random selection from dropdown
    - [ ] Random selection from checkboxes

## Contributing

To contribute to this repository, please see the [contribution guidelines](CONTRIBUTING.md).

## Contact

For further information, inquiries and support, please reach out to QE&T Automation CoE
- [DL IN Sogeti Test Automation COE](sogetitestautomationcoe.in@capgemini.com).


<!-- reference urls -->

[git]: https://git-scm.com/
[java-1.8]: https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html
[maven]: https://maven.apache.org/install.html
[intellij]: https://www.jetbrains.com/idea/
[classpath]: https://docs.oracle.com/javase/tutorial/essential/environment/paths.html
[intellij-plugins]: ./.idea/plugins.json
[qa-properties]: ./src/test/resources/Configs/qa.properties
[cucumber-frameworks]: https://github.com/RameshGhk/Cucumber_Test_Automation_Framework
[page-object-manager]: https://www.toolsqa.com/selenium-cucumber-framework/page-object-manager/
[gherkin]: https://cucumber.io/docs/gherkin/reference/
[gherkin-test-scenarios]: https://cucumber.io/docs/guides/10-minute-tutorial/#write-a-scenario
[step-definitions]: https://cucumber.io/docs/gherkin/step-organization/
[parallel-execution]: https://cucumber.io/docs/guides/parallel-execution/
[cucumber-reporting]: https://github.com/damianszczepanik/cucumber-reporting
[cucumber-report-jenkins]: https://github.com/jenkinsci/cucumber-reports-plugin/wiki/Detailed-Configuration
[webdrivermanager]: https://bonigarcia.dev/webdrivermanager/
[headless-mode]: https://smartbear.com/blog/selenium-tests-headless/