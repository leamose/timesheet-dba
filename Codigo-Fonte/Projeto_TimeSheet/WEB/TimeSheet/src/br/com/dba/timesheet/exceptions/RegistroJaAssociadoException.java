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
 * @version            $Revision: 1.1 $ $Date: 2007-09-03 18:50:01 $
 *
 */
public class RegistroJaAssociadoException extends Exception {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new ParametroInvalidoException object.
     */
    public RegistroJaAssociadoException() {
        super();
    }


    /**
     * Creates a new ParametroInvalidoException object.
     *
     * @param mensagem de erro
     */
    public RegistroJaAssociadoException(String message) {
        super(message);
    }
    
    /**
     * @param message
     * @param cause
     */
    public RegistroJaAssociadoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
