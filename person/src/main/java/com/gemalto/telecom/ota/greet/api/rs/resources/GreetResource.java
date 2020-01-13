package com.gemalto.telecom.ota.greet.api.rs.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gemalto.rnd.logging.ulf.Log;
import com.gemalto.rnd.logging.ulf.Logger;
import com.gemalto.telecom.components.monitoring.filters.ResourceMonitored;
import com.gemalto.telecom.ota.greet.api.constraints.ValidDummyPATCH;
import com.gemalto.telecom.ota.greet.api.constraints.ValidDummyPOST;
import com.gemalto.telecom.ota.greet.api.exceptions.IllegalDummyStateException;
import com.gemalto.telecom.ota.greet.api.model.Dummy;
import com.gemalto.telecom.ota.greet.api.rs.managers.GreetManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/")
@RequestScoped
@Api(value = "greet")
public class GreetResource {

    private static final Logger LOGGER = Log.getLogger(GreetResource.class);
    private static final String LOG_TYPE = "greet";
    private static final String LOG_ID = "id";

    @Inject
    private GreetManager greetManager;

    @POST
    @Path("v1/greet")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Create dummy", notes = "Create dummy")
    @ResourceMonitored
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Dummy created"),
            @ApiResponse(code = IllegalDummyStateException.HTTP_CODE, message = IllegalDummyStateException.DESCRIPTION)
    })
    public Response createDummy(
            @Valid @ValidDummyPOST
            @ApiParam(
                    value = "Dummy object<br>Required information is 'Id' and 'Name'",
                    required = true
            ) final Dummy dummy) throws IllegalDummyStateException, URISyntaxException {
        LOGGER.debug("Creating a new dummy '{0}'").details(LOG_TYPE, dummy).build();
        greetManager.createDummy(dummy);
        LOGGER.debug("Created dummy '{0}'").details(LOG_TYPE, dummy).build();
        final URI location = new URI("/v1/dummy/" + dummy.getId());
        return Response.created(location).type(MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("v1/dummy/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Change dummy state", notes = "Change dummy state")
    @ResourceMonitored
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dummy state changed"),
            @ApiResponse(code = IllegalDummyStateException.HTTP_CODE, message = IllegalDummyStateException.DESCRIPTION)
    })
    public Response changeState(
            @PathParam("id") final int id,
            @Valid @ValidDummyPATCH
            @ApiParam(
                    value = "Dummy object<br>Required information is 'State'",
                    required = true
            ) final Dummy dummy) {
        LOGGER.debug("Changing state of dummy id '{0}' with state '{1}'").details(LOG_ID, id).details(LOG_TYPE, dummy).build();
        greetManager.changeDummyState(id, dummy.getState());
        LOGGER.debug("Changed state of dummy id '{0}' with state '{1}'").details(LOG_ID, id).details(LOG_TYPE, dummy).build();
        return Response.ok().build();
    }
}
