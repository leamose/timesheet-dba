/*
 * Classname:           BaseDispatchAction.java
 * Version:	            1.0
 * Date:                31/01/2008
 * 
 * Minist�rio da Justi�a - Todos os direitos reservados
 */
package br.com.dba.timesheet.struts;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.dba.timesheet.util.Sessao;


/**
 * Classe base para actions.
 *
 * @author Fabio Oliveira de Pinho
 * @version 1.0
 */
public abstract class BaseDispatchAction extends Action {

    public static final String SESSAO_EJB = "br.com.dba.timesheet.login.sessao.usuario"; 
    
    public static final String SESSAO_REQUEST = "br.com.dba.timesheet.login.sessao.usuario.request";

    /**
     * Constante que define o nome objeto correspondente ao formul�rio que est� no request.
     */
    protected static final String NOME_ESCOPO = "form";

    /**
     * M�todo respons�vel pela execu��o da action.
     * 
     * @param mapping mapeamento do struts.
     * @param form formul�rio com os dados do usu�rio.
     * @param request requisi��o do usu�rio.
     * @param response resposta do servidor.
     */
    @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form, 
        HttpServletRequest request, HttpServletResponse response) throws Exception {
        String endereco = request.getRequestURI();

        int posicaoBarra = endereco.lastIndexOf("/") + 1;
        int posicaoPonto = endereco.lastIndexOf(".");
        String metodo  = null;

        if (posicaoPonto != -1) {
            metodo = endereco.substring(posicaoBarra, posicaoPonto);
        } else {
            metodo = endereco.substring(posicaoBarra);
        }

        try {
            Method method = getClass().getMethod(metodo, new Class[]{ActionMapping.class, 
                ActionForm.class, HttpServletRequest.class, HttpServletResponse.class} );

            //Chamada antes da execu��o da action.
            doPre(mapping, form, request, response);

            ActionForward destino = (ActionForward) method.invoke(this, 
                    new Object[]{mapping, form, request, response});

            //Chamado ap�s a execu��o da action
            doPos(mapping, form, request, response);

            return destino;
        } catch (InvocationTargetException eI) {
            getServlet().log(eI.getMessage());
            if (eI.getTargetException() instanceof Exception) {
                throw (Exception) eI.getTargetException();
            }
            throw new ServletException(eI.getTargetException());
        } catch (Exception e) {
            getServlet().log(e.getMessage());
            throw e;
        }
    }

    /**
     * M�todo chamado antes da execu��o da action.
     * 
     * @param mapping mapeamento do struts.
     * @param form formul�rio com os dados do usu�rio.
     * @param request requisi��o do usu�rio.
     * @param response resposta do servidor.
     */
    protected void doPre(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
        HttpServletResponse response) throws Exception {
    }

    /**
     * M�todo chamado ap�s da execu��o da action.
     * 
     * @param mapping mapeamento do struts.
     * @param form formul�rio com os dados do usu�rio.
     * @param request requisi��o do usu�rio.
     * @param response resposta do servidor.
     */
    protected void doPos(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
        HttpServletResponse response) throws Exception {
        request.setAttribute(NOME_ESCOPO, form);
    }

    /**
     * Salva uma mensagem de sucesso.
     * 
     * @param msg mensagem a ser salva.
     * @param request requisi��o do usu�rio.
     */
    protected void salvarMsgSucesso(String msg, HttpServletRequest request){
        ActionMessage message = new ActionMessage(msg);
        ActionMessages messages = new ActionMessages();

        messages.add(ActionMessages.GLOBAL_MESSAGE, message);
        saveMessages(request, messages);
    }

    /**
     * Salva uma mensagem de erro.
     * 
     * @param msg mensagem a ser salva.
     * @param request requisi��o do usu�rio.
     */
    protected void salvarMsgErro(String msg, HttpServletRequest request){
        ActionMessage message = new ActionMessage(msg);
        ActionErrors errors = new ActionErrors();

        errors.add(ActionErrors.GLOBAL_MESSAGE, message);
        saveErrors(request, errors);
    }

    /**
     * Salva uma mensagem de erro.
     * 
     * @param msg mensagem a ser salva.
     * @param request requisi��o do usu�rio.
     */
    protected void salvarMsgErro(String key, String msg, HttpServletRequest request){
    	ActionMessage message = new ActionMessage(key, msg);
    	ActionErrors errors = new ActionErrors();
    	
    	errors.add(key, message);
    	saveErrors(request, errors);
    }

    /**
     * Atribui o valor a sess�o de autentica��o.
     * 
     * @param request requisi��o do usu�rio.
     * @param sessao sess�o de autentica��o.
     */
    protected final void setSessaoEjb(HttpServletRequest request, Sessao sessao){
        request.getSession().setAttribute(SESSAO_EJB, sessao);
    }

    /**
     * Obt�m a sess�o de autentica��o do usu�rio.
     * 
     * @param request requisi��o do usu�rio.
     */
    protected final Sessao getSessaoEjb(HttpServletRequest request){
        return (Sessao) request.getSession().getAttribute(SESSAO_EJB);
    }
}
