package stepdefinitions;

import org.openqa.selenium.By;

import CommonMethod.baseclass;

import browserfactory.BrowserInvoke;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OpportunityPage;
import utils.Test_Data;


public class OpportunitySteps extends BrowserInvoke {
	public OpportunityPage OpportunityPage = new OpportunityPage(driver);
	BrowserInvoke browser = new BrowserInvoke();
	public static baseclass bc = new baseclass();

	@Given("Click App launcher and search Opportunity and Choose Opportunity")
	public void click_App_launcher_and_search_Opportunity_and_Choose_Opportunity() throws InterruptedException {
		staticWait(5);

		
		Thread.sleep(2000);

		clickable(OpportunityPage.getApplauncher());

		staticWait(5);
		// Thread.sleep(3000);

		clickable(OpportunityPage.getSearchbtn());

		passvalues(OpportunityPage.getSearchbtn(),"opportunities");

		Thread.sleep(2000);

		clickable(OpportunityPage.getClickopportunities());
	}

	@Then("Click New button")
	public void click_New_button() throws InterruptedException {
		baseclass.presenceOfElement(driver, By.xpath(
				"//img[@src='https://mastek-dev-ed.develop.my.salesforce.com/img/icon/t4v35/standard/opportunity_120.png']"));
		driver.navigate().refresh();
		clickable(OpportunityPage.getnewbutton());
		Thread.sleep(2000);

	}

	@When("enter Opportunity details")
	public void enter_Opportunity_details() throws Exception {
		
//ExcelInput

		// name
		presenceOfElement(driver, By.xpath("//h2[text()='New Opportunity']"));
		passvalues(OpportunityPage.getoppname(),Test_Data.Datasheet("Opportunity", 1, 0));
		Thread.sleep(1000);

		// date
		passvalues(OpportunityPage.getclosedate(),"2/7/2023");
		Thread.sleep(2000);

		// stage
		clickable(OpportunityPage.getstage());
        Thread.sleep(2000);

		String x = "//span[@title='";
		String excelstage = Test_Data.Datasheet("Opportunity", 1, 1);		
		String z = "']";
		driver.findElement(By.xpath(x + excelstage + z)).click();

	}

	@When("click opportunity save button")
	public void click_opportunity_save_button() {

		clickable(OpportunityPage.getsavebtn());
		System.out.println("Opportunity record created");

	}
}
