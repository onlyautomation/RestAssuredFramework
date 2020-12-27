package TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import RestUtils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class CreateEmployee extends BaseClass{
	
	@BeforeClass
	public void createEmployee() {
		
		logger.info("********* Started Creating Employee **********");
		
		String basePath = "create";
		RestAssured.baseURI = BaseClass.getEmpBaseURI();
		httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", RestUtils.getEmpName());
		requestParams.put("salary", RestUtils.getEmpSal());
		requestParams.put("age", RestUtils.getEmpAge());
			
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.POST, basePath);
		
		System.out.println(response.asPrettyString());
		
		
		/*
		 * //Getting booking id JsonPath jsonPath = response.jsonPath(); int empID =
		 * jsonPath.get("id"); System.out.println("Employee id is: "+empID);
		 */
		 
	}
	
	@Test
	public void testCreateEmployee() {
		
		//Asserting status code
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@AfterClass
	public void tearDown() {
	logger.info("********* Create Employee Test Case execution is completed **********");
	}

}
