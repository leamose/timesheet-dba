package br.com.dba.timesheet.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.dominios.ListaDominios;
import br.com.dba.timesheet.ejb.TimesheetDelegate;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.com.dba.timesheet.vo.TimeSheetVO;
import br.com.dba.timesheet.web.form.AtividadesForm;


public class AtividadesAction extends BaseDispatchAction {
	
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
	    try {
    		AtividadesForm formulario = (AtividadesForm) form;
    
                List<TimeSheetVO> listaTimeSheet = TimesheetDelegate.getInstancia().listarTodosTimeSheet();
    		
    //		List<AtividadeVO> listaAtividades = montaListaAtividades(formulario);
    		
    		formulario.setListaTimeSheet(listaTimeSheet);
    //		request.setAttribute("listaAtividades", listaAtividades);
		} catch (ErroInternoException e) {
		    e.printStackTrace();
		} catch (ParametroInvalidoException e) {
		    e.printStackTrace();
		}
		
		return mapping.findForward("cadastro");		
	}
	
	public ActionForward operacaoCancelada(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("retorno");        
	}
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    
	    AtividadesForm formulario = (AtividadesForm) form;
	    
	    TimeSheetVO vo = new TimeSheetVO();
	    
//	    vo.setd
	    
	    return mapping.findForward("retorno");        
	}

	public ActionForward excluir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
		return mapping.findForward("retorno");        
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    try {
            AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            
            formulario.setListaAtividades(listaDominios.getListaAtividades()) ;
            formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return mapping.findForward("retorno");        
	}

	public ActionForward retornoAlterar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    return mapping.findForward("retorno");        
	}

	
	public ActionForward detalhar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    try {

	        AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            
            formulario.setListaAtividades(listaDominios.getListaAtividades()) ;
            formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
            
        } catch (IOException e) {
            e.printStackTrace();
        }       
	    
		return mapping.findForward("retorno");        
	}

	public ActionForward retornoDetalhar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	    return mapping.findForward("retorno");        
	}

    public ActionForward voltar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("voltar");       
    }
    
    public ActionForward consultar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");       
    }
    
    public ActionForward aprovar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");       
    }
    
    public ActionForward reprovar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        try {

            AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            
            formulario.setListaAtividades(listaDominios.getListaAtividades()) ;
            formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
            
        } catch (IOException e) {
            e.printStackTrace();
        }       
        
        return mapping.findForward("retorno");       
    }

    public ActionForward retornoReprovar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");       
    }
    
    public ActionForward cadastrarAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        
        try {
            AtividadesForm formulario = (AtividadesForm) form;
            
            ListaDominios listaDominios = new ListaDominios();
            
            formulario.setListaAtividades(listaDominios.getListaAtividades()) ;
            formulario.setListaDiasDaSemana(listaDominios.getListaDiasDaSemana());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       return mapping.findForward("retorno");      
    }

    public ActionForward retornoCadastrarAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");      
    }

	public AtividadeVO criaAtividadeVO() {
		
		AtividadeVO atividadeVO = new AtividadeVO();
		
		atividadeVO.setData("Seg 23/2/2011");
		atividadeVO.setDescricaoAtividade("Ajuste de artefato proveniente da qualidade");
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
		atividadeVO.setUltimaAtividade("23/2/2011 - Fabio Pinho");
		
		return atividadeVO;
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
		
		
		
		
//		formulario.setListaAtividadesVO(lista);
		return lista;
	}
	
}
