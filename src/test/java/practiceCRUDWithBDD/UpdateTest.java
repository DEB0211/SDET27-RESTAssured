package practiceCRUDWithBDD;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;//static import

import java.util.Random;

public class UpdateTest {
	@Test
	public void update() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
		JSONObject jObj = new JSONObject();//json simple dependency
		jObj.put("createdBy", "Adarsh");
		jObj.put("projectName", "Testyantra"+randomNumber);
		jObj.put("status", "Created");
		jObj.put("teamSize", 3500);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_4403")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
		
		
		
		
		
	}

}
