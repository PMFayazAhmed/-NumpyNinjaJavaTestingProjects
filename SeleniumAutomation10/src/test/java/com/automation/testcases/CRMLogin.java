package com.automation.testcases;


import org.testng.annotations.Test;

import com.automation.utility.BrowserFactory;
import com.automation.pages.BaseClass;
import com.automation.pages.LoginPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

//TestNG Class
public class CRMLogin extends BaseClass {
	@Test 
	public void f () {
		Reporter.log("Welcome to CRMLogin Test Cases");
	}
 
  
	  
	  @Test
	  public void loginapp()  throws InterruptedException
	  {
	   //To get the page title
	    Reporter.log("Page url : " +driver.getTitle());
	    
	    Thread.sleep(5000);
	    //Abstraction is showing the essential features and hiding the background details
	    
	    //To create instance of the Login Page Objects class   
	    LoginPageObjects loginPO = PageFactory.initElements(driver, LoginPageObjects.class);   
	    loginPO.loginvalidation("Admin", "admin123");
	    
	    Thread.sleep(5000);
	    
	    
	   }

	  
	  
  }

