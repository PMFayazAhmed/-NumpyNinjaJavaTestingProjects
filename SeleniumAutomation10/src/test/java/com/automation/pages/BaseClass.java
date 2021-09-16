package com.automation.pages;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import com.automation.utility.BrowserFactory;


 
	public class BaseClass {

		 public WebDriver driver;
		 
		   @BeforeClass
		   public void beforeClass()
		   {   
		   driver = BrowserFactory.startApplication(driver, "Chrome", "https://opensource-demo.orangehrmlive.com/");
		   Reporter.log("Welcome to Home page");  
		   }  

		   @AfterClass
		   public void afterClass() 
		   {
		   BrowserFactory.quitBrowser(driver);
		  
		   }
		   
		   
		}
