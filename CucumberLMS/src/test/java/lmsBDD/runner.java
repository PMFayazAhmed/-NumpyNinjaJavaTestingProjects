package lmsBDD;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Feature" }, 
plugin = { "pretty", "html:target/cucumber/report.html",
        "json:target/cucumber/report.json","rerun:target/failed_scenarios.txt" }, monochrome = true, glue = { "lmsBDD" }
        )

public class runner { }

