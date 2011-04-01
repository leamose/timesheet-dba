/*
 * Classname:			IdentificadorJaCadastradoException.java
 * Version:				$Revision: 1.0
 * Date:				22/06/2004
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe resonsável por tratar o erro de usuário inválido.
 * 
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision$ $Date$
 *
 * */
public class IdentificadorJaCadastradoException extends Exception {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;


    public IdentificadorJaCadastradoException() {
        super();
    }


    /**
     * @param message
     */
    public IdentificadorJaCadastradoException( String message ) {
        super(message);
    }


	public IdentificadorJaCadastradoException(String message, Throwable cause) {
		super(message, cause);
	}


	public IdentificadorJaCadastradoException(Throwable cause) {
		super(cause);
	}

}
