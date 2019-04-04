package com.academy.mdq.services.apis;

import com.academy.mdq.services.dtos.responses.posts.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface IPostsComments {

  @GET
  @Path("/posts")
  @Produces(APPLICATION_JSON)
  Response getPosts();


  @GET
  @Path("/comments")
  @Produces(APPLICATION_JSON)
  Response getComments();

  @POST
  @Path("/posts")
  @Consumes (APPLICATION_JSON)
  Response addPost(Post post);

  @DELETE
  @Path("/posts/")
  public Response deletePost (@QueryParam("userId") int id);





}
