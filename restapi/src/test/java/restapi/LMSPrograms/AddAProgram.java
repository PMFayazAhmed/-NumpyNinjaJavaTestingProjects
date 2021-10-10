package restapi.LMSPrograms;

import java.util.HashMap;

import org.json.simple.JSONObject;
//import org.testng.annotations.Test;
import org.junit.Test;
import dataProvider.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class AddAProgram {

	private int iAuthStatus;
	 @Test
	public void AddProgram(){
		String path = "/programs";
		iAuthStatus =  BasicAuthTest.GetBasicAuth();
		if(iAuthStatus == 200)
		{
			HashMap<String,Object> requestParams = new HashMap<String,Object>();				
			requestParams.put("programDescription", "Support Analyst");	 		
			requestParams.put("programName", "SP1");
			requestParams.put("online", true);
			JSONObject requestParamsJSON = new JSONObject(requestParams);
			Response response =  RestAssured.given().auth()
					  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
					  .header("Content-Type", "application/json")
					  .body(requestParamsJSON.toJSONString())					  
					  .post(path)					  
					  .then()
					  .statusCode(200)
					  .extract().response();
			
			System.out.println(response.asPrettyString());
		}
	}
}
