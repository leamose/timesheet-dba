package br.com.dba.timesheet.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.pojo.Configuracao;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.TotalHorasMes;
import br.com.dba.timesheet.util.UtilDate;
import br.com.dba.timesheet.web.form.ConfigurarForm;


public class ConfigurarAction extends TimeSheetComum {
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ConfigurarForm formulario = (ConfigurarForm) form;
		String retorno = "cadastro";
		
		List<Configuracao> lista = new ArrayList<Configuracao>();
				
		//Seta a sessao.
		setSessao((Sessao) request.getSession().getAttribute("sessao"));    
		
		
		try {
			lista = getTimeSheetDelegate().listarTodosConfiguracao(getSessao());
			
			if(lista!= null){
				for (Configuracao configuracao : lista) {
					formulario.setHora_almoco_fim(configuracao.getHoraAlmocoFim());
					formulario.setHora_almoco_inicio(configuracao.getHoraAlmocoInicio());
					formulario.setHora_trabalho_inicio(configuracao.getHoraInicio());
					formulario.setHora_trabalho_fim(configuracao.getHoraFim());
					formulario.setCodigoConfiguracao(configuracao.getId());				
					formulario.setMininoAlmoco(configuracao.getMinimoAlmoco());				
					formulario.setTotalHorasMes(configuracao.getTotalHorasMes());				
				}
			}
			
			
		} catch (ParametroInvalidoException e) {
			salvarMsgErro("erro.parametro.invalido", request);
			e.printStackTrace();
		} catch (SessaoInvalidaException e) {
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
		}
		
		return mapping.findForward(retorno);		
	}
	
	public ActionForward operacaoCancelada(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");        
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    
		ConfigurarForm formulario = (ConfigurarForm) form;		
		String retorno = "retorno";
		
		try {
		
			salvarTotalHorasMes(formulario, Integer.toString(UtilDate.getAnoAtual()), formulario.getTotalHoras());
		
		} catch (ParametroInvalidoException e) {
			salvarMsgErro("erro.parametro.invalido", request);
			e.printStackTrace();
		} catch (SessaoInvalidaException e) {
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
		}
		
	    return mapping.findForward(retorno);        
	}

	private void salvaConfiguracao(ConfigurarForm formulario, TotalHorasMes totalHorasMes) throws ParametroInvalidoException, SessaoInvalidaException {
		Configuracao pojo = new Configuracao();
		pojo.setHoraAlmocoFim(formulario.getHora_almoco_fim());
		pojo.setHoraAlmocoInicio(formulario.getHora_almoco_inicio());
		pojo.setHoraFim(formulario.getHora_trabalho_fim());
		pojo.setHoraInicio(formulario.getHora_trabalho_inicio());
		pojo.setMinimoAlmoco(formulario.getMininoAlmoco());
		pojo.setTotalHorasMes(totalHorasMes);
		
		getTimeSheetDelegate().alterarConfiguracao(pojo, getSessao());
	}

	private TotalHorasMes salvarTotalHorasMes(ConfigurarForm formulario, String ano, String[] totalHoras) throws ParametroInvalidoException, SessaoInvalidaException{
		TotalHorasMes totalHorasMes = new TotalHorasMes();
		
		for (int i = 0; i < totalHoras.length; i++) {
			
			if(StringUtils.isNotEmpty(ano) && totalHoras[i] != null ){
				totalHorasMes.setId(ano + i);
				totalHorasMes.setTotalHorasMes(Integer.parseInt(totalHoras[i]));
				getTimeSheetDelegate().alterarTotalHorasMes(totalHorasMes, getSessao());
				
				salvaConfiguracao(formulario, totalHorasMes);
			}
		}	
		
		return totalHorasMes;
	}

	public ActionForward voltar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("voltar");       
    }
}
