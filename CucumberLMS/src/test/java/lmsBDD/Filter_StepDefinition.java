package lmsBDD;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Filter_StepDefinition {
	int rowSize, iEditrow;
	WebElement dropdownUserRole,dropdownBatch,dropdownProgram = null;
	String sUserEmail,sProgram,sBatch;
	public WebDriver driver;
	WebElement tblUsers = null;
	List<WebElement> tblrows = null;
	
	@Before
	   public void beforeClass()
	   {   
		driver = RegisteredUsers_StepDefinition.driver;
		
	   
	   }     
	
	@Given("Admin has entered {string} as the UserEmail filter criteria")
	public void admin_has_entered_as_the_user_email_filter_criteria(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			driver.findElement(By.xpath("//input[@id='txtUserEmail']")).sendKeys(string);
			assertTrue("The UserEmail entered is valid",driver.findElement(By.xpath("//input[@id='txtUserEmail']")).getText()==string);
			sUserEmail = string;
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	    
	}

	@When("Admin clicks the Search button")
	public void admin_clicks_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			assertTrue("The Search button is available",driver.findElement(By.xpath("//button[@id='btnSearch']")).isDisplayed());
			driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Then("Admin is able to see the information in the table view with row count as {int}")
	public void admin_is_able_to_see_the_information_in_the_table_view_with_row_count_as(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
			tblrows = tblUsers.findElements(By.tagName("tr"));
			assertTrue("There are {int} rows found",tblrows.size()==int1);
						
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Then("User Email in the first cell of the table is {string}")
	public void user_email_in_the_first_cell_of_the_table_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
			tblrows = tblUsers.findElements(By.tagName("tr"));
			for (int i=0;i<tblrows.size();i++)
			{
				List<WebElement> cols = tblrows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<cols.size();j++)
				{
					if(cols.get(j).getAttribute("InnerHTML")==string)
					{
						assertTrue("The row is filtered with UserEmail",cols.get(j).getAttribute("InnerHTML")==string);
					}
				}
			}
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
		
		
	}

	@Given("Admin has entered {string} as the Batch filter criteria")
	public void admin_has_entered_as_the_batch_filter_criteria(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
				dropdownBatch = driver.findElement(By.className("selFilterBatch"));
				assertTrue(selectoption(dropdownBatch,string)==true);
				sBatch = string;
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Batch in the {int} column of every row of the table is {string}")
	public void batch_in_the_column_of_every_row_of_the_table_is(Integer int1, String string) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		for(int i=0;i<tblrows.size();i++)
		{
			List<WebElement> cols = tblrows.get(i).findElements(By.tagName("td"));
			try
			{
				assertTrue("Value of batch in {int} column is valid", cols.get(int1).getAttribute("InnerHTML")==string);
			}
			catch(AssertionError ae)
			{
				System.out.println(ae.getMessage());
				
			}	
			
		}
	    
	}

	@Given("Admin has entered {string} as the Program filter criteria")
	public void admin_has_entered_as_the_program_filter_criteria(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
				dropdownProgram = driver.findElement(By.className("selFilterProgram"));
				assertTrue(selectoption(dropdownProgram,string)==true);
				sProgram = string;
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Program in the {int} column of every row of the table is {string}")
	public void program_in_the_column_of_every_row_of_the_table_is(Integer int1, String string) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		
		for(int i=0;i<tblrows.size();i++)
		{
			List<WebElement> cols = tblrows.get(i).findElements(By.tagName("td"));
			try
			{
				assertTrue("Value of Program in {int} column is valid", cols.get(int1).getAttribute("InnerHTML")==string);
			}
			catch(AssertionError ae)
			{
				System.out.println(ae.getMessage());
				
			}	
			
		}
	}

	@Given("Admin has mentioned {string} as the UserEmail filter criteria")
	public void admin_has_mentioned_as_the_user_email_filter_criteria(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			driver.findElement(By.xpath("//input[@id='txtUserEmail']")).sendKeys(string);
			assertTrue("The UserEmail entered is valid",driver.findElement(By.xpath("//input[@id='txtUserEmail']")).getText()==string);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Given("Admin has mentioned {string} as the Batch filter criteria")
	public void admin_has_mentioned_as_the_batch_filter_criteria(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
				dropdownBatch = driver.findElement(By.className("selFilterBatch"));
				assertTrue(selectoption(dropdownBatch,string)==true);
				sBatch = string;
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Given("Admin has mentioned {string} as the Program filter criteria")
	public void admin_has_mentioned_as_the_program_filter_criteria(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
				dropdownProgram = driver.findElement(By.className("selFilterProgram"));
				assertTrue(selectoption(dropdownProgram,string)==true);
				sProgram = string;
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Admin is able to see the information in the table view with filtered criteria {string} and {string} and {string}")
	public void admin_is_able_to_see_the_information_in_the_table_view_with_filtered_criteria_and_and(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		int iCnt = 0;
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		for (int i=0;i<tblrows.size();i++)
		{
			List<WebElement> cols = tblrows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++)
			{
				if(cols.get(j).getAttribute("innerHTML")== sUserEmail)
				{
					assertTrue("Row is filtered with User Email",cols.get(j).getAttribute("innerHTML")== sUserEmail);
					iCnt = iCnt+1;
				}
				if(cols.get(j).getAttribute("innerHTML")== sBatch)
				{
					assertTrue("Row is filtered with Batch",cols.get(j).getAttribute("innerHTML")== sBatch);
					iCnt = iCnt+1;
				}
				if(cols.get(j).getAttribute("innerHTML")== sProgram)
				{
					assertTrue("Row is filtered with Batch",cols.get(j).getAttribute("innerHTML")== sProgram);
					iCnt = iCnt+1;
				}
				if(iCnt==3)
				{
					break;
				}
			}
			if(iCnt==3)
			{
				break;
			}
		}		
		
		assertTrue("Row has a filtered view", iCnt==3);
		assertFalse("Row is not filtered",iCnt!=3);
	}
	public static boolean selectoption(WebElement element, String value)
    {
		boolean bSelect = false;
     Select dropdownvalue = new Select(element); 
     
    java.util.List<WebElement> optionscount = dropdownvalue.getOptions();
     
    //using for...each  loop
     for(WebElement option:optionscount)
     {
       if(option.getText().equals(value)) //Condition
       {
    	   option.click();       
    	   bSelect = true;
       }
     }
     return bSelect;
    }

}
