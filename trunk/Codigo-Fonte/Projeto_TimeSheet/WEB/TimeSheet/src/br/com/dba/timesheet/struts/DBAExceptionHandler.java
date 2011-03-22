/*
 * Classname:           ExceptionHandler.java
 * Version:             1.0
 * Date:                31/01/2008
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */

package br.com.dba.timesheet.struts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.ModuleException;

import br.com.dba.timesheet.exceptions.NegocioException;;

/**
 * Objeto que trata as exceções lançadas pela camada de controller.
 *
 * @author Fabio Oliveria de Pinho
 * @version 1.0
 */
public class DBAExceptionHandler extends ExceptionHandler {

    /**
     * Trata um exceção.
     * 
     */
    public ActionForward execute(Exception ex, ExceptionConfig config, ActionMapping mapping,
            ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        ActionForward forward = null;
        ActionMessage erro = null;

        if (config.getPath() != null) {
            forward = new ActionForward(config.getPath());
        } else {
            forward = mapping.getInputForward();
        }

        if (ex instanceof NegocioException) {
            NegocioException nEx = (NegocioException) ex;
            if (getProperties(request).isPresent(nEx.getMessage())) {
                erro = new ActionMessage(nEx.getMessage(), nEx.getParametros());
            } else {
                erro = new ActionMessage(nEx.getMessage(), false);
            }
        } else if (ex instanceof ModuleException) {
            erro = ((ModuleException) ex).getActionMessage();
        } else {
            erro = new ActionMessage(config.getKey(), ex.getMessage());
        }

        request.setAttribute(Globals.EXCEPTION_KEY, ex);
        
        ex.printStackTrace();
        
        storeException(request, erro.getKey(), erro, forward, config.getScope());

        return forward;
    }

    /**
     * Obtém o repositório de mensangens.
     * 
     * @param request requisição do usuário.
     * 
     * @return recurso de mensagens.
     */
    private MessageResources getProperties(HttpServletRequest request) {
        return (MessageResources) request.getSession().getServletContext().getAttribute(
            Globals.MESSAGES_KEY);
    }
}
