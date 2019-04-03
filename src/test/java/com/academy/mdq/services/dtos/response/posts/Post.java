package com.academy.mdq.services.dtos.response.posts;

import org.codehaus.jackson.annotate.JsonProperty;

public class Post {

  @JsonProperty("userId")
  private Integer userId;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("body")
  private String body;

  public Integer getUserId() {
    return userId;
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }
}
