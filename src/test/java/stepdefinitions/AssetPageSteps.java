package stepdefinitions;


import org.apache.log4j.Logger;
import browserfactory.BrowserInvoke;
import pages.AssetPage;
import utils.Test_Data;
import helper.LoggerHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class AssetPageSteps extends BrowserInvoke {

	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	AssetPage assetPage = new AssetPage(driver);
	BrowserInvoke browser = new BrowserInvoke();

	@Given("User007 navigates to Asset object")
	public void User007_navigates_to_asset_object() throws NullPointerException, InterruptedException{	
		AssetPage ap = new AssetPage(driver);
		System.out.println(driver);
		ap.navigate_to_assetObj();
		log.info("User007 navigated to Asset");
	}


	@And("User007 clicks on new button")
	public void User007_clicks_on_new_button() throws InterruptedException {
		AssetPage ap1 = new AssetPage(driver);
		ap1.clickingNewbutton();
		log.info("User007 clicked on new button");
	}

	@And("User007 enters valid data")
	public void User007_enters_valid_data() throws Exception {
		AssetPage ap2 = new AssetPage(driver);
		Thread.sleep(3000);
		ap2.AssetName.sendKeys(Test_Data.Datasheet("Asset", 1, 0));
		Thread.sleep(3000);
		ap2.AccountClick.sendKeys(Test_Data.Datasheet("Asset", 1, 1));
		Thread.sleep(3000);
		ap2.selectAccount.click();
		ap2.ContactClick.sendKeys(Test_Data.Datasheet("Asset", 1, 2));
		Thread.sleep(5000);
		ap2.selectContact.click();
		ap2.saveBtn.click();
		Thread.sleep(3000);
		log.info("User007 enters valid data for creating new asset record");

	}


	@And("User007 Verifies the New record created")
	public void verifies_the_new_record_created() throws Exception {
		AssetPage cp3 = new AssetPage(driver);
		Thread.sleep(5000);
		cp3.Details.click();
		String AssetName;
		Thread.sleep(2000);
		AssetName = cp3.VerifyAssetName.getText();
		System.out.println(AssetName);
		if(AssetName.equalsIgnoreCase(Test_Data.Datasheet("Asset", 1, 0))) {
			log.info("Verification & Validation is successful !!!"); 
		}
		else
			log.info("Verification & Validation is Failed "); 
	}

	@And("User007 update AssetName field")
	public void User007_update_AssetName_field()throws Exception {
		String AssetName;
		elementYellowHighlight(assetPage.VerifyAssetName);
		Thread.sleep(5000);
		assetPage.PencilIcon.click();
		Thread.sleep(5000);
		assetPage.AssetName.clear();
		assetPage.AssetName.sendKeys(Test_Data.Datasheet("Asset", 1, 3));
		assetPage.saveBtn.click();
		Thread.sleep(7000);
		elementLgreenHighlight(assetPage.VerifyAssetName);
		AssetName = assetPage.VerifyAssetName.getText();
		System.out.println("AssetName is"+AssetName);
		Thread.sleep(7000);
		if (AssetName == Test_Data.Datasheet("Asset", 1, 3)) {
			elementLgreenHighlight(assetPage.VerifyAssetName);
			log.info("Verification & Validation for updation is successful !!!");
		} else
			log.info("Verification & Validation for updation is Failed ");
	}


	@And("User007 Delete the Record")
	public void delete_the_record() throws Exception{
		AssetPage cp5 = new AssetPage(driver);
		Thread.sleep(2000);
		cp5.dropDownbtn.click();
		Thread.sleep(2000);
		cp5.delbtn.click();
		Thread.sleep(2000);
		cp5.delConfirm.click();
	}
}

