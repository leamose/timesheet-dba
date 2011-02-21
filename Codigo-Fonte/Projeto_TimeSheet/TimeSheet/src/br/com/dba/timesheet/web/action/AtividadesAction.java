package br.com.dba.timesheet.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.ejb.TimesheetDelegate;
import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;
import br.gov.mj.core.exception.ParametroInvalidoException;
import br.gov.mj.core.servico.exception.ErroInternoException;

public class AtividadesAction extends BaseDispatchAction {
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			List<Tipo_AtividadeVO> listaAtividades = TimesheetDelegate.getInstancia().listarTodosTipoAtividades();
			
			listaAtividades.isEmpty();
			
		} catch (ErroInternoException e) {		
			e.printStackTrace();
		} catch (ParametroInvalidoException e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("cadastro");		
	}
	
	public ActionForward cadastarAtividade(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retornoCadastro");		
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retornoSalvar");		
	}

	public ActionForward voltar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("voltar");		
	}
	
}
