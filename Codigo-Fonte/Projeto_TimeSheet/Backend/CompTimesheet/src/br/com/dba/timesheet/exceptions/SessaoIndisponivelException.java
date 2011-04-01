/*
 * Classname:                   SessaoIndisponivelException.java
 * Version:                     $Revision 1.0
 * Date:                        01/06/2004
 *
 * Ministério da Justiça - Todos os direitos reservados
 */

package br.com.dba.timesheet.exceptions;

/**
* Exceção responsável por tratar erro de sessão indisponível.
* 
* @author		União Federativa do Brasil
* @author		Ministério da Justiça
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
