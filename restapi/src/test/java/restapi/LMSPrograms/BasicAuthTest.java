package restapi.LMSPrograms;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import dataProvider.ConfigReader;

public class BasicAuthTest {
	//private int responseStatusCode = 0;

	public static int GetBasicAuth()
	{
		
		
		RestAssured.baseURI = ConfigReader.getInstance().getBaseUrl();
		
		Response response =  RestAssured.given().auth()
				  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
				  .get("/basicauth")
				  .then()
				  .statusCode(200)
				  .extract().response();
	
		//System.out.println(response.asPrettyString());
		//System.out.println(response.getStatusCode());
		return response.getStatusCode();			
	
			
		
	}

}
