package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;

	import abstractclass.DriverClass;

	public class LoginPage extends DriverClass{
		
		public LoginPage(WebDriver driver) {
			super(driver);
			
		}
		  
		  @FindBy(how =How.XPATH,using="//input[@name='username']") 
		   public static WebElement salesforceUserName;
		  
		  @FindBy(how =How.XPATH,using="//input[@name='pw']") 
		  public static WebElement salesforcePassword;
		  
		  @FindBy(how =How.XPATH,using="//input[@name='Login']") 
		  public static WebElement salesforceLogin;
		  
		  @FindBy(how =How.CSS,using="div.slds-icon-waffle")// finding element by getting its xpaths using @findby
			public WebElement Applauncher;
		  
		  
		  public void enterUserName(String username) {
		  salesforceUserName.sendKeys(username); }
		  
		  public void enterPassword(String password) {
		  salesforcePassword.sendKeys(password); }
		  
		  public void clickOnLogin() 
		  { salesforceLogin.click(); }
		 
		
		 
		
	}
