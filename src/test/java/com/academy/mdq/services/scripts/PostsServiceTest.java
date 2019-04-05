package com.academy.mdq.services.scripts;

import com.academy.mdq.properties.ServicesProperties;
import com.academy.mdq.services.clients.PostClient;
import com.academy.mdq.services.dtos.responses.Response;
import com.academy.mdq.services.dtos.responses.comments.Comment;
import com.academy.mdq.services.dtos.responses.posts.Post;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Objects.isNull;

public class PostsServiceTest {
  private final PostClient client = new PostClient();

  @Test
  public void testPostsService() {
    Response<List<Post>> response = client.getAllPosts();

    Assert.assertEquals(200, response.getStatus());

    response.getPayload().forEach(post ->
        Assert.assertFalse("Checking that all posts are not empty", isNull(post.getId())));
  }

  @Test
  public void testCommentsService() {
    Response<List<Comment>> response = client.getAllComments();

    Assert.assertEquals(200, response.getStatus());

    response.getPayload().forEach(comment ->
        Assert.assertFalse("checking that all comments are not empty", isNull(comment.getId())));
  }


  @Test
  public void testAddPostService() {
    int status = client.addPost(new Post(1, 2, "hello", "World"));
    Assert.assertEquals(201, status);
  }

  @Test
  public void testPostDeleteService() {
    int status = client.deletePost(1);
    Assert.assertEquals(204, status);
  }

}
