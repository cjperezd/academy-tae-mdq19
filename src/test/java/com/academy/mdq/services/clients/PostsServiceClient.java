package com.academy.mdq.services.clients;

import com.academy.mdq.services.apis.Posts;
import com.academy.mdq.services.dtos.response.Response;
import com.academy.mdq.services.dtos.response.comments.Comment;
import com.academy.mdq.services.dtos.response.posts.Post;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.GenericType;
import java.util.List;

public final class PostsServiceClient {

  private static final String URL = "http://jsonplaceholder.typicode.com";

  public Response<List<Post>> getAllPosts() {
    javax.ws.rs.core.Response response = client().getAllPosts();
    return new Response<>(response.getStatus(), response.readEntity(new GenericType<List<Post>>(){}));
  }

  public Response<List<Comment>> getAllComments() {
    javax.ws.rs.core.Response response = client().getAllComments();
    return new Response<>(response.getStatus(), response.readEntity(new GenericType<List<Comment>>(){}));
  }

  private Posts client() {
    ResteasyClient client = new ResteasyClientBuilder().build();
    ResteasyWebTarget target = client.target(URL);
    return target.proxy(Posts.class);
  }

}
