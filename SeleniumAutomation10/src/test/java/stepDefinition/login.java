package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class login {
	WebDriver driver=null;
	 @Given("Open Browser")
	 public void open_browser() {
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		  driver = new ChromeDriver();
	   
	 }
	 @And("user is on login page")
	 public void user_is_on_login_page() throws InterruptedException {
	  driver.navigate().to("https://example.testproject.io/web/");
	  Thread.sleep(3000);
	    
	 }
	 @When("^user enters (.*) and (.*)$")
	 public void user_enters_pooja_and(String username, String password) throws InterruptedException {
	  driver.findElement(By.id("name")).sendKeys(username);
	  Thread.sleep(3000);
	  driver.findElement(By.id("password")).sendKeys(password);
	  Thread.sleep(3000);
	    
	 }
	 @And("^click on login button$")
	 public void click_on_login_button() throws InterruptedException {
	  driver.findElement(By.id("login")).click();
	  Thread.sleep(3000);
	    
	 }
	 @Then("user is navigated to home page")
	 public void user_is_navigated_to_home_page() {
	 
	  driver.findElement(By.id("logout")).isDisplayed();
	  driver.close();
	    
	 }
}