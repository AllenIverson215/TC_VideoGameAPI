package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class TC_VideoGameAPI {
	
	@Test(priority = 1)
	public void Get_method() {
		given()
		
		.when()
			.get("http://localhost:8080/app/videogames")
		.then()
			.statusCode(200);
	}
	@Test(priority=2)
	public void Post_method() {
		HashMap data = new HashMap();
		
			data.put("id", "100");
			data.put("name", "GTA");
			data.put ("releaseDate", "2022-04-09T18:09:33.090Z");
			data.put("reviewScore", "0");
			data.put("category", "Action");
			data.put("rating", "string");
			
			Response res = 
			
			given()
				.contentType("application/json")
				.body(data)
			.when()
			.post("http://localhost:8080/app/videogames")
			.then()

			.statusCode(500)
			.log().body()
			.extract().response();
			
			String jsonString = res.asString();
			AssertJUnit.assertEquals(jsonString.contains("Internal Server Error"),true);
			
	}
	

	

}
