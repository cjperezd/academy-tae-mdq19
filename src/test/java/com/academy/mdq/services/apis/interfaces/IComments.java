package com.academy.mdq.services.apis.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface IComments {

    @GET
    @Path("/comments")
    @Produces(APPLICATION_JSON)
    Response getAllComments();
}
