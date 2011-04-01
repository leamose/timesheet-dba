package br.com.dba.timesheet.web.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.IdentificadorSenhaIncorretosException;
import br.com.dba.timesheet.exceptions.LogonBloqueadoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.web.form.LoginForm;

public class LoginAction extends TimeSheetComum {
	
	 /**
     * Constante que define o atributo na sessão que indica se o usuário está ou não logado.
     */
    public static final String AUTENTICACAO = "br.com.dba.timesheet.login.att";
 
    /**
     * Constante que define o atributo que especifica que o usuário está logado.
     */
    public static final String AUTENTICACAO_OK = "%autenticado%";

    /**
     * Constante que define o atributo que especifica que o usuário não está logado.
     */
    public static final String AUTENTICACAO_NOT_OK = "%nao_autenticado%";
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		Sessao sessao = (Sessao) request.getSession().getAttribute("sessao");
		
		sessao.setIndicaAtiva("N");
		
		request.getSession().setAttribute("sessao", sessao);
		request.getSession(false);		
		
		return mapping.findForward("retorno");		
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) throws Exception{

		LoginForm formulario = (LoginForm) form;
		String retorno = "";
		try {
			Sessao sessao = getSegurancaDelegate().autenticarUsuario(formulario.getLogin(), formulario.getSenha());
			
			if(getSegurancaDelegate().isSessaoValida(sessao)){
				request.setAttribute("codigoUsuarioLogado", sessao.getUsuario().getId());
				request.getSession().setAttribute("sessao", sessao);
				retorno = "retorno";
			}else{
				retorno = "erroLogin";
			}	
			
			if(sessao.getUsuario().getIndicaAlterarSenha()){
				retorno = "alterarSenha";				
			}
			
		} catch (IdentificadorSenhaIncorretosException e) {			
			throw new Exception(e.getMessage(), e);
		} catch (ErroInternoException e) {
			throw new Exception(e.getMessage(), e);
		} catch (ParametroInvalidoException e) {
			throw new Exception(e.getMessage(), e);
		} catch (LogonBloqueadoException e) {
			throw new Exception(e.getMessage(), e);
		}
		return mapping.findForward(retorno);
	}
		
}
