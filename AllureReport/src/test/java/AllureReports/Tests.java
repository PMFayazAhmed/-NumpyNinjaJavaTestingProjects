package AllureReports;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;


@Listeners(TestExecutionListener.class)
public class Tests extends BaseClass {
	WebDriver driver;
  
  @BeforeTest
  public void setUp() {
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	}
  By UN = By.xpath("//*[@id=\"txtUsername\"]");
  By pass = By.xpath("//*[@id=\"txtPassword\"]");
  By loginbtn = By.xpath("//*[@id=\"btnLogin\"]");
  
  @Test(priority=1)
  public void Login()
  {
	  driver.findElement(UN).sendKeys("Admin");
	  driver.findElement(pass).sendKeys("admin123");
	  driver.findElement(loginbtn).submit();
  }  
  
  @Test(priority=2)
  @Description("Verify the Tab Title")
  @Epic("HRMHOME4373")
  @Story("HRM-583")
  @Step("Verify 'Orange HRM' title")
  @Severity(SeverityLevel.MINOR)
  public void VerifyTitle() throws InterruptedException
  {	  
		  Thread.sleep(2000);
		  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		  	
  }
  
  @Test(priority=3)
  public void registeration()
  {
	  throw new SkipException("Skip this testcase");
  }
  
 
  
  @AfterTest
  public void close() {
	  driver.close();
	  driver.quit();
  }

}
