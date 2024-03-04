package stepdefinitions;

import java.io.IOException;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import CommonMethod.baseclass;
import browserfactory.BrowserInvoke;
import pages.ContractPage;
import utils.Test_Data;
import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ContractSteps extends BrowserInvoke {

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	public static ContractPage contractPage = new ContractPage(driver);
	public static BrowserInvoke browser = new BrowserInvoke();
	public static baseclass bc = new baseclass();
	public JavascriptExecutor j = (JavascriptExecutor) driver;

	@Given("User navigates to Contract object")
	public void user_navigates_to_contract_object() throws NullPointerException, InterruptedException, IOException {

		contractPage.AppLauncher();
		presenceOfElement(driver, By.xpath("//h3[text()='Apps']"));
		contractPage.Search.sendKeys("Contracts");
		presenceOfElement(driver, By.xpath("(//b[contains(text(),'Contracts')])[1]"));
		contractPage.Contract.click();
		log.info("user navigated to Contract");
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	@And("clicks on new button")
	public void clicks_on_new_button() throws InterruptedException {
		contractPage.clickingNewbutton();
		log.info("user clicked on new button");
	}

	@When("enters valid date")
	public void enters_valid_date() throws Exception {
		presenceOfElement(driver, By.xpath("//h2[text()='New Contract']"));
		contractPage.AccountName.sendKeys(Test_Data.Datasheet("Contract", 1, 0));
		Thread.sleep(3000);
		contractPage.AccountName.click();
		contractPage.Acconutlookup.click();
		contractPage.ContractTerm.sendKeys(Test_Data.Datasheet("Contract", 1, 1));
		Thread.sleep(3000);
		contractPage.ContractStartDatepicker.click();
		contractPage.ContractStartDate.click();
		contractPage.saveBtn.click();
		log.info("user enters valid data for creating new order record");

	}

	@When("Verifies the New record created")
	public void verifies_the_new_record_created() throws Exception {
		Thread.sleep(5000);
		contractPage.Details.click();
		presenceOfElement(driver, By.xpath("//span[text()='Contract Owner']"));
		Thread.sleep(5000);
		elementYellowHighlight(contractPage.ContractNumber);
		Thread.sleep(5000);
		String AccName;
		Thread.sleep(2000);
		AccName = contractPage.VerifyAccountName.getText();
		if (AccName.equalsIgnoreCase(Test_Data.Datasheet("Contract", 1, 0))) {
			elementLgreenHighlight(contractPage.ContractNumber);
			log.info("Verification & Validation is successful !!!");
		} else
			log.info("Verification & Validation is Failed ");
	}
	
	
	@And("update ContractTerm field")
	public void update_ContractTerm_field() throws Exception {
		String ContractNumber;
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", contractPage.ContractTermfield);
		//presenceOfElement(driver, By.xpath("//span[text()='Contract Owner']"));
		Thread.sleep(5000);
		elementYellowHighlight(contractPage.ContractTermfield);
		Thread.sleep(5000);
		contractPage.dropDownbtn.click();
		Thread.sleep(5000);
		contractPage.editbton.click();
		contractPage.ContractTerm.clear();
		contractPage.ContractTerm.sendKeys(Test_Data.Datasheet("Contract", 1, 2));
		contractPage.saveBtn.click();
		Thread.sleep(5000);
		elementLgreenHighlight(contractPage.ContractTermfield);
		ContractNumber = contractPage.ContractTermfield.getText();
		//AccName = contractPage.VerifyAccountName.getText();
		Thread.sleep(5000);
		if (ContractNumber == Test_Data.Datasheet("Contract", 1, 2)) {
			//elementLgreenHighlight(contractPage.ViewContractterm);
			elementLgreenHighlight(contractPage.ContractTermfield);
			log.info("Verification & Validation for updation is successful !!!");
		} else
			log.info("Verification & Validation for updation is Failed ");
		
		
		
	}
	


	@When("Delete the Record")
	public void delete_the_record() throws Exception {
		Thread.sleep(2000);
		contractPage.dropDownbtn.click();
		Thread.sleep(2000);
		contractPage.delbtn.click();
		Thread.sleep(2000);
		contractPage.delConfirm.click();
	}
}
