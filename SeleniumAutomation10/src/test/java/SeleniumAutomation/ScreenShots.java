package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ScreenShots {
	static WebDriver driver = null;
	
	
  @Test
  public void functionf() throws Exception{
	  takeSnapShot("GoogleHome");
	  
  }
  
  
  public static void takeSnapShot(String fileName) throws Exception{

      //Convert web driver object to TakeScreenshot

      TakesScreenshot scrShot =((TakesScreenshot)driver);

      //Call getScreenshotAs method to create image file

              File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

          //Move image file to new destination

              File DestFile=new File("C:\\Users\\ekpoo\\Documents\\Numpy Ninja\\workspace\\SeleniumAutomation\\test-output\\Screenshots\\"+fileName+".png");

              //Copy file at destination
              FileUtils.copyFile(SrcFile, DestFile);

  }
	  
 
  @BeforeTest

	public void beforeTest() throws InterruptedException {
		  
		  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		 driver.get("https://www.google.com/");
		   
		 //  driver.navigate().to("http://demo.automationtesting.in/Register.html");
		   
		  
		   Thread.sleep(3000);
		   
		   driver.manage().window().maximize();
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
		  driver.quit();
	  }

	}	   	     