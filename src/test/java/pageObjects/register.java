package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import utility.utilities;

public class register {

	WebDriver driver;

	/// Web elements used

	@FindBy(xpath = ".//div[@class='header__logo js-logo']")

	WebElement registerHome;

	@FindBy(id = "signUpFormEmail")

	WebElement email;

	@FindBy(id = "signUpFormPassword")

	WebElement passwordField;

	@FindBy(xpath = ".//select[@id='signUpFormShipments']")

	WebElement monthlyShipment;

	@FindBy(xpath = ".//select[@id='signUpFormShipments']/parent::div")

	WebElement monthlyShipmentVisible;

	@FindBy(xpath = ".//select[@id='signUpFormEcommerce']")

	WebElement platform;

	@FindBy(xpath = ".//select[@id='signUpFormEcommerce']/parent::div")

	WebElement platformVisible;

	@FindBy(id = "signUpFormMarketplace")

	WebElement marketPlace;

	@FindBy(xpath = ".//select[@id='signUpFormMarketplace']/parent::div")

	WebElement marketPlaceVisible;

	@FindBy(id = "signUpFormPhone")

	WebElement phone;

	@FindBy(xpath = ".//*[@class='button button--primary h-mt-m']")

	WebElement registerButton;

	@FindBy(xpath = ".//main[@class='eb-onboarding ng-scope']")

	WebElement onboardingSection;

	@FindBy(xpath = ".//a[@title='Acceder']")

	WebElement loginButton;

	@FindBy(xpath = ".//input[@id='signInFormUser']")

	WebElement emailLoginField;

	@FindBy(xpath = ".//input[@id='signInFormPassword']")

	WebElement passwordLoginField;

	@FindBy(id = "signInFormButton")

	WebElement enterButton;

	public register(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Check all the elements are displayed in the page

	public void checkElements() {

		utilities.waitForElement(email);
		AssertJUnit.assertTrue(email.isDisplayed());
		utilities.waitForElement(passwordField);
		AssertJUnit.assertTrue(passwordField.isDisplayed());
		utilities.waitForElement(monthlyShipmentVisible);
		AssertJUnit.assertTrue(monthlyShipmentVisible.isDisplayed());
		utilities.waitForElement(platformVisible);
		AssertJUnit.assertTrue(platformVisible.isDisplayed());
		utilities.waitForElement(marketPlaceVisible);
		AssertJUnit.assertTrue(marketPlaceVisible.isDisplayed());
		utilities.waitForElement(phone);
		AssertJUnit.assertTrue(phone.isDisplayed());

	}

	// Fill the credentials

	public void fillRegisterFields(String username, String password) {

		utilities.waitForElement(email);
		email.sendKeys(username);
		utilities.waitForElement(passwordField);
		passwordField.sendKeys(password);
		utilities.waitForElement(monthlyShipmentVisible);
		Select selectMonthlyShipment = new Select(monthlyShipment);
		selectMonthlyShipment.selectByVisibleText("1 - 10");
		utilities.smallPause();
		utilities.waitForElement(platformVisible);
		Select selectPlatform = new Select(platform);
		selectPlatform.selectByVisibleText("PrestaShop");
		utilities.smallPause();
		utilities.waitForElement(marketPlaceVisible);
		Select selectMarketPlace = new Select(marketPlace);
		selectMarketPlace.selectByVisibleText("Amazon");
		utilities.smallPause();
		utilities.waitForElement(phone);
		phone.sendKeys("22222");
		utilities.waitForElement(registerButton);
		registerButton.click();

	}

	// Perform a login

	public void fillLogin(String username, String password) {

		utilities.waitForElement(loginButton);
		loginButton.click();

		utilities.waitForElement(emailLoginField);
		emailLoginField.sendKeys(username);
		passwordLoginField.sendKeys(password);

		enterButton.click();

	}

	// Confirm got to register home page

	public WebElement getRegisterPage() {
		utilities.waitForElement(registerHome);
		return registerHome;

	}

	/**
	 * 
	 * This POM method will be used for check the registration form elements
	 * 
	 * @param testName
	 * @throws Exception
	 * 
	 * 
	 */

	public void getToHome() throws Exception {

		try {

			// Fill the Credentials
			this.checkElements();

		} catch (Exception e) {
			// Log the info for the report

			throw (e);
		}
	}

	/**
	 * 
	 * This POM method will be used for get to home and register a new user
	 * 
	 * @param testName
	 * @throws Exception
	 * 
	 * 
	 */

	public void registerNewUser(String username, String password) throws Exception {

		try {

			// Fill the Credentials
			this.fillRegisterFields(username, password);

		} catch (Exception e) {

			throw (e);
		}
	}

}