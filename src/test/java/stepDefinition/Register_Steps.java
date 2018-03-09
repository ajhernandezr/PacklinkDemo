package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.register;
import utility.utilities;

public class Register_Steps {
	WebDriver driver = utilities.getDriver();

	register registerObject = new register(driver);


	@Given("^an internet user \"([^\"]*)\"$")
	public void an_internet_user(String username) throws Throwable {

		System.out.println("Following User will be used in the process " + username);

	}

	@When("^going to https://pro\\.packlink\\.es/registro$")
	public void going_to_https_pro_packlink_es_registro() throws Throwable {
		// Check register page is displayed
		AssertJUnit.assertTrue(registerObject.getRegisterPage().isDisplayed());

	}

	@Then("^it will see the registration form WITH (\\d+) required fields$")
	public void it_will_see_the_registration_form_WITH_required_fields(int arg1) throws Throwable {
		// Check the form elements are displayed
		registerObject.checkElements();

	}

	@When("^registered in https://pro\\.packlink\\.es WITH credentials \"([^\"]*)\" and random \"([^\"]*)\"$")
	public void registered_in_https_pro_packlink_es_WITH_credentials_and_random(String username, String password)
			throws Throwable {
		// Check register page is displayed and fill all the fields for a new user
		registerObject.getRegisterPage();
		registerObject.registerNewUser(username, password);
	}

	
	@Given("^a registered client \"([^\"]*)\" and \"([^\"]*)\"$")
	public void a_registered_client_and(String username, String password) throws Throwable {
		// Check home is displayed and perform the Login
		AssertJUnit.assertTrue(registerObject.getRegisterPage().isDisplayed());
		registerObject.fillLogin(username, password);

	}
	
}