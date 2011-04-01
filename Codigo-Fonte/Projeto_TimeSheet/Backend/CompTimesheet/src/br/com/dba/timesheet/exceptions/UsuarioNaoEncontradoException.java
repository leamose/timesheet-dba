/*
 * Classname:			UsuarioNaoEncontradoException.java
 * Version:				$Revision: 1.0
 * Date:				23/06/2004
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe responsável por tratar o erro de usuário não encontrado.
 * 
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision$ $Date$
 *
 * */
public class UsuarioNaoEncontradoException extends Exception {

    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;


    public UsuarioNaoEncontradoException() {
        super();
    }


    /**
     * @param message
     */
    public UsuarioNaoEncontradoException( String message ) {
        super(message);
    }
    
	public UsuarioNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}
}
