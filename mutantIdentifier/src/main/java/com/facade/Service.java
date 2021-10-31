package com.facade;

import static com.util.Constants.COMMON_STRING_MUTANT;
import static com.util.Constants.FACADE_PATH;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.controller.MutantIdentifier;

@Path(FACADE_PATH)
public class Service {

	@POST
	@Path(COMMON_STRING_MUTANT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response mutant(String request) {
		MutantIdentifier mutantIdentifier = new MutantIdentifier();
		return mutantIdentifier.execute(request);
	}
}
