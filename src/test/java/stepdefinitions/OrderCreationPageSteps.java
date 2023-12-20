package stepdefinitions;



import org.apache.log4j.Logger;

import browserfactory.BrowerInvoke;
import browserfactory.BrowserFactory;
import pages.ContractPage;
import pages.OrderCreationPage;
	

import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


public class OrderCreationPageSteps extends BrowerInvoke{
		
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		OrderCreationPage orderrecordcreationpage = new OrderCreationPage(driver);
		
	//	OrderCreationPage orderrecordcreationpage = new OrderCreationPage(BrowserFactory.getDriver());
	//	ContractPage contractPage = new ContractPage(driver);
		BrowerInvoke browser = new BrowerInvoke();
		
		@When("User009 navigates to order object")
		public void user009_navigates_to_order_object() throws InterruptedException, NullPointerException {
			
		//	System.out.println(driver);
		
			orderrecordcreationpage.navigateOrder();
			log.info("user009 navigated to Orders");
		}
		@And("User009 clicks on new button")
		public void user009_clicks_on_new_button() throws InterruptedException {
			orderrecordcreationpage.clickingNewbutton();
			log.info("user009 clicked on new button");
		}
		
		  @And("User009 enters valid data {string} & {string}") 
		  public void
		  User009_enters_valid_data(String sheetname, String TCID) throws InterruptedException, Exception {
		  orderrecordcreationpage.creatingNewRecord(sheetname, TCID);
		  log.info("user009 enters valid data for creating new order record"); 
		  }
		  @And("User009 clicks on save button")
		  public void user009_clicks_on_save_button() throws InterruptedException {
		  	orderrecordcreationpage.clickingSavebutton();
		      log.info("User009 clicked on save button");
		  }
		 
		  @And("Verifies009 the New record created {string} & {string}") 
		  public void
		  Verifies009_the_New_record_created(String sheetname, String TCID) throws InterruptedException, Exception {
		  orderrecordcreationpage.verifyCreatedRecord(sheetname, TCID);
		  log.info("Verifies009 the New record created with entered valid data"); 
		  }
			
		
}