package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SelectCheckboxSelect  {
	 
	WebDriver driver = null;
	

@Test
public void selectbox () throws InterruptedException {
	
	
	 //To scroll the page
    JavascriptExecutor js = (JavascriptExecutor) driver;  //Interface
    js.executeScript("window.scrollBy(0,300)");
    Reporter.log("Page is scrolled by pixel");  
	
	 
 // Three ways to select command anyone can be used 
	
	
	Select skills = new Select(driver.findElement(By.xpath("//*[@id=\"Skills\"]")));
	
	   skills.selectByVisibleText("Adobe InDesign");
	   Thread.sleep(3000);
	   skills.selectByIndex(2);
	   Thread.sleep(3000);
	   skills.selectByValue("APIs");
	   Thread.sleep(3000);
}
@BeforeTest

	public void beforeTest() throws InterruptedException {
		  
		  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		//   driver.get("https://www.google.com/");
		   
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