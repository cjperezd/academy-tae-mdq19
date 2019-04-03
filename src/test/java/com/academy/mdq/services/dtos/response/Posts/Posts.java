package com.academy.mdq.services.dtos.response.Posts;
import org.codehaus.jackson.annotate.JsonProperty;

public class Posts {

    @JsonProperty
    private int userId;

    @JsonProperty
    private int id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String body;

    @Override
    public String toString() {
        return "Posts{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
