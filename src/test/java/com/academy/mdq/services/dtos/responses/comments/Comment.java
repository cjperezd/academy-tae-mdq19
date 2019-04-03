package com.academy.mdq.services.dtos.responses.comments;

import org.codehaus.jackson.annotate.JsonProperty;

public class Comment {

  @JsonProperty
  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;

  @Override
  public String toString() {
    return "Comment{" +
        "postId=" + postId +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", body='" + body + '\'' +
        '}';
  }

  public int getPostId() {
    return postId;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getBody() {
    return body;
  }
}
