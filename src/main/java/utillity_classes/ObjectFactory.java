package utillity_classes;

import model_classes.AddressModel;
import model_classes.CompanyModel;
import model_classes.GeoModel;
import model_classes.UserModel;

public class ObjectFactory {
	public static UserModel createUser(int id, String name, String username, String email, AddressModel address,
			String phone, String website, CompanyModel company) {
		UserModel user = new UserModel(id, name, username, email, address, phone, website, company);
		return user;
	}

	public static AddressModel createAddress(String street, String suite, String city, String zipcode, GeoModel geo) {
		AddressModel address = new AddressModel(street, suite, city, zipcode, geo);
		return address;
	}

	public static GeoModel createGeo(String lat, String lng) {
		GeoModel geo = new GeoModel(lat, lng);
		return geo;
	}

	public static CompanyModel createCompany(String name, String catchPhrase, String bs) {
		CompanyModel company = new CompanyModel(name, catchPhrase, bs);
		return company;
	}
}