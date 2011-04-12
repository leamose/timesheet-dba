package br.com.dba.timesheet.exceptions;

/**
 * Classe resons�vel por tratar o erro de usu�rio inv�lido.
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
