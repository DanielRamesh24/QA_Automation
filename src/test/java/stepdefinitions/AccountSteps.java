package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import CommonMethod.baseclass;
import pages.AccountPage;
import browserfactory.BrowserInvoke;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Test_Data;

public class AccountSteps extends BrowserInvoke {

	public static AccountPage acc = new AccountPage(driver);
	public static BrowserInvoke browser = new BrowserInvoke();
	public static baseclass bc = new baseclass();

	@Given("Click App launcher and search Accounts and Choose accounts")
	public void click_app_launcher_and_search_accounts_and_choose_accounts() throws InterruptedException, IOException {

		staticWait(10);
		// acc = new Account();
		Thread.sleep(5000);
		bc.navigate_to_Objects("Accounts");
		acc.getClickaccount().click();
	}

	@And("Click Account New button")
	public void click_Account_tab_and_click_Account_New_button() {
		baseclass.presenceOfElement(driver, By.xpath(
				"//img[@src='https://mastek-dev-ed.develop.my.salesforce.com/img/icon/t4v35/standard/account_120.png']"));
		driver.navigate().refresh();
		performClick(acc.getNewbutton());
	}

	@When("enter Account details")
	public void enter_Account_name() throws Exception {
		staticWait(5);

		// excel input
		passvalues(acc.getAccountname(), Test_Data.Datasheet("Account", 1, 0));
		Thread.sleep(1000);
		passvalues(acc.getAccountnumber(), Test_Data.Datasheet("Account", 1, 1));
		Thread.sleep(1000);

		passvalues(acc.getAccountsite(), Test_Data.Datasheet("Account", 1, 2));

		staticWait(5);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", acc.getType());

		/*
		 * js.
		 * executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');"
		 * , acc.getType());
		 */

		performClick(acc.getType());
		Thread.sleep(1000);
		String a = "//span[text()='";
		String excel = Test_Data.Datasheet("Account", 1, 3);
		String c = "']";
		driver.findElement(By.xpath(a + excel + c)).click();
		performClick(acc.getIndustry());
		Thread.sleep(1000);
		String x = "//span[@title='";
		String excelindustry = Test_Data.Datasheet("Account", 1, 4);
		String z = "']";
		driver.findElement(By.xpath(x + excelindustry + z)).click();
		Thread.sleep(1000);
		passvalues(acc.getAnnualrevenue(), Test_Data.Datasheet("Account", 1, 5));
		performClick(acc.getRating());
		Thread.sleep(1000);
		String m = "//span[@title='";
		String excelrating = Test_Data.Datasheet("Account", 1, 6);
		String n = "']";
		driver.findElement(By.xpath(m + excelrating + n)).click();
		Thread.sleep(1000);
		passvalues(acc.getPhone(), Test_Data.Datasheet("Account", 1, 7));
		Thread.sleep(1000);
		passvalues(acc.getFax(), Test_Data.Datasheet("Account", 1, 8));
		Thread.sleep(1000);
		passvalues(acc.getWebsite(), Test_Data.Datasheet("Account", 1, 9));
		Thread.sleep(1000);
		passvalues(acc.getTickersymbol(), Test_Data.Datasheet("Account", 1, 10));
		Thread.sleep(1000);
		passvalues(acc.getEmployees(), Test_Data.Datasheet("Account", 1, 11));
		Thread.sleep(1000);
		passvalues(acc.getSICcode(), Test_Data.Datasheet("Account", 1, 12));
		Thread.sleep(1000);
		passvalues(acc.getDescription(), Test_Data.Datasheet("Account", 1, 13));

	}

	@When("click create save button")
	public void click_create_save_button() throws Exception {
		staticWait(5);
		clickable(acc.getSavebutton());

		Thread.sleep(3000);
	}

	@When("Click dropdown and click edit")
	public void click_dropdown_and_click_edit() throws Exception {
		Thread.sleep(2000);
		performClick(acc.getDetail());
		Thread.sleep(5000);
		performClick(acc.getEditicon());
		clear(acc.getUpdateAccountname());

	}

	@When("Update the Account name")
	public void update_the_account_name() throws Exception {
		Thread.sleep(2000);
		// fieldEdit(editacc.getAccedit(), "Account Updated");
		passvalues(acc.getAccountname(), Test_Data.Datasheet("Account", 1, 14));
		Thread.sleep(1000);
		acc.getAccedit().sendKeys(Keys.TAB);

	}
	
	@Then("User Click edit Save button")
	public void user_click_edit_save_button() throws Exception {
		Thread.sleep(1000);

		performClick(acc.getSaveedit());

		System.out.println("Account updated successfully");

		Thread.sleep(3000);

		elementYellowHighlight(acc.getUpdatehighlight());

		Thread.sleep(5000);
	}


	@Then("User Click Delete button")
	public void user_click_delete_button() throws Exception {
		Thread.sleep(1000);

		performClick(acc.getDeletebtn());
		Thread.sleep(2000);
	}

	@Then("User Click Delete to Confirm")
	public void user_click_delete_to_confirm() throws Exception {
		performClick(acc.getConfirmDeletebtn());
		Thread.sleep(2000);
		System.out.println("Account Deleted successfully");
	}

}
