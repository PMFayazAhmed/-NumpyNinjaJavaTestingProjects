package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Assignment1 {
	WebDriver driver = null;
	
	@Test
  public void f()  throws InterruptedException {
	 
	  driver.manage().window().maximize();
	  
	  
	  driver.navigate().refresh();
	   Thread.sleep(3000);
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	//   driver.get("https://www.google.com/");
	   
	   driver.navigate().to("https://www.godaddy.com/");
	   
	   System.out.println("opens godaddy");
	   Thread.sleep(3000);
	   
	   driver.manage().window().maximize();
	   
  }
  
  @AfterTest
  public void afterTest() {
	  
	 driver.close();
	 driver.quit();
	  

}
}
