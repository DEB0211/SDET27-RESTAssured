package com.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {
	@Test
	public void auths() {
		Response response = given()
			.formParams("client_id", "sdet27")
			.formParams("client_secret", "68c13b6e3c9b5b4afb36e698ca81363b")
			.formParams("grant_type", "client_credentials")
			.formParams("redirect_uri", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token=response.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "1951")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
			.log().all();
			
	}

}
