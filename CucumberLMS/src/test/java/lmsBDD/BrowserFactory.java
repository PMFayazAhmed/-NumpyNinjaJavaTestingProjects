package lmsBDD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browsername, String appurl)
	  {
	   System.out.println("url: " + appurl);
	   
	   if(browsername.equals("Chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");;
	    //("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	      driver = new ChromeDriver();
	   }
	   
	   else
	   {
	    System.out.println("Browser is unavailable");
	   }
	   //Launch url
	   driver.get(appurl); 
	   
	    //To maximize the browser
	     driver.manage().window().maximize();
	     //Reporter.log("Page is scrolled by pixel");
	     
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //  Thread.sleep(2000);  
	   
	   return driver;
	  }
	  
	  
	  public static void quitBrowser(WebDriver driver) 
	  {
	   driver.close();
	   driver.quit();
	  }

}
