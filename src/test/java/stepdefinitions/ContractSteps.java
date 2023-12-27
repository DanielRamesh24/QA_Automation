package stepdefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import CommonMethod.baseclass;
import browserfactory.BrowerInvoke;
import pages.ContractPage;
import utils.Test_Date;
import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ContractSteps extends BrowerInvoke {

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	public static ContractPage contractPage = new ContractPage(driver);
	public static BrowerInvoke browser = new BrowerInvoke();
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
		Thread.sleep(3000);
	}

	@And("clicks on new button")
	public void clicks_on_new_button() throws InterruptedException {
		contractPage.clickingNewbutton();
		log.info("user clicked on new button");
	}

	@When("enters valid date")
	public void enters_valid_date() throws Exception {
		presenceOfElement(driver, By.xpath("//h2[text()='New Contract']"));
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
		Thread.sleep(5000);
		contractPage.Details.click();
		String AccName;
		Thread.sleep(2000);
		AccName = contractPage.VerifyAccountName.getText();
		if (AccName.equalsIgnoreCase(Test_Date.Datasheet("Contract", 1, 0))) {
			log.info("Verification & Validation is successful !!!");
		} else
			log.info("Verification & Validation is Failed ");
	}

	@When("update ContractTerm field")
	public void update_ContractTerm_field() throws Exception {
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
		if (ContractNumber == "2") {
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
