package com.academy.mdq.services.apis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
