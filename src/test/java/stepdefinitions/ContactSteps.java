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
	public static baseclass base = new baseclass();
	
	
	@Given("user is logged in and clicks the contact tab") 
	public void user_is_logged_in_and_clicks_the_contact_tab() throws InterruptedException {
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		base.javaexeClick(contactPage.getContTab());
	}

	@When("The user able to hit New button")
	public void the_user_able_to_hit_new_button() throws InterruptedException {
		Thread.sleep(10000);
		base.javaexeClick(contactPage.getNewconBtn());
	}

	@Then("The user should able to fill the required fields and save the contact")
	public void the_user_should_able_to_fill_the_required_fields_and_save_the_contact() throws Exception{
		Thread.sleep(10000);
		contactPage.filldata(Test_Data.Datasheet("Contact", 1, 0), Test_Data.Datasheet("Contact", 1, 1), Test_Data.Datasheet("Contact", 1, 2));
	    base.javaexeClick(contactPage.getSelAccount());
	    base.javaexeClick(contactPage.getSaveBtn());
	    base.javaexeClick(contactPage.getDeatilTab());
	
	}


}
