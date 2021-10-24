package com.facade;

import javax.ws.rs.POST;
import static com.util.Constants.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.controller.MutantIdentifier;

@Path(FACADE_PATH)
public class Service {

	@Path(COMMON_STRING_MUTANT)
	@POST
	public Response mutant(String request) {
		MutantIdentifier mutantIdentifier = new MutantIdentifier();
		return mutantIdentifier.execute(request);
	}
}
