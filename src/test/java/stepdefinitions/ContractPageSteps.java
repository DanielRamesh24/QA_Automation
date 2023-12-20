package stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import CommonMethod.baseclass;
import abstractclass.DriverClass;
import browserfactory.BrowerInvoke;
import browserfactory.BrowserFactory;
import pages.ContractPage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.SeleniumUtils;
import utils.Test_Date;
import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContractPageSteps extends BrowerInvoke {
	
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		ContractPage contractPage = new ContractPage(driver);
		BrowerInvoke browser = new BrowerInvoke();
			
		@Given("User navigates to Contract object")
		public void user_navigates_to_contract_object() throws NullPointerException, InterruptedException{	
//			ContractPage Cp = new ContractPage(driver);
//			System.out.println(driver);
//			Cp.navigate_to_contractObj();
			contractPage.navigate_to_contractObj();
			
			log.info("user navigated to Contract");
		}
		
		
		@And("clicks on new button")
		public void clicks_on_new_button() throws InterruptedException {
//			ContractPage cp1 = new ContractPage(driver);
//			cp1.clickingNewbutton();
			contractPage.clickingNewbutton();
			log.info("user clicked on new button");
		}
		
		@When("enters valid date")
		public void enters_valid_date() throws Exception {
			//ContractPage cp2 = new ContractPage(driver);
			contractPage.AccountName.sendKeys(Test_Date.Datasheet("Contract", 1, 0));
		  Thread.sleep(3000);
		  contractPage.AccountName.click();
		  contractPage.Acconutlookup.click();
		  contractPage.ContractTerm.sendKeys("1");
		  Thread.sleep(3000);
		  contractPage.ContractStartDatepicker.click();
		  contractPage.ContractStartDate.click();
		  contractPage.saveBtn.click();
		  log.info("user enters valid data for creating new order record");

		}
		

       @When("Verifies the New record created")
       public void verifies_the_new_record_created() throws Exception {
    	  // ContractPage cp3 = new ContractPage(driver);
    	   	Thread.sleep(5000);
    	   	contractPage.Details.click();
    	    String AccName ; 
    	    Thread.sleep(2000);
			AccName = contractPage.VerifyAccountName.getText();
			if(AccName.equalsIgnoreCase(Test_Date.Datasheet("Contract", 1, 0))) {
				  log.info("Verification & Validation is successful !!!"); 
			  }
			 else
				  log.info("Verification & Validation is Failed "); 
       }
       
       @When("update ContractTerm field")
       public void update_ContractTerm_field()throws Exception {
    	//   ContractPage Contractrecordcreationpage = new ContractPage(driver);
    	   String ContractNumber;
    	   Thread.sleep(5000);
    	   contractPage.dropDownbtn.click();
    	   Thread.sleep(5000);
    	   contractPage.editbton.click(); 
    	   contractPage.ContractTerm.clear();
    	   contractPage.ContractTerm.sendKeys("2");
    	   contractPage.saveBtn.click();
    	   ContractNumber = contractPage.ContractTerm.getText();
    	   System.out.println(ContractNumber);
    	   if(ContractNumber == "2") {
				  log.info("Verification & Validation for updation is successful !!!"); 
			  }
    	   else
				  log.info("Verification & Validation for updation is Failed "); 
       }
 		 
       
       @When("Delete the Record")
       public void delete_the_record() throws Exception{
    	 //  ContractPage cp5 = new ContractPage(driver);
    	   Thread.sleep(2000);
    	   contractPage.dropDownbtn.click();
    	   Thread.sleep(2000);
    	   contractPage.delbtn.click();
    	   Thread.sleep(2000);
    	   contractPage.delConfirm.click();
       }
}
		  
