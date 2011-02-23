package br.com.dba.timesheet.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 * @author Fabio Oliveira de Pinho
 * 
 * @version 1.0
 */
public final class StringUtil {
	
	private static StringUtil util;
	private Locale localeBrasil;
	private NumberFormat nmfFormatoMoeda;
	private NumberFormat nmfFormatoNumero;
	
	private StringUtil() {
		
		localeBrasil 		= new Locale ("pt","BR");
		nmfFormatoMoeda 	= NumberFormat.getCurrencyInstance(localeBrasil);
		nmfFormatoNumero 	= NumberFormat.getNumberInstance(localeBrasil);		
		
		nmfFormatoMoeda.setMaximumFractionDigits(2);
		nmfFormatoNumero.setMaximumFractionDigits(2);

	}
	
	public static StringUtil getInstancia() {
		if (util == null) {
			util = new StringUtil();
		}
		return util;
	}

	/**
	 * Retorna um String representando o valor do objeto, se o mesmo for null,
	 * retorna o String "null", caso contrário retorna o resultado de toString()
	 * do objecto.
	 * 
	 * @param object
	 * @return
	 */
	public static String getToStringValue(Object object) {
		if (object == null) {
			return "null";

		} else {
			return object.toString();
		}
	}

	public static boolean isNotEmpty(String text) {
		return text != null && text.trim().length() > 0;
	}

	public static boolean isEmpty(String text) {
		return text == null || text.trim().length() == 0;
	}

	/**
	 * Retorna true se alguma das strings estiverem vazias.
	 * 
	 * @param text
	 * @param text2
	 * @return boolean
	 */
	public static boolean isEmpty(String text, String text2) {
		return isEmpty(text) || isEmpty(text2);
	}

	public static String fixeSize(String original, int size) {
		if (original != null) {
			if (original.length() > size) {
				return original.substring(0, size);
			} else if (original.length() == size) {
				return original;
			} else {
				StringBuffer buf = new StringBuffer(original);
				for (int i = 0; i < size - original.length(); i++) {
					buf.append(" ");
				}

				return buf.toString();
			}
		} else {
			StringBuffer buf = new StringBuffer(original);
			for (int i = 0; i < size; i++) {
				buf.append(" ");
			}

			return buf.toString();
		}
	}

	public static String replaceChar(String original, char ch, String text) {
		if (original != null) {
			StringBuffer buf = new StringBuffer();
			char actual;
			for (int i = 0; i < original.length(); i++) {
				actual = original.charAt(i);

				if (actual == ch) {
					buf.append(text);
				} else {
					buf.append(actual);
				}
			}

			return buf.toString();
		} else {
			return original;
		}
	}

	public static String replaceFirstChar(String original, char ch, String text) {
		if (original != null) {
			StringBuffer buf = new StringBuffer();
			char actual;
			for (int i = 0; i < original.length(); i++) {
				actual = original.charAt(i);

				if (actual == ch) {
					buf.append(text);
					buf.append(original.substring(i + 1));
					break;
				} else {
					buf.append(actual);
				}
			}

			return buf.toString();
		} else {
			return original;
		}
	}

	public static String appendLeftZeros(String input, int size) {
		int qtd = size - input.length();
		String original = input;
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < qtd; i++) {
			buf.append("0");
		}

