/*
 * Classname:			ParametroInvalidoException.java
 * Version:				$Revision: 1.0
 * Date:				04/05/2005
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Exceção responsável por tratar erro de parâmetro inválido.
 *
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
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
