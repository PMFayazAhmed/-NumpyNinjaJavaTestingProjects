package lmsBDD;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InactiveUsers_StepDefinition {
	
	int iActivateRow;
	String sUserEmail;
	public WebDriver driver;
	WebElement tblUsers = null;
	List<WebElement> tblrows = null;
	
		  
	@Before
	   public void beforeClass()
	   {   
		driver = RegisteredUsers_StepDefinition.driver;
		
	   
	   }     
	
	@When("Admin clicks on Inactive Users radio button")
	public void admin_clicks_on_inactive_users_radio_button() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			
			driver.findElement(By.xpath("//input[@value='InactiveUsers']")).click();
			assertTrue("The InactiveUsers checbox is clicked",driver.findElement(By.xpath("//input[@value='InactiveUsers']")).isSelected());
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Then("Admin is able to view the {int} inactive users in HTML table")
	public void admin_is_able_to_view_the_inactive_users_in_html_table(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
			tblrows = tblUsers.findElements(By.tagName("tr"));
			assertTrue("There are {int} inactive users in HTML table",tblrows.size()==int1);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@When("Admin clicks the Activate button on the {int} row in the table")
	public void admin_clicks_the_activate_button_on_the_row_in_the_table(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		sUserEmail = tblrows.get(int1).findElements(By.tagName("td")).get(0).getAttribute("InnerHTML");
		for (int icnt = 0; icnt >= tblrows.size(); icnt++)
		{
			if(icnt == int1) {
				iActivateRow = int1;
				try
				{
					WebElement rowtoActivate = tblrows.get(icnt);
					WebElement ActivateButton = rowtoActivate.findElement(By.className("btnActivate"));
					ActivateButton.click();
					assertTrue("Clicked Activate button",icnt == int1);
					break;
				}
				catch(AssertionError ae)
				{
					System.out.println(ae.getMessage());
					
				}
				
			}			
			
		}	
	}

	@Then("Admin is able to see a confirmation popup in the screen for the user to be marked as Active")
	public void admin_is_able_to_see_a_confirmation_popup_in_the_screen_for_the_user_to_be_marked_as_active() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			
			assertTrue("The confirmation screen is displayed",driver.findElement(By.xpath("\"//div[@classname='ConfirmActivatePopup']\"")).isDisplayed());
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Given("Admin sees a popup confirmation on the screen")
	public void admin_sees_a_popup_confirmation_on_the_screen() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			
			assertTrue("The confirmation screen is displayed",driver.findElement(By.xpath("\"//div[@classname='ConfirmActivatePopup']\"")).isDisplayed());
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@When("Admin clicks the Yes button in the popup")
	public void admin_clicks_the_yes_button_in_the_popup() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			if(driver.findElement(By.xpath("\"//div[@classname='ConfirmActivatePopup']\"")).isDisplayed())
			{
				driver.findElement(By.id("popover-yes")).click(); //click Yes button
				assertTrue("Clicked Yes button",true);
			}
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Then("Admin is able to make the user status as Active")
	public void admin_is_able_to_make_the_user_status_as_active() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			driver.findElement(By.xpath("//input[@id='txtUserEmail']")).sendKeys(sUserEmail);
			assertTrue("The UserEmail entered is valid",driver.findElement(By.xpath("//input[@id='txtUserEmail']")).getText()==sUserEmail);
			
			assertTrue("The Search button is available",driver.findElement(By.xpath("//button[@id='btnSearch']")).isDisplayed());
			driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
			
			tblrows = tblUsers.findElements(By.tagName("tr"));
			assertTrue("There are {int} rows found",tblrows.size() == 0);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Given("Admin has clicked on Registered Users radio button")
	public void admin_has_clicked_on_registered_users_radio_button() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			driver.findElement(By.xpath("//input[@value='RegisteredUsers']")).click();
			assertTrue("The RegisteredUsers checbox is clicked",driver.findElement(By.xpath("//input[@value='RegisteredUsers']")).isSelected());
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Then("User Email in the {int} column of the of the {int} row is {string}")
	public void user_email_in_the_column_of_the_of_the_row_is(Integer int1, Integer int2, String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
			tblrows = tblUsers.findElements(By.tagName("tr"));
			List<WebElement> cols = tblrows.get(int2).findElements(By.tagName("td")); //row number
			assertTrue("The row is available with UserEmail",cols.get(int1).getAttribute("InnerHTML")==string); //col number
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

}
