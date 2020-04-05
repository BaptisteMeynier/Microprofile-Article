package com.keywer.article.microprofile.rest;

import com.keywer.article.microprofile.service.FishService;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Valid
@Path("fish")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class FishResource {

    @Inject
    private FishService fishService;

    @GET
    @Path("{fishFamily}")
    public int countByFamily(@NotBlank @PathParam("fishFamily") String fishFamily) {
        return fishService.countByFamily(fishFamily);
    }
}

