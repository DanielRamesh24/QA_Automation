package apphooks;



import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import browserfactory.BrowserFactory;
import constants.Constants;
import utils.ConfigReader;
import utils.ExcelUtils;

import helper.LoggerHelper;
import io.cucumber.*;
import io.cucumber.core.cli.Main;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;






public class ApplicationHooks {


	 private WebDriver driver;
//	public static driverSupportedBrowser Browsertype;
	 private BrowserFactory browserfactory;
	
	 private ConfigReader configReader;
	 String browsername;
	 Properties prop;
	 Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		
		@Before(order = 0)
		public void getProperty() throws IOException {
			ExcelUtils.openExcel();
			
			configReader = new ConfigReader();
			browsername= configReader.initializingProperties();
		}		
	
	@io.cucumber.java.Before(order =1)
	public void launchBrowser() throws AWTException{ // invoking browser 
		//String browserName = prop.getProperty("browser");
		//System.out.println(browsername);
		BrowserFactory object = new BrowserFactory();
		driver = object.browserInvoke(browsername);
		
		log.info("current browser name is "+browsername);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
		log.info("current browser is closed "+browsername);
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(Constants.screenshotpath +"/"+ screenshotName+ ".png"));
			
			System.out.println("failed scenario");
			//System.out.println("screenshotName" +screenshotName);
			//System.out.println("sourcePath"+ sourcePath);
			log.info("Scenario is failed ");
			
		}
		else
		{
			
				// take screenshot:
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenshotName);
				
				File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File(Constants.screenshotpath +"/"+ screenshotName+ ".png"));
				
				System.out.println("passed scenario");
				//System.out.println("screenshotName" +screenshotName);
				//System.out.println("sourcePath"+ sourcePath);
				log.info("Scenario is passed ");
				
			}
		}
	

	
}
