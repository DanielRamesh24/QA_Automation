package CommonMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

	public static void implicitWait(int w) {
		driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void hndlAlerts() {
		driver.switchTo().alert().dismiss();
	}

	public void navigate_to_Objects(String objectName) throws InterruptedException, IOException {

		Thread.sleep(5000);
		
		cp.Applauncher.click();
		Thread.sleep(2000);
		presenceOfElement(driver, By.xpath("//h3[text()='Apps']"));
		cp.Search.sendKeys(objectName);
		Thread.sleep(5000);

	}

	public static void staticWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
