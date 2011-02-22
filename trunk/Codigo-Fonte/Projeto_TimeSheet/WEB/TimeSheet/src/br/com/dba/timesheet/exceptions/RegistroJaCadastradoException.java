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
 * @version            $Revision: 1.1 $ $Date: 2007-09-03 18:50:01 $
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
