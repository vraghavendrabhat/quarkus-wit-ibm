package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/developers")
public class DeveloperResource {

	private static final List<Developer> DEVELOPERS = new ArrayList<Developer>();

	@Inject
	Validator validator;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDeveloper(@Valid Developer developer) {

		DEVELOPERS.add(developer);
		return Response.ok().build();

//		Set<ConstraintViolation<Developer>> violations = validator.validate(developer);
//		if (violations.isEmpty()) {
//			DEVELOPERS.add(developer);
//			return Response.ok().build();
//		} else {
//			return Response.status(Response.Status.BAD_REQUEST).entity(createErrorMessage(violations))
//					.type(MediaType.APPLICATION_JSON).build();
//		}
	}

//	private Object createErrorMessage(Set<ConstraintViolation<Developer>> violations) {
//		JsonArrayBuilder errors = Json.createArrayBuilder();
//		for (ConstraintViolation<?> violation : violations) {
//			errors.add(Json.createObjectBuilder().add("path", violation.getPropertyPath().toString()).add("message",
//					violation.getMessage()));
//		}
//		return errors.build();
//	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDevelopers(Developer developer) {
		DEVELOPERS.add(developer);
		return Response.ok().entity(DEVELOPERS).build();
	}

}
