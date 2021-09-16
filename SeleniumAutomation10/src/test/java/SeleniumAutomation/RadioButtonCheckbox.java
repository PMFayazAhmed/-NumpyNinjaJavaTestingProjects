package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class RadioButtonCheckbox  {
	
	WebDriver driver = null;
	

@Test
public void selectbox () throws InterruptedException {
	
	//To select the specific radiobutton  
	   driver.findElement(By.xpath("//input[@value='Male']")).click();
	   Reporter.log("Radio button is selected successfully");   
	   Thread.sleep(500);
		
	 //*[@id="basicBootstrapForm"]/div[5]/div/label[1]/input
	
	 //*[@id="basicBootstrapForm"]/div[5]/div/label[2]/input         
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
