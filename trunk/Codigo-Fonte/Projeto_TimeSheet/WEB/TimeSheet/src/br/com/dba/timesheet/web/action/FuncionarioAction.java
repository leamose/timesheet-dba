package br.com.dba.timesheet.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.struts.BaseDispatchAction;

public class FuncionarioAction extends BaseDispatchAction {
	
	public ActionForward cadastarFuncionario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("cadastro");		
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");		
	}
	
	public ActionForward abrePopUpCadastrarFuncionario(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
	    
	    

	    return mapping.findForward("retorno");       
    }
	
}
