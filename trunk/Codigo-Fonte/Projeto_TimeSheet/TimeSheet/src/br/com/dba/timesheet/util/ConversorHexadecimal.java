/*
 * Classname:           ConversorHexadecimal.java
 * Version:             1.0
 * Date:                24/04/2008
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */

package br.com.dba.timesheet.util;


/**
 * Codifica/decodifica arrays hexadecimais.
 *
 * @author Uni�o Federativa do Brasil
 * @author Minist�rio da Justi�a
 * @author CGTI
 * @version 1.0
 * 
 * @deprecated
 */
@Deprecated
public final class ConversorHexadecimal {

    private ConversorHexadecimal(){
    }

    private static final char[] DIGITOS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'};
    

    /**
     * Converte um array de char hexadecimal para um array bin�rio.
     * 
     * @param hexa array de dados em hexadecimal.
     * 
     * @return array de bytes equivalente.
     */
    public static byte[] decode(char[] hexa) {
        int len = hexa.length;
        
        if ((len & 0x01) != 0) {
            throw new RuntimeException("Dado informado n�o � hexadecimal.");
        }
        
        byte[] out = new byte[len >> 1];

        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(hexa[j]) << 4;
            j++;
            f = f | toDigit(hexa[j]);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    /**
     * Converte um array de bytes em um array hexadecimal.
     * 
     * @param conteudo conte�do em bytes.
     * 
     * @return array de caracteres hexadecimal.
     */
    public static char[] encode(byte[] conteudo) {
        int l = conteudo.length;

        char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITOS[(0xF0 & conteudo[i]) >>> 4 ];
            out[j++] = DIGITOS[ 0x0F & conteudo[i] ];
        }

        return out;
    }

    /**
     * Converte um caracter hexadecimal em um inteiro.
     * 
     * @param ch caracter
     * 
     * @return equivalente inteiro.
     */
    private static int toDigit(char ch) {
        int digit = Character.digit(ch, 16);

        if (digit == -1) {
            throw new RuntimeException("Caracter informado n�o � hexadecimal " + ch);
        }

        return digit;
    }
}
