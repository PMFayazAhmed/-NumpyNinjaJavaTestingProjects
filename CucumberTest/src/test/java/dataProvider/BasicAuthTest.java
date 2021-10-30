package dataProvider;


import io.restassured.RestAssured;
import io.restassured.response.Response;



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
