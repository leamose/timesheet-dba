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
		
		String popUp = request.getParameter("popUp");
		
		if(popUp!= null && popUp.equals("true")){
			url = "/WebContent/erro/erroGeral.jsp?mensagem=Sessão Expirada.&popUp=true";
		}else{
			url = "/WebContent/erro/erroGeral.jsp?mensagem=Sessão Expirada.&popUp=false";
		}
		
		if(sessao==null){
			request.getRequestDispatcher(url).forward(req, response);
		}else{			
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
