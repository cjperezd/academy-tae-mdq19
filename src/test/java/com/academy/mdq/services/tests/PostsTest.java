package com.academy.mdq.services.tests;

import com.academy.mdq.services.apis.interfaces.IPost;
import com.academy.mdq.services.clients.PostServiceClient;
import com.academy.mdq.services.dtos.response.Posts.Posts;
import com.academy.mdq.services.dtos.response.Response;
import com.academy.mdq.services.dtos.response.comments.Comments;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class PostsTest {
    private final PostServiceClient client = new PostServiceClient();

    @Test
    public void myTest() {

        Response<List<Posts>> response = client.getAllPosts();
        Assert.assertEquals(200, response.getStatus());
        response.getPayload().forEach(post-> Assert.assertNotNull(post.getId()));
        response.getPayload().forEach(post-> Assert.assertNotNull(post.getUserId()));
        response.getPayload().forEach(post-> Assert.assertNotNull(post.getBody()));
        response.getPayload().forEach(post-> Assert.assertNotNull(post.getTitle()));


        Response<List<Comments>> response1 = client.getAllComments();
        Assert.assertEquals(200,response1.getStatus());
        response1.getPayload().forEach(comment -> Assert.assertNotNull(comment.getPostId()));
        response1.getPayload().forEach(comment -> Assert.assertNotNull(comment.getId()));
        response1.getPayload().forEach(comment -> Assert.assertNotNull(comment.getName()));
        response1.getPayload().forEach(comment -> Assert.assertNotNull(comment.getBody()));
        response1.getPayload().forEach(comment -> Assert.assertNotNull(comment.getEmail()));



    }
}
