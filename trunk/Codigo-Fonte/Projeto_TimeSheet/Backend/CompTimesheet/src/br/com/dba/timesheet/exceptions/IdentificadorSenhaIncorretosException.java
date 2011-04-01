/*
 * Classname:                   IdentificadorSenhaIncorretosException.java
 * Version:                     $Revision 1.0
 * Date:                        01/06/2004
 *
 * Minist�rio da Justi�a - Todos os direitos reservados
 */

package br.com.dba.timesheet.exceptions;

/**
* Exce��o respons�vel por tratar erro de usu�rio ou senha incorretos.
* 
* @author		Uni�o Federativa do Brasil
* @author		Minist�rio da Justi�a
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
