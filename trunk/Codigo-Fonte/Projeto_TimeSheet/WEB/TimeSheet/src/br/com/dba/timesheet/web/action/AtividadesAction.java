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

		List<AtividadeVO> listaAtividades = montaListaAtividades(formulario);
		
		
		request.setAttribute("listaAtividades", listaAtividades);
		
		return mapping.findForward("cadastro");		
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retornoSalvar");        
    }

    public ActionForward voltar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("voltar");       
    }
    
    public ActionForward cadastrarAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        AtividadesForm formulario = (AtividadesForm) form;
        
        montaListaTipoAtividades(formulario);       
        
        return mapping.findForward("retornoCadastro");      
    }

	public AtividadeVO criaAtividadeVO() {
		
		AtividadeVO atividadeVO = new AtividadeVO();
		
		atividadeVO.setData("Seg 23/2/2011");
		atividadeVO.setDescricaoAtividade("Elaboracao e programacao do projeto Timesheet");
		atividadeVO.setInicioPrevisto("08:00");
		atividadeVO.setTerminoPrevisto("18:00");
		atividadeVO.setHorasDiarias("8");
		atividadeVO.setSaldoDiario("8");
		atividadeVO.setDescricaoOp("DCX003458 - Cliente");
		atividadeVO.setDescricaoMetodologia("MP");
		atividadeVO.setNumeroProjeto("123");
		atividadeVO.setProdutoServico("3");
		atividadeVO.setOutros("Teste");
		atividadeVO.setObservacoes("Teste Observacao");
		return atividadeVO;
	}

	public List<Tipo_AtividadeVO> montaListaTipoAtividades(AtividadesForm formulario) {
		List<Tipo_AtividadeVO> lista = new ArrayList<Tipo_AtividadeVO>();
		
		lista.add(criaTipo_AtividadeVO("Elaboração de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Validação de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Ajuste de artefato proveniente da qualidade"));
		lista.add(criaTipo_AtividadeVO("Correção de artefato de metodologia"));
		lista.add(criaTipo_AtividadeVO("Atividade de item não mensurável"));
		lista.add(criaTipo_AtividadeVO("Outras atividades"));

		
		formulario.setListaTipoAtividades(lista);
		return lista;
	}

	public Tipo_AtividadeVO criaTipo_AtividadeVO(String descricao) {        
        Tipo_AtividadeVO tipo_AtividadeVO = new Tipo_AtividadeVO();
        tipo_AtividadeVO.setDescricao(descricao);
        
        return tipo_AtividadeVO;
    }

    public List<AtividadeVO> montaListaAtividades(AtividadesForm formulario) {
		List<AtividadeVO> lista = new ArrayList<AtividadeVO>();
		
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		lista.add(criaAtividadeVO());
		
		
		formulario.setListaAtividades(lista);
		return lista;
	}
	
}
