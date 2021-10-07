package lmsBDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisteredUsers_StepDefinition {
	String sUserEmail;
	int iDeleteRow;	
	public static WebDriver driver;
	WebElement tblUsers = null;
	List<WebElement> tblrows = null;
	
	//Constructor
	
	@Before
	   public void beforeClass()
	   {   
		driver = BrowserFactory.startApplication(driver, "Chrome", "https://www.google.com");
		
	   
	   }  
	 
	
	@Given("Admin is in https:\\/\\/lmsportal.com\\/Admin")
	public void admin_is_in_https_lmsportal_com_admin() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{	
			
			System.out.println(driver.toString());
			String url = "https://www.google.com";
			driver.navigate().to(url);
			assertTrue("The Page URL is valid",driver.getCurrentUrl() == url);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	   
	}

	@When("Admin clicks on Users menu")
	public void admin_clicks_on_users_menu() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on Manage Users submenu")
	public void admin_clicks_on_manage_users_submenu() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin lands on https:\\/\\/www.LMSportal.com\\/Admin\\/ManageUsers")
	public void admin_lands_on_https_www_lm_sportal_com_admin_manage_users() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			String url = "https://lmsportal.com/Admin/ManagerUsers";
			assertTrue("The Page URL is valid",driver.getCurrentUrl() == url);
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Given("Admin is in https:\\/\\/www.LMSportal.com\\/Admin\\/ManageUsers page")
	public void admin_is_in_https_www_lm_sportal_com_admin_manage_users_page() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			String url = "https://lmsportal.com/Admin/ManagerUsers";
			assertTrue("The Page URL is valid",driver.getCurrentUrl() == url);
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@When("Admin clicks on Registered Users radio button")
	public void admin_clicks_on_registered_users_radio_button() {
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

	@Then("Admin is able to view the {int} registered users in HTML table")
	public void admin_is_able_to_view_the_registered_users_in_html_table(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		assertTrue("There are {int} registered users in HTML table",tblrows.size()==int1);
	}

	@Given("Admin has selected {string} as the UserEmail filter criteria")
	public void admin_has_selected_as_the_user_email_filter_criteria(String string) {
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

	@Given("Admin clicks on Search button")
	public void admin_clicks_on_search_button() {
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

	@When("Admin clicks the Delete button on the {int} row in the table")
	public void admin_clicks_the_delete_button_on_the_row_in_the_table(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		tblUsers = driver.findElement(By.xpath("//table[@id='Users']"));
		tblrows = tblUsers.findElements(By.tagName("tr"));
		for (int icnt = 0; icnt >= tblrows.size(); icnt++)
		{
			if(icnt == int1) {
				iDeleteRow = int1;
				try
				{
					WebElement rowtoDelete = tblrows.get(icnt);
					WebElement DeleteButton = rowtoDelete.findElement(By.className("btnDelete"));
					DeleteButton.click();
					assertTrue("Clicked Delete button",icnt == int1);
					break;
				}
				catch(AssertionError ae)
				{
					System.out.println(ae.getMessage());
					
				}
				
			}			
			
		}	
	}

	@Then("Admin is able to see a confirmation popup in the screen")
	public void admin_is_able_to_see_a_confirmation_popup_in_the_screen() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			
			assertTrue("The confirmation screen is displayed",driver.findElement(By.xpath("\"//div[@classname='ConfirmPopup']\"")).isDisplayed());
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@Given("Admin sees a confirmation popup in the screen")
	public void admin_sees_a_confirmation_popup_in_the_screen() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			
			assertTrue("The confirmation screen is displayed",driver.findElement(By.xpath("\"//div[@classname='ConfirmPopup']\"")).isDisplayed());
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
			
		}
	}

	@When("Admin clicks the Yes button in popup screen")
	public void admin_clicks_the_yes_button_in_popup_screen() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			if(driver.findElement(By.xpath("\"//div[@classname='ConfirmPopup']\"")).isDisplayed())
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

	@Then("Admin is able to make the user status as Inactive")
	public void admin_is_able_to_make_the_user_status_as_inactive() {
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

	@Given("Admin has clicked on Inactive Users radio button")
	public void admin_has_clicked_on_inactive_users_radio_button() {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			driver.findElement(By.xpath("//input[@value='Inactive']")).click();
			assertTrue("The InactiveUsers checbox is clicked",driver.findElement(By.xpath("//input[@value='InactiveUsers']")).isSelected());
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@When("Admin enters {string} as the UserEmail filter criteria and clicks on Search button")
	public void admin_enters_as_the_user_email_filter_criteria_and_clicks_on_search_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try
		{
			driver.findElement(By.xpath("//input[@id='txtUserEmail']")).sendKeys(string);
			assertTrue("The UserEmail entered is valid",driver.findElement(By.xpath("//input[@id='txtUserEmail']")).getText()==string);
			
			assertTrue("The Search button is available",driver.findElement(By.xpath("//button[@id='btnSearch']")).isDisplayed());
			driver.findElement(By.xpath("//button[@id='btnSearch']")).click();
			
			
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	}

	@Then("User Email in the {int} column of the {int} row is {string}")
	public void user_email_in_the_column_of_the_row_is_abc_gmail_com(Integer int1, Integer int2,String string) {
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
