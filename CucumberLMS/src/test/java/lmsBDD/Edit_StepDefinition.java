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

public class Edit_StepDefinition {
	int rowSize, iEditrow;
	WebElement dropdownUserRole,dropdownBatch,dropdownProgram = null;
	String sUserRole,sProgram,sBatch;
	public WebDriver driver;
	WebElement tblUsers = null;
	List<WebElement> tblrows = null;
	
	@Before
	   public void beforeClass()
	   {   
		driver = RegisteredUsers_StepDefinition.driver;
			   
	   }     
	
	@Given("Admin is able to view the users")
	public void admin_is_able_to_view_the_users() {
	    // Write code here that turns the phrase above into concrete actions
		
		rowSize = tblrows.size();
		if (rowSize > 0)
		{
			System.out.println("The number of rows in table is: " + rowSize);
		}
		else
		{
			assertFalse("Row Count should not be zero",rowSize==0);
		}
	}

	@When("Admin clicks on Edit button in the {int} row")
	public void admin_clicks_on_edit_button_in_the_row(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		for (int icnt = 0; icnt >= tblrows.size(); icnt++)
		{
			if(icnt == int1) {
				iEditrow = int1;
				try
				{
					WebElement rowToEdit = tblrows.get(icnt);
					WebElement EditButton = rowToEdit.findElement(By.className("btnEdit"));
					EditButton.click();
					assertTrue("Clicked Edit button",icnt == int1);
					break;
				}
				catch(AssertionError ae)
				{
					System.out.println(ae.getMessage());
					
				}
				
			}			
			
		}

	}

	@Then("Admin is able to view dropdown elements in UserRole, Program and Batch columns")
	public void admin_is_able_to_view_dropdown_elements_in_user_role_program_and_batch_columns() {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		dropdownUserRole = tblrows.get(iEditrow).findElement(By.className("selUserRole"));
		dropdownBatch = tblrows.get(iEditrow).findElement(By.className("selBatch"));
		dropdownProgram = tblrows.get(iEditrow).findElement(By.className("selProgram"));				
		assertTrue("Edit button is clicked and edit fields are visible", dropdownUserRole.isDisplayed() && dropdownProgram.isDisplayed() && dropdownBatch.isDisplayed());
		assertFalse("Edit fields are not visible",dropdownUserRole.isDisplayed() ==false || dropdownProgram.isDisplayed()==false || dropdownBatch.isDisplayed()==false);
	}

	@Given("Admin has cliked on Edit button in the {int} row")
	public void admin_has_cliked_on_edit_button_in_the_row(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		for (int icnt = 0; icnt >= tblrows.size(); icnt++)
		{
			if(icnt == int1) {
				iEditrow = int1;
				try
				{
					WebElement rowToEdit = tblrows.get(icnt);
					WebElement EditButton = rowToEdit.findElement(By.className("btnEdit"));
					EditButton.click();
					assertTrue("Clicked Edit button",icnt == int1);
					break;
				}
				catch(AssertionError ae)
				{
					System.out.println(ae.getMessage());
					
				}
				
			}			
			
		}	
	}

	@When("Admin clicks on dropdown in UserRole column")
	public void admin_clicks_on_dropdown_in_user_role_column() {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		try {
			dropdownUserRole = tblrows.get(iEditrow).findElement(By.className("selUserRole"));
			dropdownUserRole.click();
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
		
	}

	@When("Admin selects {string} value")
	public void admin_selects_value(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			
				assertTrue(selectoption(dropdownUserRole,string)==true);
				sUserRole = string;
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Admin is able to set a new value for User Role")
	public void admin_is_able_to_set_a_new_value_for_user_role() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			assertTrue("New UserRole is set ",dropdownUserRole.getText() == sUserRole);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@When("Admin clicks on dropdown in Batch column")
	public void admin_clicks_on_dropdown_in_batch_column() {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		try {
			dropdownBatch = tblrows.get(iEditrow).findElement(By.className("selBatch"));
			dropdownBatch.click();
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@When("Admin selects {int} value")
	public void admin_selects_value(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
				
				assertTrue(selectoption(dropdownBatch,int1.toString())==true);
				sBatch = int1.toString();
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Admin is able to set a new value for Batch")
	public void admin_is_able_to_set_a_new_value_for_batch() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			assertTrue("New Batch is set ",dropdownBatch.getText() == sBatch);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@When("Admin clicks on dropdown in Program column and Admin selects {string} value")
	public void admin_clicks_on_dropdown_in_program_column_and_admin_selects_value(String string) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		try {
			dropdownProgram = tblrows.get(iEditrow).findElement(By.className("selProgram"));
			dropdownProgram.click();
			
			assertTrue(selectoption(dropdownProgram,string)==true);
			sProgram =string;
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Admin is able to set a new value for Program")
	public void admin_is_able_to_set_a_new_value_for_program() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			assertTrue("New Program is set ",dropdownProgram.getText() == sProgram);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Given("Admin has selected UserRole as {string} and Program as {string} and Batch as {int} for the {int} row")
	public void admin_has_selected_user_role_as_and_program_as_and_batch_as_for_the_row(String string, String string2, Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			assertTrue("New UserRole is set ",dropdownUserRole.getText() == sUserRole);
			assertTrue("New Batch is set ",dropdownBatch.getText() == sBatch);
			assertTrue("New Program is set ",dropdownProgram.getText() == sProgram);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@When("Admin clicks on Save button")
	public void admin_clicks_on_save_button() {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		try
		{
			WebElement rowToEdit = tblrows.get(iEditrow);
			WebElement SaveButton = rowToEdit.findElement(By.className("btnSave"));
			SaveButton.click();
			assertTrue("Clicked Save button",SaveButton != null);
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Admin is able to see the updated values in the {int} row")
	public void admin_is_able_to_see_the_updated_values_in_the_row(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		int iCnt = 0;
		assertTrue("Row to edit is valid", iEditrow == int1);
		iEditrow = int1;
		WebElement rowToEdit = tblrows.get(iEditrow);		
		List<WebElement> cols = rowToEdit.findElements(By.tagName("td"));
		for(int i=0;i<cols.size();i++)
		{			
			if(cols.get(i).getAttribute("innerHTML")== sUserRole)
			{
				assertTrue("New User Role is set",cols.get(i).getAttribute("innerHTML")== sUserRole);
				iCnt = iCnt+1;
			}
			if(cols.get(i).getAttribute("innerHTML")== sBatch)
			{
				assertTrue("New Batch is set",cols.get(i).getAttribute("innerHTML")== sBatch);
				iCnt = iCnt+1;
			}
			if(cols.get(i).getAttribute("innerHTML")== sProgram)
			{
				assertTrue("New Program is set",cols.get(i).getAttribute("innerHTML")== sProgram);
				iCnt = iCnt+1;
			}
		}
		assertTrue("All new values are saved", iCnt==3);
		assertFalse("Save has failed",iCnt!=3);
	}
	//reusable function to select from dropdown
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
