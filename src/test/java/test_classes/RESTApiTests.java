package test_classes;

import java.io.IOException;
import java.util.List;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model_classes.PostsModel;
import model_classes.UserModel;
import utillity_classes.PostsAndUsersUtils;
import utillity_classes.RandomUtils;
import utillity_classes.ResponseBodyTypeUtils;
import utillity_classes.StatusCodeUtils;
import utillity_classes.TestDataUtils;
import utillity_classes.UserUtils;

public class RESTApiTests {
	private static final Logger log = LogManager.getLogger(RESTApiTests.class);

	@Test
	public void RESTAPITests() throws IOException {
		Assert.assertEquals(StatusCodeUtils.OK.getCode(),
				PostsAndUsersUtils.getAllPosts().getStatusLine().getStatusCode(), "Status code is not 200");
		log.info("Status Code is 200");

		Assert.assertEquals(ContentType.getOrDefault(PostsAndUsersUtils.getAllPosts().getEntity()).getMimeType(),
				ResponseBodyTypeUtils.JSON.getType(), "Response body is not valid JSON");
		log.info("Response body is valid Json");

		List<PostsModel> posts = new Gson().fromJson(EntityUtils.toString(PostsAndUsersUtils.getAllPosts().getEntity()),
				new TypeToken<List<PostsModel>>() {
				}.getType());
		for (int i = 0; i < posts.size() - 1; i++) {
			Assert.assertTrue(posts.get(i).id < posts.get(i + 1).id, "List is not sorted ascending by id");
			log.info("List is sorted ascending by id");
		}
		Assert.assertEquals(StatusCodeUtils.OK.getCode(),
				PostsAndUsersUtils.getPostById(TestDataUtils.getExpectedId("test1")).getStatusLine().getStatusCode(),
				"Status code should be 200");
		log.info("Status code is 200");

		PostsModel actualPost = new Gson().fromJson(
				EntityUtils.toString(PostsAndUsersUtils.getPostById(TestDataUtils.getExpectedId("test1")).getEntity()),
				PostsModel.class);

		Assert.assertEquals(TestDataUtils.getExpectedUserId("test1"), actualPost.userId,
				"userId should be " + TestDataUtils.getExpectedUserId("test1"));
		log.info("User id is equal to expected user id");
		Assert.assertEquals(TestDataUtils.getExpectedId("test1"), actualPost.id,
				"id should be " + TestDataUtils.getExpectedId("test1"));
		log.info("Id is equal to expected id");
		Assert.assertFalse(actualPost.title.isEmpty(), "title should not be empty");
		log.info("Title is not empty");
		Assert.assertFalse(actualPost.body.isEmpty(), "body should not be empty");
		log.info("Body is not empty");

		Assert.assertEquals(StatusCodeUtils.NOT_FOUND.getCode(),
				PostsAndUsersUtils.getPostById(TestDataUtils.getExpectedId("test2")).getStatusLine().getStatusCode(),
				"Status code should be 404");
		log.info("Status code is 404");
		Assert.assertEquals("{}", EntityUtils
				.toString(PostsAndUsersUtils.getPostById(TestDataUtils.getExpectedId("test2")).getEntity()).trim(),
				"Response body should be empty");
		log.info("Response body is empty");

		PostsModel post = new PostsModel(TestDataUtils.getNewPostId("newPost"),
				TestDataUtils.getNewPostUserId("newPost"), RandomUtils.generateRandomString(),
				RandomUtils.generateRandomString());
		ObjectMapper mapper = new ObjectMapper();

		Assert.assertEquals(StatusCodeUtils.CREATED.getCode(),
				PostsAndUsersUtils.createPost(mapper.writeValueAsString(post)).getStatusLine().getStatusCode(),
				"Status Code is not 201");
		log.info("Status code is 201");
		PostsModel createdPost = mapper.readValue(
				EntityUtils.toString(PostsAndUsersUtils.createPost(mapper.writeValueAsString(post)).getEntity()),
				PostsModel.class);

		Assert.assertNotNull(createdPost.id, "id is not present in response");
		log.info("Id is present in response");
		Assert.assertEquals(createdPost.userId, post.userId, "UserId does not match data from request");
		log.info("UserId match data from request");
		Assert.assertEquals(createdPost.title, post.title, "Title does not match data from request");
		log.info("Title match data from request");
		Assert.assertEquals(createdPost.body, post.body, "Body does not match data from request");
		log.info("Body match data from request");

		Assert.assertEquals(StatusCodeUtils.OK.getCode(),
				PostsAndUsersUtils.getAllUsers().getStatusLine().getStatusCode(), "Status Code is not 200");
		log.info("Status code is 200");

		ContentType contentType5 = ContentType.getOrDefault(PostsAndUsersUtils.getAllUsers().getEntity());

		Assert.assertEquals(contentType5.getMimeType(), ResponseBodyTypeUtils.JSON.getType(),
				"Response body is not valid JSON");
		log.info("Response body is valid JSON");

		JSONArray usersArray = new JSONArray(EntityUtils.toString(PostsAndUsersUtils.getAllUsers().getEntity()));
		JSONObject userObject = null;
		for (int i = 0; i < usersArray.length(); i++) {
			JSONObject temp = usersArray.getJSONObject(i);
			if (temp.getInt("id") == TestDataUtils.getExpectedUserId("test3")) {
				userObject = temp;
				break;
			}
		}

		UserModel actualUser = UserUtils.getActualUser(userObject);
		UserModel expectedUser = UserUtils.getExpectedUser();
		Assert.assertEquals(actualUser, expectedUser, "Actual user values does not match expected user values");
		log.info("Actual user data matches expected user data");

		Assert.assertEquals(PostsAndUsersUtils.getUserById(TestDataUtils.getExpectedUserId("test3")).getStatusLine()
				.getStatusCode(), StatusCodeUtils.OK.getCode(), "Status Code is not 200");
		log.info("Status code is 200");

		JSONObject userObjecttest6 = new JSONObject(EntityUtils
				.toString(PostsAndUsersUtils.getUserById(TestDataUtils.getExpectedUserId("test3")).getEntity()));
		UserModel actualUsertest6 = UserUtils.getActualUser(userObjecttest6);
		UserModel expectedUsertest6 = UserUtils.getExpectedUser();
		Assert.assertEquals(actualUsertest6, expectedUsertest6,
				"Actual user values does not match expected user values");
		log.info("Actual user data matches expected user data");
	}
}