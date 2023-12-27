package stepdefinitions;

import CommonMethod.baseclass;
import browserfactory.BrowerInvoke;
import helper.LoggerHelper;
import pages.ContractPage;
import pages.LeadPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LeadSteps extends BrowerInvoke {

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	public LeadPage leadPage = new LeadPage(driver);
	public ContractPage contractPage = new ContractPage(driver);
	public baseclass bc = new baseclass();
	public BrowerInvoke browser = new BrowerInvoke();

	@Given("User is logged in and searches for lead object")
	public void user_is_logged_in_and_searches_for_lead_object() throws InterruptedException, IOException {
		baseclass.presenceOfElement(driver, By.xpath("//span[text()='Related']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", leadPage.LeadTab);
		Thread.sleep(5000);

	}

	@Then("Create a new Lead with DataTable")
	public void create_a_new_lead_with_data_table(DataTable LeadData) throws InterruptedException, IOException {
		List<List<String>> dataset = LeadData.asLists();
		String fName = dataset.get(2).get(0);
		String lName = dataset.get(2).get(1);
		String cmpny = dataset.get(2).get(2);
		String title = dataset.get(2).get(3);

		baseclass.presenceOfElement(driver, By.xpath("//span[text()='Recently Viewed']"));

		leadPage.LeadCreatedata(fName, lName, cmpny, title);
	}

	@And("User Delete the Record")
	public void user_delete_the_record() throws Exception {
		Thread.sleep(5000);
		contractPage.dropDownbtn.click();
		Thread.sleep(5000);
		leadPage.Leaddelbtn.click();
		Thread.sleep(2000);
		contractPage.delConfirm.click();
		Thread.sleep(2000);
	}
	
}
