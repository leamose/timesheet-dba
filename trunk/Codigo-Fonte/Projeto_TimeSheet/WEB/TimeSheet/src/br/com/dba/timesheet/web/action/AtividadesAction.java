package br.com.dba.timesheet.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;
import br.com.dba.timesheet.web.form.AtividadesForm;

public class AtividadesAction extends BaseDispatchAction {
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		AtividadesForm formulario = (AtividadesForm) form;

		montaListaTipoAtividades(formulario);
		
		return mapping.findForward("cadastro");		
	}

	public AtividadeVO criaTipo_AtividadeVO() {
		
		AtividadeVO atividadeVO = new AtividadeVO();
		
		atividadeVO.setAlteracao_data_avaliacao();
		atividadeVO.setAtividade_original_id();
		atividadeVO.setCliente_id();
		atividadeVO.setData_hora_fim();
		atividadeVO.setData_hora_inicio();
		atividadeVO.setFuncionario_id();
		atividadeVO.setMetodologia_id();
		atividadeVO.setObservacao();
		atividadeVO.setOp_id();
		atividadeVO.setProduto_servico_id();
		atividadeVO.setTipo_atividade_id();
		
		
		return tipo_AtividadeVO;
	}
	
	public ActionForward cadastarAtividade(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		AtividadesForm formulario = (AtividadesForm) form;
		
		montaListaTipoAtividades(formulario);		
		
		return mapping.findForward("retornoCadastro");		
	}

	public void montaListaTipoAtividades(AtividadesForm formulario) {
		List<Tipo_AtividadeVO> lista = new ArrayList<Tipo_AtividadeVO>();
		
		lista.add(criaTipo_AtividadeVO("Elaboração de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Validação de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Ajuste de artefato proveniente da qualidade"));
		lista.add(criaTipo_AtividadeVO("Correção de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Atividade de item não mensurável"));
		lista.add(criaTipo_AtividadeVO("Outras atividades"));

		
		formulario.setListaTipoAtividades(lista);
	}

	public void montaListaAtividades(AtividadesForm formulario) {
		List<AtividadeVO> lista = new ArrayList<AtividadeVO>();
		
		lista.add(criaTipo_AtividadeVO("Elaboração de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Validação de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Ajuste de artefato proveniente da qualidade"));
		lista.add(criaTipo_AtividadeVO("Correção de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Atividade de item não mensurável"));
		lista.add(criaTipo_AtividadeVO("Outras atividades"));
		
		
		formulario.setListaTipoAtividades(lista);
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
