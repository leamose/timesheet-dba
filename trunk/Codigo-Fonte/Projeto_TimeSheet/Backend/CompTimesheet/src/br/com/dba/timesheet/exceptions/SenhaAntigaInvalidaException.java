/*
 * Classname:			SenhaAntigaInvalidaException.java
 * Version:				$Revision: 1.0
 * Date:				22/06/2004
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe respons�vel por tratar o erro da senha antiga inv�lida do usu�rio 
 * no momento de alterar a senha.
 * 
 * @author             Uni�o Federativa do Brasil
 * @author             Minist�rio da Justi�a
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
