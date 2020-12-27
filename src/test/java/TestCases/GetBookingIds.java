package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookingIds extends BaseClass {

	@BeforeClass
	public void getBookingIDs() throws InterruptedException {
		
		logger.info("**************Started getting all booking ids test case execution");

		String basePath = "booking";

		RestAssured.baseURI = BaseClass.getBookingBaseURI();

		// Request Object
		httpRequest = RestAssured.given();

		// Response Object
		response = httpRequest.request(Method.GET, basePath);

		// Print Response as a string
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response body is: " + responseBody);
		
		Thread.sleep(3000);

	}

	@Test
	public void testGetBookingIDs() {

		// Get Status Line
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		

		// Get Status Code
				Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@AfterClass
	public void tearDown() {
	logger.info("********* Getting All Booking IDs Test Case execution is completed **********");
	}

}
