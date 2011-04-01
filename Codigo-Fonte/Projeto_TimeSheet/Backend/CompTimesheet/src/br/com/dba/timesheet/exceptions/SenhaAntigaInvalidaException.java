/*
 * Classname:			SenhaAntigaInvalidaException.java
 * Version:				$Revision: 1.0
 * Date:				22/06/2004
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe responsável por tratar o erro da senha antiga inválida do usuário 
 * no momento de alterar a senha.
 * 
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision$ $Date$
 *
 * */
public class SenhaAntigaInvalidaException extends Exception {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;


    public SenhaAntigaInvalidaException() {
        super();
    }


    /**
     * @param message
     */
    public SenhaAntigaInvalidaException( String message ) {
        super(message);
    }
}
