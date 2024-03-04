package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import abstractclass.DriverClass;
import org.openqa.selenium.JavascriptExecutor;

public class ContractPage extends DriverClass {

	public ContractPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='slds-icon-waffle']") // finding element by getting its xpaths using
																			// @findby
	public WebElement Applauncher;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search apps and items...']")
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "(//b[contains(text(),'Contracts')])[1]")
	public WebElement Contract;

	@FindBy(how = How.XPATH, using = "//a[@title='New']")
	public WebElement Newbutton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Accounts...']")
	public WebElement AccountName;

	@FindBy(how = How.XPATH, using = "//input[@name='ContractTerm']")
	public WebElement ContractTerm;
	
	@FindBy(how = How.XPATH, using = "//lightning-formatted-number[@data-output-element-id=\"output-field\"]")
	public WebElement ContractTermfield;
	
	
	@FindBy(how = How.XPATH, using = "(//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11'])[5]")
	public WebElement ViewContractterm;
	
	@FindBy(how = How.XPATH, using = "//button[@title='Clear Selection']")
	public WebElement ClearselectionName;
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='StartDate']")
	public WebElement ContractStartDatepicker;

	@FindBy(how = How.XPATH, using = "(//span[text()='11'])[1]")
	public WebElement ContractStartDate;

	@FindBy(how = How.XPATH, using = "//lightning-base-combobox-formatted-text[@title='00000101']")
	public WebElement Contractlookup;

	@FindBy(how = How.XPATH, using = "(//lightning-base-combobox-formatted-text[@title='TestDaniel'])[1]")
	public WebElement Acconutlookup;
	
	@FindBy(how = How.XPATH, using = "(//lightning-base-combobox-formatted-text[@title='Kevin Testing'])[1]")
	public WebElement Acconutlookup1;

	@FindBy(how = How.XPATH, using = "//a[text()='Details']")
	public WebElement Details;

	@FindBy(how = How.XPATH, using = "(//span[text()='TestDaniel'])[2]")
	public WebElement VerifyAccountName;

	@FindBy(how = How.XPATH, using = "(//lightning-formatted-number[text()='12'])[2]")
	public WebElement VerifyContractTerm;

	@FindBy(how = How.XPATH, using = "(//lightning-formatted-text[text()='7/23/2023'])[2]")
	public WebElement VerifyStartDate;

	@FindBy(how = How.XPATH, using = "(//button[@title='Edit Contract Term (months)'])")
	public WebElement UpdateContractTerm;

	@FindBy(how = How.XPATH, using = "(//button[@name='SaveEdit'])")
	public WebElement saveBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='slds-button slds-button_icon-border-filled']")
	public WebElement dropDownbtn;

	@FindBy(how = How.XPATH, using = "//lightning-menu-item[@data-target-selection-name=\"sfdc:StandardButton.Contract.Edit\"]")
	public WebElement editbton;

	@FindBy(how = How.XPATH, using = "//lightning-menu-item[@data-target-selection-name=\"sfdc:StandardButton.Contract.Delete\"]")
	public WebElement delbtn;

	@FindBy(how = How.XPATH, using = "//button[@title='Delete']")
	public WebElement delConfirm;
	
	
	@FindBy(how = How.XPATH, using = "(//lightning-formatted-text[@data-output-element-id='output-field'])[2]")
	public WebElement ContractNumber;
	

	public void AppLauncher() throws InterruptedException {
		Thread.sleep(10000);
		Applauncher.click();
	}

	public void clickingNewbutton() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", Newbutton);
		Thread.sleep(5000);

	}

}