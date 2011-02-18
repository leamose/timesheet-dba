/*
 * Classname:           GeradorHash.java
 * Version:             1.0
 * Date:                24/04/2008
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */

package br.com.dba.timesheet.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 * Gera hash (resumos criptograficos) de dados.
 *
 * @author Uni�o Federativa do Brasil
 * @author Minist�rio da Justi�a
 * @author CGTI
 * @version 1.0
 * @deprecated
 */
@Deprecated
public class GeradorHash {

    private static final String ALGORITMO_SHA1 = "SHA-1";

    public static String gerarHashSha1(byte [] conteudo){
        return gerarHash(conteudo, ALGORITMO_SHA1);
    }

    public static String gerarHashMd5(byte [] conteudo){
        return gerarHash(conteudo, "MD5");
    }

    private static String gerarHash(byte [] conteudo, String algoritmo){
        try {
            MessageDigest digest = MessageDigest.getInstance(algoritmo);

            byte [] hash = digest.digest(conteudo);

            String resumo = new String(ConversorHexadecimal.encode(hash));

            return resumo.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("O Provider n�o da suporte ao agoritmo " + algoritmo);
        }
    }
}
