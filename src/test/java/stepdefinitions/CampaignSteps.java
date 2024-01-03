package stepdefinitions;

import CommonMethod.baseclass;
import browserfactory.BrowserInvoke;
import helper.LoggerHelper;
import pages.CampaignPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class CampaignSteps extends BrowserInvoke {
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	public CampaignPage campaignPage = new CampaignPage(driver);
	BrowserInvoke browser = new BrowserInvoke();
	public static baseclass bc = new baseclass();

	@Given("user is logged in and clicks the campaign tab")
	public void user_is_logged_in_and_clicks_the_campaign_tab() throws InterruptedException, IOException {
		bc.navigate_to_Objects("Campaigns");
		campaignPage.clickCampaign.click();

	}

	@When("Campaign creation")
	public void campaign_creation() throws InterruptedException {
		baseclass.presenceOfElement(driver, By.xpath("//span[text()='Recently Viewed']"));

		campaignPage.createcampaign();

	}

}
