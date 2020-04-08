package com.keywer.article.microprofile.rest;

import com.keywer.article.microprofile.domain.Fish;
import com.keywer.article.microprofile.repository.FishRepository;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.QueryStringDefaults;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;


@Valid
@Path("fish")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class FishResource {

    private static final String X_TOTAL_COUNT = "X-Total-Count";
    @Inject
    private FishRepository fishRepository;

    @Context
    protected UriInfo uriInfo;

    @Inject
    private QueryStringDefaults qsd;

    @GET
    @Path("family/{fishFamily}")
    public int countByFamily(@NotBlank @PathParam("fishFamily") String fishFamily) {
        return fishRepository.countFishByFamily(fishFamily);
    }

    @GET
    public Response getAllFish() {
        QueryParameters query = qsd.builder().queryEncoded(uriInfo.getRequestUri().getRawQuery()).build();

        List<Fish> allFishs = this.fishRepository.getFishs(query);
        Long allFishsCount = this.fishRepository.getFishsCount(query);

        return Response.ok(allFishs).header(X_TOTAL_COUNT, allFishsCount).build();
    }
}

