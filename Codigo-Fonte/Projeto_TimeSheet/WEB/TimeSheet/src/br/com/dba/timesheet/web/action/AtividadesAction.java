package br.com.dba.timesheet.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.dominios.ListaDominios;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.util.UtilDate;
import br.com.dba.timesheet.web.form.AtividadesForm;


public class AtividadesAction extends TimeSheetComum {
	
    private static final String ACAO_ALTERAR = "alterar";
    private static final String ACAO_DETALHAR = "detalhar";

    public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
	    try {
    		AtividadesForm formulario = (AtividadesForm) form;
    		 
            String data1 = UtilDate.getDataComoString(UtilDate.getCalendarPrimeiroDoMesAtual().getTime());
                		
            String data2 = UtilDate.getDataComoString(UtilDate.getDataNoUltimoDiaDoMes(UtilDate.getDataAtual()));
    		
//            List<TimeSheet> listaTimeSheet = getTimeSheetDelegate().listarTodosTimeSheet();    		
//            List<TimeSheet> listaTimeSheet = getTimeSheetDelegate().consultarTimeSheetPorDataHoraInicio(UtilDate.getHoraZero(new Date()));    		
    		
    		
    		try {
    		    List<TimeSheetVO> listaTimeSheet = getTimeSheetDelegate().getListaTimeSheetVO(UtilDate.getDataComHoraZero(data1),
    		            UtilDate.getDataComHoraZero(data2));
     		
    		    formulario.setListaTimeSheetVO(listaTimeSheet);
    		
    		} catch (Exception e) {    		   
    		    e.printStackTrace();
    		}

    		
    		
		} catch (ErroInternoException e) {
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
	    
	    try {
    	    AtividadesForm formulario = (AtividadesForm) form;
    	    
    	    TimeSheet timeSheet = preencherTimeSheet(formulario);    	    
    	    salvarTimeSheet(timeSheet);
    	    
    	    HistoricoTimeSheet historicoTimeSheet = preencherHistoricoTimeSheet(timeSheet, "S");            
            salvarHistoricoTimeSheet(historicoTimeSheet);
            
            
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
        
        
	    return mapping.findForward("retorno");        
	}
	
	 
    
    /**
     * Salva o objeto Projeto no banco. 
     * 
     * @param formulario
     * @param metodologia
     * @return
     * @throws ParametroInvalidoException
     */
    public Projeto salvarProjeto(AtividadesForm formulario,
            Metodologia metodologia) throws ParametroInvalidoException {
       
        Projeto projeto = new Projeto();       
        projeto.setMetodologia(metodologia);
        projeto.setNome(formulario.getNomeProjeto());
        projeto.setNumeroProjeto(Integer.valueOf(formulario.getNumeroProjeto()));
        
        return getTimeSheetDelegate().salvarProjeto(projeto);
    }

    /**
     * Método responsavel em excluir uma atividade.
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     */
	public ActionForward excluir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
		return mapping.findForward("retorno");        
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    try {
            AtividadesForm formulario = (AtividadesForm) form;
            
            TimeSheet timesheet = getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet()));

            preencherFormularioInicial(formulario);
            
            if(timesheet != null){
                preencherFormulario(formulario, timesheet);
            }
            
