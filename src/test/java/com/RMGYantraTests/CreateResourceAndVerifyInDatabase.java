package com.RMGYantraTests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import sdet27.GenericUtility.BaseAPIClass;
import sdet27.GenericUtility.EndPoints;

public class CreateResourceAndVerifyInDatabase extends BaseAPIClass{
	
	@Test
	public void createResourceAndVerifyInDb() throws Throwable
	{
		//Step 1: create test data
		PojoClass pLib = new PojoClass("Chaitra", "Nyka"+jLib.getRandomNum(), "Completed", 45);
		
		//Step 2: execute post request
		Response resp = given()
						.body(pLib)
						.contentType(ContentType.JSON)
						.when()
						.post(EndPoints.createProject);
		
		//Step 3: capture the project id from response
		String expData = rLib.getJSONData(resp, "projectId");
		System.out.println(expData);
		
		//Step 4: verify in db
		String query = "select * from project;";
		String actData=dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData,true);
		
		//Step 5: validate
		Assert.assertEquals(expData, actData);
		Reporter.log("data verification successful", true);
		
		
		
	}

}
