/*
 * Classname:			UsuarioNaoEncontradoException.java
 * Version:				$Revision: 1.0
 * Date:				23/06/2004
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe respons�vel por tratar o erro de usu�rio n�o encontrado.
 * 
 * @author             Uni�o Federativa do Brasil
 * @author             Minist�rio da Justi�a
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
