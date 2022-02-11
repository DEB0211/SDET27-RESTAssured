package DifferenetWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateAResourceUsingHashMapTest {
	@Test
	public void create() {

		HashMap map = new HashMap();

		map.put("createdBy", "Chaitra1234");
		map.put("projectName", "APTYSS bangalore");
		map.put("status", "Created");
		map.put("teamSize", 1234);

		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();



	}

}
