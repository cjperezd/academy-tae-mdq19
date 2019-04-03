package com.academy.mdq.services.dtos.responses.posts;

import org.codehaus.jackson.annotate.JsonProperty;

public class Post{
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
    return "Post{" +
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
