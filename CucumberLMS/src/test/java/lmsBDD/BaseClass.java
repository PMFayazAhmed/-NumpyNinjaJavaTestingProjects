package lmsBDD;

import java.util.concurrent.TimeUnit;

import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
	private static boolean initialized = false;

	   private WebDriver driver;

	   @Before
	   public void setUp() throws Exception {
	      if (!initialized) {
	         // initialize the driver
	    	  System.setProperty("webdriver.chrome.driver", "E:\\API Testing\\Selenium\\Drivers\\chromedriver.exe");
	         driver = new ChromeDriver();
	         driver.manage().window().maximize();
		     //Reporter.log("Page is scrolled by pixel");
		     System.out.println("ebtered");
		      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         initialized = true;
	      }
	   }

	   public WebDriver getDriver() {
	      return driver;
	   }
	
	
}