package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SelectBox  {
	
	WebDriver driver = null;
	

@Test
public void selectbox () throws InterruptedException {
	
	//Select skills = new Select(driver.findElement(By.xpath("//*[@id=\"Skills\"]")));
	
//	   skills.selectByVisibleText("Adobe InDesign");
//	   Thread.sleep(3000);
//	   skills.selectByIndex(2);
//	   Thread.sleep(3000);
//	   skills.selectByValue("APIs");
//	   Thread.sleep(3000);
	   
	   	     
	   
	    //To scroll the page
	       JavascriptExecutor js = (JavascriptExecutor) driver;  //Interface
	       js.executeScript("window.scrollBy(0,300)");
	       Reporter.log("Page is scrolled by pixel");  
	       
	    //Define the Webelement first
	    WebElement dropdownskills = driver.findElement(By.id("Skills"));
	    
	    //Inbuilt Select class
	    Select dropdownvalue = new Select(dropdownskills);
	    
	    //SelectByVisibleText()
	    dropdownvalue.selectByVisibleText("Adobe InDesign");
	    Reporter.log("Selected using VisibleText : Adobe InDesign " );
	    
	    Thread.sleep(2000);
	    
	    //SelectByValue using Value Attribute
	    
	    dropdownvalue.selectByValue("Android"); //Android
	    Reporter.log("Selected using value : Android ");
	    Thread.sleep(2000); 
	     
	    //SelectByIndex
	    dropdownvalue.selectByIndex(3);
	    Reporter.log("Selected using index : 3 ");
	    Thread.sleep(2000);    
	  
	    //Without using select By using getOptions
	    selectoption(dropdownskills,"Art Design");
	    Thread.sleep(2000);
	    
	    //Define the Webelement first
	    WebElement dropdownskills1 = driver.findElement(By.id("countries"));
	    selectoption(dropdownskills1,"Algeria");
	    Thread.sleep(2000);

	    
	    
}
	  //Reusable function  
	    //Parameters : Dropdown name and Value
	    //Dynamically without the select methods
	    
	    public static void selectoption(WebElement elements, String value)
	    {  
	     
	     Select dropdownvalue = new Select(elements); 
	     
	    java.util.List<WebElement> optionscount = dropdownvalue.getOptions();
	     
	    //using for...each  loop
	     for(WebElement option:optionscount)
	     {
	       if(option.getText().equals(value)) //Condition
	       {
	       option.click();  
	       Reporter.log("Without Select method by using get options count :  " + value);
	       break;
	       }
	     }
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