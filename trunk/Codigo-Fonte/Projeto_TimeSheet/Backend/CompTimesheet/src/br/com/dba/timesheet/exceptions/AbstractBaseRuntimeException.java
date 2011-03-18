package br.com.dba.timesheet.exceptions;


/**
 * Classe pai para todas exceções de Runtime dentro da CGTI.
 *
 * @author Fabio Oliveira de Pinho
 * @version 1.0
 */
public abstract class AbstractBaseRuntimeException extends RuntimeException { 

    /**
     * Construtor Padrão.
     */
    public AbstractBaseRuntimeException(){
    }

    /**
     * Construtor com a mensagem de erro.
     * 
     * @param msg mensagem da exceção.
     */
    public AbstractBaseRuntimeException(String msg){
        super(msg);
    }
    
    /**
     * Construtor com a mensagem de erro e a pilha do erro.
     * 
     * @param msg mensagem da exceção.
     * @param throwable pilha de erro.
     */
    public AbstractBaseRuntimeException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
