package abstractclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverClass {


		 protected  WebDriver driver;
			public DriverClass(WebDriver driver) { 
				this.driver = driver;
				PageFactory.initElements(this.driver, this);
			
				
			}
		
}
