/*
 * Classname:                   SessaoInvalidaException.java
 * Version:                     $Revision 1.0
 * Date:                        01/06/2004
 *
 * Ministério da Justiça - Todos os direitos reservados
 */

package br.com.dba.timesheet.exceptions;

/**
* Exceção responsável por tratar erro de sessão inválida.
* 
* @author		União Federativa do Brasil
* @author		Ministério da Justiça
* @author		SE-SPOA-CGTI
* @version 		$Revision$ $Date$
*
* */
public class SessaoInvalidaException extends Exception {

    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;


    /**
     * Creates a new SessaoInvalidaException object.
     */
    public SessaoInvalidaException() {
        super();
    }


    /**
     * Creates a new SessaoInvalidaException object.
     *
     * @param mensagem de erro
     */
    public SessaoInvalidaException(String message) {
        super(message);
    }
}
