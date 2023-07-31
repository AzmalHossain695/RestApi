package utillity_classes;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestDataUtils {
	private static JsonObject testData;

	static {
		try {
			FileReader reader = new FileReader(".\\src\\main\\resources\\test_data_files\\testdata.json");
			JsonElement jsonData = JsonParser.parseReader(reader);
			testData = jsonData.getAsJsonObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getNewPostId(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("id").getAsInt();
	}

	public static int getNewPostUserId(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("userId").getAsInt();
	}

	public static int getExpectedUserId(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("expectedUserId").getAsInt();
	}

	public static int getExpectedId(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("expectedId").getAsInt();
	}

	public static String getExpectedName(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("name").getAsString();
	}

	public static String getExpectedUsername(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("username").getAsString();
	}

	public static String getExpectedEmail(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("email").getAsString();
	}

	public static String getExpectedStreet(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("street").getAsString();
	}

	public static String getExpectedSuite(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("suite").getAsString();
	}

	public static String getExpectedCity(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("city").getAsString();
	}

	public static String getExpectedZipCode(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("zipcode").getAsString();
	}

	public static String getExpectedLat(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("lat").getAsString();
	}

	public static String getExpectedLng(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("lng").getAsString();
	}

	public static String getExpectedPhone(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("phone").getAsString();
	}

	public static String getExpectedWebsite(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("website").getAsString();
	}

	public static String getExpectedCompanyName(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("companyname").getAsString();
	}

	public static String getExpectedCatchPhrase(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("catchPhrase").getAsString();
	}

	public static String getExpectedBs(String testCaseKey) {
		return testData.getAsJsonObject(testCaseKey).get("bs").getAsString();
	}
}