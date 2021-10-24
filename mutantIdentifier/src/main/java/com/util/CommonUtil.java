package com.util;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.model.ResponseBodyType;
import com.model.StatusType;
import static com.util.Constants.*;
import static com.util.ValidationsUtil.*;

/**
 * 
 * @author CAMILO
 * @version 1.0.0
 * @since 24/10/2021
 * @category Clase utilitaria
 *
 */
public class CommonUtil {

	private CommonUtil() {
	}

	/**
	 * Metodo para parcear un objeto a otro
	 * 
	 * @param any
	 * @param clazz
	 * @return Objeto parseado
	 * @throws IOException
	 */
	public static <T> T parsePayloadWithJaxbAnnotation(Object any, Class<?> clazz) throws IOException {

		ObjectMapper mapper = null;
		ObjectReader objectReader = null;
		try {
			mapper = new ObjectMapper();
			mapper.registerModule(new JaxbAnnotationModule());
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			objectReader = mapper.readerFor(clazz);
			return objectReader.readValue(any.toString());
		} catch (IOException e) {
			throw new IOException(Constants.PARSING_ERROR_MESSAGE);
		}

	}

	/**
	 * Metodo para parsear object a String
	 * 
	 * @param object
	 * @param excludeNull
	 * @return String
	 * @throws Exception
	 */
	public static String parseObjectToString(Object object, boolean excludeNull) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (excludeNull) {
				mapper.setSerializationInclusion(Include.NON_NULL);
			}
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return COMMON_STRING_EMPTY;
		}
	}

	/**
	 * Metodo par aobtener objeto {@code ResponseBodyType}
	 * 
	 * @param code
	 * @param description
	 * @return {@link ResponseBodyType}
	 */
	public static ResponseBodyType getResponseBodyType(String code, String description) {
		ResponseBodyType responseBodyType = new ResponseBodyType();
		StatusType statusType = new StatusType();
		statusType.setCodes(code);
		statusType.setDescription(description);
		responseBodyType.setMutantIdentifierRS(statusType);
		return responseBodyType;
	}

	/**
	 * Metodo que valida si la matriz es cuadrada
	 * 
	 * @param adn
	 * @return boolean
	 */
	public static boolean isNotSquareMatrix(String[] adn) {
		return Arrays.stream(adn).filter(i -> i.length() != adn.length).findFirst().isPresent();
	}

	/**
	 * Metodo que valida que los caracteres de entrada sean solo A,T,C,G
	 * 
	 * @param adn
	 * @return boolean
	 */
	public static boolean isValidRequest(String[] adn) {
		for (String dna : adn) {
			if (!dna.matches(REGULAR_PHRASE_VALID_CHARACTERS)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Validamos si el adn ingresado es mutante
	 * 
	 * @param dna
	 * @return boolean
	 */
	public static boolean isMutant(String[] dna) {
		// Validamos cadena horizontal
		int count = horizontalValidation(dna);
		if (count >= COMMON_INT_MUTANT_SIZE_VALID) {
			return true;
		}
		// Validamos cadena vertical
		count += verticalValidation(dna);
		if (count >= COMMON_INT_MUTANT_SIZE_VALID) {
			return true;
		}
		// Validamos cadena diagonal derecha
		count += rightDiagonalValidation(dna);
		if (count >= COMMON_INT_MUTANT_SIZE_VALID) {
			return true;
		}
		// Validamos cadena diagonal izquierda
		count += leftDiagonalValidation(dna);
		if (count >= COMMON_INT_MUTANT_SIZE_VALID) {
			return true;
		}
		return false;
	}
}
