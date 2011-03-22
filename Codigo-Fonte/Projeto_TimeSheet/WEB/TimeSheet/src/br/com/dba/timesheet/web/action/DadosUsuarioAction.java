package br.com.dba.timesheet.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.util.UtilDate;
import br.com.dba.timesheet.web.form.DadosUsuarioForm;

public class DadosUsuarioAction extends TimeSheetComum {
	
	/**
	 * Efetua a alteracao de senha do usuario.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward alterarSenha(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String retorno = "retorno";
		
		try {
			DadosUsuarioForm formulario = (DadosUsuarioForm) form;
			
			Usuario usuario = getUsuarioPeloID(formulario.getCodigoUsuario());
			
			if(usuario!=null){
				usuario.setSenha(formulario.getSenha());
				usuario.setIndicaAlterarSenha(false);
				usuario.setDataUltimoLogin(UtilDate.getDataAtual());
				usuario.setIndicaBloqueado(false);
			}
			
			getTimeSheetDelegate().alterarUsuario(usuario);
			
		} catch (ParametroInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapping.findForward(retorno);		
	}
	
	/**
	 * Efetua a alteracao de senha do usuario.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward desbloquearUsuario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");		
	}
	
}
