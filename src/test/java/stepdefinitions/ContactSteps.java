package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import CommonMethod.baseclass;
import browserfactory.BrowserInvoke;
import helper.LoggerHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;
import utils.Test_Data;

public class ContactSteps extends BrowserInvoke {
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	
	public ContactPage contactPage = new ContactPage(driver);
	BrowserInvoke browser = new BrowserInvoke();
		
	
	@Given("user is logged in and clicks the contact tab") 
	public void user_is_logged_in_and_clicks_the_contact_tab() throws InterruptedException {
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		baseclass.javaexeClick(contactPage.getContTab());
	}

	@When("The user able to hit New button")
	public void the_user_able_to_hit_new_button() throws InterruptedException {
		Thread.sleep(10000);
		baseclass.javaexeClick(contactPage.getNewconBtn());
	}

	@Then("The user should able to fill the required fields and save the contact")
	public void the_user_should_able_to_fill_the_required_fields_and_save_the_contact() throws Exception{
		Thread.sleep(10000);
		contactPage.filldata(Test_Data.Datasheet("Contact", 1, 0), Test_Data.Datasheet("Contact", 1, 1), Test_Data.Datasheet("Contact", 1, 2));
		baseclass.javaexeClick(contactPage.getSelAccount());
		baseclass.javaexeClick(contactPage.getSaveBtn());
		baseclass.javaexeClick(contactPage.getDeatilTab());
	
	}


}
