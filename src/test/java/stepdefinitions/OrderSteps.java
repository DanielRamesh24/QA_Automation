package stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import browserfactory.BrowserInvoke;
import pages.OrderPage;
import utils.Test_Data;
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
		
	}

	@And("Verifies009 the New record created {string} & {string}")
	public void Verifies009_the_New_record_created(String sheetname, String TCID)
			throws InterruptedException, Exception {
		orderrecordcreationpage.verifyCreatedRecord(sheetname, TCID);
		log.info("Verifies009 the New record created with entered valid data");
				
	}

	
	@And("user009 update status field")
	public void user009_update_status_field() throws Exception {
		Thread.sleep(5000);
		orderrecordcreationpage.Details.click();
		String Shippingfield;
		elementYellowHighlight(orderrecordcreationpage.VerifyShippingfield);
		presenceOfElement(driver, By.xpath("(//span[text()='Contract Number'])[2]"));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", orderrecordcreationpage.statusheading);
		Thread.sleep(2000);
		performClick(orderrecordcreationpage.EditbtnShippingAddress);
		Thread.sleep(2000);
		performClick(orderrecordcreationpage.Street);
		Thread.sleep(2000);
		orderrecordcreationpage.Street.sendKeys(Test_Data.Datasheet("Order", 1, 4));
		Thread.sleep(2000);
		orderrecordcreationpage.saveBtn.click();
		Shippingfield = orderrecordcreationpage.VerifyShippingfield.getText();
		if (Shippingfield == Test_Data.Datasheet("Order", 1, 4)) {
			elementLgreenHighlight(orderrecordcreationpage.VerifyShippingfield);
			log.info("Verification & Validation for updation is successful !!!");
		} else
			log.info("Verification & Validation for updation is Failed ");
		
		
	}

	@And("user009 Delete the Order Record")
	public void user009_delete_the_order_record() throws Exception {
		Thread.sleep(5000);
		performClick(orderrecordcreationpage.dropDownb);
		Thread.sleep(2000);
		//performClick(orderrecordcreationpage.dropDownbtn);
		//performClick(orderrecordcreationpage.dropDownbtn);
		driver.navigate().refresh();
		Thread.sleep(5000);
		orderrecordcreationpage.dropDownbtn.click();
		//orderrecordcreationpage.Details.click();
		Thread.sleep(5000);
		orderrecordcreationpage.delbtn.click();
		//orderrecordcreationpage.delbtn.click();
		Thread.sleep(2000);
		orderrecordcreationpage.delConfirm.click();
	    
	}


}