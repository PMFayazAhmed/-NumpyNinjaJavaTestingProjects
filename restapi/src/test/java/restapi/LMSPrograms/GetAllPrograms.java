package restapi.LMSPrograms;

import org.testng.annotations.Test;

import dataProvider.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class GetAllPrograms {
	
	//private BasicAuthTest basicauthtest;
	int iAuthStatus;


@Test
public void GetProgramsList() {
	
	String path = "/programs";
	iAuthStatus =  BasicAuthTest.GetBasicAuth();
	if(iAuthStatus == 200)
	{
		Response response =  RestAssured.given().auth()
				  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
				  .get(path)
				  .then()
				  .statusCode(200)
				  .extract().response();
		
		System.out.println(response.asPrettyString());
	}
	
}
}
