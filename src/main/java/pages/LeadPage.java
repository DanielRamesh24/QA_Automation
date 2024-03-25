package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonMethod.baseclass;
import abstractclass.DriverClass;

public class LeadPage extends DriverClass {

	public LeadPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Leads']")
	public WebElement LeadTab;

	@FindBy(how = How.XPATH, using = "(//b[contains(text(),'Leads')])[1]")
	public WebElement clickLead;

	@FindBy(how = How.XPATH, using = "//a[@title='New']")
	public WebElement newLead;
	@FindBy(how = How.XPATH, using = "//*[@name='firstName']")
	public WebElement firstName;

	@FindBy(how = How.XPATH, using = "//*[@name='lastName']")
	public WebElement lastName;

	@FindBy(how = How.XPATH, using = "//*[@name='Company']")
	public WebElement company;

	@FindBy(how = How.XPATH, using = "//*[@name='Title']")
	public WebElement title;

	@FindBy(how = How.XPATH, using = "//*[@id='combobox-button-244']")
	public WebElement leadstatus;

	@FindBy(how = How.XPATH, using = "//*[@name='SaveEdit']")
	public WebElement saveBtn;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Mark Status as Complete')]")
	public WebElement MarkstatusComplete;

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/th[1]/span[1]/a[1]")
	public WebElement firstRecord;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[2]/th/span/a")
	public WebElement secondRecord;

	@FindBy(how = How.XPATH, using = "//button[@class='slds-button slds-button_icon-border-filled']//lightning-primitive-icon")
	public WebElement dropdown;

	@FindBy(how = How.XPATH, using = "//lightning-menu-item[@data-target-selection-name='sfdc:StandardButton.Lead.Edit']//a[@role='menuitem']")
	public WebElement editBtn;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/records-modal-lwc-detail-panel-wrapper[1]/records-record-layout-event-broker[1]/slot[1]/records-lwc-detail-panel[1]/records-base-record-form[1]/div[1]/div[2]/div[1]/div[1]/records-lwc-record-layout[1]/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2[1]/records-record-layout-block[1]/slot[1]/records-record-layout-section[1]/div[1]/div[1]/div[1]/slot[1]/records-record-layout-row[1]/slot[1]/records-record-layout-item[2]/div[1]/span[1]/slot[1]/lightning-input[1]/div[1]/div[1]/input[1]")
	public WebElement phone;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Delete']")
	public WebElement DeleteBtn;
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'label bBody')][normalize-space()='Delete']")
	public WebElement DeleteYes;

	@FindBy(how = How.XPATH, using = "//span[text()='Delete']")
	public WebElement Leaddelbtn;

	public void LeadCreatedata(String FirstName, String LastName, String Company, String Title)
			throws InterruptedException, IOException {
		driver.navigate().refresh();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", newLead);
		baseclass.presenceOfElement(driver, By.xpath("//span[text()='Lead Information']"));
		firstName.sendKeys(FirstName);
		baseclass.elementLgreenHighlight(firstName);
		lastName.sendKeys(LastName);
		baseclass.elementLgreenHighlight(lastName);

		company.sendKeys(Company);
		baseclass.elementLgreenHighlight(company);

		title.sendKeys(Title);
		baseclass.elementLgreenHighlight(title);
		baseclass.staticWait(7);
		saveBtn.click();
		baseclass.staticWait(10);

	}
	
	public void leadupdation( String lName, String cmpny) throws InterruptedException
	{
		baseclass.staticWait(5);
	System.out.print("Lead Update");
/*	JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", LeadTab);
		baseclass.staticWait(7);
		firstRecord.click();   */
		baseclass.staticWait(10);
		dropdown.click();
		baseclass.staticWait(5);
		editBtn.click();
		baseclass.staticWait(10);
		lastName.sendKeys(lName);		
		baseclass.staticWait(5);
		baseclass.elementYellowHighlight(lastName);
		company.sendKeys(cmpny);
		baseclass.elementYellowHighlight(company);
		saveBtn.click();
		System.out.print("Lead is  updated succesfully");
		baseclass.staticWait(10);


	}
	
	public void leaddeletion() throws InterruptedException
	{
	/*	System.out.print("Lead delete");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", LeadTab);
		baseclass.staticWait(5);
		firstRecord.click();   */
		baseclass.staticWait(10);
		dropdown.click();
		baseclass.staticWait(5);
     	DeleteBtn.click();
     	DeleteYes.click();
		baseclass.staticWait(10);

	}



}
