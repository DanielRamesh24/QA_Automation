package stepdefinitions;

import org.apache.log4j.Logger;
import browserfactory.BrowserInvoke;
import pages.LoginPage;
import utils.Test_Data;
import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginSteps extends BrowserInvoke {

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	LoginPage loginpage = new LoginPage(driver);
	BrowserInvoke browser = new BrowserInvoke();

	@Given("the user navigates to the URL")
	public void user_navigates_to_the_url() throws Exception {
		browser.launch();// Launch browser
		driver.get(Test_Data.Datasheet("LoginPage", 1, 0));
	}

	@And("the user enters valid credential")
	public void the_user_enters_valid_credential() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(Test_Data.Datasheet("LoginPage", 1, 1));
		loginpage.enterPassword(Test_Data.Datasheet("LoginPage", 1, 2));

	}

	@And("clicks Login button")
	public void clicks_login_button() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		// ContractPage Contractrecordcreationpage = new ContractPage(driver);
		loginpage.clickOnLogin();
		log.info("user clicked login button");

	}
}