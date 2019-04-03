package com.academy.mdq.services.dtos.response.comments;

import org.codehaus.jackson.annotate.JsonProperty;

public class Comments {

    @JsonProperty
    private int postId;

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    @JsonProperty
    private String body;

    @Override
    public String toString() {
        return "Comments{" +
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

    public String getBody() {
        return body;
    }

    public String getEmail(){
        return email;
    }
}
