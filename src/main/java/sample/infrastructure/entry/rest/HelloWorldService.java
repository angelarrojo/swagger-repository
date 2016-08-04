package sample.infrastructure.entry.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/validation")
@Api(value = "/validation", description = "Validation Rest")
/* @Produces({MediaType.TEXT_PLAIN}) */
public class HelloWorldService {

	@GET
	@Path("/{birthdate}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "", notes = "Test API Validation", response = Response.class)
	@ApiResponses({ @ApiResponse(code = 404, message = "URL not found"),
			@ApiResponse(code = 200, message = "Validation OK") })
	public Response getMsg(@ApiParam(value = "path-parameter birthdate", required = true) @PathParam("birthdate") String birthdate,
			@ApiParam(value = "query-parameter laboralSituation") @QueryParam("laboralSituation") String laboralSituation) {
		String output = "BirthDate: " + birthdate + " , Laboral Situation: " +laboralSituation;
		return Response.status(200).entity(output).build();
	}

}