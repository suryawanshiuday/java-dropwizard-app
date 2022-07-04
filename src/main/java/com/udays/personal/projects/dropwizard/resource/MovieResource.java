package com.udays.personal.projects.dropwizard.resource;

import com.codahale.metrics.annotation.Timed;
import com.udays.personal.projects.dropwizard.model.Movie;
import com.udays.personal.projects.dropwizard.service.MovieService;

import javax.annotation.processing.Generated;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
/**
 * when we enable @RolesAllowed, user needs to be logged in to pass through Auth
 * when we access using localhost url, this will cause 401 and return "Credentials are required to access this resource."
 * while testing with localhost, I used postman with Authorization Bearer type and Token as test_token
 */
@RolesAllowed("ADMIN")
public class MovieResource {

    private final MovieService movieService;

    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @GET
    @Timed
    @Path("/all")
    public Response getAllMovies(){
        return Response.ok(movieService.getAllMovies()).build();
    }
}
