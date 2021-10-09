package restapi.LMSPrograms;

import org.testng.annotations.Test;

import dataProvider.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class GetAProgram {
	private int iAuthStatus;
	public void GetProgramsList() {
		int PID = 698;
		String path = "/programs/"+ PID;
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
