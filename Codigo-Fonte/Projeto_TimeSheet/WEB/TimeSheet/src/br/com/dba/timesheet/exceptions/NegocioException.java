package br.com.dba.timesheet.exceptions;


/**
 * Classe que encapsula pai para as exceções de negócio.
 *
 * @author União Federativa do Brasil
 * @author Ministério da Justiça
 * @author CGTI
 * @version 1.0
 */
public class NegocioException extends AbstractBaseException {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String [] _parametros;

    /**
     * Construtor padrão.
     */
    public NegocioException() {
    }

    /**
     * Construtor para mensagem de erro.
     * 
     * @param msg mensagem de erro.
     */
    public NegocioException(String msg) {
        super(msg);
    }

    /**
     * Construtor para mensagem de erro.
     * 
     * @param msg mensagem de erro.
     * @param parametros lista de parametros.
     */
    public NegocioException(String msg, String[] parametros) {
        super(msg);
        _parametros = parametros;
    }

    /**
     * Construtor para mensagem de erro e problema (pilha).
     * 
     * @param msg mensagem de erro.
     * @param pilha pilha de erro.
     */
    public NegocioException(String msg, Throwable pilha) {
        super(msg, pilha);
    }

    /**
     * Construtor para mensagem de erro e problema (pilha).
     * 
     * @param msg mensagem de erro.
     * @param parametros lista de parametros.
     * @param pilha pilha de erro.
     */
    public NegocioException(String msg, String[] parametros, Throwable pilha) {
        super(msg, pilha);
        _parametros = parametros;
    }

    /**
     * Obtém um dado.
     * 
     * @return o valor de parametros
     */
    public String[] getParametros() {
        return _parametros;
    }
}
