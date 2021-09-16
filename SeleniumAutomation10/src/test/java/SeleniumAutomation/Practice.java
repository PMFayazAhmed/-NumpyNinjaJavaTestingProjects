package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Practice {
	
	WebDriver driver = null ;
	


  @Test
  public void f() {
	  
	 
	  
  }
  @BeforeTest
  public void beforeTest()  throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver(); 
	  driver.navigate().to("http://demo.automationtesting.in/Register.html");
	   
	  
	   Thread.sleep(3000);
	   
	   driver.manage().window().maximize();
 }

	
  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
	  
	    }

}
