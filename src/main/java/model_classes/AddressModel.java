package model_classes;

import java.util.Objects;

public class AddressModel {
	public String street;
	public String suite;
	public String city;
	public String zipcode;
	public GeoModel geo;

	public AddressModel(String street, String suite, String city, String zipcode, GeoModel geo) {
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.geo = geo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		AddressModel other = (AddressModel) obj;
		return Objects.equals(street, other.street) && Objects.equals(suite, other.suite)
				&& Objects.equals(city, other.city) && Objects.equals(zipcode, other.zipcode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(street, suite, city, zipcode);
	}
}