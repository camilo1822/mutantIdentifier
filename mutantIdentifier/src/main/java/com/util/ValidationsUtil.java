package com.util;

import static com.util.Constants.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author CAMILO
 * @version 1.0.0
 * @since 24/10/2021
 * @category Clase utilitaria para validar cadenas de adn mutante
 *
 */
public class ValidationsUtil {

	private ValidationsUtil() {
	}

	/**
	 * Metodo que valida si un caracter se repite 4 o mas veces seguidas en una
	 * cadena de forma horizontal, si se repite mas de dos veces se cierra el ciclo
	 * 
	 * @param adn
	 * @return int conteo de repeticiones
	 */
	public static int horizontalValidation(String[] adn) {
		int count = COMMON_ZERO;
		for (String dna : adn) {
			Pattern p = Pattern.compile(REGULAR_PHRASE_REPEATING_CHARACTERS);
			Matcher m = p.matcher(dna);
			while (m.find()) {
				count++;
			}
			if (count >= 2) {
				break;
			}
		}
		return count;
	}

	/**
	 * Metodo que valida si un caracter se repite 4 o mas veces seguidas en una
	 * cadena de forma vertical, si se repite mas de dos veces se cierra el ciclo
	 * 
	 * @param adn
	 * @return int conteo de repeticiones
	 */
	public static int verticalValidation(String[] adn) {
		char[][] characterMatrix = new char[adn.length][adn.length];
		String[] dna = new String[adn.length];
		char character[];
		// Cambiamos de vertical a horizontal la posicion de los caracteres
		for (int i = COMMON_ZERO; i < adn.length; i++) {
			character = adn[i].toCharArray();
			for (int j = COMMON_ZERO; j < character.length; j++) {
				characterMatrix[j][i] = character[j];
			}
		}
		// Convertimos matriz de caracteres a arreglo de string
		for (int i = COMMON_ZERO; i < adn.length; i++) {
			dna[i] = String.valueOf(characterMatrix[i]);
		}
		return horizontalValidation(dna);
	}
	
	/**
	 * Metodo que valida si un caracter se repite 4 o mas veces seguidas en una
	 * cadena de forma diagonal derecha, si se repite mas de dos veces se cierra el ciclo
	 * 
	 * @param adn
	 * @return int conteo de repeticiones
	 */
	public static int rightDiagonalValidation(String[] adn) {
		StringBuilder stringBuilder;
		ArrayList<String> diagonalsString = new ArrayList<String>();
		for (int i = COMMON_ZERO; i < adn.length - COMMON_INT_MATRIX_LIMIT; i++) {
			for (int j = COMMON_ZERO; j < adn[i].length() - COMMON_INT_MATRIX_LIMIT; j++) {
				stringBuilder = new StringBuilder();
				stringBuilder.append(adn[i].charAt(j));
				stringBuilder.append(adn[i + COMMON_ONE].charAt(j + COMMON_ONE));
				stringBuilder.append(adn[i + COMMON_TWO].charAt(j + COMMON_TWO));
				stringBuilder.append(adn[i + COMMON_THREE].charAt(j + COMMON_THREE));
				diagonalsString.add(stringBuilder.toString());
			}
		}
		String[] stringArray = diagonalsString.toArray(new String[COMMON_ZERO]);
		return horizontalValidation(stringArray);
	}
	
	/**
	 * Metodo que valida si un caracter se repite 4 o mas veces seguidas en una
	 * cadena de forma diagonal izquierda, si se repite mas de dos veces se cierra el ciclo
	 * 
	 * @param adn
	 * @return int conteo de repeticiones
	 */
	public static int leftDiagonalValidation(String[] adn) {
		StringBuilder stringBuilder;
		ArrayList<String> diagonalsString = new ArrayList<String>();
		int size;
		for (int i = COMMON_ZERO; i < adn.length - COMMON_THREE; i++) {
			size = adn[COMMON_ONE].length();
			for (int j = COMMON_ZERO; j < adn[i].length() - COMMON_THREE; j++) {
				stringBuilder = new StringBuilder();
				stringBuilder.append(adn[i].charAt(size-j-COMMON_ONE));
				stringBuilder.append(adn[i + COMMON_ONE].charAt(size-j-COMMON_TWO));
				stringBuilder.append(adn[i + COMMON_TWO].charAt(size-j-COMMON_THREE));
				stringBuilder.append(adn[i + COMMON_THREE].charAt(size-j-COMMON_FOUR));
				diagonalsString.add(stringBuilder.toString());
			}
		}
		String[] stringArray = diagonalsString.toArray(new String[COMMON_ZERO]);
		return horizontalValidation(stringArray);
	}

}
