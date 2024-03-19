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
	
	@FindBy(xpath = "//lightning-base-combobox-formatted-text[@title='Test Asset Account']")
	private WebElement selAccount;
	
	@FindBy(xpath = "//input[@name='Title']")
	private WebElement fieldTitle;
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//*[@data-label='Details']")
	private WebElement detailTab;
	
	public WebElement getContTab() {
		return contTab;
	}
	
	public WebElement getNewconBtn() {
		return newconBtn;
	}
	
	public WebElement getFstName() {
		return fstName;
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
	
	public WebElement getDeatilTab() {
		return detailTab;
	}
	
	public void filldata(String a,String b,String c) {
		
		baseclass.fillTextbox(fstName, a);
		baseclass.fillTextbox(lstName, b);
		baseclass.fillTextbox(accName, c);
				
	}
	
}
