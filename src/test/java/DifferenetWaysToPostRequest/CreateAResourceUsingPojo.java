package DifferenetWaysToPostRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

public class CreateAResourceUsingPojo {
	@Test
	public void create() {
		
		PojoClass pojo = new PojoClass("Adarsh", "Sdet 27 api project", "completed", 300);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}
}
