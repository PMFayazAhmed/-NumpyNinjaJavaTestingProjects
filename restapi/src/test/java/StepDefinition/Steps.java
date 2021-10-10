package StepDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;

import dataProvider.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import io.restassured.RestAssured;
import restapi.LMSPrograms.BasicAuthTest;

public class Steps {
	private int iAuthStatus=0;
	HashMap<String,Object> requestParams;
	JSONObject requestParamsJSON;
	String NewProgramID;
	int Statuscode;
	
	@Given("I am a authorised user")
	public void i_am_a_authorised_user() {
		 
	    // Write code here that turns the phrase above into concrete actions
		iAuthStatus =  BasicAuthTest.GetBasicAuth();
		try
		{
			Assert.assertEquals(iAuthStatus, 200);
		}
		catch(AssertionError ae)
		{
			System.out.println(ae.getMessage());
		}
	    
	}

	@Given("I enter details for a new Program")
	public void i_enter_details_for_a_new_program() {
	    // Write code here that turns the phrase above into concrete actions
		requestParams = new HashMap<String,Object>();				
		requestParams.put("programDescription", "Support Analyst");	 		
		requestParams.put("programName", "SP1");
		requestParams.put("online", true);
		requestParamsJSON = new JSONObject(requestParams);
	    System.out.println(requestParamsJSON.toJSONString());
	}

	@When("I use Http Post request")
	public void i_use_http_post_request() {
	    // Write code here that turns the phrase above into concrete actions
		String path = "/programs";
		//iAuthStatus =  BasicAuthTest.GetBasicAuth();
		Response response =  RestAssured.given().auth()
				  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
				  .header("Content-Type", "application/json")
				  .body(requestParamsJSON.toJSONString())					  
				  .post(path);
		NewProgramID=  response.then().contentType(ContentType.JSON).extract().path("programId").toString();
		String jsonString = response.asPrettyString();
		System.out.println(jsonString);
		
	}

	@Then("The program is added")
	public void the_program_is_added() {
	    // Write code here that turns the phrase above into concrete actions
		String path = "/programs/" + NewProgramID;
		Response response =  RestAssured.given().auth()
				  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
				  .get(path);
				  
		Assert.assertEquals(NewProgramID, response.then().contentType(ContentType.JSON).extract().path("programId").toString());
		Statuscode = response.getStatusCode();
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("Status Code is {int}")
	public void status_code_is(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(Statuscode, 200);
	    //throw new io.cucumber.java.PendingException();
	}

	@Given("A List of programs are available")
	public void a_list_of_programs_are_available() {
	    // Write code here that turns the phrase above into concrete actions
		String path = "/programs";
		Response response =  RestAssured.given().auth()
				  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
				  .get(path)
				  .then()
				  .statusCode(200)
				  .extract().response();
		
		List<Map<String, String>> programs = JsonPath.from(response.asString()).get("programs");
		Assert.assertTrue(programs.size() > 0);
	}

	@When("I Use http GET request")
	public void i_use_http_get_request() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String path = "/programs";
		Response response =  RestAssured.given().auth()
				  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
				  .get(path);
		Statuscode = response.getStatusCode();
		Assert.assertEquals(200, Statuscode);
	}

	@Then("I am able to see the list of programs")
	public void i_am_able_to_see_the_list_of_programs() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String path = "/programs";
		Response response =  RestAssured.given().auth()
				  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
				  .get(path);
		Statuscode = response.getStatusCode();
		System.out.println(response.asPrettyString());
		
	}


}
