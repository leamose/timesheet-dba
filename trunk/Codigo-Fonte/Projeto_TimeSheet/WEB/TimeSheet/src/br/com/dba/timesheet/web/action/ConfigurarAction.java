package br.com.dba.timesheet.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.struts.BaseDispatchAction;


public class ConfigurarAction extends BaseDispatchAction {
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("cadastro");		
	}
	
	public ActionForward operacaoCancelada(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");        
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    
	    return mapping.findForward("retorno");        
	}

	public ActionForward voltar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("voltar");       
    }
}
