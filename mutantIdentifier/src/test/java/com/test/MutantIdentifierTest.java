package com.test;

import static com.util.CommonUtil.parsePayloadWithJaxbAnnotation;
import static com.util.Constants.*;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.controller.MutantIdentifier;
import com.model.ResponseBodyType;

public class MutantIdentifierTest {
	private MutantIdentifier mutantIdentifier;

	@Before
	public void setUp() {
		mutantIdentifier = new MutantIdentifier();
	}

	@Test
	public void testBadParameters() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"CTTTTC\",\"TTXTGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(INVALID_REQUEST_ERROR_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testMatrizNotSquare() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"CTTTC\",\"TTXTGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(IS_NOT_SQUARE_MATRIX_ERROR_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testNoMutant() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"CATGCC\",\"TTGGGC\",\"AGTTGT\",\"TTCCTA\",\"TCATTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(NOT_MUTANT_ERROR_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testMutantHorizontal() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"CTTTTC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(SUCCESS_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testMutantDiagonalRight() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"CATTTC\",\"TTATGT\",\"ATAAGG\",\"GCTCTA\",\"TCATTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(SUCCESS_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testMutantDiagonalLeftRight() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"CATGTC\",\"TTGTGT\",\"AGATGG\",\"TCCCTA\",\"TCATTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(SUCCESS_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testMutantDiagonalLeft() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"CATGCC\",\"TTGTGT\",\"AGTTGT\",\"TTCCTA\",\"TCATTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(SUCCESS_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testMutantVertical() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"AAGTGC\",\"ATATGT\",\"AGAAGG\",\"CGCCTA\",\"TCACTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(SUCCESS_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

	@Test
	public void testMutantVerticalHorizontal() throws IOException {
		String message = "{\"mutantIdentifierRQ\":{\"dna\":[\"ATGCGA\",\"AAGTGC\",\"ATATGT\",\"TGAAGG\",\"CCCCTA\",\"TCACTG\"]}}";
		Response response = mutantIdentifier.execute(message);
		ResponseBodyType responseBodyType = parsePayloadWithJaxbAnnotation(response.getEntity(),
				ResponseBodyType.class);
		assertTrue(SUCCESS_CODE.equals(responseBodyType.getMutantIdentifierRS().getCodes()));
	}

}
