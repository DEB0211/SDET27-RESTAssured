package DifferenetWaysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAResourceUsingJsonObjectTest {
	@Test
	public void create() {
		//creation of random numbers
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
		JSONObject jObj = new JSONObject();//json simple dependency
		jObj.put("createdBy", "Chaitra123");
		jObj.put("projectName", "APTYss"+randomNumber);
		jObj.put("status", "Created");
		jObj.put("teamSize", 1234);
		
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
	}

}
