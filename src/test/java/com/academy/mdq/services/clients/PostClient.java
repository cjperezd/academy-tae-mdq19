package com.academy.mdq.services.clients;

import com.academy.mdq.services.apis.IPostsComments;
import com.academy.mdq.services.dtos.responses.Response;
import com.academy.mdq.services.dtos.responses.comments.Comment;
import com.academy.mdq.services.dtos.responses.posts.Post;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.GenericType;
import java.util.List;

public final class PostClient {

  private IPostsComments client() {
    ResteasyClient client = new ResteasyClientBuilder().build();
    ResteasyWebTarget target = client.target("http://jsonplaceholder.typicode.com");
    return target.proxy(IPostsComments.class);
  }

  public Response<List<Post>> getAllPosts() {
    javax.ws.rs.core.Response response = client().getPosts();
    return new Response<>(response.getStatus(), response.readEntity(new GenericType<List<Post>>() {
    }));
  }

  public Response<List<Comment>> getAllComments() {
    javax.ws.rs.core.Response response = client().getComments();
    return new Response<>(response.getStatus(), response.readEntity(new GenericType<List<Comment>>() {
    }));
  }

  public int addPost(Post post) {
    javax.ws.rs.core.Response response = client().addPost(post);
    return response.getStatus();
  }

  public int deletePost (int id){
    javax.ws.rs.core.Response response = client().deletePost(id);
    return response.getStatus();
  }
}
