package br.com.dba.timesheet.exceptions;

/**
 * Classe resonsável por tratar o erro de usuário inválido.
 * 
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

}
