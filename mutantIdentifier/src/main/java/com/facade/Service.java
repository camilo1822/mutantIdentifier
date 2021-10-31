package com.facade;

import static com.util.Constants.COMMON_STRING_MUTANT;
import static com.util.Constants.FACADE_PATH;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.MutantIdentifier;

//@Produces({ "application/json" })
//@RestController
//@RequestMapping(FACADE_PATH)
@Path(FACADE_PATH)
public class Service {

	@POST
	@Path(COMMON_STRING_MUTANT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response mutant(String request) {
		System.out.println("entre a mutantes");
		MutantIdentifier mutantIdentifier = new MutantIdentifier();
		return mutantIdentifier.execute(request);
	}

	@GET
	@Path("/ejm")
	@Produces(MediaType.APPLICATION_JSON)
	public String ejm(String request) {
		System.out.println("entre a ejm");
		return "hola mundo";
	}
}
