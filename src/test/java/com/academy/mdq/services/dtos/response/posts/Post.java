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

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String toString() {
    return userId + " / " + id + " / " + title + " / " + body;
  }
}
