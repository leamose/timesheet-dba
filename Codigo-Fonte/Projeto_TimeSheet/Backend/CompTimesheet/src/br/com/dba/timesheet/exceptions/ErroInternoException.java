/*
 * Classname:			ErroInternoException.java
 * Version:				$Revision: 1.0
 * Date:				04/05/2005
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Exceção responsável por tratar os erros internos do sistema.
 * 
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision: 1.3 $ $Date: 2010-01-11 17:25:04 $
 *
 *@deprecated
 */
@Deprecated
public class ErroInternoException extends RuntimeException {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2L;

    /**
     * Creates a new ErroInternoException object.
     */
    public ErroInternoException() {
        super();
    }


    /**
     * Creates a new ErroInternoException object.
     *
     * @param mensagem de erro
     */
    public ErroInternoException(String message) {
        super(message);
    }
       
    /**
     * @param message
     * @param cause
     */
    public ErroInternoException(String message, Throwable cause) {
        super(message, cause);
    }
}
