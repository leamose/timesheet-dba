/**
 * 
 */
package br.com.dba.timesheet.util;

/**
 * 
 * TODO comentar
 *
 * @author Fabio Oliveira de Pinho
 * 
 * @version 1.0
 */
public final class MaskUtil {

	private MaskUtil() { }
	
	/**
	 * Retorna a data com máscara.
	 * 
	 * @param value
	 * @return
	 */
	public static String appendDateMask(String value) {
		if (value != null) {
			/*
			 * Remove qualquer coisa diferente de numero
			 */
			value = StringUtil.removeNoNumbers(value);
				
			if (value.length() >= 4) {
				return value.substring(0, 2) + "/"
					+ value.substring(2, 4) + "/"
					+ value.substring(4);
			} else {
				return value;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * Adiciona a máscara para hora.
	 * 
	 * @param value
	 * @return
	 */
	public static String appendHourMinuteMask(String value) {
		if (value != null) {
			/*
			 * Remove qualquer coisa diferente de numero
			 */
			value = StringUtil.removeNoNumbers(value);
			
			return value.substring(0, 2) 
				+ ":"
				+ value.substring(2);
		} else {
			return null;
		}
	}

	/**
	 * Retorna o CNPJ com máscara.
	 * Exemplo de CNPJ válido (para teste): 23.643.315/0030-97
	 * 
	 * @param value
	 * @return 
	 */
	public static String appendCNPJMask(String value) {
		/*
		 * Remove qualquer coisa diferente de numero
		 */
		value = StringUtil.removeNoNumbers(value);
		
		return value.substring(0, 2) + "."
			+ value.substring(2, 5) + "."
			+ value.substring(5, 8) + "/"
			+ value.substring(8, 12) + "-"
			+ value.substring(12);
	}

	/**
	 * Adiciona máscara para CPF.
	 * 
	 * @param value
	 * @return
	 */
	public static String appendCPFMask(String value) {
		value = StringUtil.removeNoNumbers(value);

		return value.substring(0, 3) + "."
			+ value.substring(3, 6) + "."
			+ value.substring(6, 9) + "-"
			+ value.substring(9);
	}
}
