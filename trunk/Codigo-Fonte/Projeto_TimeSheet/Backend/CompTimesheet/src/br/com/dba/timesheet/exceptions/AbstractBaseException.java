package br.com.dba.timesheet.exceptions;


/**
 * Classe pai para todas exce��es (exceto as Runtime) dentro da CGTI.
 *
 * @author Fabio Oliveira de Pinho
 * @version 1.0
 */
public abstract class AbstractBaseException extends Exception { 

    /**
     * Construtor Padr�o.
     */
    public AbstractBaseException(){
    }

    /**
     * Construtor com a mensagem de erro.
     * 
     * @param msg mensagem da exce��o.
     */
    public AbstractBaseException(String msg){
        super(msg);
    }
    
    /**
     * Construtor com a mensagem de erro e a pilha do erro.
     * 
     * @param msg mensagem da exce��o.
     * @param throwable pilha de erro.
     */
    public AbstractBaseException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
