package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class GoogleSearch {
	WebDriver driver=null;
	@Given("browser is open")
	public void browser_is_open() {
		
		  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@And("user is on google search page")
	public void user_is_on_google_search_page() {
	    // Write code here that turns the phrase above into concrete actions
		//Code to navigate to driver
		driver.navigate().to("https://google.com");
	    //throw new io.cucumber.java.PendingException();
	}
	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
	    // Write code here that turns the phrase above into concrete actions
		// In the google search box, enter any text - Say "Cucumber Test"
		  driver.findElement(By.name("q")).sendKeys("Cucumber Test");
	    //throw new io.cucumber.java.PendingException();
	}
	@And("hits Enter")
	public void hits_enter() {
	    // Write code here that turns the phrase above into concrete actions
		// Simulate the clicking of enter key
		 driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
	    // Write code here that turns the phrase above into concrete actions
		// The test case should pass if the resulting page
				 // contains an expected text - Say ""What is Cucumber Test"
				 driver.getPageSource().contains("Test automation Software");
				// Finally, closing driver after test is complete
				   driver.close();
	    //throw new io.cucumber.java.PendingException();
	}
}
