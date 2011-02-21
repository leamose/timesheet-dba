/*
 * Classname:			CNPJ.java
 * Version:				$Revision: 1.0
 * Date:				21/06/2005
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.struts.validator;

/**
 * Classe responsável por validar e formatar um número de CNPJ.
 * 
 * @author União Federativa do Brasil
 * @author Ministério da Justiça
 * @author SE-SPOA-CGTI
 * @version $Revision: 1.1 $ $Date: 2005-11-09 18:55:33 $
 * 
 */
public class CNPJ {

    private CNPJ() {

    }

    /**
     * Valida um número de CNPJ. 
     * 
     * @param numeroCNPJ 
     * 
     */
    public static boolean validaCNPJ(String numeroCNPJ) {
        if (numeroCNPJ == null) {
            return false;
        }
        boolean resultado = false;
        numeroCNPJ = numeroCNPJ.trim();
        int tamanho = numeroCNPJ.length();
        if (tamanho > 14 && tamanho < 19) {
            numeroCNPJ = retiraFormatacao(numeroCNPJ);
        }
        if (numeroCNPJ.length() > 14) {
            return false;
        }
        int posicaoTemp = 0;
        try {
            for (int i = 0, j = 5; i < 12; i++) {
                posicaoTemp += j-- * (numeroCNPJ.charAt(i) - '0');
                if (j < 2)
                    j = 9;
            }
            posicaoTemp = 11 - (posicaoTemp % 11);
            if (posicaoTemp > 9)
                posicaoTemp = 0;
            if (posicaoTemp == (numeroCNPJ.charAt(12) - '0')) {
                posicaoTemp = 0;
                for (int i = 0, j = 6; i < 13; i++) {
                    posicaoTemp += j-- * (numeroCNPJ.charAt(i) - '0');
                    if (j < 2)
                        j = 9;
                }
                posicaoTemp = 11 - (posicaoTemp % 11);
                if (posicaoTemp > 9)
                    posicaoTemp = 0;
                if (posicaoTemp == (numeroCNPJ.charAt(13) - '0')) {
                    resultado = true;
                }
            }
            return resultado;
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Retira formatação de um número de CNPJ. 
     * 
     * @param numeroCNPJ 
     * 
     */
    public static String retiraFormatacao(String numeroCNPJ) {
        if (numeroCNPJ == null) {
            return null;
        }        
        numeroCNPJ = numeroCNPJ.trim();
        numeroCNPJ = numeroCNPJ.replace(".", "");
        numeroCNPJ = numeroCNPJ.replace("/", "");        
        numeroCNPJ = numeroCNPJ.replace("-", "");
        return numeroCNPJ;
    }

    /**
     * Formata um número de CNPJ. 
     * 
     * @param numeroCNPJ 
     * 
     */
    public static String formata(String numeroCNPJ) {
        if (numeroCNPJ == null) {
            return null;
        }                
        StringBuffer sb = new StringBuffer(numeroCNPJ);
        sb.insert(2, ".");
        sb.insert(6, ".");
        sb.insert(10, "/");
        sb.insert(15, "-");        
        return sb.toString();
    }
}
