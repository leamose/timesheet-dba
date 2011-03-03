package br.com.dba.timesheet.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.vo.FuncionarioVO;
import br.com.dba.timesheet.web.form.FuncionarioForm;

public class FuncionarioAction extends BaseDispatchAction {
	
	public ActionForward cadastrarFuncionario(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    FuncionarioForm formulario = (FuncionarioForm) form;
	    
	    List<FuncionarioVO> listaFuncionarios = new ArrayList<FuncionarioVO>();
        
        formulario.setListaFuncionarios(listaFuncionarios);
	    
		return mapping.findForward("retorno");		
	}	
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");		
	}

	public ActionForward retornoConsultar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    return mapping.findForward("retorno");		
	}

	public ActionForward consultar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    
	    
	    FuncionarioForm formulario = (FuncionarioForm) form;
	    
	    
	    FuncionarioVO vo = new FuncionarioVO();	    
	    vo.setNome("Fabio Oliveira de Pinho");
	    vo.setCargo("Fabio Oliveira de Pinho");
	    vo.setChefe(false);
	    vo.setFerias(false);
	    vo.setHoraAlmocoInicio(8);
	    vo.setHoraAlmocoFim(18);
	    vo.setHoraTrabalhoFim(12);
	    vo.setHoraTrabalhoInicio(14);
	    
	    
	    List<FuncionarioVO> listaFuncionarios = new ArrayList<FuncionarioVO>();
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    listaFuncionarios.add(vo);
	    
	    request.setAttribute("listaFuncionarios", listaFuncionarios);
	    
	    return mapping.findForward("retorno");		
	}
	
}
