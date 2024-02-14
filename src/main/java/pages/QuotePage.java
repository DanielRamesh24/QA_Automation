package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import abstractclass.DriverClass;

public class QuotePage extends DriverClass {

	public QuotePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@CacheLookup
	@FindBy(xpath = "//div[@class='actionsWrapper']//lightning-primitive-icon[@size='xx-small']//*[name()='svg']")
	private WebElement Quotedropdown;

	public WebElement getQuotedropdown() {
		return Quotedropdown;
	}

	@FindBy(xpath = "//a[@title='New Quote']")
	private WebElement Newquote;

	public WebElement getNewquote() {
		return Newquote;
	}

	@FindBy(xpath = "//input[@name='Name']")
	private WebElement Quotename;

	public WebElement getQuotename() {
		return Quotename;
	}

	@FindBy(xpath = "//input[@name='ExpirationDate']")
	private WebElement ExpirationDate;

	public WebElement getExpirationDate() {
		return ExpirationDate;
	}

	@FindBy(xpath = "//input[@name='Tax']")
	private WebElement Tax;

	public WebElement getTax() {
		return Tax;
	}

	@FindBy(xpath = "//input[@name='Phone']")
	private WebElement Phone;

	public WebElement getPhone() {
		return Phone;
	}

	@FindBy(xpath = "//input[@inputmode='email']")
	private WebElement Email;

	public WebElement getEmail() {
		return Email;
	}

	@FindBy(xpath = "//input[@name='Fax']")
	private WebElement Fax;

	public WebElement getFax() {
		return Fax;
	}

	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement Quotesave;

	public WebElement getQuotesave() {
		return Quotesave;
	}

}
