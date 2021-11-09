package com.lcwaikiki.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features/",
        glue = "com/lcwaikiki/step_definitions",
        dryRun = false,
        publish = true,
        tags = ""


)
public class CukesRunner {
}
