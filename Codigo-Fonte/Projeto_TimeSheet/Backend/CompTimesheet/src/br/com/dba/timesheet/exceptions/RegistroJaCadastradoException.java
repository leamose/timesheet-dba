/*
 * Classname:			ParametroInvalidoException.java
 * Version:				$Revision: 1.0
 * Date:				04/05/2005
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Exce��o respons�vel por tratar erro de par�metro inv�lido.
 *
 *
 */
public class RegistroJaCadastradoException extends Exception {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new ParametroInvalidoException object.
     */
    public RegistroJaCadastradoException() {
        super();
    }


    /**
     * Creates a new ParametroInvalidoException object.
     *
     * @param mensagem de erro
     */
    public RegistroJaCadastradoException(String message) {
        super(message);
    }
    
    /**
     * @param message
     * @param cause
     */
    public RegistroJaCadastradoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
