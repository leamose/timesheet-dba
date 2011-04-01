/*
 * Classname:                   SessaoIndisponivelException.java
 * Version:                     $Revision 1.0
 * Date:                        01/06/2004
 *
 * Minist�rio da Justi�a - Todos os direitos reservados
 */

package br.com.dba.timesheet.exceptions;

/**
* Exce��o respons�vel por tratar erro de sess�o indispon�vel.
* 
* @author		Uni�o Federativa do Brasil
* @author		Minist�rio da Justi�a
* @author		SE-SPOA-CGTI
* @version 		$Revision$ $Date$
*
* */
public class SessaoIndisponivelException extends Exception {
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;


    /**
     * Creates a new SessaoIndisponivelException object.
     */
    public SessaoIndisponivelException() {
        super();
    }


    /**
     * Creates a new SessaoIndisponivelException object.
     *
     * @param mensagem de erro.
     */
    public SessaoIndisponivelException(String message) {
        super(message);
    }
}
