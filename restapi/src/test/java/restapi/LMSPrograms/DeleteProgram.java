package restapi.LMSPrograms;

import org.testng.annotations.Test;

import dataProvider.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProgram {
	private int iAuthStatus;
	@Test
	public void DeleteAProgram() {
		int PID = 700;
		String path = "/programs/"+ PID;
		iAuthStatus =  BasicAuthTest.GetBasicAuth();
		if(iAuthStatus == 200)
		{
			Response response =  RestAssured.given().auth()
					  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
					  .delete(path)
					  .then()
					  .statusCode(200)
					  .extract().response();
			
			System.out.println(response.asPrettyString());
		}
	}
		

}
