package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/pom/features",
		glue = {"stepdefinitions"},
		plugin = {"pretty",
				"html:target/HtmlReports",
				"json:target/JSONReports/report.json", 
				"junit:target/JUnitReports/report.xml"},
		dryRun=false
		)


public class TestRunner {

}