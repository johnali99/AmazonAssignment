package stepDefinition;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base{

	@Before
	public void BeforeHooks(Scenario scenario) {
		
		//gets the scenario name
		logger.info("Scenario "+ scenario.getName() + " started");
		browser();
		openBrowser();
	}
	
	@After
	public void AfterHooks(Scenario scenario) throws InterruptedException {
		
		tearDown();
		//Gives the status in console whether the scenario is PASSED or FAILED
		logger.info("Scenario " + scenario.getName() + " " + scenario.getStatus());
		
	}
}
