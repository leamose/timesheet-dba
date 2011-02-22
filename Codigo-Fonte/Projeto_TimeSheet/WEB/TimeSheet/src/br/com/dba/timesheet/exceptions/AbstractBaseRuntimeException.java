package br.com.dba.timesheet.exceptions;


/**
 * Classe pai para todas exce��es de Runtime dentro da CGTI.
 *
 * @author Uni�o Federativa do Brasil
 * @author Minist�rio da Justi�a
 * @author CGTI
 * @author Anderson Claiton Fernandes
 * @version 1.0
 */
public abstract class AbstractBaseRuntimeException extends RuntimeException { 

    /**
     * Construtor Padr�o.
     */
    public AbstractBaseRuntimeException(){
    }

    /**
     * Construtor com a mensagem de erro.
     * 
     * @param msg mensagem da exce��o.
     */
    public AbstractBaseRuntimeException(String msg){
        super(msg);
    }
    
    /**
     * Construtor com a mensagem de erro e a pilha do erro.
     * 
     * @param msg mensagem da exce��o.
     * @param throwable pilha de erro.
     */
    public AbstractBaseRuntimeException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
