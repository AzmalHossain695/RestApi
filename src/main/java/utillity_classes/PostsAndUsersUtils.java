package utillity_classes;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class PostsAndUsersUtils {

	public static HttpResponse getAllPosts() throws IOException {
		String url = ConfigDataUtils.getUrl() + ConfigDataUtils.getPosts();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		return client.execute(request);
	}

	public static HttpResponse getPostById(int id) throws IOException {
		String url = ConfigDataUtils.getUrl() + ConfigDataUtils.getPosts() + id;
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		return client.execute(request);
	}

	public static HttpResponse createPost(String postJson) throws IOException {
		String url = ConfigDataUtils.getUrl() + ConfigDataUtils.getPosts();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		StringEntity entity = new StringEntity(postJson);
		request.setEntity(entity);
		request.setHeader("Content-type", "application/json");
		return client.execute(request);
	}

	public static HttpResponse getAllUsers() throws IOException {
		String url = ConfigDataUtils.getUrl() + ConfigDataUtils.getUsers();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		return client.execute(request);
	}

	public static HttpResponse getUserById(int id) throws IOException {
		String url = ConfigDataUtils.getUrl() + ConfigDataUtils.getUsers() + id;
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		return client.execute(request);
	}
}