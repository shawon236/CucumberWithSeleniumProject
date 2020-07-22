package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        features = ".//Features",
        dryRun = false,
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber.json", "junit:target/cucumber-reports/cucumber.xml", //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "html:target/HtmlReports"},

        tags = {"@sanity"}
        )

public class TestRunnerClass {

}

//to run all Features--->".//Features"
// to run specific Feature---> ".//Features/Admin.feature"
// to run according to tag---> tags = {"@sanity"} with ".//Features"
// to run according to tag---> tags = {"@sanity,@Smoke"} with ".//Features"
// Combination of different Tag-->tags = {"@sanity","@Regression"} with ".//Features"

//Git hub URL: https://github.com/shawon236/CucumberWithSeleniumProject.git
//C:\Users\shawo\IdeaProjects\CucumberWithSeleniumProject