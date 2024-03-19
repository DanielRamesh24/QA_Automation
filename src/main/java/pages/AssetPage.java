package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonMethod.baseclass;
import abstractclass.DriverClass;

public class AssetPage extends DriverClass{
	
	public AssetPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='slds-icon-waffle']") 
	public WebElement Applauncher;
	
	@FindBy(how =How.XPATH,using="//input[@placeholder='Search apps and items...']")
	public WebElement Search;

	@FindBy(how =How.XPATH,using="(//b[contains(text(),'Asset')])[4]")
	public WebElement Asset;
	
	@FindBy (how = How.XPATH, using="//a[@title='New']")
	public WebElement Newbutton;
	
	@FindBy (how = How.XPATH, using="//*[@name='Name']")
	public WebElement AssetName;
	
	@FindBy (how = How.XPATH, using="//input[@placeholder='Search Accounts...']")
	public WebElement AccountClick;
	
	@FindBy (how = How.XPATH, using="(//li[@class='slds-listbox__item'])[1]")
	public WebElement selectAccount;
	
	@FindBy (how = How.XPATH, using="(//*[//input[@placeholder='Search Contacts...']]//following::li[@class='slds-listbox__item'])[1]")
	public WebElement selectContact;
		
	@FindBy (how = How.XPATH, using="//input[@placeholder='Search Contacts...']")
	public WebElement ContactClick;
	
    @FindBy (how = How.XPATH, using="(//button[@name='SaveEdit'])")
    public WebElement saveBtn;
    
    @FindBy (how = How.XPATH, using="//a[@data-label='Details']")
    public WebElement Details;
    
    @FindBy (how = How.XPATH, using="//*[@title='Edit Asset Name']")
    public WebElement PencilIcon;
    
    @FindBy (how = How.XPATH, using="(//lightning-formatted-text[@data-output-element-id='output-field'])[1]")
    public WebElement VerifyAssetName;
    
	@FindBy(how = How.XPATH, using = "//button[@class='slds-button slds-button_icon-border-filled']")
	public WebElement dropDownbtn;

	@FindBy(how = How.XPATH, using = "//lightning-menu-item[@data-target-selection-name=\"sfdc:StandardButton.Asset.Edit\"]")
	public WebElement editbton;

	@FindBy(how = How.XPATH, using = "//lightning-menu-item[@data-target-selection-name=\"sfdc:StandardButton.Asset.Delete\"]")
	public WebElement delbtn;

	@FindBy(how = How.XPATH, using = "//button[@title='Delete']")
	public WebElement delConfirm;
    


	public void AppLauncher() throws InterruptedException {
		Thread.sleep(10000);
		Applauncher.click();
	}
	
	public void navigate_to_assetObj() throws InterruptedException {
		Thread.sleep(10000);
		Applauncher.click();
		baseclass.presenceOfElement(driver, By.xpath("//h3[text()='Apps']"));
		Search.sendKeys("Asset");
		Thread.sleep(5000);
		Asset.click();
	}
	public void clickingNewbutton() throws InterruptedException {
		Thread.sleep(5000);
		Newbutton.click();
		Thread.sleep(5000);
		
	}
}
