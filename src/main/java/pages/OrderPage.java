package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import utils.SeleniumUtils;
import utils.Test_Data;
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

	@FindBy(how = How.XPATH, using = "(//a[@data-label=\"Details\"])[2]")
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
	
	@FindBy(how = How.XPATH, using = "(//button[@name='SaveEdit'])")
	public WebElement saveBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@class='slds-button slds-button_icon-border-filled'][@part='button button-icon']")
	public WebElement dropDownbtn;
	

	
	@FindBy(how = How.XPATH, using = "//lightning-button-menu[@class='menu-button-item slds-dropdown-trigger slds-dropdown-trigger_click']//button")
	public WebElement dropDownb;
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='test-id__field-label'][text()= 'Status']")
	public WebElement statusheading;
	
	
	@FindBy(how = How.XPATH, using = "//lightning-menu-item[@data-target-selection-name=\"sfdc:StandardButton.Order.Edit\"]")
	public WebElement editbton;
	
	@FindBy(how = How.XPATH, using = "//button[@data-value='Draft']")
	public WebElement Statuspicklist;
	
	@FindBy(how = How.XPATH, using = "//span[@title='Activated']")
	public WebElement Activatepicklistvalue;
	
	@FindBy(how = How.XPATH, using = "//lightning-base-combobox-item[@data-value='Activated']")
	public WebElement ActivatedPicklistvalue;
	
	
	@FindBy(how = How.XPATH, using = "//lightning-base-combobox-item[@data-value='Draft']")
	public WebElement DraftPicklistvalue;
	
	
	@FindBy(how = How.XPATH, using = "//runtime_platform_actions-action-renderer[@title='Delete']")
	public WebElement delbtn;

	@FindBy(how = How.XPATH, using = "//button[@title='Delete']")
	public WebElement delConfirm;
	
	@FindBy(how = How.XPATH, using = "(//lightning-formatted-text[@data-output-element-id='output-field'])[12]")
	public WebElement Ordernumber;
	
	@FindBy(how = How.XPATH, using = "(//force-lookup[@data-output-element-id='output-field'])[1]")
	public WebElement contractNumber;
	

	@FindBy(how = How.XPATH, using = "//button[@title='Edit Shipping Address']")
	public WebElement EditbtnShippingAddress;
	
	@FindBy(how = How.XPATH, using = "//button[@title='Edit Status']")
	public WebElement EditBtnstatus;
	

	@FindBy(how = How.XPATH, using = "//button[@Id='combobox-button-676']")
	public WebElement Draft;
	
	@FindBy(how = How.XPATH, using = "(//textarea[@name='street'])[1]")
	public WebElement Street;
	
	@FindBy(how = How.XPATH, using = "(//lightning-formatted-text[@data-output-element-id=\"output-field\"])[26]")
	public WebElement ordernumber;
	
	@FindBy(how = How.XPATH, using = "(//lightning-formatted-address[@data-output-element-id=\"output-field\"])[1]")
	public WebElement VerifyShippingfield;
	
	
	
	
	

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

		AccountName.sendKeys(Test_Data.Datasheet("Order", 1, 1));
		Thread.sleep(3000);
		AccountName.click();
		Acconutlookup.click();

		ContractNumber.sendKeys(Test_Data.Datasheet("Order", 1, 2));
		Thread.sleep(3000);
		Contractlookup.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", OrderStartDatepicker);
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

		String expectedAccountName = Test_Data.Datasheet("Order", 1, 1);
		String actualAccountName = VerifyAccountName.getText();
		if (expectedAccountName.equals(actualAccountName)) {
			SeleniumUtils.matchingHighlights(driver, VerifyAccountName);
			//baseclass.elementLgreenHighlight(VerifyAccountName);
			Thread.sleep(5000);
		} else {
			SeleniumUtils.mismatchingHighlights(driver, VerifyAccountName);
			Thread.sleep(5000);
		}

		String expectedContractNumber = Test_Data.Datasheet("Order", 1, 2);
		String actualContractNumber = VerifyContractNumber.getText();
		if (expectedContractNumber.equals(actualContractNumber)) {
			System.out.println("Passed");

		} else {
			System.out.println("Failed");

		}
	}

}