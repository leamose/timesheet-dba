/*
 * Classname:			CPF.java
 * Version:				$Revision: 1.0
 * Date:				21/06/2005
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.struts.validator;

/**
 * Classe responsável por validar e formatar um número de CPF.
 * 
 * @author União Federativa do Brasil
 * @author Ministério da Justiça
 * @author SE-SPOA-CGTI
 * @version $Revision: 1.2 $ $Date: 2008-05-20 14:18:20 $
 * 
 */
public class CPF {

    private CPF() {

    }

    /**
     * Valida um número de CPF. 
     * 
     * @param numeroCPF 
     * 
     */
    public static boolean validaCPF(String numeroCPF) {
        if (numeroCPF == null) {
            return false;
        }                
        boolean resultado = false;
        numeroCPF = numeroCPF.trim();
        int tamanho = numeroCPF.length();
        if (tamanho > 11 && tamanho < 15) {
            numeroCPF = retiraFormatacao(numeroCPF);
        } 
        if (numeroCPF.length() > 11) {
            return false;
        }
        int posicaoTemp = 0;
        try {
            for (int i = 0; i < 9; i++)
                posicaoTemp += (10 - i) * (numeroCPF.charAt(i) - '0');
            posicaoTemp = 11 - (posicaoTemp % 11);
            if (posicaoTemp > 9)
                posicaoTemp = 0;
            if (posicaoTemp == (numeroCPF.charAt(9) - '0')) {
                posicaoTemp = 0;
                for (int i = 0; i < 10; i++)
                    posicaoTemp += (11 - i) * (numeroCPF.charAt(i) - '0');
                posicaoTemp = 11 - (posicaoTemp % 11);
                if (posicaoTemp > 9)
                    posicaoTemp = 0;
                if (posicaoTemp == (numeroCPF.charAt(10) - '0')) {
                    resultado = true;
                }
            }
            return resultado;
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }

    }

    /**
     * Retira formatação um número de CPF. 
     * 
     * @param numeroCPF 
     * 
     */    
    public static String retiraFormatacao(String numeroCPF) {
        if (numeroCPF == null) {
            return null;
        }          
        numeroCPF = numeroCPF.trim();
        numeroCPF = numeroCPF.replace(".", "");
        numeroCPF = numeroCPF.replace("-", "");        
        return numeroCPF;
    }
    
    /**
     * Formata um número de CPF. 
     * 
     * @param numeroCPF 
     * 
     */
    public static String formata(String numeroCPF) {
        if (numeroCPF == null) {
            return null;
        }            
        StringBuffer sb = new StringBuffer(numeroCPF);
        if (sb.length() > 3)
            sb.insert(3,".");
        if (sb.length() > 7)
            sb.insert(7,".");
        if (sb.length() > 11)
            sb.insert(11,"-");        
        return sb.toString();
    }    
}
