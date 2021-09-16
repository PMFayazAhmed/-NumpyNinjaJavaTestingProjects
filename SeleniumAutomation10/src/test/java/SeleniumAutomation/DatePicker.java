package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DatePicker {
	
		WebDriver driver = null;
		
  @Test
  public void testWebElement () throws InterruptedException {
	  
	  //selecting the DatePicker
	  
	  //option 1
	  driver.findElement(By.id("from")).click();
	  Thread.sleep(4000);
	  
	  driver.findElement(By.linkText("7")).click();
	  Thread.sleep(4000);
	  
	  
	  //option 2
	  
	  driver.findElement(By.id("from")).clear();
	  
	  driver.findElement(By.id("from")).sendKeys("08/11/2022");
	  
	  
	  driver.findElement(By.id("to")).click();
	  
	  driver.findElement(By.linkText("16")).click();
	  
	  Thread.sleep(2000);
	  
	  	  
  }
  @BeforeTest

	public void beforeTest() throws InterruptedException {
		  
		  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		//   driver.get("https://www.google.com/");
		   
		   driver.navigate().to("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
		   
		    Thread.sleep(3000);
		   
		   driver.manage().window().maximize();
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
		  driver.quit();
	  }

	}	   	   