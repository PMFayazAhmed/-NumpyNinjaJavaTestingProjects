package SeleniumAutomation;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class CheckBoxExercise  {
	
	WebDriver driver = null;
	

@Test
public void f() {
		  
		Reporter.log("Inside Checkbox Exercise Class") ;
	
	  }
@Test

	public void checkboxvalidation() throws InterruptedException  {   
		 //To select specific checkbox
		  //IsDisplayed
     	driver.findElement(By.id("checkbox1"));	
		Reporter.log("Checkbox : " + driver.findElement(By.id("checkbox1")).isDisplayed());
		
		//IsEnabled
		Reporter.log("Checkbox : " + driver.findElement(By.id("checkbox1")).isEnabled());
		
		//IsSelected 
		Reporter.log("Before Checkbox Status : " + driver.findElement(By.id("checkbox1")).isSelected());
		
		//Checkbox Selection 
		driver.findElement(By.id("checkbox1")).click();
		
		//IsSelected
		Reporter.log("After Checkbox Status : " + driver.findElement(By.id("checkbox1")).isSelected());
		
		//driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		
		Reporter.log("checkbox is selected successfully");
		Thread.sleep(5000);
		
	}
@Test

	//To select all the Checkbox using Dynamically 
	public void selectallcheckbox() throws InterruptedException {
		
		//Java collection - List
		// Java for ...each loop
		
	   //Select all the checkbox
	
	  //  WebElement checkboxcount = driver.findElements(By.xpath("//input[@type='checkbox']"));
	
	  //driver.get("http://demo.automationtesting.in/Register.html");
	  java.util.List<WebElement> checkboxcount = driver.findElements(By.xpath("//input[@type='checkbox']"));
	    	
       Reporter.log("Dynamically Number of Checkbox is : "+ checkboxcount.size()); //count of checkbox
       
        checkboxcount.size();
        
       for(WebElement chkboxvalue : checkboxcount) {
      
    	chkboxvalue.click();
       
    	Reporter.log("Selected Checkbox ID : " + chkboxvalue.getAttribute("id"));
    	     	    
    	Reporter.log("Selected Checkbox Value : " + chkboxvalue.getAttribute("value"));
    	    	       
    	   
       }  	   
    	  
       Thread.sleep(5000);
}
@Test


//To select specific checkbox
	public void selectSpecificCheckbox() throws InterruptedException {
	
	
	  
	  
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