            formulario.setAcao(ACAO_ALTERAR);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		return mapping.findForward("retorno");        
	}
	
	/**
	 * Efetua no Banco de dados a alteracao da Atividade(TimeSheet).
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward retornoAlterar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) {
	
	    AtividadesForm formulario = (AtividadesForm) form;
        
        try {
            TimeSheet timeSheet = preencherTimeSheet(formulario);
            alterarTimeSheet(timeSheet);
        
            HistoricoTimeSheet historicoTimeSheet = preencherHistoricoTimeSheet(timeSheet, "A");            
            salvarHistoricoTimeSheet(historicoTimeSheet);
	    
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    return mapping.findForward("retorno");        
	}

	/**
	 * Metodo responsavel em detalhar uma atividade
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
    public ActionForward detalhar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	    try {

	        AtividadesForm formulario = (AtividadesForm) form;
            
            TimeSheet timesheet = getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet()));
            
            preencherFormularioInicial(formulario);
            preencherFormulario(formulario, timesheet);
            
            formulario.setAcao(ACAO_DETALHAR);
            formulario.setDesabilitarCampo(true);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
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
        
        AtividadesForm formulario = (AtividadesForm)form;
       
        try {
            
            Date data2 = UtilDate.getData(formulario.getDataParaPesquisa());
            
            List<TimeSheet> lista = getTimeSheetDelegate()
                    .consultarTimeSheetPorDataHoraInicio(
                            UtilDate.getDataComHoraZero(formulario.getDataParaPesquisa()), 
                            UtilDate.getDateComHoraFinal(data2));
            
            formulario.setListaTimeSheet(lista);
            
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
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
            
            formulario.setListaAtividades(getListarTodasAtividades()) ;
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
            
            formulario.limparFormulario();
            
            //Lista para as combos.
            preencherFormularioInicial(formulario);
            preencherFormulario(formulario, null);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       return mapping.findForward("retorno");      
    }


    public ActionForward retornoCadastrarAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");      
    }

    //*********************************************
    //* METODOS AUXILIARES :
    //*********************************************
    public void preencherFormulario(AtividadesForm formulario, TimeSheet timesheet){
         
        if(timesheet !=null){
            formulario.setId(timesheet.getId());
            formulario.setData(UtilDate.getDataComoString(timesheet.getDataHoraInicio()));
            formulario.setDataHoraInicio(UtilDate.getHoraComoString(timesheet.getDataHoraInicio()));
            formulario.setDataHoraFim(UtilDate.getHoraComoString(timesheet.getDataHoraInicio()));
            formulario.setCodigoOp(Integer.toString(timesheet.getOp().getId()));
            formulario.setCodigoMetodologia(Integer.toString(timesheet.getMetodologia().getId()));
            formulario.setNomeProjeto(timesheet.getProjeto().getNome());
            formulario.setNumeroProjeto(Integer.toString(timesheet.getProjeto().getNumeroProjeto()));
            formulario.setCodigoCliente(Integer.toString(timesheet.getCliente().getId()));
            formulario.setCodigoAtividade(Integer.toString(timesheet.getAtividade().getId()));
            formulario.setCodigoProdutoServico(Integer.toString(timesheet.getProdutoServico().getId()));
            formulario.setObservacao(timesheet.getObservacao());
            formulario.setOutros(timesheet.getOutrasAtividades());
        }
        formulario.setDesabilitarCampo(false);
    }

    public void preencherFormularioInicial(AtividadesForm formulario)  throws IOException {
        formulario.setListaAtividades(getListarTodasAtividades()) ;        
        formulario.setListaClientes(getListarTodosClientes());
        formulario.setListaOPs(getListarTodasOPs());
        formulario.setListaMetodologias(getListarTodasMetodologias());
        formulario.setListaProdutosServicos(getListarTodosProdutosServicos());
    }
    
    /**
     * Cria e preenche o objeto TimeSheet com os dados da tela. 
     * 
     * @param formulario
     * @param metodologia
     * @return
     * @throws ParametroInvalidoException
     */
    public TimeSheet preencherTimeSheet(AtividadesForm formulario)
            throws ParametroInvalidoException {
        
        TimeSheet pojo = new TimeSheet();

        try {            
            
            if(formulario.getAcao().equals(ACAO_ALTERAR)){
                pojo.setId(formulario.getId());
            }
            
            //COMBOS
            pojo.setAtividade(getAtividadePeloID(Integer.valueOf(formulario.getCodigoAtividade())));
            pojo.setCliente(getClientePeloID(Integer.valueOf(formulario.getCodigoCliente())));
            
            Metodologia metodologia = getMetodologiaPeloID(Integer.valueOf(formulario.getCodigoMetodologia()));
            pojo.setMetodologia(metodologia);
            
            pojo.setOp(getOPPeloID(Integer.valueOf(formulario.getCodigoOp())));
            pojo.setProdutoServico(getProdutoServicoPeloID(Integer.valueOf(formulario.getCodigoProdutoServico())));
    
            // TODO RECUPERANDO O USUARIO FABIO....ARRUMAR
            pojo.setFuncionario(getFuncionarioPeloID(3));
                        
            Projeto projetoSalvo = salvarProjeto(formulario, metodologia);            
            pojo.setProjeto(projetoSalvo);
            
            //TEXTOS
            pojo.setDataHoraInicio(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraInicio() + ":00"));
            pojo.setDataHoraFim(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraInicio() + ":00"));
            pojo.setObservacao(formulario.getObservacao());
            pojo.setOutrasAtividades(formulario.getOutros());
            
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return pojo;
    }

    /**
     * Cria e preenche o objeto HistoricoTimeSheet com os dados da tela. 
     * 
     * @param timeSheet
     * @param metodologia
     * @return
     * @throws ParametroInvalidoException
     */
    public HistoricoTimeSheet preencherHistoricoTimeSheet(TimeSheet timeSheet, String tipoOperacao)throws ParametroInvalidoException {
        
        HistoricoTimeSheet pojo = new HistoricoTimeSheet();
        
        //COMBOS
        pojo.setAtividade(timeSheet.getAtividade());
        pojo.setCliente(timeSheet.getCliente());
        pojo.setMetodologia(timeSheet.getMetodologia());
        pojo.setOp(timeSheet.getOp());
        pojo.setProdutoServico(timeSheet.getProdutoServico());
        pojo.setFuncionario(timeSheet.getFuncionario());        
        pojo.setProjeto(timeSheet.getProjeto());
        pojo.setTimeSheet(timeSheet);
        
        //TEXTOS
        pojo.setDataHoraInicio(timeSheet.getDataHoraInicio());
        pojo.setDataHoraFim(timeSheet.getDataHoraFim());
        pojo.setDataOperacao(new Date());
        pojo.setObservacao(timeSheet.getObservacao());
        pojo.setTipoOperacao(tipoOperacao);
        
        return pojo;
    }

    
    
}
