package restapi.LMSPrograms;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutProgram {
	private int iAuthStatus;
	@Test
	public void UpdateProgram() {
		int PID = 698;
		String path = "/programs/"+ PID;
		iAuthStatus =  BasicAuthTest.GetBasicAuth();
		if(iAuthStatus == 200)
		{
					
			

			RestAssured.baseURI ="https://lms-program-rest-service.herokuapp.com";
			RequestSpecification request = RestAssured.given().auth().basic("admin", "password");
			
			HashMap<String,Object> requestParams = new HashMap<String,Object>();				
			requestParams.put("programDescription", "Support Analyst");	 		
			requestParams.put("programName", "SP1");
			requestParams.put("online", true);
			JSONObject requestParamsJSON = new JSONObject(requestParams);
			request.header("Content-Type", "application/json");
			request.body(requestParamsJSON.toJSONString());
		
			Response response = request.put(path);

			int statusCode = response.getStatusCode();
			System.out.println(response.asString());
			Assert.assertEquals(statusCode, 200); 

		}
	}

}
