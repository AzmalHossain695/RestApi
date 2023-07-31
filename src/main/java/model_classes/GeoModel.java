package model_classes;

import java.util.Objects;

public class GeoModel {
	public String lat;
	public String lng;

	public GeoModel(String lat, String lng) {
		this.lat = lat;
		this.lng = lng;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		GeoModel other = (GeoModel) obj;
		return Objects.equals(lat, other.lat) && Objects.equals(lng, other.lng);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lat, lng);
	}
}