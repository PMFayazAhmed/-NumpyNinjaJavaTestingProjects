package SeleniumAutomation;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ScreenshotsPractice {
	
	WebDriver driver = null;
	
  @Test
  public void Screenshotdemo()   throws InterruptedException, IOException {
	  
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  
	  FileUtils.copyFile(source, new File("C:\\Users\\Isaias773\\eclipse-workspace\\SeleniumAutomation10\\Screenshots\\MyNEwScore.png"));
	  
	  System.out.println("Screenshot captured");
	  
	  
	  
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