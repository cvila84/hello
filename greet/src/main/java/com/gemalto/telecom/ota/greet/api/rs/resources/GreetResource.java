package com.gemalto.telecom.ota.greet.api.rs.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
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
import com.gemalto.telecom.ota.greet.api.exceptions.IllegalDummyStateException;
import com.gemalto.telecom.ota.greet.api.model.Greet;
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

    @GET
    @Path("v1/greet/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Send greetings", notes = "Send greetings")
    @ResourceMonitored
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Greetings sent"),
    })
    public Response sendGreetings(
            @PathParam("name") final String name
    ) {

    }

    @PUT
    @Path("v1/greet/{name}")
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
            ) final Greet greet) {
        LOGGER.debug("Changing state of dummy id '{0}' with state '{1}'").details(LOG_ID, id).details(LOG_TYPE, greet).build();
        greetManager.changeDummyState(id, greet.getState());
        LOGGER.debug("Changed state of dummy id '{0}' with state '{1}'").details(LOG_ID, id).details(LOG_TYPE, greet).build();
        return Response.ok().build();
    }
}
