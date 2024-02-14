package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import abstractclass.DriverClass;

public class AccountPage extends DriverClass {
	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@CacheLookup
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	private WebElement Applauncher;

	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	private WebElement Searchbtn;

	@FindBy(xpath = "//b[text()='Accounts']")
	private WebElement Clickaccount;

	@FindBy(xpath = "//div[@title='New']")
	private WebElement Newbutton;

	@FindBy(xpath = "//input[@name='Name']")
	private WebElement Accountname;

	@FindBy(xpath = "//input[@name='AccountNumber']")
	private WebElement Accountnumber;

	@FindBy(xpath = "//input[@name='Site']")
	private WebElement Accountsite;

	@FindBy(xpath = "(//button/span[text()='--None--'])[2]")
	private WebElement Type;

	@FindBy(xpath = "(//button/span[text()='--None--'])[3]")
	private WebElement Industry;

	@FindBy(xpath = "//input[@name='AnnualRevenue']")
	private WebElement Annualrevenue;

	@FindBy(xpath = "(//button/span[text()='--None--'])[1]")
	private WebElement Rating;

	@FindBy(xpath = "//input[@name='Phone']")
	private WebElement Phone;

	@FindBy(xpath = "//input[@name='Fax']")
	private WebElement Fax;

	@FindBy(xpath = "//input[@name='Website']")
	private WebElement Website;

	@FindBy(xpath = "//input[@name='TickerSymbol']")
	private WebElement Tickersymbol;

	@FindBy(xpath = "(//button/span[text()='--None--'])[3]")
	private WebElement Ownership;

	@FindBy(xpath = "//input[@name='NumberOfEmployees']")
	private WebElement Employees;

	@FindBy(xpath = "//input[@name='Sic']")
	private WebElement SICcode;

	@FindBy(xpath = "//input[@name='SLAExpirationDate__c']")
	private WebElement SLAexpirationdate;

	@FindBy(xpath = "//textarea[@maxlength='32000']")
	private WebElement Description;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement Savebutton;

	public WebElement getApplauncher() {
		return Applauncher;
	}

	public WebElement getSearchbtn() {
		return Searchbtn;
	}

	public WebElement getClickaccount() {
		return Clickaccount;
	}

	public WebElement getNewbutton() {
		return Newbutton;
	}

	public WebElement getAccountname() {
		return Accountname;
	}

	public WebElement getAccountnumber() {
		return Accountnumber;
	}

	public WebElement getAccountsite() {
		return Accountsite;
	}

	public WebElement getType() {
		return Type;
	}

	public WebElement getIndustry() {
		return Industry;
	}

	public WebElement getAnnualrevenue() {
		return Annualrevenue;
	}

	public WebElement getRating() {
		return Rating;
	}

	public WebElement getPhone() {
		return Phone;
	}

	public WebElement getFax() {
		return Fax;
	}

	public WebElement getWebsite() {
		return Website;
	}

	public WebElement getTickersymbol() {
		return Tickersymbol;
	}

	public WebElement getOwnership() {
		return Ownership;
	}

	public WebElement getEmployees() {
		return Employees;
	}

	public WebElement getSICcode() {
		return SICcode;
	}

	public WebElement getSLAexpirationdate() {
		return SLAexpirationdate;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}

}
