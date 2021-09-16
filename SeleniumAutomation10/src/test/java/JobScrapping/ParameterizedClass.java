package JobScrapping;

//import java.util.Iterator;
import java.util.List;


//import java.awt.Robot;
//import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class ParameterizedClass {
	WebDriver driver = null;
	//WebDriver frameelement = null;
		int i, jobsperpage = 0;
		
    	@Parameters("keyWord")
    	@Test
    	public void Parameterpassing(String keyWord) throws InterruptedException
    	{
    		if(keyWord.equalsIgnoreCase("Selenium"))
           	{
           	  System.out.println("The keyword value is : " +keyWord);
           	}else if(keyWord.equalsIgnoreCase("API Testing"))
           	{
           		System.out.println("The keyword value is : " +keyWord);
                   	
           	}else if(keyWord.equalsIgnoreCase("Postman"))
           	{
           		System.out.println("The keyword value is : " +keyWord);
           	}
           	else if(keyWord.equalsIgnoreCase("Rest Assured"))
           	{
           		System.out.println("The keyword value is : " +keyWord);
           	}	 

           		WebElement searchBox = driver.findElement(By.name("q"));
           	 //Sending keyword value
           	 searchBox.sendKeys(keyWord);
           	 System.out.println("The search keyword entered is : " +keyWord);	
            	 
           	 //Verifying the keyword on UI
           	 Thread.sleep(1000);
           	 
           	 WebElement WhereBox = driver.findElement(By.id("text-input-where"));
           	 //Sending keyword value
           	WhereBox.click();           	
           	WhereBox.sendKeys(Keys.CONTROL + "a");
           	WhereBox.sendKeys(Keys.DELETE);
           	 System.out.println("The Where box is cleared");	
           	 Thread.sleep(2000);
           	
           	// rb = new Robot();
            
            
            // press Control+V for pasting
           //	rb.keyPress(KeyEvent.VK_ENTER);
           // rb.keyRelease(KeyEvent.VK_ENTER);
            
           	 WebElement FindButton = driver.findElement(By.className("icl-WhatWhere-buttonWrapper"));
           	 FindButton.submit();
           	System.out.println("The Find Jobs button is clicked");	
           	Thread.sleep(1000);
           	 
           driver.findElement(By.id("filter-dateposted")).click();
           	//yosegi-FilterPill-dropdownListItemLink
           driver.findElement(By.linkText("Last 24 hours")).click();
           if (driver.findElement(By.id("popover-foreground")).isDisplayed())
           {
        	   driver.findElement(By.id("popover-x")).click();
           }
           Thread.sleep(1000);
           JavascriptExecutor js = (JavascriptExecutor)driver;
      	  js.executeScript("window.scrollBy(0,300)");
      	  
      	  	Reporter.log("Scrolled page");
           	 
           	System.out.println("Page Title:" + driver.getTitle());
	        System.out.println("Jobs Count: " + driver.findElement(By.id("searchCount")).getText());
	        String Totaljobs = driver.findElement(By.id("searchCount")).getText().split(" ")[3];
	        System.out.println(Totaljobs);
	        	List<WebElement> jobs= driver.findElements(By.className("slider_container"));
	        
	        int jobsPerPage=jobs.size();
	        if (jobsperpage >= 15)
	        {
	        	
	        }
	        System.out.println(jobsPerPage);
	         
	        for(int i=0;i<jobsPerPage;i++)
	        {
	        	String DatePosted =  jobs.get(i).findElement(By.className("date")).getText();
	        	System.out.println("Date Posted: "+ DatePosted);
	         
	         WebElement resultContent= jobs.get(i).findElement(By.className("resultContent"));
	         WebElement jobTitle = resultContent.findElement(By.className("jobTitle"));
	         //System.out.println(jobTitle.getText().substring(3));
	         jobTitle.click();
	         Thread.sleep(1000);	  
	         WebElement jobcontainer = driver.findElement(By.id("vjs-container"));
	         jobcontainer.click();
	         Thread.sleep(1000);	         
	         WebElement wFrame = jobcontainer.findElement(By.xpath("//*[@id=\"vjs-container-iframe\"]"));	         
	         //System.out.println("Identifying the IFrame ");
	         wFrame.click();
	         Thread.sleep(1000);
	         //System.out.println("Clicking on the IFrame ");
	         Thread.sleep(1000);
	         System.out.println("The Job Link is: " + wFrame.getAttribute("src"));
	         Thread.sleep(1000);
	         driver.switchTo().frame(wFrame);
	         Thread.sleep(2000);
	         WebElement m = driver.findElement(By.xpath("//body"));
	         WebElement m1 = m.findElement(By.className("jobsearch-JobComponent-embeddedHeader"));
	         //String content = m1.getText();
	         m1.click();
	         //System.out.println(content);
	         
	         String jobtitle = m1.findElement(By.xpath("//div/h1[contains(@class,'icl-u-xs-mb')]")).getText();
	         //System.out.println(content1);
	         
	         //System.out.println("Job Title is: " + content1);
	         
	         if (jobtitle.contains("- job post"))
	         {
	        	 //char[] ch =  content1.toCharArray();
	        	 for (int icnt = jobtitle.length() - 1; icnt >= 0; icnt--) {
	        		 if(jobtitle.charAt(icnt)=='-')
	        		 {
	        			System.out.println("Job Title is: " + jobtitle.substring(0, icnt-1));
	        			break;
	        			 
	        		 }
	                 
	             }
	         }
	         
	         //String jobcompnayname = m1.findElement(By.xpath("//div[contains(@class,'icl-u-lg-mr')]")).getText();
	         //jobsearch-JobDescriptionSection-sectionItem
	         //System.out.println("Job Category is: " + m1.getText());
	         
	         String jobcompnayname = m1.findElement(By.xpath("//div[contains(@class,'icl-u-lg-mr')]")).getText();
	         System.out.println("Job CompanyName is: " + jobcompnayname);
	         String joblocation = m1.findElement(By.xpath("//div[contains(@class,'icl-u-xs-mt')]//div[2]")).getText();
	         
	         Object[] a = joblocation.lines().toArray();
	         
	         if(a.length==2)
	         {
	        	 //System.out.println("Job Location is: " + a[0].toString());
		         System.out.println("Job Location is: " + a[1].toString());
	         }
	         else
	         {
	        	 //System.out.println("Job Location is: " + a[0].toString());
		        // System.out.println("Job Location is: " + a[1].toString());
		         System.out.println("Job Location is: " + a[2].toString());
	         }
	         
	         
	         
	         Boolean isPresent = m1.findElements(By.xpath("//div[contains(@class,'jobsearch-JobMetadataHeader-item ')]")).size() > 0;
			
	         if(isPresent)
	         {
	        	 Boolean isChildPresent = m1.findElement(By.xpath("//div[contains(@class,'jobsearch-JobMetadataHeader-item ')]")).
						  findElements(By.xpath("//span[contains(@class,'icl-u-xs-mt')]")).size() > 0;
						if(isChildPresent)
						{
							String sjobcategory = m1.findElement(By.
									  xpath("//div[contains(@class,'jobsearch-JobMetadataHeader-item ')]")).
									  findElement(By.xpath("//span[contains(@class,'icl-u-xs-mt')]")).getText();
									  System.out.println("Job Category is: " + sjobcategory);
						}
						else
						{
							System.out.println("Job Category is not available");
							
						}
	        	
	         }
	         else
	         {
	        	 
						System.out.println("Job Category is not available");
				
	         }
	        		 
				
				
				  
				 
				
	         //jobsearch-InlineCompanyRating
	        WebElement jobdetail = m.findElement(By.className("jobsearch-JobComponent-embeddedBody"));
	        jobdetail.click();
			/*
			 * String DatePosted = jobdetail.findElement(By.xpath(
			 * "//div[contains(@class,'jobsearch-JobMetadataFooter')]")).getText();
			 * //System.out.println(DatePosted);
			 * 
			 * Object[] dp = DatePosted.lines().toArray();
			 * 
			 * System.out.println("Job Posted is: " + dp[1].toString());
			 */
	         
	         
	        String JobDescription = jobdetail.findElement(By.xpath("//div[contains(@class,'jobsearch-jobDescriptionText')]")).getText();
	        
	         //String content = m.findElement(By.xpath("//[@id=\"viewJobSSRRoot\"]/div[1]/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]")).getText();
	         
	         
	         System.out.println("Job details is: " + JobDescription);
				
				  
			
				 
	         driver.switchTo().defaultContent();
	         Thread.sleep(2000);
	         jobTitle.click();        
	         System.out.println("-------*******---------");
	        }
	        
	       
           	  
				
           	
           	}
			     	
    	@BeforeTest
    	  public void beforeTest() {
    		//Set property for chrome driver exe path
    			 System.setProperty("webdriver.chrome.driver", "E:\\API Testing\\Selenium\\Drivers\\chromedriver.exe");
    			 
    			    
    			  //navigate to website 
    			  driver = new ChromeDriver();
    			
    			  driver.navigate().to("https://indeed.com");
    			  driver.manage().window().maximize();
    	  }

    	  @AfterTest
    	  public void afterTest() {
    		  //driver.close();
    		 // driver.quit();
    	  }
}