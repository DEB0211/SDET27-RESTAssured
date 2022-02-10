package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject()
	{
		//Step 1: create test Data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chaitra");
		jObj.put("projectName", "APTY");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		//Step 2: 
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//Step 3
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_1802");
		
		//step 4: verify
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
