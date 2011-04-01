/*
 * Classname:                   IdentificadorSenhaIncorretosException.java
 * Version:                     $Revision 1.0
 * Date:                        01/06/2004
 *
 * Ministério da Justiça - Todos os direitos reservados
 */

package br.com.dba.timesheet.exceptions;

/**
* Exceção responsável por tratar erro de usuário ou senha incorretos.
* 
* @author		União Federativa do Brasil
* @author		Ministério da Justiça
* @author		SE-SPOA-CGTI
* @version 		$Revision$ $Date$
*
* */
public class IdentificadorSenhaIncorretosException extends Exception {


    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;


    /**
     * Creates a new IdentificadorSenhaIncorretosException object.
     */
    public IdentificadorSenhaIncorretosException() {
        super();
    }


    /**
     * Creates a new IdentificadorSenhaIncorretosException object.
     *
     * @param mensagem de erro
     */
    public IdentificadorSenhaIncorretosException(String message) {
        super(message);
    }
    
    public IdentificadorSenhaIncorretosException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
