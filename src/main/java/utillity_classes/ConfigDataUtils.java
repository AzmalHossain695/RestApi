package utillity_classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConfigDataUtils {
	private static String url;
	private static String posts;
	private static String users;

	static {
		try {
			FileReader reader = new FileReader(".\\src\\main\\resources\\config_data_files\\configdata.json");
			JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();
			url = config.get("url").getAsString();
			posts = config.get("posts").getAsString();
			users = config.get("users").getAsString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String getUrl() {
		return url;
	}

	public static String getPosts() {
		return posts;
	}

	public static String getUsers() {
		return users;
	}
}