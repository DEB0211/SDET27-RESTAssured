package com.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	public void param() {
		String proId="TY_PROJ_2002";
		given()
			.pathParam("projectID", proId)
	    .when()
	    	.delete("http://localhost:8084/projects/{projectID}")
	    .then()
	    	.log().all();
		
	}

}
