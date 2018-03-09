package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import cucumber.api.DataTable;
import utility.utilities;

public class onboarding {

	WebDriver driver;

	/// Web elements used

	@FindBy(xpath = ".//main[@class='eb-onboarding ng-scope']")

	WebElement onboardingSection;

	@FindBy(id = "btn-welcomenew-next")

	WebElement nextButton;

	@FindBy(xpath = ".//section[@class='eb-onboarding__section eb-onboarding__section__warehouse ng-scope is-active']")

	WebElement onboardingDirectionSection;

	@FindBy(id = "warehouse-name")

	WebElement directionName;

	@FindBy(id = "sender-name")

	WebElement senderName;

	@FindBy(id = "sender-surname")

	WebElement senderSurname;

	@FindBy(id = "from-company")

	WebElement companyName;

	@FindBy(id = "postalcode")

	WebElement postalCode;

	@FindBy(id = "address")

	WebElement address;

	@FindBy(id = "warehouse-form-submit")

	WebElement saveDirectionButton;

	@FindBy(xpath = ".//section[@class='eb-onboarding__section eb-onboarding__section__parcel ng-scope is-active']")

	WebElement onboardingPacketSection;

	@FindBy(id = "parcel-name")

	WebElement packetName;

	@FindBy(id = "length")

	WebElement packetLength;

	@FindBy(id = "width")

	WebElement packetWidth;

	@FindBy(id = "height")

	WebElement packetHeight;

	@FindBy(id = "weight")

	WebElement packetWeight;

	@FindBy(id = "parcel-form-submit")

	WebElement savePacketButton;

	@FindBy(xpath = ".//section[@class='eb-onboarding__section eb-onboarding__section--end ng-scope is-active']")

	WebElement onboardingEndSection;

	public onboarding(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Check got to Onboard page

	public WebElement getOnboardingPage() {
		utilities.waitForElement(onboardingSection);
		return onboardingSection;

	}

	// Check got to onboardingDirectionSection page

	public WebElement getOnboardingDirectionPage() {
		utilities.waitForElement(onboardingDirectionSection);
		return onboardingDirectionSection;

	}

	// Check got to onboardingPacketSection page

	public WebElement getOnboardingPacketPage() {
		utilities.waitForElement(onboardingPacketSection);
		return onboardingPacketSection;

	}

	// Check got to onboardingPacketSection page

	public WebElement getOnboardingEndSection() {
		utilities.waitForElement(onboardingEndSection);
		return onboardingEndSection;

	}

	// Get to next page
	public void goToNextPage() {

		nextButton.click();

	}

	// Fill the direction elements
	public void fillDirection(DataTable parameters, int scenario) {

		List<Map<String, String>> data = parameters.asMaps(String.class, String.class);

		int Row = scenario;
		directionName.clear();
		directionName.sendKeys(data.get(Row).get("Direction"));
		senderName.sendKeys(data.get(Row).get("Name"));
		senderSurname.sendKeys(data.get(Row).get("Surname"));
		companyName.sendKeys(data.get(Row).get("Company"));
		postalCode.sendKeys(data.get(Row).get("Postal"));
		utilities.smallPause();
		directionName.click();
		address.sendKeys(data.get(Row).get("Address"));
		saveDirectionButton.click();

	}

	// Fill the packet information
	public void fillPacketInformation(DataTable parameters, int scenario) {
		List<Map<String, String>> data = parameters.asMaps(String.class, String.class);

		int Row = scenario;

		packetName.clear();
		packetName.sendKeys(data.get(Row).get("Packet"));
		packetWeight.sendKeys(data.get(Row).get("Weight"));
		packetWidth.sendKeys(data.get(Row).get("Width"));
		packetHeight.sendKeys(data.get(Row).get("Height"));
		packetLength.sendKeys(data.get(Row).get("Length"));

		savePacketButton.click();

	}

	/**
	 * 
	 * This POM method will be used for perform the onboarding go to next page
	 * 
	 * @param testName
	 * @throws Exception
	 * 
	 * 
	 */

	public void performOnboardingNextPage() throws Exception {

		try {

			// Fill the Direction
			this.goToNextPage();

		} catch (Exception e) {

			throw (e);
		}
	}

	/**
	 * 
	 * This POM method will be used for perform the onboarding fill direction
	 * 
	 * @param scenario
	 * @param parameters
	 * 
	 * @param testName
	 * @throws Exception
	 * 
	 * 
	 */

	public void performOnboardingFillDirection(int scenario, DataTable parameters) throws Exception {

		try {

			// Fill the Direction
			this.fillDirection(parameters, scenario);

		} catch (Exception e) {

			throw (e);
		}
	}

	/**
	 * 
	 * This POM method will be used for perform the onboarding packet
	 * information
	 * 
	 * @param parameters
	 * @param scenario
	 * 
	 * @param testName
	 * @throws Exception
	 * 
	 * 
	 */

	public void performOnboardingPacketInformation(int scenario,DataTable parameters) throws Exception {

		try {

			// Fill the packet information
			this.fillPacketInformation(parameters,scenario);

		} catch (Exception e) {

			throw (e);
		}
	}

}