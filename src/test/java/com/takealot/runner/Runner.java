package com.takealot.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-html-reports",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/takealot/stepDefinition",
        dryRun = false,
        tags = "@api"
)

public class Runner {
}
