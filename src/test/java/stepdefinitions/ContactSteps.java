package stepdefinitions;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import browserfactory.BrowserInvoke;
import helper.LoggerHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;
import pages.ContractPage;
import pages.LeadPage;
import utils.ExcelUtils;
import utils.SeleniumUtils;

public class ContactSteps extends BrowserInvoke {
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	// public static WebDriver driver;
	public SeleniumUtils selutil = new SeleniumUtils();
	public ContactPage contactPage = new ContactPage(driver);
	public ContractPage contractPage = new ContractPage(driver);
	BrowserInvoke browser = new BrowserInvoke();
	public LeadPage leadPage = new LeadPage(driver);

	@Given("user is logged in and clicks the contact tab")
	public void user_is_logged_in_and_clicks_the_contact_tab() throws InterruptedException {

		Thread.sleep(10000);
		staticWait(20);
		performClick(contactPage.getContTab());
	}

	@When("The user able to hit New button")
	public void the_user_able_to_hit_new_button()throws InterruptedException {
		Thread.sleep(10000);
		performClick(contactPage.getNewconBtn());
	}

	@Then("The user should able to fill the required fields and save the contact")
	public void the_user_should_able_to_fill_the_required_fields_and_save_the_contact()throws Exception {
		Thread.sleep(10000);
		contactPage.filldata(ExcelUtils.readExcel("Contact", "TC_001", "First Name"),
				ExcelUtils.readExcel("Contact", "TC_001", "Last Name"),
				ExcelUtils.readExcel("Contact", "TC_001", "Account Name"));
		performClick(contactPage.getSelAccount());
		performClick(contactPage.getSaveBtn());

	}

	@Given("The record is properly created with the given user inputs")
	public void the_record_is_properly_created_with_the_given_user_inputs() throws Exception {
		Thread.sleep(5000);
		hoverElement(contactPage.getDetailTab());
		performClick(contactPage.getDetailTab());
		System.out.println("After detail click ");
		presenceOfElement(driver, By.xpath("//span[text()='Contact Owner']"));
		String contactName = contactPage.getContactName().getText();
		String contactNameConcat = ExcelUtils.readExcel("Contact", "TC_001", "First Name") + " "+ ExcelUtils.readExcel("Contact", "TC_001", "Last Name");
		System.out.println("contactName is " + contactName);
		System.out.println("contactNameConcat is " + contactNameConcat);
		if (contactName.equalsIgnoreCase(contactNameConcat)) 
		{
			elementLgreenHighlight(contactPage.getContactName());
			log.info("Verification & Validation is successful !!!");
		} 
		else
		{
			elementRedHighlight(contactPage.getContactName());
			log.info("Verification & Validation is Failed ");
		
	}
	}

	@When("The user clicks the Edit button")
	public void the_user_clicks_the_edit_button() {
		staticWait(50);
		clickable(contactPage.getContDroDown());
		clickable(contactPage.getContEdit());
	}

	@Then("The user should enter the values for the fields to be updated")
	public void the_user_should_enter_the_values_for_the_fields_to_be_updated() throws Exception {
		presenceOfElement(driver, By.xpath("//button[text()='Cancel']"));
		clickable(contactPage.getEditFirstName());
		contactPage.getEditFirstName().clear();
		contactPage.getEditFirstName().sendKeys(ExcelUtils.readExcel("Contact", "TC_001", "First name update"));
		clickable(contactPage.getEditLastName());
		contactPage.getEditLastName().clear();
		contactPage.getEditLastName().sendKeys(ExcelUtils.readExcel("Contact", "TC_001", "Last name update"));
		clickable(contactPage.getClickSave());
		// staticWait(50);

	}

	@Given("The record is updated properly")
	public void the_record_is_updated_properly() throws Exception {

		Thread.sleep(10000);
		String contactName = contactPage.getContactName().getText();
		String contactNameConcat = ExcelUtils.readExcel("Contact", "TC_001", "First name update") +" "+ ExcelUtils.readExcel("Contact", "TC_001", "Last name update");
		if (contactName.equalsIgnoreCase(contactNameConcat)) {
			elementLgreenHighlight(contactPage.getContactName());
			log.info("Verification & Validation is successful !!!");
		}  
		else
		{
			elementRedHighlight(contactPage.getContactName());
			log.info("Verification & Validation is Failed ");
		
	}
	}

	@When("The user clicks the Delete button")
	public void the_user_clicks_the_delete_button() throws IOException, InterruptedException {
		staticWait(50);

		hoverElement(contactPage.getContDroDown());
		// elementBlueHighlight(contactPage.getContDroDown());
		staticWait(10);

		performClick(contactPage.getContDroDown());
		staticWait(50);
		/*
		 * String screenshotName="after drop click"; File file = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE); FileUtils.copyFile(file, new
		 * File(Constants.screenshotpath +"/"+ screenshotName+ ".png"));
		 */
		/*
		 * contractPage.dropDownbtn.click(); Thread.sleep(5000);
		 * leadPage.Leaddelbtn.click(); Thread.sleep(2000);
		 * contractPage.delConfirm.click(); Thread.sleep(2000);
		 */
		// presenceOfElement(driver, By.xpath("//span[text()='Delete']"));

		// staticWait(5);
		/*
		 * String screenshotName = scenario.getName().replaceAll(" ", "_"); File file =
		 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(file, new File(Constants.screenshotpath +"/"+
		 * screenshotName+ ".png"));
		 */
		Thread.sleep(2000);
		contactPage.getDropdelete().click();

	}

	@Then("Confirm the delete operation")
	public void confirm_the_delete_operation() throws IOException, InterruptedException {
		/*
		 * System.out.println("inside confirm delete"); presenceOfElement(driver,
		 * By.xpath("//h2[text()='Delete Contact']"));
		 * elementLgreenHighlight(contactPage.getContdelete());
		 * System.out.println("before confirm click");
		 * performClick(contactPage.getContdelete());
		 * System.out.println("After confirm click"); Thread.sleep(2000);
		 */

		Thread.sleep(2000);
		System.out.println("before confirm click");
		contactPage.getContdelete().click();
		System.out.println("After confirm click");

	}

}
