package com.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	@Test
	public void bearerAuth() {
		given()
			.auth().oauth2("ghp_ILHLz13x27gIVVFCQtUPMHmJs91DPxUz")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}

}
