package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonMethod.baseclass;
import abstractclass.DriverClass;
import utils.Test_Data;

public class CampaignPage extends DriverClass {
	public CampaignPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Campaigns']")
	public WebElement CampaignTab;

	@FindBy(how = How.XPATH, using = "//b[text()='Campaigns']")
	public WebElement clickCampaign;

	@FindBy(how = How.XPATH, using = "//li[@data-target-selection-name='sfdc:StandardButton.Campaign.New']//a[@title='New']")
	public WebElement NewCampgn;

	@FindBy(how = How.XPATH, using = "(/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1])[1]")
	public WebElement CampaignName;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement ActiveChkbox;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public WebElement Type;

	@FindBy(how = How.XPATH, using = "//button[@title='Save']")
	public WebElement SaveBtn;

	public void clickCampaign() throws InterruptedException {
		Thread.sleep(10000);

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", CampaignTab);
	}

	public void createcampaign() throws Exception {

		baseclass.presenceOfElement(driver, By.xpath(
				"//img[@src='https://mastek-dev-ed.develop.my.salesforce.com/img/icon/t4v35/standard/campaign_120.png']"));
		NewCampgn.click();
		baseclass.staticWait(5);
		baseclass.presenceOfElement(driver, By.xpath("//h2[text()='New Campaign']"));
		CampaignName.sendKeys(Test_Data.Datasheet("Campaign", 1, 0));
		ActiveChkbox.click();
		SaveBtn.click();
	}

}
