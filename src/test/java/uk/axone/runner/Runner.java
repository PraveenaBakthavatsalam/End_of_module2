package uk.axone.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"uk/axone/stepdefinition"},
        plugin = {"html: Signin.html",
                "pretty",
                "summary"
        }
)
public class Runner extends AbstractTestNGCucumberTests {
}
