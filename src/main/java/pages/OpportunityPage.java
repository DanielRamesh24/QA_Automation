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
	
	@FindBy(xpath = "(//button/span[text()='--None--'])[1]")
	private WebElement stage ;
	

	public WebElement getstage() {
		return stage;
	}
	
	@FindBy(xpath = "//button[@name=\"SaveEdit\"]")
	private WebElement savebtn ;
	

	public WebElement getsavebtn() {
		return savebtn;
	}
}
