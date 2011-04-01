/*
 * Classname:                   LogonBloqueadoException
 * Version:                     $Revision 1.0
 * Date:                        01/06/2004
 *
 * Minist�rio da Justi�a - Todos os direitos reservados
 */

package br.com.dba.timesheet.exceptions;

/**
* Exce��o respons�vel por tratar erro de usu�rio bloqueado.
* 
* @author		Uni�o Federativa do Brasil
* @author		Minist�rio da Justi�a
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
