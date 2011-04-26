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
import br.com.dba.timesheet.exceptions.SessaoIndisponivelException;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.web.form.LoginForm;

public class LoginAction extends TimeSheetComum {
	
    /**
     * Método responsável pela autenticação do usuário.
     * 
     * @param mapping mapeamento do struts.
     * @param form formulário com os dados do usuário.
     * @param request requisição do usuário.
     * @param response resposta do servidor.
     */
    public ActionForward inicio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        return mapping.findForward("pagina.login");
    }
    
    
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		Sessao sessao = (Sessao) request.getSession().getAttribute("sessao");
		
		sessao.setIndicaAtiva("N");
		
		request.getSession().setAttribute("sessao", sessao);
		request.getSession(false);		
		
		return mapping.findForward("retorno");		
	}

	public ActionForward erroAcesso(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		return mapping.findForward("pagina.de.erro.acesso");		
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {

		LoginForm formulario = (LoginForm) form;
		String retorno = "retorno";
		try {
			Sessao sessao = getSegurancaDelegate().autenticarUsuario(formulario.getLogin(), formulario.getSenha());
			
			if(getSegurancaDelegate().isSessaoValida(sessao)){
				request.setAttribute("codigoUsuarioLogado", sessao.getUsuario().getId());
				formulario.setCodigoUsuario(sessao.getUsuario().getId());
				request.getSession().setAttribute("sessao", sessao);
			}else{
				throw new SessaoIndisponivelException("MSG015");
			}	
			
			if(sessao.getUsuario().getIndicaAlterarSenha()){
				retorno = "alterarSenha";				
			}
			
		} catch (IdentificadorSenhaIncorretosException e) {			
	        salvarMsgErro("MSG024", request);
	        retorno = "pagina.de.erro.acesso";
		} catch (ErroInternoException e) {
			retorno = "pagina.de.erro.acesso";
		} catch (ParametroInvalidoException e) {
			salvarMsgErro("MSG024", request);
			retorno = "pagina.de.erro.acesso";
		} catch (LogonBloqueadoException e) {
			salvarMsgErro("MSG011", request);
			retorno = "pagina.de.erro.acesso";
		} catch (SessaoIndisponivelException e) {
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
		}
		return mapping.findForward(retorno);
	}
	
}
