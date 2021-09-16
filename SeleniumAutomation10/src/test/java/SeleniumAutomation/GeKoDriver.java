package SeleniumAutomation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GeKoDriver {
	
		
		   public static void main(String[] args) {
			  
			  
			 	  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver.exe");
				  WebDriver driver = new FirefoxDriver();
				  
				  driver.get("https://www.google.com/");
				   
				  	   
				  driver.manage().window().maximize();
			}

		}
			   

