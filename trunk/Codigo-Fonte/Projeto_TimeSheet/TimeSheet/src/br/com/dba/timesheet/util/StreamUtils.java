/*
 * Classname:           StreamUtils.java
 * Version:             1.0
 * Date:                31/01/2008
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */

package br.com.dba.timesheet.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Classe que encapsula os m�todos utilit�rios para tratamento de streans
 * 
 * @author Uni�o Federativa do Brasil
 * @author Minist�rio da Justi�a
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
     * @param input stream com dados para convers�o
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
