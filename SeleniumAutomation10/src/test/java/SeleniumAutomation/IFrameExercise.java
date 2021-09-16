
package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class IFrameExercise {
	
	WebDriver driver = null;
	
	@Test
	public void f()
	{
		Reporter.log("Inside the IFrameExercise Class");
	}
	
  @Test
  public void IFrameOperation ()   throws InterruptedException {
	  
	  
	  //driver.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");
	  
	  driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='eduFooterWrap']//iframe[1]")));
      Thread.sleep(5000);
      Reporter.log("Identifying the Iframe");
      
      
      
      driver.findElement(By.xpath("//input[@name='name']")).sendKeys("SoftwareTestingHelp.com");
      Thread.sleep(5000);
      Reporter.log("Entering the value for the edit which is place inside the frame");
      
      
      driver.switchTo().defaultContent();
      Reporter.log("Switching to the default page");
      
	  
	  
  }
  @BeforeTest

 	public void beforeTest() throws InterruptedException {
 		  
 		  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
 		  driver = new ChromeDriver();
 		  
 		//   driver.get("https://www.google.com/");
 		   
 		   driver.navigate().to("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction");
 		   
 		    Thread.sleep(3000);
 		   
 		   driver.manage().window().maximize();
 	  }

 	  @AfterTest
 	  public void afterTest() {
 		  driver.close();
 		  driver.quit();
 	  }

 	}	   	   