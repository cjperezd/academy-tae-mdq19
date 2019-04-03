package com.academy.mdq.services.clients;

import com.academy.mdq.services.apis.interfaces.IPost;
import com.academy.mdq.services.apis.interfaces.IComments;
import com.academy.mdq.services.dtos.response.Posts.Posts;
import com.academy.mdq.services.dtos.response.Response;
import com.academy.mdq.services.dtos.response.comments.Comments;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.GenericType;

import java.util.List;

public final class PostServiceClient {

    public Response<List<Posts>> getAllPosts() {
        javax.ws.rs.core.Response response = client().getAllPosts();
        return new Response<>(response.getStatus(), response.readEntity(new GenericType<List<Posts>>() {
        }));
    }

    public Response<List<Comments>> getAllComments() {
        javax.ws.rs.core.Response response = commentsClient().getAllComments();
        return new Response<>(response.getStatus(), response.readEntity(new GenericType<List<Comments>>() {
        }));
    }


    public IPost client() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("https://jsonplaceholder.typicode.com");
        return target.proxy(IPost.class);
    }

    public IComments commentsClient() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("https://jsonplaceholder.typicode.com");
        return target.proxy(IComments.class);
    }


}
