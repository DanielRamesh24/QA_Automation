package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;
import utils.Test_Date;
import abstractclass.DriverClass;

public class OrderPage extends DriverClass {

	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//div[@class='slds-icon-waffle']") // finding element by getting its xpaths using
																			// @findby
	public WebElement Applauncher;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search apps and items...']")
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Orders')]")
	public WebElement Orders;

	@FindBy(how = How.XPATH, using = "//a[@title='New']")
	public WebElement Newbutton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Accounts...']")
	public WebElement AccountName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Contracts...']")
	public WebElement ContractNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='EffectiveDate']")
	public WebElement OrderStartDatepicker;

	@FindBy(how = How.XPATH, using = "//span[text()='23']")
	public WebElement OrderStartDate;

	@FindBy(how = How.XPATH, using = "//lightning-base-combobox-formatted-text[@title='00000101']")
	public WebElement Contractlookup;

	@FindBy(how = How.XPATH, using = "(//lightning-base-combobox-formatted-text[@title='Kevin Testing'])[1]")
	public WebElement Acconutlookup;

	@FindBy(how = How.XPATH, using = "//a[text()='Details']")
	// a[text()='Details']
	// span[text()='Details']
	public WebElement Details;

	@FindBy(how = How.XPATH, using = "(//span[text()='Kevin Testing'])[2]")
	public WebElement VerifyAccountName;

	@FindBy(how = How.XPATH, using = "(//span[text()='00000101'])[2]")
	public WebElement VerifyContractNumber;

	@FindBy(how = How.XPATH, using = "(//lightning-formatted-text[text()='7/23/2023'])[2]")
	public WebElement VerifyStartDate;

	@FindBy(how = How.XPATH, using = "//button[@name='SaveEdit']")
	// button[text()='Save']
	public WebElement Savebutton;

	public void navigateOrder() throws InterruptedException {
		Thread.sleep(10000);
		Applauncher.click();
		Thread.sleep(10000);
		Search.sendKeys("Orders");
		Thread.sleep(10000);
		Orders.click();
		Thread.sleep(5000);
	}

	public void clickingNewbutton() throws InterruptedException {

		Newbutton.click();
		Thread.sleep(5000);

	}

	public void creatingNewRecord(String methodName, String Tc_id) throws Exception, InterruptedException {

		AccountName.sendKeys(Test_Date.Datasheet("Order", 1, 1));
		Thread.sleep(3000);
		AccountName.click();
		Acconutlookup.click();

		ContractNumber.sendKeys(Test_Date.Datasheet("Order", 1, 2));
		Thread.sleep(3000);
		Contractlookup.click();
		OrderStartDatepicker.click();
		OrderStartDate.click();
		Thread.sleep(5000);
	}

	public void clickingSavebutton() throws InterruptedException {

		Savebutton.click();
		Thread.sleep(5000);
	}

	public void verifyCreatedRecord(String methodName, String Tc_id) throws Exception, InterruptedException {
		Details.click();

		String expectedAccountName = Test_Date.Datasheet("Order", 1, 1);
		String actualAccountName = VerifyAccountName.getText();
		if (expectedAccountName.equals(actualAccountName)) {
			SeleniumUtils.matchingHighlights(driver, VerifyAccountName);
			Thread.sleep(5000);
		} else {
			SeleniumUtils.mismatchingHighlights(driver, VerifyAccountName);
			Thread.sleep(5000);
		}

		String expectedContractNumber = Test_Date.Datasheet("Order", 1, 2);
		String actualContractNumber = VerifyContractNumber.getText();
		if (expectedContractNumber.equals(actualContractNumber)) {
			System.out.println("Passed");

		} else {
			System.out.println("Failed");

		}
	}

}