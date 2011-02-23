package br.com.dba.timesheet.exceptions;




/**
 * Exce��o de base para todas as exce��es oriundas da camada de DAO.
 *
 * @author Uni�o Federativa do Brasil
 * @author Minist�rio da Justi�a
 * @author CGTI
 * @author Anderson Claiton Fernandes
 * @version 1.0
 */
public class DAOException extends AbstractBaseRuntimeException {
    
    /**
     * Construtor Padr�o.
     */
    public DAOException(){
    }

    /**
     * Construtor com a mensagem de erro.
     * 
     * @param msg mensagem da exce��o.
     */
    public DAOException(String msg){
        super(msg);
    }
    
    /**
     * Construtor com a mensagem de erro e a pilha do erro.
     * 
     * @param msg mensagem da exce��o.
     * @param throwable pilha de erro.
     */
    public DAOException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
