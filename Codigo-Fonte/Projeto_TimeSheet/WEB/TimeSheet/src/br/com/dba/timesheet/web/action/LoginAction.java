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
	        HttpServletRequest request, HttpServletResponse response) throws Exception {

		String retorno = "";
		
		try {
			LoginForm formulario = (LoginForm) form;
			
			Usuario usuario = new Usuario();	
			
			if("".equals(formulario.getLogin())){
				salvarMsgErro("MSG016", request);
				return mapping.findForward("erroLogin");
			}
			
			usuario.setLogin(formulario.getLogin());
			
			//Recupera o Usuario Logado.
			Usuario usuarioLogado = getUsuario(usuario);
			
		    if(usuarioLogado!=null){
				formulario.setCodigoUsuario(usuarioLogado.getId());				
				retorno = autenticarUsuario(retorno, formulario, usuarioLogado, request);
				request.setAttribute("codigoUsuarioLogado", usuarioLogado.getId());
			}
		    
			if("".equals(retorno)){
				formulario.limparFormulario();				
				salvarMsgErro("MSG016", request);
				retorno = "erroLogin";
			}
			
		} catch (ParametroInvalidoException e) {
			throw new Exception(e.getMessage(), e);
		}
		
		request.getSession();
		
	    return mapping.findForward(retorno);		
	}

	/**
	 *	Método responsavel em autenticar o usuario.
	 * @param request 
	 * @param mapping 
	 */
	private String autenticarUsuario(String retorno, LoginForm formulario,
		Usuario usuarioLogado, HttpServletRequest request) {
			
		//verifica se é a primeira vez que o usuario loga no sistema ou se esta bloqueado. 
		if(usuarioLogado.getIndicaAlterarSenha() == null || usuarioLogado.getIndicaAlterarSenha()){
			formulario.setIndicaAlterarSenha(usuarioLogado.getIndicaAlterarSenha());
			retorno = "alterarSenha"; 
		}
		if(usuarioLogado.getIndicaBloqueado()){
			 formulario.setIndicaBloqueado(usuarioLogado.getIndicaBloqueado());
			 salvarMsgErro("MSG016", request);
			 retorno = "usuarioBloqueado";
		}
			
		if(usuarioLogado.getSenha()!=null && !"".equals(usuarioLogado.getSenha())){
			if(usuarioLogado.getSenha().equals(formulario.getSenha())){
				retorno = "retorno";
			}else{
				salvarMsgErro("usuario.sem.acesso", request);
			}
		}
		return retorno;
	}	
}
