package TestCases;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;


public class CreateBooking extends BaseClass {

	@BeforeClass
	public void createBooking() {
		
		logger.info("*************Started Execution of Booking Test Case");
		
		String basePath = "booking";

		RestAssured.baseURI = BaseClass.getBookingBaseURI();

		// Request Object
		httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("firstname", "Imran");
		requestParams.put("lastname", "Qasim");
		requestParams.put("totalprice", 111);
		requestParams.put("depositpaid", true);
		Map<String, String> bookingDates = new HashMap<>();
		bookingDates.put("checkin", "2020-12-30");
		bookingDates.put("checkout", "2020-12-31");
		requestParams.put("bookingdates", bookingDates);
		requestParams.put("additionalneeds", "Breakfast");

		// Setting-up the request order
		httpRequest.header("Content-Type", "application/json");

		// Attaching the request payload to the body
		httpRequest.body(requestParams.toJSONString());

		// Response Object
		response = httpRequest.request(Method.POST, basePath);

		// Print Response as a string
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response body is: " + responseBody);
		
		//getting booking id
		JsonPath jsonPath = response.jsonPath();
		int bID = jsonPath.get("bookingid"); 
		System.out.println("Booking ID is: "+bID);
	}
	
	@Test
	public void testBooking() {

		// Get Status Line
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");

		// Get Status Code
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@AfterClass
	public void tearDown() {
	logger.info("********* Create Booking Test Case execution is completed **********");
	}
	

}
