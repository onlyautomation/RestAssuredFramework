package RestUtils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RestUtils {
	
	public static String getEmpName() {
		String empName = RandomStringUtils.randomAlphabetic(1);
		return "Imran"+empName;
	}
	
	public static String getEmpSal() {
		String empSal = RandomStringUtils.randomAlphanumeric(5);
		return empSal;
	}
	
	public static String getEmpAge() {
		String empAge = RandomStringUtils.randomAlphanumeric(2);
		return empAge;
	}

}
