package br.com.dba.timesheet.exceptions;

/**
* Exceção responsável por tratar erro de usuário ou senha incorretos.
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
