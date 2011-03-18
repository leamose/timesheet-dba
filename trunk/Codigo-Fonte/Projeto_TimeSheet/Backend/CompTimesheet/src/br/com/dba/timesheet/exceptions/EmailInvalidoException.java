/*
 * Classname:			EmailInvalidoException.java
 * Date:				26/07/2004
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.exceptions;

/**
 * Classe responsável por abstrair o acesso ao serviço Usuario.
 *
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision: 1.1 $ $Date: 2005-11-09 18:55:33 $
 *
 */
public class EmailInvalidoException extends Exception {
    
 
	private static final long serialVersionUID = 1L;

	/**
     * Construtor único que recebe detalhes da mensagem
     * @param s - Mensagem de erro
     */
    public EmailInvalidoException(String s){
        super(s);
    }

}
