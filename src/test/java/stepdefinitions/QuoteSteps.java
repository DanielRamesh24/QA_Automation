package stepdefinitions;

import org.openqa.selenium.Keys;

import browserfactory.BrowserInvoke;
import io.cucumber.java.en.Then;
import pages.QuotePage;
import utils.Test_Data;

public class QuoteSteps extends BrowserInvoke {

	public QuotePage quote = new QuotePage(driver);

	@Then("Scroll down to Quotes and click dropdown and click new Quote")
	public void scroll_down_to_Quotes_and_click_dropdown_and_click_new_Quote() throws InterruptedException {

		Thread.sleep(5000);

		clickable(quote.getQuotedropdown());
		Thread.sleep(2000);

		clickable(quote.getNewquote());
		Thread.sleep(2000);

	}

	@Then("Enter Quote details")
	public void enter_Quote_details() throws Exception {

		/*
		 * passvalues(quote.getQuotename(), "My Quote"); Thread.sleep(3000); //
		 * quote.getExpirationDate().sendKeys(Keys.TAB);
		 * passvalues(quote.getExpirationDate(), "2/6/2024"); passvalues(quote.getTax(),
		 * "50"); passvalues(quote.getPhone(), "9876543210");
		 * passvalues(quote.getEmail(), "quote@yopmail.com"); passvalues(quote.getFax(),
		 * "quote");
		 */

		// excel input
		passvalues(quote.getQuotename(), Test_Data.Datasheet("Quote", 1, 0));
		Thread.sleep(1000);
		passvalues(quote.getExpirationDate(),"2/6/2024");
		Thread.sleep(1000);
		passvalues(quote.getTax(),Test_Data.Datasheet("Quote", 1, 2));
		Thread.sleep(1000);
		passvalues(quote.getPhone(),Test_Data.Datasheet("Quote", 1, 3));
		Thread.sleep(1000);
		passvalues(quote.getEmail(),Test_Data.Datasheet("Quote", 1, 4));
		Thread.sleep(1000);
		passvalues(quote.getFax(),Test_Data.Datasheet("Quote", 1, 5));
		Thread.sleep(1000);

	}

	@Then("Click Quote Save")
	public void click_Quote_Save() {

		performClick(quote.getQuotesave());
		System.out.println("Quote Created Successfully");

	}
	
	@Then("Click Edit in the dropdown")
	public void click_Edit_in_the_dropdown() throws InterruptedException {

		Thread.sleep(10000);
		performClick(quote.getQuoteobject());
		Thread.sleep(10000);
		// moveCursorClick(quote.getQuoteDetailtab());
		// performClick(quote.getQuoteDetailtab());
		clickable(quote.getQuoteDetailtab());

	}

	@Then("Update the Quote name")
	public void update_the_Quote_name() throws Exception{
		performClick(quote.getQuotePencilicon());
//		clear(quotepage.getQuotename());
		Thread.sleep(1000);
		passvalues(quote.getQuotename(), Test_Data.Datasheet("Quote", 1, 4));
		quote.getQuotename1().sendKeys(Keys.TAB);
		Thread.sleep(1000);

	}

	@Then("Click Quote Edit Save")
	public void click_Quote_Edit_Save() throws InterruptedException {
		Thread.sleep(1000);
		performClick(quote.getQuoteUpdatesave());

		Thread.sleep(1000);

		System.out.println("Quote Updated Successfully");
		Thread.sleep(1000);

		elementYellowHighlight(quote.getUpdatedQuotename());
		Thread.sleep(1000);

	}

	@Then("Click Delete Quote and Confirm Delete")
	public void click_Delete_Quote_and_Confirm_Delete() throws InterruptedException {
		Thread.sleep(1000);
		performClick(quote.getQuoteDelete());

		Thread.sleep(1000);
		performClick(quote.getQuoteconfirmDeletee());

		System.out.println("Quote Deleted Successfully");

	}

}
