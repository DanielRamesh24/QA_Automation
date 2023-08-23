package CommonMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {

	public static WebDriver driver;
	
	public static void fillTextbox(WebElement a, String value) {
	    a.sendKeys(value);
	    }

	public static void clickBtn(WebElement a) {
        a.click();
	}

	public static void implicitWait(int w) {
        driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);
	}
	
	public static void quitBrowser() {
         driver.quit();
	}

	public static void hndlAlerts() {
       	driver.switchTo().alert().dismiss();
	}

	
}
