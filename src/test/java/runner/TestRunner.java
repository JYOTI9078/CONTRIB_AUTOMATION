package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "stepdefinitions",
        monochrome = true,
        dryRun = false,
        tags = "@tests",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-reports/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
