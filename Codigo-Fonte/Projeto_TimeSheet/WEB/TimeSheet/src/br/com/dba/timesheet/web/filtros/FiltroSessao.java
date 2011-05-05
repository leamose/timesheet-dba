package br.com.dba.timesheet.web.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.com.dba.timesheet.pojo.Sessao;

public class FiltroSessao implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		Sessao sessao = (Sessao) req.getSession().getAttribute("sessao");
		
		String url = "";
		
		if(sessao==null){
			url = "/WebContent/jsp/erro/erroAcesso.jsp?mensagem=Sessão Expirada.&popUp=true";
			request.getRequestDispatcher(url).forward(req, response);
		}else{			
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
