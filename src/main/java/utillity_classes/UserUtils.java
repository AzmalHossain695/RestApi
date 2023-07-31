package utillity_classes;

import model_classes.UserModel;

import org.json.JSONObject;

import model_classes.AddressModel;
import model_classes.GeoModel;
import model_classes.CompanyModel;

public class UserUtils {
	public static UserModel getExpectedUser() {
		AddressModel expectedAddress = new AddressModel(TestDataUtils.getExpectedStreet("test3"),
				TestDataUtils.getExpectedSuite("test3"), TestDataUtils.getExpectedCity("test3"),
				TestDataUtils.getExpectedZipCode("test3"),
				new GeoModel(TestDataUtils.getExpectedLat("test3"), TestDataUtils.getExpectedLng("test3")));

		CompanyModel expectedCompany = new CompanyModel(TestDataUtils.getExpectedCompanyName("test3"),
				TestDataUtils.getExpectedCatchPhrase("test3"), TestDataUtils.getExpectedBs("test3"));

		UserModel expectedUser = new UserModel(TestDataUtils.getExpectedUserId("test3"),
				TestDataUtils.getExpectedName("test3"), TestDataUtils.getExpectedUsername("test3"),
				TestDataUtils.getExpectedEmail("test3"), expectedAddress, TestDataUtils.getExpectedPhone("test3"),
				TestDataUtils.getExpectedWebsite("test3"), expectedCompany);
		return expectedUser;
	}

	public static UserModel getActualUser(JSONObject userObject6) {
		AddressModel actualAddress = new AddressModel(userObject6.getJSONObject("address").getString("street"),
				userObject6.getJSONObject("address").getString("suite"),
				userObject6.getJSONObject("address").getString("city"),
				userObject6.getJSONObject("address").getString("zipcode"),
				new GeoModel(userObject6.getJSONObject("address").getJSONObject("geo").getString("lat"),
						userObject6.getJSONObject("address").getJSONObject("geo").getString("lng")));

		CompanyModel actualCompany = new CompanyModel(userObject6.getJSONObject("company").getString("name"),
				userObject6.getJSONObject("company").getString("catchPhrase"),
				userObject6.getJSONObject("company").getString("bs"));

		UserModel actualUser = new UserModel(userObject6.getInt("id"), userObject6.getString("name"),
				userObject6.getString("username"), userObject6.getString("email"), actualAddress,
				userObject6.getString("phone"), userObject6.getString("website"), actualCompany);
		return actualUser;
	}
}