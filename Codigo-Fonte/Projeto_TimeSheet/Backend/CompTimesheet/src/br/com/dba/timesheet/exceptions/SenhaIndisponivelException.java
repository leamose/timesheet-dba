/*
 * Classname:			SenhaIndisponivelException.java
 * Version:				$Revision: 1.0
 * Date:				23/06/2004
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe respons�vel por tratar erro de o usu�rio tentar consultar uma
 * senha que n�o seja tempor�ria.
 * 
 * @author             Uni�o Federativa do Brasil
 * @author             Minist�rio da Justi�a
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
