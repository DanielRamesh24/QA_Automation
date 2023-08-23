package utils;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;





public class SeleniumUtils {
	
	public void dropDown(WebDriver driver) throws InterruptedException {// to get the dropdown methods
//		Select values from Dropdown
			Select DropDown = new Select(driver.findElement(By.xpath("")));
			DropDown.selectByIndex(0);
			Thread.sleep(3000);
			DropDown.selectByVisibleText("");
			DropDown.selectByValue(null);
	// get selected values Select/multiselect
			List<WebElement> selectedElements = DropDown.getAllSelectedOptions();
			DropDown.getOptions();
			DropDown.getFirstSelectedOption();
			
//		Deselect values from Select
			Thread.sleep(2000);
			DropDown.deselectByIndex(3);
			DropDown.deselectAll();
			DropDown.deselectByValue(null);
			DropDown.deselectByVisibleText(null);
		}
		public void alertAccept(WebDriver driver) {//to get the alert methods
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	        alert.dismiss();
	        alert.getText();
	    }
		 public void verifyingElement(WebElement element,WebDriver driver) throws Exception{// to get the verifyingElement methods
		        boolean checkStatus;
		        checkStatus=element.isSelected(); 
		        checkStatus=element.isDisplayed();
		        checkStatus=element.isEnabled();
		        }
		
