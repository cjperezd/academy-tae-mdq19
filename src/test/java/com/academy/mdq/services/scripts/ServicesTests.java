package com.academy.mdq.services.scripts;

import com.academy.mdq.services.clients.PostClient;
import com.academy.mdq.services.dtos.responses.Response;
import com.academy.mdq.services.dtos.responses.comments.Comment;
import com.academy.mdq.services.dtos.responses.posts.Post;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Objects.isNull;

public class ServicesTests {
  private final PostClient client = new PostClient();

  @Test
  public void testPostsService() {
    Response<List<Post>> response = client.getAllPosts();

    Assert.assertEquals(200, response.getStatus());

    response.getPayload().forEach(post ->
        Assert.assertFalse("The post id " + post.getId() + " is not empty.", isNull(post.getId())));
  }

  @Test
  public void testCommentsService() {
    Response<List<Comment>> response = client.getAllComments();

    Assert.assertEquals(200, response.getStatus());

    response.getPayload().forEach(comment ->
        Assert.assertFalse("The comment id" + comment.getId() + "is not empty", isNull(comment.getId())));
  }

}
