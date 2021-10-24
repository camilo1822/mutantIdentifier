package com.controller;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.DnaType;
import com.model.RequestBodyType;
import com.model.ResponseBodyType;

import static com.util.CommonUtil.*;
import static com.util.Constants.*;

/**
 * 
 * @author CAMILO
 * @version 1.0.0
 * @since 17/10/2021
 * @category Clase principal para identificar mutantes
 *
 */
public class MutantIdentifier {

	public Response execute(String request) {
		DnaType dnaType;
		ResponseBodyType responseBodyType;
		String jsonResponse;
		try {
			// Obtenemos RQ
			dnaType = getDnaType(request);
			// Validamos que sea matriz cuadrada
			if (isNotSquareMatrix(dnaType.getDna().toArray(new String[COMMON_ZERO]))) {
				responseBodyType = getResponseBodyType(IS_NOT_SQUARE_MATRIX_ERROR_CODE,
						IS_NOT_SQUARE_MATRIX_ERROR_MESSAGE);
				jsonResponse = parseObjectToString(responseBodyType, true);
				return Response.status(Response.Status.FORBIDDEN).type(MediaType.APPLICATION_JSON).entity(jsonResponse)
						.build();
			}
			// Validamos caracteres permitidos
			if (!isValidRequest(dnaType.getDna().toArray(new String[COMMON_ZERO]))) {
				responseBodyType = getResponseBodyType(INVALID_REQUEST_ERROR_CODE, INVALID_REQUEST_ERROR_MESSAGE);
				jsonResponse = parseObjectToString(responseBodyType, true);
				return Response.status(Response.Status.FORBIDDEN).type(MediaType.APPLICATION_JSON).entity(jsonResponse)
						.build();
			}
			// Validamos si es mutante
			if (!isMutant(dnaType.getDna().toArray(new String[COMMON_ZERO]))) {
				responseBodyType = getResponseBodyType(NOT_MUTANT_ERROR_CODE, NOT_MUTANT_ERROR_MESSAGE);
				jsonResponse = parseObjectToString(responseBodyType, true);
				return Response.status(Response.Status.FORBIDDEN).type(MediaType.APPLICATION_JSON).entity(jsonResponse)
						.build();
			}
		} catch (IOException e) {
			e.printStackTrace();
			responseBodyType = getResponseBodyType(PARSING_ERROR_CODE, PARSING_ERROR_MESSAGE);
			jsonResponse = parseObjectToString(responseBodyType, true);
			return Response.status(Response.Status.FORBIDDEN).type(MediaType.APPLICATION_JSON).entity(jsonResponse)
					.build();
		}
		// Armamos respuesta
		responseBodyType = getResponseBodyType(SUCCESS_CODE, SUCCESS_MESSAGE);
		jsonResponse = parseObjectToString(responseBodyType, true);
		return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();

	}

	/**
	 * Metodo para obtener {@code DnaType} a partir del string de entrada
	 * 
	 * @param request
	 * @return {@link DnaType}
	 * @throws IOException
	 */
	private DnaType getDnaType(String request) throws IOException {
		RequestBodyType requestBodyType = parsePayloadWithJaxbAnnotation(request, RequestBodyType.class);
		return requestBodyType.getMutantIdentifierRQ();
	}

}
