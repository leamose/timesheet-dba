package br.com.dba.timesheet.web.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.IdentificadorSenhaIncorretosException;
import br.com.dba.timesheet.exceptions.LogonBloqueadoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.SessaoIndisponivelException;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.web.filtros.ConstantesLogin;
import br.com.dba.timesheet.web.filtros.FiltroSessao;
import br.com.dba.timesheet.web.form.LoginForm;

public class LoginAction extends TimeSheetComum {
	
    /**
     * M�todo respons�vel pela autentica��o do usu�rio.
     * 
     * @param mapping mapeamento do struts.
     * @param form formul�rio com os dados do usu�rio.
     * @param request requisi��o do usu�rio.
     * @param response resposta do servidor.
     */
    public ActionForward inicio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        return mapping.findForward("pagina.login");
    }
    
    
	public ActionForward sair(ActionMapping mapping, ActionForm form,
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

	/**
     * M�todo respons�vel pela autentica��o do usu�rio.
     * 
     * @param mapping mapeamento do struts.
     * @param form formul�rio com os dados do usu�rio.
     * @param request requisi��o do usu�rio.
     * @param response resposta do servidor.
     */
    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
        String msgErro = (String)session.getAttribute(FiltroSessao.ERRO_LOGIN);
        if (msgErro != null && !msgErro.equals("")) {
            salvarMsgErro(msgErro, request);
            request.getSession().setAttribute(FiltroSessao.ERRO_LOGIN, "");
        }
        return mapping.findForward("pagina.login");
    }
	
	
	public ActionForward autenticar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {

		LoginForm formulario = (LoginForm) form;
		String retorno = "retorno";
		try {
			
			Sessao sessao = getSegurancaDelegate().autenticarUsuario(formulario.getLogin(), formulario.getSenha());
			
			if(getSegurancaDelegate().isSessaoValida(sessao)){
				request.setAttribute("codigoUsuarioLogado", sessao.getUsuario().getId());
				formulario.setCodigoUsuario(sessao.getUsuario().getId());				
				marcarAutenticacao(request, ConstantesLogin.AUTENTICACAO_OK);
				request.getSession().setAttribute(TimeSheetComum.SESSAO_EJB, sessao);
			}else{
				throw new SessaoIndisponivelException("MSG015");
			}	
			
			if(sessao.getUsuario().getIndicaAlterarSenha()){
				retorno = "alterarSenha";				
			}
			
		} catch (IdentificadorSenhaIncorretosException e) {		
			marcarAutenticacao(request, ConstantesLogin.AUTENTICACAO_NOT_OK);
	        salvarMsgErro("MSG024", request);
	        retorno = "pagina.de.erro.acesso";
		} catch (ErroInternoException e) {
			marcarAutenticacao(request, ConstantesLogin.AUTENTICACAO_NOT_OK);
			retorno = "pagina.de.erro.acesso";
		} catch (ParametroInvalidoException e) {
			marcarAutenticacao(request, ConstantesLogin.AUTENTICACAO_NOT_OK);
			salvarMsgErro("MSG024", request);
			retorno = "pagina.de.erro.acesso";
		} catch (LogonBloqueadoException e) {
			marcarAutenticacao(request, ConstantesLogin.AUTENTICACAO_NOT_OK);
			salvarMsgErro("MSG011", request);
			retorno = "pagina.de.erro.acesso";
		} catch (SessaoIndisponivelException e) {
			marcarAutenticacao(request, ConstantesLogin.AUTENTICACAO_NOT_OK);
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
		}
		return mapping.findForward(retorno);
	}
	
	/**
     * Atribui parametro na sess�o que indica se o us�rio est� ou n�o logado.
     * 
     * @param request requisi��o do usu�rio.
     * @param att atributo a ser colocado na sess�o.
     */
    private void marcarAutenticacao(HttpServletRequest request, String att)
    {
        request.getSession().setAttribute(ConstantesLogin.AUTENTICACAO, att);
    }
	
	
}
