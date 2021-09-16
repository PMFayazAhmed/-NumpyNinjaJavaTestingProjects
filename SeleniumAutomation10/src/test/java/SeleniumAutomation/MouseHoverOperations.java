package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class MouseHoverOperations {
	
	WebDriver driver = null;
	
	
	@Test
	public void f() {
		Reporter.log("Inside the Mouse Hover class");
	}
	
  @Test
  public void MouseHoverOperation() throws InterruptedException
  {
  
   WebElement mainmenu1 = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
   WebElement mainsubmenu1 = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
  
   Actions actobj = new Actions(driver); 
   actobj.moveToElement(mainmenu1).moveToElement(mainsubmenu1).click().perform();
    
   
   Reporter.log("Mouse Hover operation performed successfully");
   
   Thread.sleep(5000);
  }

  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.navigate().to("https://demo.opencart.com/");
	  Thread.sleep(1000);
	  
	  Reporter.log("Automation Practice Website Opens");
	  Thread.sleep(1000);
	  
	  driver.manage().window().maximize();
	    
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
	  driver.quit();

  }
  
  }
  
