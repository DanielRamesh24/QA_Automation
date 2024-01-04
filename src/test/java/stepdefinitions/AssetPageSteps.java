package stepdefinitions;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import CommonMethod.baseclass;
import abstractclass.DriverClass;
import browserfactory.BrowserInvoke;
import browserfactory.BrowserFactory;
import pages.AssetPage;
import pages.ContractPage;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.SeleniumUtils;
import utils.Test_Data;
import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AssetPageSteps extends BrowserInvoke {

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	AssetPage assetPage = new AssetPage(driver);
	BrowserInvoke browser = new BrowserInvoke();

	@Given("User007 navigates to Asset object")
	public void User007_navigates_to_asset_object() throws NullPointerException, InterruptedException{	
		AssetPage ap = new AssetPage(driver);
		System.out.println(driver);
		ap.navigate_to_assetObj();

		log.info("User007 navigated to Asset");
	}


	@And("User007 clicks on new button")
	public void User007_clicks_on_new_button() throws InterruptedException {
		AssetPage ap1 = new AssetPage(driver);
		ap1.clickingNewbutton();
		log.info("User007 clicked on new button");
	}

	@And("User007 enters valid data")
	public void User007_enters_valid_data() throws Exception {
		AssetPage ap2 = new AssetPage(driver);
		Thread.sleep(3000);
		ap2.AssetName.sendKeys(Test_Data.Datasheet("Asset", 1, 0));
		Thread.sleep(3000);
		ap2.AccountClick.sendKeys(Test_Data.Datasheet("Asset", 1, 1));
		Thread.sleep(3000);
		ap2.AccountClick.sendKeys(Keys.ARROW_DOWN);
		ap2.AccountClick.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		ap2.AccountClick.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		ap2.ContactClick.sendKeys(Test_Data.Datasheet("Asset", 1, 2));
		Thread.sleep(3000);
		ap2.ContactClick.sendKeys(Keys.ARROW_DOWN);
		ap2.ContactClick.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		ap2.ContactClick.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		ap2.saveBtn.click();
		Thread.sleep(3000);
		log.info("User007 enters valid data for creating new order record");

	}


//	@When("Verifies the New record created")
//	public void verifies_the_new_record_created() throws Exception {
//		ContractPage cp3 = new ContractPage(driver);
//		Thread.sleep(5000);
//		cp3.Details.click();
//		String AccName ; 
//		Thread.sleep(2000);
//		AccName = cp3.VerifyAccountName.getText();
//		if(AccName.equalsIgnoreCase(Test_Date.Datasheet("Contract", 1, 0))) {
//			log.info("Verification & Validation is successful !!!"); 
//		}
//		else
//			log.info("Verification & Validation is Failed "); 
//	}
//
//	@When("update ContractTerm field")
//	public void update_ContractTerm_field()throws Exception {
//		ContractPage Contractrecordcreationpage = new ContractPage(driver);
//		String ContractNumber;
//		Thread.sleep(5000);
//		Contractrecordcreationpage.dropDownbtn.click();
//		Thread.sleep(5000);
//		Contractrecordcreationpage.editbton.click(); 
//		Contractrecordcreationpage.ContractTerm.clear();
//		Contractrecordcreationpage.ContractTerm.sendKeys("2");
//		Contractrecordcreationpage.saveBtn.click();
//		ContractNumber = Contractrecordcreationpage.ContractTerm.getText();
//		System.out.println(ContractNumber);
//		if(ContractNumber == "2") {
//			log.info("Verification & Validation for updation is successful !!!"); 
//		}
//		else
//			log.info("Verification & Validation for updation is Failed "); 
//	}
//
//
//	@When("Delete the Record")
//	public void delete_the_record() throws Exception{
//		ContractPage cp5 = new ContractPage(driver);
//		Thread.sleep(2000);
//		cp5.dropDownbtn.click();
//		Thread.sleep(2000);
//		cp5.delbtn.click();
//		Thread.sleep(2000);
//		cp5.delConfirm.click();
//	}
}

