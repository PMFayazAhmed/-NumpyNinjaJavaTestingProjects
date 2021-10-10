package End2EndTesting;

import dataProvider.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthenticationSuccessful {

	public void IsAuthenticated() {
	RestAssured.baseURI = ConfigReader.getInstance().getBaseUrl();
			
			Response response =  RestAssured.given().auth()
					  .basic(ConfigReader.getInstance().getUserID(), ConfigReader.getInstance().getPassword())
					  .get("/basicauth")
					  .then()
					  .statusCode(200)
					  .extract().response();
		
			System.out.println(response.asPrettyString());
			System.out.println(response.getStatusCode());
			
	}
}
