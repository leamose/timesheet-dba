package br.com.dba.timesheet.exceptions;




/**
 * Exceção de base para todas as exceções oriundas da camada de DAO.
 *
 * @author Fabio Oliveira de Pinho
 * @version 1.0
 */
public class DAOException extends AbstractBaseRuntimeException {
    
    /**
     * Construtor Padrão.
     */
    public DAOException(){
    }

    /**
     * Construtor com a mensagem de erro.
     * 
     * @param msg mensagem da exceção.
     */
    public DAOException(String msg){
        super(msg);
    }
    
    /**
     * Construtor com a mensagem de erro e a pilha do erro.
     * 
     * @param msg mensagem da exceção.
     * @param throwable pilha de erro.
     */
    public DAOException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
