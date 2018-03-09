package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.shipments;
import utility.utilities;

public class Shipments_Steps {
	WebDriver driver = utilities.getDriver();

	shipments shipmentsObject = new shipments(driver);

	@When("^performing a search with the following information:Madrid -> \"([^\"]*)\"\\. One parcel, (\\d+) kg, (\\d+) cm x (\\d+) cm x (\\d+) cm\\.$")
	public void performing_a_search_with_the_following_information_Madrid_One_parcel_kg_cm_x_cm_x_cm(String postal, int weight, int width, int height, int length) throws Throwable {
		//Check Shipment page is displayed
		AssertJUnit.assertTrue(shipmentsObject.getShipmentsPage().isDisplayed());
		// Perform the search with the package parameters
		shipmentsObject.perfomShipmentSearch(postal,weight,width,height,length);
		
		

	}

	@Then("^it will select the first service (\\d+) of the list$")
	public void it_will_select_the_first_service_of_the_list(int selectShipment) throws Throwable {
		// Select the service
		shipmentsObject.perfomSelectPackage(selectShipment);
	}
	
	@When("^a service has been selected \"([^\"]*)\" and (\\d+)$")
	public void a_service_has_been_selected(String packet, int selectShipment) throws Throwable {
		// Check Shipment page is displayed
		AssertJUnit.assertTrue(shipmentsObject.getShipmentsPage().isDisplayed());
		// Perform the search with the package parameters
		shipmentsObject.perfomShipmentDefaultSearch(packet);
		// Select the service
		shipmentsObject.perfomSelectPackage(selectShipment);
	}

	@Then("^it will save the shipment as a draft$")
	public void it_will_save_the_shipment_as_a_draft() throws Throwable {
		// Save the shipment
		shipmentsObject.performSaveShipment();

	}

	@Then("^it will appear in the shipment list \"([^\"]*)\"$")
	public void it_will_appear_in_the_shipment_list(String packet) throws Throwable {

		// Check Shipment page is displayed
		AssertJUnit.assertTrue(shipmentsObject.getShipmentsPage().isDisplayed());
		// Check the saved shipment appears in the shipment list
		shipmentsObject.checkSavedShipment(packet);
	}

}