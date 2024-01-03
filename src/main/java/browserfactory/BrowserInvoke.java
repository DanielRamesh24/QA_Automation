package browserfactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import CommonMethod.baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInvoke extends baseclass {

	// public static WebDriver driver;

	public void launch() {
		System.setProperty("Webdriver.chrome.driver","CucumberFramework/src/test/resources/Drivers/chromedriver.exe");

		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		// return driver;
	}
}
