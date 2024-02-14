package stepdefinitions;

import org.apache.log4j.Logger;

import browserfactory.BrowserInvoke;
import pages.OrderPage;

import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class OrderSteps extends BrowserInvoke {

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	OrderPage orderrecordcreationpage = new OrderPage(driver);

	//BrowserInvoke browser = new BrowserInvoke();

	@When("User009 navigates to order object")
	public void user009_navigates_to_order_object() throws InterruptedException, NullPointerException {

		orderrecordcreationpage.navigateOrder();
		log.info("user009 navigated to Orders");
	}

	@And("User009 clicks on new button")
	public void user009_clicks_on_new_button() throws InterruptedException {
		orderrecordcreationpage.clickingNewbutton();
		log.info("user009 clicked on new button");
	}

	@And("User009 enters valid data {string} & {string}")
	public void User009_enters_valid_data(String sheetname, String TCID) throws InterruptedException, Exception {
		orderrecordcreationpage.creatingNewRecord(sheetname, TCID);
		log.info("user009 enters valid data for creating new order record");
	}

	@And("User009 clicks on save button")
	public void user009_clicks_on_save_button() throws InterruptedException {
		orderrecordcreationpage.clickingSavebutton();
		log.info("User009 clicked on save button");
		driver.quit();
		log.info("current browser is closed");
	}

	@And("Verifies009 the New record created {string} & {string}")
	public void Verifies009_the_New_record_created(String sheetname, String TCID)
			throws InterruptedException, Exception {
		orderrecordcreationpage.verifyCreatedRecord(sheetname, TCID);
		log.info("Verifies009 the New record created with entered valid data");
				
	}

}