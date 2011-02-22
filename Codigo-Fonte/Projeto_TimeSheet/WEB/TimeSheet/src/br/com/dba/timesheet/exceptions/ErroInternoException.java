/*
 * Classname:			ErroInternoException.java
 * Version:				$Revision: 1.0
 * Date:				04/05/2005
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Exce��o respons�vel por tratar os erros internos do sistema.
 * 
 * @author             Uni�o Federativa do Brasil
 * @author             Minist�rio da Justi�a
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
