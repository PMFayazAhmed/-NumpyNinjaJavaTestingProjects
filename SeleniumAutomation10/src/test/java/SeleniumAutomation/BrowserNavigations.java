package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;


public class BrowserNavigations {
	
	
	public class WebDriver {

	ChromeDriver driver= null;
   
@Test
public void  loginpage() throws InterruptedException   {
	  driver.navigate().to("https://www.facebook.com/");
	   System.out.println("opens Facebook");
	   Reporter.log("opens facebook");
	   Thread.sleep(3000);
	   
	   driver.navigate().back();
	   System.out.println("goes back to Google");
	   Thread.sleep(3000);
	   
	   driver.navigate().forward();
	   System.out.println("goes forward");
	   Thread.sleep(3000);
	   
	   driver.navigate().refresh();
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

