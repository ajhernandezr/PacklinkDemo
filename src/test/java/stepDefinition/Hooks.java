
package stepDefinition;
 
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utility.utilities;
 
public class Hooks {
	WebDriver driver;

	@Before
	public void beforeScenario() throws MalformedURLException {
		driver = utilities.selectBrowser();
		utilities.setWebDriver(driver);
	
	}
	
	// Close the driver after the test is done
		@After
		public void AfterSteps() {
			this.driver.quit();
		}

	
	
 
}