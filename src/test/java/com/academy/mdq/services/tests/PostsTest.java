package com.academy.mdq.services.tests;

import com.academy.mdq.services.clients.PostsServiceClient;
import com.academy.mdq.services.dtos.response.Response;
import com.academy.mdq.services.dtos.response.comments.Comment;
import com.academy.mdq.services.dtos.response.posts.Post;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PostsTest {

  private final PostsServiceClient client = new PostsServiceClient();

  public PostsTest() throws IOException {
  }

  @Test
  public void getAllPosts() {

    Response<List<Post>> response = client.getAllPosts();
    assertEquals(200, response.getStatus());
    response.getPayload()
        .forEach(post -> {
          assertNotNull(post.getUserId());
          assertNotNull(post.getId());
          assertNotNull(post.getTitle());
          assertNotNull(post.getBody());
        });
  }

  @Test
  public void getAllComments() {

    Response<List<Comment>> response = client.getAllComments();
    assertEquals(200, response.getStatus());
    response.getPayload()
        .forEach(comment -> {
          assertNotNull(comment.getPostId());
          assertNotNull(comment.getId());
          assertNotNull(comment.getName());
          assertNotNull(comment.getEmail());
          assertNotNull(comment.getBody());
        });
  }

  @Test
  public void createPost() {

    Post newPost = new Post();
    newPost.setUserId(11);
    newPost.setId(101);
    newPost.setTitle("laboriosam dolor voluptates");
    newPost.setBody("consequatur omnis est praesentium ducimus non iste neque hic deserunt voluptatibus veniam cum et rerum sed");

    int status = client.createPost(newPost);
    assertEquals(201, status);
  }

  @Test
  public void deletePost() {

    int status = client.deletePost(101);
    assertEquals(404, status);
  }

}
