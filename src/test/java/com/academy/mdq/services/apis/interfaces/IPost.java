package com.academy.mdq.services.apis.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface IPost {

    @GET
    @Path("/posts")
    @Produces(APPLICATION_JSON)
    Response getAllPosts();

    /*@PUT
    @Path("basic")
    @Consumes("text/plain")
    void putBasic(String body);

    @GET
    @Path("queryParam")
    @Produces("text/plain")
    String getQueryParam(@QueryParam("param")String param);

    @GET
    @Path("matrixParam")
    @Produces("text/plain")
    String getMatrixParam(@MatrixParam("param")String param);

    @GET
    @Path("uriParam/{param}")
    @Produces("text/plain")
    int getUriParam(@PathParam("param")int param);*/
}
