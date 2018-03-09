package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.onboarding;
import utility.utilities;

public class Onboarding_Steps {
	WebDriver driver = utilities.getDriver();

	onboarding onboardingObject = new onboarding(driver);
	
	
	@Then("^it will land into the onboarding process$")
	public void it_will_land_into_the_onboarding_process() throws Throwable {
		// Check onboarding page is displayed
		onboardingObject.getOnboardingPage();
		AssertJUnit.assertTrue(onboardingObject.getOnboardingPage().isDisplayed());

	}


	@When("^accessing for the first time$")
	public void accessing_for_the_first_time() throws Throwable {
		// Check Onboarding page is displayed and proceed to the next page
		AssertJUnit.assertTrue(onboardingObject.getOnboardingPage().isDisplayed());
		onboardingObject.performOnboardingNextPage();
	}

	@Then("^it will complete the onboarding process with the following Parameters and perform the \"([^\"]*)\"$")
	public void it_will_complete_the_onboarding_process_with_the_following_Parameters_and_perform_the(int Scenario,
			DataTable Parameters) throws Throwable {
		// Check Onboarding direction page is displayed,pass the table with
		// parameters and fill the parameters and proceed to the next page

		AssertJUnit.assertTrue(onboardingObject.getOnboardingDirectionPage().isDisplayed());

		onboardingObject.performOnboardingFillDirection(Scenario, Parameters);

		// Check Onboarding packet details page is displayed, fill the
		// parameters and proceed to the next page
		AssertJUnit.assertTrue(onboardingObject.getOnboardingPacketPage().isDisplayed());
		onboardingObject.performOnboardingPacketInformation(Scenario, Parameters);

		// Check Onboarding end page is displayed
		AssertJUnit.assertTrue(onboardingObject.getOnboardingEndSection().isDisplayed());
	}

	

}