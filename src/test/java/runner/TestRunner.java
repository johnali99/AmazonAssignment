package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReportingConfig;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "classpath:features",
		glue = "stepDefinition",
		tags = "@testRun",	
		dryRun = false,
		monochrome = true,
		strict = true,
		plugin = {"pretty", 
				"html:target/site/cucumber-pretty",
				"json:target/cucumber.json" },
		publish = true
		)

public class TestRunner {

	/**
	 * This method will invoke the Cucumber reporting once the execution is over.
	 * @AfterClass annotation is from Junit and this will run after (AfterHooks)
	 */
	@AfterClass
	public static void generateReport() {
		CucumberReportingConfig.reportConfig();
	}
	
}