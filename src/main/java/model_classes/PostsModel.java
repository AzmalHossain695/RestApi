package model_classes;

import java.util.Objects;

public class PostsModel {
    public int userId;
    public int id;
    public String title;
    public String body;

    public PostsModel() {}

    public PostsModel(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsModel postModel = (PostsModel) o;
        return userId == postModel.userId &&
                id == postModel.id &&
                Objects.equals(title, postModel.title) &&
                Objects.equals(body, postModel.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, body);
    }
}