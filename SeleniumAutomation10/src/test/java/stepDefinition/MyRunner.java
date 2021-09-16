package stepDefinition;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue={"stepDefinition"},
plugin = {"pretty","html:target/HtmlReports1/report.html",
		  "json:target/JSONReports/report.json",
		  "junit:target/JUnitReports/report.xml"}
)
public class MyRunner {
}