package br.com.dba.timesheet.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.web.form.LoginForm;

public class LoginAction extends TimeSheetComum {
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		return mapping.findForward("retorno");		
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {

		try {
			LoginForm formulario = (LoginForm) form;
			
			Usuario usuario = new Usuario();
			
			usuario.setLogin(formulario.getLogin());		
			
			constultarUsuario(usuario);
			
		} catch (ParametroInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return mapping.findForward("retorno");		
	}

	public void constultarUsuario(Usuario usuario)
			throws ParametroInvalidoException {
		getTimeSheetDelegate().consultarUsuario(usuario);
	}
	
}
