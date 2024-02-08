package browserfactory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
public WebDriver driver;

public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	

	public  static WebDriver browserInvoke(String browser) {
	System.out.println("browser value is: " + browser);

		
		  if (browser.equals("Chrome")) {
			  WebDriverManager.chromedriver().setup();
		   tlDriver.set(new ChromeDriver());
		  
		
		  } 
		  else if
		  (browser.equals("firefox")) { 
			  WebDriverManager.firefoxdriver().setup();
		  tlDriver.set(new FirefoxDriver()); }
		  
		  else if 
		  (browser.equals("ie")) {
		  WebDriverManager.iedriver().setup(); 
		  tlDriver.set(new InternetExplorerDriver()); 
		  }
		  
		  
		  else {
		  System.out.println("Please pass the correct browser value: " + browser); 
		  }
		 

	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	return getDriver();
	}
	
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	
	}
}


/*
 * public enum driverSupportedBrowser{// enum is used for create a set of user
 * defined variables. chrome,firefox,internetExplorer; }
 */
	
/*	public WebDriver browserInvoke(driverSupportedBrowser browsertype) // Invoking browser depends on switch case. It used to chose the browser types
	{
	switch(browsertype)	{
	
	case chrome:
	WebDriverManager.chromedriver().setup(); // WebDriverManager is used to get the drivers using dependencies

	tlDriver.set(new ChromeDriver());
	((WebDriver) tlDriver).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for a certain measure of time before throwing an exception.
	((WebDriver) tlDriver).manage().window().maximize();
	break;
	
	case firefox:
	WebDriverManager.firefoxdriver().setup();	
	tlDriver.set(new FirefoxDriver());
	((WebDriver) tlDriver).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for a certain measure of time before throwing an exception.
	((WebDriver) tlDriver).manage().window().maximize();
	break;

	case internetExplorer:
	WebDriverManager.iedriver().setup();
	tlDriver.set(new InternetExplorerDriver());
	((WebDriver) tlDriver).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //wait for a certain measure of time before throwing an exception.
	((WebDriver) tlDriver).manage().window().maximize();
	break;
	
	}
	return getDriver();
}*/