package br.com.dba.timesheet.web.filtros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.web.action.TimeSheetComum;

public class FiltroSessao implements Filter {

	private static final String ACTION_EXCECOES = "br.com.dba.timesheet.web.login.excluidos";
    private static final String ACTION_LOGIN = "br.com.dba.timesheet.web.login";
    
    /**
     * Constante que define o nome da string de erro no login contida na sess�o.
     */
    public static final String ERRO_LOGIN = "br.com.dba.timesheet.web.login.msg";
    
	
    private List<String> excecoes;
    private String actionLogin;
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
     * M�todo chamado no momento que a inst�ncia do filtro � criada. Usado para obter os 
     * par�metros de configura��o.
     * 
     * @param config configura��o do filtro.
     */
    public void init(FilterConfig config) throws ServletException {
        String parametro = config.getInitParameter(ACTION_EXCECOES);
        excecoes = new ArrayList<String>();

        if (parametro != null && !parametro.equals("")) {
            StringTokenizer tokens = new StringTokenizer(parametro, ",");
            while (tokens.hasMoreTokens()) {
                excecoes.add(tokens.nextToken().trim());
            }
        }

        actionLogin = config.getInitParameter(ACTION_LOGIN);
    }
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest requisicao = (HttpServletRequest) request;
        HttpServletResponse resposta = (HttpServletResponse) response;
        requisicao.getContextPath();
        
        if (excecoes.contains(requisicao.getServletPath())) 
        {
            chain.doFilter(request, response);
            return;
        }
        if (verificarAutenticacao(requisicao)) 
        {
            chain.doFilter(request, response);
        } 
        else 
        {
            resposta.sendRedirect(requisicao.getContextPath() + actionLogin);
        }
		
		
	}
	
	/**
     * Verifica se o usu�rio est� autenticado na sess�o.
     * 
     * @param request requisi��o do usu�rio.
     * 
     * @return true caso esteja.
     */
    private boolean verificarAutenticacao(HttpServletRequest request){
        if (    request.getSession(false) == null ||
                request.getSession(false).isNew() ||
                request.getSession(false).getAttribute(ConstantesLogin.AUTENTICACAO) == null) // n�o tem sess�o
        {
            return false;
        }
        else // tem sess�o
        {
            Sessao sessaoEjb = (Sessao)request.getSession(false).getAttribute(TimeSheetComum.SESSAO_EJB);
            if (sessaoEjb != null && "N".equals(sessaoEjb.getIndicaAtiva())) // foi invalidada
            {
                request.getSession(false).invalidate();
                return false;
            }
        }
        if (request.getSession().getAttribute(ConstantesLogin.AUTENTICACAO).equals(ConstantesLogin.AUTENTICACAO_NOT_OK)) 
        {
            request.getSession().setAttribute(ERRO_LOGIN, "controleacesso.msg.erro.sessao.expirou");
            return false;
        }
        if (request.getSession().getAttribute(ConstantesLogin.AUTENTICACAO).equals(ConstantesLogin.AUTENTICACAO_OK)) 
        {
            return true;
        }

        return false;
    }
	

}
