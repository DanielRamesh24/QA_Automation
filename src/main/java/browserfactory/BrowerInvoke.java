package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowerInvoke {

	
	public  static WebDriver driver;
	
	public  void launch() {
		System.setProperty("Webdriver.chrome.driver","CucumberFramework/src/test/resources/Drivers/chromedriver.exe");
				// "C:/Users/daniel.r/eclipse-workspace/CucumberFramework/src/test/resources/Drivers/chromedriver.exe");
		
		
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();

		 driver.manage().window().maximize();
	//return driver;
}
}

