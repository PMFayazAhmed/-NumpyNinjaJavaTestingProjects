package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.chrome.ChromeDriver;



public class GoogleChrome {
	
	public class WebDriver {

		ChromeDriver driver= null;	
	
@Test	
	public void opens() throws InterruptedException {
		driver.navigate().to("https://www.facebook.com/");
		   System.out.println("opens Facebook");
		   Reporter.log("opens facebook");
		   Thread.sleep(3000);
}


  @BeforeTest
  public void beforeTest() throws InterruptedException  {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	   driver = new ChromeDriver();
	  
	//   driver.get("https://www.google.com/");
	   
	   driver.navigate().to("https://www.google.com/");
	   
	   System.out.println("opens google");
	   Thread.sleep(3000);
	   
	   driver.manage().window().maximize();
	   
	

	  }
	
	}

	
	}

	


	

