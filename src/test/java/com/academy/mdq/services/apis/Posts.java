package com.academy.mdq.services.apis;

import com.academy.mdq.services.dtos.response.posts.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface Posts {

  @GET
  @Path("/posts")
  @Produces(APPLICATION_JSON)
  Response getAllPosts();
  
  @GET
  @Path("/comments")
  @Produces(APPLICATION_JSON)
  Response getAllComments();

  @POST
  @Path("/posts")
  @Consumes(APPLICATION_JSON)
  Response createPost(Post newPost);

  @DELETE
  @Path("/posts")
  Response deletePost(@PathParam("Id") Integer id);

}
