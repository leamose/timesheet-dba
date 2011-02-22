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
 * @author             Uni�o Federativa do Brasil
 * @author             Minist�rio da Justi�a
 * @author             SE-SPOA-CGTI
 * @version            $Revision: 1.1 $ $Date: 2005-06-03 13:16:44 $
 *
 */
public class ParametroInvalidoException extends Exception {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new ParametroInvalidoException object.
     */
    public ParametroInvalidoException() {
        super();
    }


    /**
     * Creates a new ParametroInvalidoException object.
     *
     * @param mensagem de erro
     */
    public ParametroInvalidoException(String message) {
        super(message);
    }
    
    /**
     * @param message
     * @param cause
     */
    public ParametroInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
