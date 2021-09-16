package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class RadioButtonSelection {
	public class RadioButton {
		WebDriver driver= null;
		
	  @Test
	  public void radiobuttonworks () throws InterruptedException {
		  
		//Is Enabled
		  Reporter.log("Webelement is Enabled " + driver.findElement(By.xpath("//input[@value='Male']")).isEnabled());
		  
		  //Is Displayed
		  Reporter.log("Webelement is Displayed " +driver.findElement(By.xpath("//input[@value='Male']")).isDisplayed());
		  
		  
		   //To select the specific radiobutton
		  
		   driver.findElement(By.xpath("//input[@value='Male']")).click();
		   Reporter.log("Radio button is selected successfully");   
		   Thread.sleep(500);
	   
		  
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
	  
}
