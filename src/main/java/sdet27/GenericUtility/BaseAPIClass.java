package sdet27.GenericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {
	
	public DatabaseUtility dLib = new DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredUtility rLib = new RestAssuredUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		baseURI = "http://localhost";
		port = 8084;
		
		dLib.connectToDB();
		System.out.println("======database Connection esatablised======");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		System.out.println("=======database connection closed====");
	}

}