		return buf.toString() + original;
	}

	public static String retiraEspacoBrancoDireita(String texto) {
		if (texto != null && texto.length() > 0 && texto.indexOf(" ") >= 0) {
			int i = 0;
			// String ret = "";
			for (i = texto.length() - 1; i >= 0; i--) {
				if (!Character.isSpaceChar(texto.charAt(i)))
					break;
			}

			return new String(texto.substring(0, i + 1));
		}
		return new String(texto);
	}

	public static String retiraEspacoBrancoEsquerda(String texto) {
		if (texto != null && texto.length() > 0 && texto.indexOf(" ") >= 0) {
			int i = 0;
			// String ret = "";
			for (; i >= texto.length() - 1; i++) {
				if (!Character.isSpaceChar(texto.charAt(i)))
					break;
			}

			return new String(texto.substring(i, texto.length()));
		}
		return new String(texto);
	}

	/**
	 * Baseado na String original retorna uma String apenas com os caracteres
	 * numéricos.
	 * 
	 * @param original
	 * @return
	 */
	public static String removeNoNumbers(String original) {
		if (original != null) {
			StringBuffer buf = new StringBuffer();
			int len = original.length();
			char ch;

			for (int i = 0; i < len; i++) {
				ch = original.charAt(i);

				if (Character.isDigit(ch)) {
					buf.append(ch);
				}
			}

			return buf.toString();
		} else {
			return null;
		}
	}

	/**
	 * Remove a acentuação de uma string.
	 * 
	 * @param string
	 *            string
	 * @return string sem acentos.
	 */
	public static String removerAcentuacao(String string) {
		if (!isEmpty(string)) {
			string = substituirString(string, "[ÁÀÂÃ]", "A");
			string = substituirString(string, "[áàâãª]", "a");
			string = substituirString(string, "[ÉÈÊ]", "E");
			string = substituirString(string, "[éèê]", "e");
			string = substituirString(string, "[ÍÌÎÏ]", "I");
			string = substituirString(string, "[íìîï]", "i");
			string = substituirString(string, "[ÓÒÔÕÖ]", "O");
			string = substituirString(string, "[óòôõºö]", "o");
			string = substituirString(string, "[ÚÙÛÜ]", "U");
			string = substituirString(string, "[úùûü]", "u");
			string = substituirString(string, "Ç", "C");
			string = substituirString(string, "ç", "c");
		}
		return string;
	}

	/**
	 * Altera a string definida por parâmetro.
	 * 
	 * @param srcString
	 *            String que será modificada.
	 * @param localizar
	 *            String que será pesquisada.
	 * @param novaString
	 *            String substituta.
	 * @return nova string com as devidas alterações.
	 */
	public static String substituirString(String srcString, String localizar,
			String novaString) {
		if (!isEmpty(srcString, localizar)) {
			srcString = srcString.replaceAll(localizar, novaString);
		}
		return srcString;
	}

	/**
	 * Retorna a string sem espaços em branco.
	 * 
	 * @param src
	 * @return
	 */
	public static String removeEspacos(String src) {
		if (isNotEmpty(src)) {
			src = src.trim();
		}
		return src;
	}

	/**
	 * toString() gerantindo o null.
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(Object object) {
		if (object != null) {
			return object.toString();
		} else {
			return "";
		}
	}
	
	/**
	 * Método para formatar o anoMesReferencia para ser exibido para o usuario
	 * @param anoMesReferencia
	 * @return
	 */
	public static String formataAnoMesReferencia(String anoMesReferencia) {
		String mes = anoMesReferencia.substring(4, 6);
		String ano = anoMesReferencia.substring(0, 4);		
		String valorFormatado = DataUtil.converterMesParaExtensoAbreviado(new Integer(mes) - 1) + "/" + ano;
		return valorFormatado;
	}
	
	public static String formataCep(String cep) {
		String novoCEP = cep.substring(0, 2) + "." + cep.substring(2, 5) + "-"
		+ cep.substring(5, 8);
		return novoCEP;
	}
	
	public static String formataCnpj(String cnpj) {
		String novoCnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2,5) + '.' + cnpj.substring(5,8) + '/' + cnpj.substring(8,12)+ '-' + cnpj.substring(12,cnpj.length());
		return novoCnpj;
	}
	
	public static String cnpjSemFormatacao(String cnpj) {
		String novoCnpj = cnpj.replace(".", "");
		novoCnpj = novoCnpj.replace("-", "");
		novoCnpj = novoCnpj.replace("/", "");
		return novoCnpj;
	}

	//Metodo para formata valores
	public String getFormatacaoValorMoedaBrasil(double valor) {
		return nmfFormatoMoeda.format(valor);
	}
	
	public String getFormatacaoNumericoBrasil(double valor) {
		return nmfFormatoNumero.format(valor);
	}
	
	public Double getFormatacaoValorNumericoBrasil(String valor) throws Exception {
		Number num = nmfFormatoNumero.parse(valor);
		
		return num.doubleValue();
	}

}
