package com.academy.mdq.services.dtos.response.comments;

import org.codehaus.jackson.annotate.JsonProperty;

public class Comment {

  @JsonProperty("postId")
  private Integer postId;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("body")
  private String body;

  public Integer getPostId() {
    return postId;
  }

  public Integer getId() {
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