package utils;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;





public class ConfigReader {

	private Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	
	  public String initializingProperties() {
	  
	//  String result = StringUtils.EMPTY; 
	  prop = new Properties(); 
	  try {
	  FileInputStream ip = new FileInputStream("C:\\Users\\daniel.r\\eclipse-workspace\\CucumberFramework\\src\\test\\resources\\configuration\\configuration.properties");
	  prop.load(ip);
	  
	  } catch (FileNotFoundException e) 
	  { e.printStackTrace(); 
	  } 
	  catch (IOException e) 
	  { e.printStackTrace(); 
	  }
	  
	  return prop.getProperty("browser");
	  
	  }
	
	
}