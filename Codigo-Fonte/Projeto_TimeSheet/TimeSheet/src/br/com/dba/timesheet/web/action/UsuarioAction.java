package br.com.dba.timesheet.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.struts.BaseDispatchAction;

public class UsuarioAction extends BaseDispatchAction {
	
	public ActionForward logar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("cadastrarAtividade");		
	}
	
}
