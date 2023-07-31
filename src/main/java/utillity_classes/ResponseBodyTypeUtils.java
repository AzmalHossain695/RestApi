package utillity_classes;

public enum ResponseBodyTypeUtils {
	JSON("application/json");

	private final String type;

	ResponseBodyTypeUtils(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}