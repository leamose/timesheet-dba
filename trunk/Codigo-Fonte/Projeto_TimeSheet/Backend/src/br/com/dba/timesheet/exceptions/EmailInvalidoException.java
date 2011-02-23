/*
 * Classname:			EmailInvalidoException.java
 * Date:				26/07/2004
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe respons�vel por abstrair o acesso ao servi�o Usuario.
 *
 * @author             Uni�o Federativa do Brasil
 * @author             Minist�rio da Justi�a
 * @author             SE-SPOA-CGTI
 * @version            $Revision: 1.1 $ $Date: 2005-11-09 18:55:33 $
 *
 */
public class EmailInvalidoException extends Exception {
    
 
	private static final long serialVersionUID = 1L;

	/**
     * Construtor �nico que recebe detalhes da mensagem
     * @param s - Mensagem de erro
     */
    public EmailInvalidoException(String s){
        super(s);
    }

}
