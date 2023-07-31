package utillity_classes;

public enum StatusCodeUtils {
	OK(200), NOT_FOUND(404), CREATED(201);

	private final int code;

	StatusCodeUtils(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}