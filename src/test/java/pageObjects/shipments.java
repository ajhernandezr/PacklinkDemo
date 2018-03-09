package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import utility.utilities;

public class shipments {

	WebDriver driver;

	/// Web elements used

	@FindBy(xpath = ".//main[@class='eb-main ng-scope']")

	WebElement shipmentsPage;

	@FindBy(xpath = ".//nav[@class='eb-add-shipment']")

	WebElement createShipmentButton;

	@FindBy(id = "openCreateShipmentFromHeader")

	WebElement addShipmentButton;

	@FindBy(id = "postalcodeto")

	WebElement postalCodeTo;

	@FindBy(xpath = ".//ul[@class='dropdown-menu ng-isolate-scope ng-hide']")

	WebElement postalCodeToElement;

	@FindBy(xpath = ".//div[@class='eb-field eb-create-parcels__custom-parcels-fld']")

	WebElement customPackageSelect;

	@FindBy(xpath = ".//span[text()='Paquete personalizado']")

	WebElement customPackage;

	@FindBy(id = "length")

	WebElement packetLength;

	@FindBy(id = "width")

	WebElement packetWidth;

	@FindBy(id = "height")

	WebElement packetHeight;

	@FindBy(id = "weight")

	WebElement packetWeight;

	@FindBy(xpath = ".//button[@class='eb-create-shipment__submit-btn ng-binding']")

	WebElement obtainPrices;

	@FindBy(xpath = ".//header[@class='eb-shipment__header']")

	WebElement createShipmentPage;

	@FindBy(xpath = ".//header[@class='eb-shipment-section__header eb-shipment-section__header--service']")

	WebElement selectServicSection;

	@FindBy(xpath = ".//button[@class='eb-quote__call-to-action']")

	List<WebElement> selectService;

	@FindBy(xpath = ".//button[@class='eb-shipment__close-btn tr-createFlow--save ng-binding']")

	WebElement saveShipmentButton;

	@FindBy(xpath = ".//td[@class='eb-shipments-table__cell tr-shipments-table--opendetails']")

	List<WebElement> savedShipments;

	public shipments(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Check got to Shipments page

	public WebElement getShipmentsPage() {
		utilities.waitForElement(shipmentsPage);
		return shipmentsPage;

	}

	// Get to Create shipment page
	public void goToCreateShipmentPage() {

		utilities.waitForElement(createShipmentButton);
		createShipmentButton.click();
		addShipmentButton.click();
	}

	// Create a Custom package and obtain the prices
	public void createCustomShipment(String postal, int weight, int width, int height, int length) {

		utilities.waitForElement(createShipmentPage);
		postalCodeTo.sendKeys(postal);
		utilities.smallPause();

		customPackageSelect.click();
		customPackage.click();
		packetWeight.sendKeys("" + weight);
		packetWidth.sendKeys("" + width);
		packetHeight.sendKeys("" + height);
		packetLength.sendKeys("" + length);
		obtainPrices.click();

	}

	// Create a standard package and obtain the prices
	public void createDefaultShipment(String packet) {

		utilities.waitForElement(createShipmentPage);
		postalCodeTo.sendKeys(packet);
		utilities.smallPause();
		customPackageSelect.click();

		
		obtainPrices.click();

	}

	// Select the service
	public void selectServicePacket() {

		utilities.waitForElement(selectServicSection);

		selectService.get(0).click();
	}

	// Save the shipment
	public void saveShipment() {

		utilities.waitForElement(saveShipmentButton);

		saveShipmentButton.click();
	}

	// Check the saved shipment
	public void checkSavedShipment(String packet) {
		// There must be at least one saved shipment, the last one is the most
		// recent saved one
		utilities.waitForElement(savedShipments.get(0));

		AssertJUnit.assertTrue(savedShipments.get(0).getText().contains(packet));
	}

	/**
	 * 
	 * This POM method will be used for perform the shipment
	 * 
	 * @param length
	 * @param height
	 * @param width
	 * @param weight
	 * @param postal
	 * 
	 * 
	 * @throws Exception
	 * 
	 * 
	 */

	public void perfomShipmentSearch(String postal, int weight, int width, int height, int length) throws Exception {

		try {

			// Get to Create shipment page
			this.goToCreateShipmentPage();
			// Create a Custom package and obtain the prices
			this.createCustomShipment(postal, weight, width, height, length);

		} catch (Exception e) {

			throw (e);
		}
	}

	/**
	 * 
	 * This POM method will be used for perform the selection of the shipment
	 * 
	 * 
	 * 
	 * @throws Exception
	 * 
	 * 
	 */

	public void perfomSelectPackage(int selectShipment) throws Exception {

		try {

			// Select the service
			this.selectServicePacket();

		} catch (Exception e) {

			throw (e);
		}
	}

	/**
	 * 
	 * This POM method will be used for perform the shipment of created packet
	 * 
	 * @param postal
	 * 
	 * @throws Exception
	 * 
	 */

	public void perfomShipmentDefaultSearch(String packet) throws Exception {

		try {

			// Get to Create shipment page
			this.goToCreateShipmentPage();
			// Create a Custom package and obtain the prices
			this.createDefaultShipment(packet);

		} catch (Exception e) {

			throw (e);
		}
	}

	/**
	 * 
	 * This POM method will be used for perform the shipment of created packet
	 * 
	 * @throws Exception
	 *             *
	 */

	public void performSaveShipment() throws Exception {

		try {

			// Get to Save
			this.saveShipment();

		} catch (Exception e) {

			throw (e);
		}
	}
	/**
	 * 
	 * This POM method will be used for check the created packet
	 * 
	 * @throws Exception
	 *             *
	 */
	// Check the saved shipment
	public void performCheckSavedShipment(String packet) throws Exception {

		try {

			// Check the saved shipment
			this.checkSavedShipment(packet);

		} catch (Exception e) {

			throw (e);
		}
	}
}