package br.com.dba.timesheet.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.web.form.FuncionarioForm;

public class FuncionarioAction extends BaseDispatchAction {
	
	public ActionForward cadastrarFuncionario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    FuncionarioForm formulario = (FuncionarioForm) form;
	    

	    
		return mapping.findForward("retorno");		
	}	
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");		
	}

	public ActionForward retornoConsultar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    return mapping.findForward("retorno");		
	}

	public ActionForward consultar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    
	    
	    FuncionarioForm formulario = (FuncionarioForm) form;
	    return mapping.findForward("retorno");		
	}
	
}
