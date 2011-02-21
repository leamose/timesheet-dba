/*
 * Classname:           StreamUtils.java
 * Version:             1.0
 * Date:                31/01/2008
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */

package br.com.dba.timesheet.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Classe que encapsula os métodos utilitários para tratamento de streans
 * 
 * @author União Federativa do Brasil
 * @author Ministério da Justiça
 * @author CGTI
 * @version 1.0
 * 
 * @deprecated
 */
@Deprecated
public final class StreamUtils {

    /**
     * Construtor protegido.
     */
    private StreamUtils() {
    }

    /**
     * Converte um input stream para um array de bytes
     * 
     * @param input stream com dados para conversão
     * @return [] byte - bytes correspondete a stream
     * 
     * @throws IOException problemas na leitura da stream.
     */
    public static byte[] converterInputStreamParaByte(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[4000];

        for (int dataSize = 0; dataSize != -1; dataSize = input.read(buf)) {
            output.write(buf, 0, dataSize);
        }

        return output.toByteArray();
    }
}
