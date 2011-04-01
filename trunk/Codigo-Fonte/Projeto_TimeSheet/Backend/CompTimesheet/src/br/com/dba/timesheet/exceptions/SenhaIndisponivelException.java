/*
 * Classname:			SenhaIndisponivelException.java
 * Version:				$Revision: 1.0
 * Date:				23/06/2004
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe responsável por tratar erro de o usuário tentar consultar uma
 * senha que não seja temporária.
 * 
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision$ $Date$
 *
 * */
public class SenhaIndisponivelException extends Exception {

    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;


    public SenhaIndisponivelException() {
        super();

    }


    /**
     * @param message
     */
    public SenhaIndisponivelException( String message ) {
        super(message);
    }


}
