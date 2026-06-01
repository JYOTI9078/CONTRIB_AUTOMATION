package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/", glue = "stepdefinitions", monochrome = true, dryRun = false, tags = "@AP_TestCase",
//plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber-reports/cucumber.json" })
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner extends AbstractTestNGCucumberTests {

}