package SeleniumAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SampleDriver {
	  @Test
	  public void f() {
		  System.out.println("Inside the Test Method");
		  System.out.println("Inside the Hello Method");
		  System.out.println("Welcome");
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Inside the Before Method");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("Inside the after Method");
	  }

	}
