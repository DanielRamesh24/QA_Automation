package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import abstractclass.DriverClass;


public class OpportunityPage extends DriverClass {

	public OpportunityPage(WebDriver driver) {
		super(driver);
	}

	@CacheLookup
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	private WebElement Applauncher;

	public WebElement getApplauncher() {
		return Applauncher;
	}

	@FindBy(xpath = "//div//input[@placeholder='Search apps and items...']")
	private WebElement Searchbtn;

	public WebElement getSearchbtn() {
		return Searchbtn;
	}

	@FindBy(xpath = "//p[@class='slds-truncate']")
	private WebElement Clickopportunities;

	public WebElement getClickopportunities() {
		return Clickopportunities;
	}
	
	@FindBy(xpath = "//a[@title='New']")
	private WebElement newbutton;

	public WebElement getnewbutton() {
		return newbutton;
	}
	
	@FindBy(xpath = "//input[@name='Name']")
	private WebElement oppname;

	public WebElement getoppname() {
		return oppname;
	}
	
	@FindBy(xpath = "//input[@name='CloseDate']")
	private WebElement closedate;

	public WebElement getclosedate() {
		return closedate;
	}
	
	@FindBy(xpath = "//button[@aria-label='Stage - Current Selection: --None--']")
	private WebElement stage ;
	

	public WebElement getstage() {
		return stage;
	}
	
	@FindBy(xpath = "//button[@name=\"SaveEdit\"]")
	private WebElement savebtn ;
	

	public WebElement getsavebtn() {
		return savebtn;
	}
	
	@CacheLookup
	@FindBy(xpath = "//li[@title='Details']")
	private WebElement detailsection;

	public WebElement getdetailsection() {
		return detailsection;
	}
	
	@FindBy(xpath = "//button[@title='Edit Opportunity Name']")
	private WebElement pencilicon;

	public WebElement getpencilicon() {
		return pencilicon;
	}
	
	@FindBy(xpath = "//input[@name='Name']")
	private WebElement updateoppname;

	public WebElement getupdateoppname() {
		return updateoppname;
	}
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement savebtn1 ;
	

	public WebElement getsavebtn1() {
		return savebtn1;
	}

	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Opportunity.Name']//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']")
	private WebElement Updatehighlight ;
	

	public WebElement getUpdatehighlight() {
		return Updatehighlight;
	}
}
