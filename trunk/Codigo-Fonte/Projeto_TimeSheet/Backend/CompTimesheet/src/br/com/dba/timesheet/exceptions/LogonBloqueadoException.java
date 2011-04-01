/*
 * Classname:                   LogonBloqueadoException
 * Version:                     $Revision 1.0
 * Date:                        01/06/2004
 *
 * Ministério da Justiça - Todos os direitos reservados
 */

package br.com.dba.timesheet.exceptions;

/**
* Exceção responsável por tratar erro de usuário bloqueado.
* 
* @author		União Federativa do Brasil
* @author		Ministério da Justiça
* @author		SE-SPOA-CGTI
* @version 		$Revision$ $Date$
*
* */
public class LogonBloqueadoException extends Exception {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;
    private String lembrete;
    
    /**
     * Creates a new LogonBloqueadoException object.
     */
    public LogonBloqueadoException() {
        super();
    }


    /**
     * Creates a new LogonBloqueadoException object.
     *
     * @param mensagem de erro
     */
    public LogonBloqueadoException(String message) {
        super(message);
    }

    
    /**
     * Creates a new LogonBloqueadoException object.
     *
     * @param mensagem de erro
     */
    public LogonBloqueadoException(String message,String lembrete) {
        super(message);
        this.lembrete = lembrete; 
    }
    
    
    /**
     * @return lembrete.
     */
    public String getLembrete() {
        return lembrete;
    }
}
