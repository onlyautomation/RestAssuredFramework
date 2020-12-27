package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
   static Properties prop;
	
	public RequestSpecification httpRequest;
	public Response response;
	public Logger logger;
	
	@BeforeClass
	public void setup(){
		logger=Logger.getLogger("API Logger");//added Logger
		PropertyConfigurator.configure("Log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);
	}
	
	
	public static Properties loadProperties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\iqasim\\RestAssuredFramework\\RestAssuredFramework\\Config\\config.properties");
			prop.load(fis);
			System.out.println(fis.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getBookingBaseURI() {
		prop = loadProperties();
		String baseURI = (String) prop.get("bookingBaseURI");
		System.out.println("Base URI is: "+baseURI);
		return baseURI;
	}
	
	public static String getEmpBaseURI() {
		prop = loadProperties();
		String baseURI = (String) prop.get("createEmpBaseURI");
		System.out.println("Base URI is: "+baseURI);
		return baseURI;
	}

}
