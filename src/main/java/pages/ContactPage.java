package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import CommonMethod.baseclass;
import abstractclass.DriverClass;

public class ContactPage extends DriverClass {
	
		
	public ContactPage(WebDriver driver) {
		super(driver);
	}

	@CacheLookup
	@FindBy(xpath ="//*[@title='Contacts']")
	private WebElement contTab;
	
	@FindBy(xpath = "(//a[@title='New'])[1]")
	private WebElement newconBtn;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement fstName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lstName;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement accName;
	
	@FindBy(xpath = "//lightning-base-combobox-formatted-text[@title='Vignesh Testing']")
	private WebElement selAccount;
	
	@FindBy(xpath = "//input[@name='Title']")
	private WebElement fieldTitle;
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//a[text()='Details']")
	private WebElement detailTab;
	
	@FindBy(xpath = "//lightning-formatted-name[@data-output-element-id='output-field']")
	private WebElement contactName;
	
	@FindBy(xpath = "//button[@class='slds-button slds-button_icon-border-filled']")
	private WebElement contDroDown;
	
	
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement contEdit;
	
	@FindBy(xpath = "//button[@title='Delete']")
	private WebElement contdelete;
	
	@FindBy(xpath = "//span[@class='slds-truncate'][text()='Delete']")
	private WebElement dropdelete;
	//a[@name='Delete']
	
	public WebElement getDropdelete() {
		return dropdelete;
	}

	public WebElement getContdelete() {
		return contdelete;
	}

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement editFirstName;
	
	
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement editLastName;
	
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement clickSave;
	
	public WebElement getClickSave() {
		return clickSave;
	}

	public WebElement getContEdit() {
		return contEdit;
	}

	public WebElement getEditFirstName() {
		return editFirstName;
	}

	public WebElement getEditLastName() {
		return editLastName;
	}
	
	
	


	
	public WebElement getContDroDown() {
		return contDroDown;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getContTab() {
		return contTab;
	}
	
	public WebElement getNewconBtn() {
		return newconBtn;
	}
	
	public WebElement getFstName() {
		return fstName;
	} 
	
	public WebElement getDetailTab() {
		return detailTab;
	}

	public WebElement getLstName() {
		return lstName;
	}
	
	public WebElement getAccName() {
		return accName;
	}
	
	public WebElement getSelAccount() {
		return selAccount;
	}
	
	public WebElement getFieldTitle() {
		return fieldTitle;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

	
	public void filldata(String a,String b,String c) {
		
		baseclass.fillTextbox(fstName, a);
		baseclass.fillTextbox(lstName, b);
		baseclass.fillTextbox(accName, c);
				
	}
	
}
