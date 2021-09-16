package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class RobotClass  {
	
	WebDriver driver = null;
	
		
	public void sendkeyexercise() throws InterruptedException 
	   
	   {
	  Thread.sleep(8000);  
	     
	  //Selenium cannot identify Windows based application
	  //Using SendKeys methods   

	  WebElement button = driver.findElement(By.cssSelector("input#file-upload"));
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver; 
	  js.executeScript("arguments[0].click();",button); //Click action on the button
	   
	  
	     //click on ‘Choose file’ to upload the desired file
	  button.sendKeys("C:\\Selenium\\RobotClass\\DatePicker.txt"); //Uploading the file using sendKeys
	  System.out.println("File is Uploaded Successfully");
	         
	      Reporter.log("Successfully executed using Sendkeys "); 
	   
	  Thread.sleep(8000);
	  
	   }
	
	@Test
	
	
	 public void robotclass() throws AWTException, InterruptedException
	 { 
	  //Selenium cannot identify Windows based application
	  //Robot Class methods   

	//  WebElement button = driver.findElement(By.cssSelector("input#file-upload"));
	//  JavascriptExecutor js = (JavascriptExecutor) driver; 
	//  js.executeScript("arguments[0].click();",button); //Click action on the button
	
		
		driver.findElement(By.xpath("//span[contains(text(),'Choose CV')]")).click();
		
		
		
		
		Thread.sleep(2000); 
	
	  
	  // creating object of Robot class
	     Robot rb = new Robot();
	   
	  // copying File path to Clipboard
	     StringSelection str = new StringSelection("C:\\Selenium\\RobotClass\\DatePicker.txt");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	     
	     
	     Thread.sleep(2000);
	     
	  
	     
	     
	      // press Control+V for pasting
	      rb.keyPress(KeyEvent.VK_CONTROL);
	      rb.keyPress(KeyEvent.VK_V);
	  
	     // release Control+V for pasting
	     rb.keyRelease(KeyEvent.VK_CONTROL);
	     rb.keyRelease(KeyEvent.VK_V);
	  
	     // for pressing and releasing Enter
	     rb.keyPress(KeyEvent.VK_ENTER);
	     rb.keyRelease(KeyEvent.VK_ENTER);
	     
	     Thread.sleep(8000);
	     Reporter.log("Successfully executed using Robot Class ");
	     
	   }
	
	
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.manage().deleteAllCookies();
	  
	  driver.navigate().to("https://www.monsterindia.com/seeker/registration");
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
  