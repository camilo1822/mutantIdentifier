package com.util;

/**
 * 
 * @author CAMILO
 * @version 1.0.0
 * @since 17/10/2021
 * @category Clase utilitaria para constantes
 *
 */
public class Constants {

	private Constants() {
	}

	//General
	public static final String COMMON_STRING_EMPTY = "";
	public static final int COMMON_ZERO = 0;
	public static final int COMMON_ONE = 1;
	public static final int COMMON_TWO = 2;
	public static final int COMMON_THREE = 3;
	public static final int COMMON_FOUR = 4;
	public static final int COMMON_INT_MUTANT_SIZE_VALID = COMMON_TWO;
	public static final int COMMON_INT_MATRIX_LIMIT = COMMON_THREE;
	public static final String SUCCESS_MESSAGE = "SUCCESS";
	public static final String SUCCESS_CODE = "MU_0";
	public static final String REGULAR_PHRASE_REPEATING_CHARACTERS = "(\\w)\\1{3}";
	public static final String REGULAR_PHRASE_VALID_CHARACTERS = "[ATCG]+";
	//FACADE
	public static final String FACADE_PATH = "/services";
	public static final String COMMON_STRING_MUTANT = "mutant";
	// Errores
	public static final String PARSING_ERROR_MESSAGE = "Error parseando objeto";
	public static final String PARSING_ERROR_CODE = "MU_1";
	public static final String IS_NOT_SQUARE_MATRIX_ERROR_MESSAGE = "Matriz de entrada no es cuadrada";
	public static final String IS_NOT_SQUARE_MATRIX_ERROR_CODE = "MU_2";
	public static final String INVALID_REQUEST_ERROR_MESSAGE = "Caracteres de entrada invalidos, solo se permite: A,T,C,G";
	public static final String INVALID_REQUEST_ERROR_CODE = "MU_3";
	public static final String NOT_MUTANT_ERROR_MESSAGE = "No es mutante";
	public static final String NOT_MUTANT_ERROR_CODE = "MU_4";
}
