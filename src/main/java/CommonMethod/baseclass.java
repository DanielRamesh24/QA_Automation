package CommonMethod;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ContractPage;

public class baseclass {

	public static WebDriver driver;
	ContractPage cp = new ContractPage(driver);

	public static void fillTextbox(WebElement a, String value) {
		a.sendKeys(value);
	}

	public static void clickBtn(WebElement a) {
		a.click();
	}

	
	public static void quitBrowser() {
		driver.quit();
	}

	public static void hndlAlerts() {
		driver.switchTo().alert().dismiss();
	}

	public void navigate_to_Objects(String objectName) throws InterruptedException, IOException {
		presenceOfElement(driver, By.xpath("//div[@style='background-image: url(/img/salesforce-noname-logo-v2.svg?width=128&height=128)']"));
		cp.Applauncher.click();
		presenceOfElement(driver, By.xpath("//h3[text()='Apps']"));
		cp.Search.sendKeys(objectName);
		staticWait(5);
	}
	public static void performClick(WebElement b) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", b);
	}
	public static void passvalues(WebElement a, String object) {
		a.sendKeys(object);
	}
	
	public static void clickable(WebElement click) {
		click.click();
	}

	public static void staticWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public static WebElement presenceOfElement(WebDriver driver, By by) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}
	
	public static void javaexeClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
	}

}