		 public void frameHandling(WebElement element,WebDriver driver) {// to get the frameHandling methods
				driver.switchTo().frame(1);	
				driver.switchTo().defaultContent();
				driver.switchTo().frame("frame2");		
		 }
		  public static void windowHandling(WebDriver driver) throws IOException, InterruptedException {// to get the windowHandling methods
			  String currentWindow = driver.getWindowHandle();
				System.out.println(currentWindow);
				Set<String> allWindowhandles = driver.getWindowHandles();
				System.out.println(allWindowhandles);
				Set<String> allWindowhandles1 = driver.getWindowHandles();
				for(int i=0;i<allWindowhandles1.size();i++) {
					String windowhandle = allWindowhandles1.toArray()[i].toString();
					System.out.println(windowhandle);
					if(!windowhandle.equals(currentWindow)) {
						driver.switchTo().window(windowhandle);
						String fileURL = driver.getCurrentUrl();
						System.out.println(fileURL);
						
						Thread.sleep(5000);
						
						
						URL pdfUrl = new URL(fileURL);
						System.out.println("pdf url ");
						//InputStream in = pdfUrl.openStream();
						System.out.println("inputstream");
						
						
						BufferedInputStream bf = new BufferedInputStream(pdfUrl.openStream());
						System.out.println("bufferedinputstream");
						
						PDDocument doc  = PDDocument.load(bf);
						//PDFParser TestPDF = new PDFParser( (RandomAccessRead) bf);

						//TestPDF.parse();
						System.out.println("docload");
						//int numberOfPages = doc.getNumberOfPages();
					//	System.out.println("The total number of pages "+numberOfPages);
						String content = new PDFTextStripper().getText(doc);
						System.out.println(content);
						//doc.close();
						
						Assert.assertTrue(content.contains("Important: Save the completed PDF form (use menu File - Save)."));
						//Assert.assertTrue(pdfContent.contains("The Pdf995 Suite offers the following features"));
						System.out.println(content);
						
						
//						System.out.println(driver.findElement(By.id("")).getText());
						//driver.close();
					}
				}
				
				//driver.switchTo().window(currentWindow);
		  }
		  
		  
		  public static void verifyContentInPDf(String FileURL) throws MalformedURLException {
				//specify the url of the pdf file
				
				//String url ="http://www.pdf995.com/samples/pdf.pdf";
				//String url ="http://foersom.com/net/HowTo/data/OoPdfFormExample.pdf";
				//driver.get(url);
				try {
					String pdfContent = readPdfContent(FileURL);
					
					Assert.assertTrue(pdfContent.contains("Important: Save the completed PDF form (use menu File - Save)."));
					//Assert.assertTrue(pdfContent.contains("The Pdf995 Suite offers the following features"));
					System.out.println(pdfContent);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		  public static  String readPdfContent(String url) throws IOException {
				
				URL pdfUrl = new URL(url);
				InputStream in = pdfUrl.openStream();
				BufferedInputStream bf = new BufferedInputStream(in);
				PDDocument doc = PDDocument.load(bf);
				int numberOfPages = getPageCount(doc);
				System.out.println("The total number of pages "+numberOfPages);
				String content = new PDFTextStripper().getText(doc);
				System.out.println(content);
				doc.close();
			
			return content;
		}
			
			public static int getPageCount(PDDocument doc) {
				//get the total number of pages in the pdf document
				int pageCount = doc.getNumberOfPages();
				return pageCount;
				
			}
		  
		  
		  
		  
		   public void browserNavigation(WebDriver driver) throws InterruptedException {//to get the browserNavigation methods
			   	driver.manage().window().maximize();
				driver.navigate().to("");
				driver.navigate().back();
				driver.navigate().forward();
				Thread.sleep(8000);
				driver.navigate().refresh();
				driver.close();
		   }
		   	public void elementMethods(WebElement element,WebDriver driver) {// to get the elementMethods 
		   		element.click();
		   		element.sendKeys("");
		   		element.clear();
		   		element.getAttribute("name");
		   		element.getLocation();
		   		element.getTagName();
		   		element.getText();
		   		element.getSize();
		   	}
		   	public static void mouseActions(WebDriver driver) throws Exception{// to get the mouseActions methods
		   		//Actions action = new Actions(driver);
//				double click
				//action.doubleClick(element).perform();
//				drag and drop
				//driver.get("http://only-testing-blog.blogspot.com/2014/09/drag-and-drop.html");
				//action.dragAndDrop(element, element).perform();			
//				Resize the element
		   		JavascriptExecutor js = (JavascriptExecutor) driver;
		   		js.executeScript("window.scrollBy(0,800)", "");
				
				/*
				 * action.dragAndDropBy(element, 150, 150).perform(); // mouse hover
				 * action.moveToElement(element).perform();
				 * action.clickAndHold(element).moveToElement(element).release().build().perform
				 * (); // Resize the element method 2 j.executeScript("window.scrollBy(0,500)");
				 * action.clickAndHold(element).moveByOffset(150,
				 * 150).release().build().perform(); // Keyboard operations
				 * action.click(element).perform();
				 * action.keyDown(Keys.SHIFT).sendKeys("user").build().perform();
				 * action.sendKeys("qa").build().perform(); action.keyUp(Keys.SHIFT).perform();
				 * action.sendKeys("automation").build().perform();
				 */
		   	}
		   	public void keyRobots(WebElement element,WebDriver driver) throws Exception{//to get the keyRobots methods
		   		Robot robot = new Robot();
		   		Actions a = new Actions(driver);
				a.moveToElement(element).click().build().perform();
				StringSelection s= new StringSelection("D:\\text2.txt");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
		   		robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
		   	}
		 	public void keyboardactions(WebElement element,WebDriver driver) throws Exception{//to get the keyRobots methods
		   		Robot robot = new Robot();
		   		Actions a = new Actions(driver);
				
//				robot.keyPress(KeyEvent.VK_DOWN);
//				robot.keyRelease(KeyEvent.VK_DOWN);
//				robot.keyPress(KeyEvent.VK_DOWN);
//				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
		   	}
		   	
		   	public void timeHandling(WebElement element,WebDriver driver) throws InterruptedException {// to get the timeHandling methods
		   		Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
			//	WebDriverWait wait = new WebDriverWait(driver, 40);
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
			//	wait.until(ExpectedConditions.alertIsPresent());
		   	}
		   	public void Screenshot(WebDriver driver) throws IOException {// to get the Screenshot methods
		   		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File("location"));
		   	}
		   	
		   	
			/*
			 * public static String getScreenshot(WebDriver driver, String screenshotName)
			 * throws IOException { // to capture the screenshots String dateName = new
			 * SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date()); TakesScreenshot ts =
			 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
			 * 
			 * // after execution, you could see a folder "FailedTestsScreenshots" under src
			 * folder String destination = Constant.screenshotpath + screenshotName +
			 * dateName + ".png";
			 * 
			 * File finalDestination = new File(destination); FileUtils.copyFile(source,
			 * finalDestination); return destination; }
			 */
		  	 
		   	public static void matchingHighlights(WebDriver driver, WebElement element) {
		   		//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		   		//jsExecutor.executeScript("arguments[0].style.background='green'", element); 
		   		//String temp=(String)jsExecutor.executeScript("arguments[0].style.background='green'", element);
		   		((JavascriptExecutor) driver).executeScript("arguments[0].style.background='green'", element);
		   	}
		   	
		   	public static void mismatchingHighlights(WebDriver driver, WebElement element) {
		   		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		   		jsExecutor.executeScript("arguments[0].style.background='red'", element);
		   	}
		   	
		   	public static void uploadingFile(String uploadfilename) throws Exception{//to get the keyRobots methods
		   		Robot robot = new Robot();
		   		
		   		StringSelection s= new StringSelection(uploadfilename);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(1000);
		   		robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
		   	}
}