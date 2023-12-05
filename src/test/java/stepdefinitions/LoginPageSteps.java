package stepdefinitions;



import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.xml.LaunchSuite;

import apphooks.ApplicationHooks;
import browserfactory.BrowerInvoke;
import browserfactory.BrowserFactory;
import cucumber.api.java.Before;
import pages.ContractPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelUtils;
import utils.Test_Date;
import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageSteps extends  BrowerInvoke {
	

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	LoginPage loginpage = new LoginPage(driver);
	BrowerInvoke browser = new BrowerInvoke();
	
	
	
	@Given("the user navigates to the URL")
	public void user_navigates_to_the_url() throws Exception {
			browser.launch();//Launch browser
			System.out.println("driver");
			driver.get(Test_Date.Datasheet("LoginPage", 1, 0));
	}

      @And("the user enters valid credential")
     public void the_user_enters_valid_credential() throws Exception {
    	  	LoginPage loginpage = new LoginPage(driver);
    	  	loginpage.enterUserName(Test_Date.Datasheet("LoginPage", 1, 1));
    	  	loginpage.enterPassword(Test_Date.Datasheet("LoginPage", 1, 2));
    
    }
	
	@And("clicks Login button")
	public void clicks_login_button() throws InterruptedException {
			LoginPage loginpage = new LoginPage(driver);
			//ContractPage Contractrecordcreationpage = new ContractPage(driver);
			loginpage.clickOnLogin(); 
			log.info("user clicked login button");
	}
}