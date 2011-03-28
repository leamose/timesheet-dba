package br.com.dba.timesheet.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.util.Constantes;
import br.com.dba.timesheet.util.UtilDate;
import br.com.dba.timesheet.web.form.AtividadesForm;


public class AtividadesAction extends TimeSheetComum {

	/**
	 * Método responsavel em recuperar as atividades(TimeSheet's) e se o usuario logado for chefe, 
	 * retorna a lista de funcionarios subordinado.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	    try {
    		AtividadesForm formulario = (AtividadesForm) form;
    		List<Funcionario> listaFuncionariosSubordinados = null;
    		List<HorasAtividadeVO> listaHorasAtividadeVOs = null;
    		List<TimeSheetVO> listaTimeSheet = null;
    		boolean indicaChefe = false;
    		Integer codigoUsuario = null;
    		
    		//Recupera da requisicao ou do formulario o codigo do usuario logado.
    		if(request.getAttribute("codigoUsuarioLogado")!=null){
    			codigoUsuario = (Integer)request.getAttribute("codigoUsuarioLogado");
    		}else {
    			codigoUsuario = Integer.valueOf(formulario.getCodigoUsuarioLogado());
    		}

    		Usuario usuarioLogado = getUsuarioPeloID(codigoUsuario);
    		
    		if(usuarioLogado!=null){
    			if(usuarioLogado.getFuncionario()!=null && usuarioLogado.getFuncionario().getIndicaChefe()){
	    			indicaChefe = usuarioLogado.getFuncionario().getIndicaChefe();
	    			
					listaFuncionariosSubordinados = consultaFuncionariosPeloCodigoFuncionarioChefe(usuarioLogado);
	    		}else{
	    			indicaChefe = false;
	    		}	    		
	    		
    			listaTimeSheet = getListaTimeSheetVO(usuarioLogado.getFuncionario());
    			
    			listaHorasAtividadeVOs = getListaHorasAtividadeVO(usuarioLogado.getFuncionario());

    			//Preenche formulario
    			formulario.setTamanhoListaHoras(listaHorasAtividadeVOs != null ? listaHorasAtividadeVOs.size():0);
	    		formulario.setCodigoUsuarioLogado(usuarioLogado.getId());
    			formulario.setUsuario(usuarioLogado);
    			formulario.setCodigoFuncionarioLogado(usuarioLogado.getFuncionario()!=null ? usuarioLogado.getFuncionario().getId():null);
	    		formulario.setIndicaChefe(indicaChefe);
	    		formulario.setMesLiteral(UtilDate.getMesLiteral());
    			formulario.setListaHorasAtividadeVOs(listaHorasAtividadeVOs);
    			formulario.setListaTimeSheetVO(listaTimeSheet);
	    		formulario.setListaFuncionariosSubordinados(listaFuncionariosSubordinados);
	    		formulario.setIndicaAvaliacao(false);
	    		
	    	}else{
    			salvarMsgErro("MSG017", request);
    			return mapping.findForward("erroLogin");
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

	/**
	 * Método responsavel em recuperar as atividades(TIMESHEETs) do funcionario subordinado. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward recuperarAtividades(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<TimeSheetVO> listaTimeSheet = null;
		List<HorasAtividadeVO> listaHorasAtividadeVOs = null;
		Funcionario subordinado = null;
		
		AtividadesForm formulario = (AtividadesForm) form;
		
		try {
    		
    		//CONSULTA Funcionario Subordinado.
    		subordinado = getFuncionarioPeloID(Integer.valueOf(formulario.getCodigoFuncionario()));
    		
    		if(subordinado!=null){
    			
    			listaTimeSheet = getListaTimeSheetVO(subordinado);
    			listaHorasAtividadeVOs = getListaHorasAtividadeVO(subordinado);
    			
    			//Descricao do Mes : Exemplo (Março, Abril....)
    			formulario.setMesLiteral(UtilDate.getMesLiteral());
    			formulario.setCodigoFuncionarioSubordinado(subordinado.getId());
    			formulario.setSubordinado(subordinado);	    			
    			formulario.setListaHorasAtividadeVOs(listaHorasAtividadeVOs);
    			formulario.setListaTimeSheetVO(listaTimeSheet);
    			formulario.setIndicaAvaliacao(true);
	    		
	    	}else{
    			salvarMsgErro("MSG017", request);
    			return mapping.findForward("erroLogin");
    		}

		} catch (ErroInternoException e) {
		    e.printStackTrace();
		}
		
		return mapping.findForward("retorno");        
	}

	public ActionForward salvar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		HistoricoTimeSheet historicoTimeSheet = null;
		TimeSheet timeSheet = null;
		
	    try {
    	    AtividadesForm formulario = (AtividadesForm) form;
    	    
    	    
    	    //TODO: Verificar se a Atividade(TimeSheet) ja foi fechado 
    	    // --- ERRO "Seu Timesheet de Março de 2010  já está fechado." 
    	    
    	    timeSheet = preencherTimeSheet(formulario);    	    
    	    salvarTimeSheet(timeSheet);
    	    
    	    historicoTimeSheet = preencherHistoricoTimeSheet(timeSheet, "I", formulario);            
            salvarHistoricoTimeSheet(historicoTimeSheet);
            
            //Submeter a pagina pai. 
            request.setAttribute("submiter", true);
            
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
	    
	    AtividadesForm formulario = (AtividadesForm) form;
	    
	    TimeSheet pojo;
	    
        try {
            pojo = getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet()));	    
            removerTimeSheet(pojo);
            
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
		return mapping.findForward("retorno");        
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TimeSheet timesheet = null;
		
	    try {
            AtividadesForm formulario = (AtividadesForm) form;
            
            timesheet = getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet()));
            
            if(timesheet != null){
            	formulario.setListaProdutosServicos(recuperarListaProdutoServico(timesheet.getMetodologia().getId())); 
            	
            	preencherFormularioInicial(formulario);
                preencherFormulario(formulario, timesheet);
            }
            
            formulario.setAcao(Constantes.ACAO_ALTERAR);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParametroInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		return mapping.findForward("retorno");        
	}
	

	public ActionForward popularComboProdutoServico(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			AtividadesForm formulario = (AtividadesForm) form;
			
			preencherFormularioInicial(formulario);
			
			formulario.setListaProdutosServicos(recuperarListaProdutoServico(Integer.valueOf(formulario.getCodigoMetodologia())));
			
		} catch (ParametroInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
	    TimeSheet timeSheet = null;
	    HistoricoTimeSheet historicoTimeSheet = null;
        try {
            timeSheet = preencherTimeSheet(formulario);
            alterarTimeSheet(timeSheet);
        
            historicoTimeSheet = preencherHistoricoTimeSheet(timeSheet, "A", formulario);            
            salvarHistoricoTimeSheet(historicoTimeSheet);
            
            //Submeter a pagina pai. 
            request.setAttribute("submiter", true);
	    
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
            
            preencherFormularioInicial(formulario);
            preencherFormulario(formulario, getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet())));
            
            formulario.setAcao(Constantes.ACAO_DETALHAR);
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
            
            List<TimeSheetVO> lista = getTimeSheetDelegate()
                    .getListaTimeSheetVOPeloMesAno(formulario.getMesConsulta(), formulario.getAnoConsulta(), formulario.getCodigoFuncionarioLogado());
            
            formulario.setListaTimeSheetVO(lista);
            
            
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
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
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
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
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
    
    public ActionForward inicioAvaliacao(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	    
    	AtividadesForm formulario = (AtividadesForm) form;
	    
	    formulario.setListaSituacaoAtividade(getListarTodasSituacaoAtividade());
	    formulario.setId(Integer.valueOf(formulario.getCodigoTimeSheet()));	    
	    
	    try {
            TimeSheet timesheet = getTimeSheetPeloID(formulario.getId());
	    
            preencherFormularioInicial(formulario);
            preencherFormulario(formulario, timesheet);
            
            formulario.setData(UtilDate.getDataComoString(timesheet.getDataHoraInicio()));
	    } catch (Exception e) {
	    	throw new Exception(e.getMessage(), e);
	    }
	    
	    
	    
		return mapping.findForward("retorno");		
	}

	public ActionForward salvarAvaliacao(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
	    try {
	    	AtividadesForm formulario = (AtividadesForm) form;
    	    
    //	    formulario.setListaSituacaoAtividade(getListarTodasSituacaoAtividade());
    	    
    	    AvaliacaoAtividade avaliacaoAtividade = new AvaliacaoAtividade();
	    
    	    // TODO RECUPERANDO O USUARIO FABIO....ARRUMAR
    	    avaliacaoAtividade.setFuncionarioAvaliador(getFuncionarioPeloID(2));
    	    
    	    avaliacaoAtividade.setObservacao(formulario.getObservacao());
    	    avaliacaoAtividade.setObservacaoPrivada(formulario.getObservacaoPrivada());
    	    avaliacaoAtividade.setSituacaoAtividade(getSituacaoAtividadePeloID(Integer.valueOf(formulario.getCodigoSituacaoAtividade())));
    	    avaliacaoAtividade.setTimeSheet(getTimeSheetPeloID(formulario.getId()));
    	    
    	    try {
                getTimeSheetDelegate().salvarAvaliacaoAtividade(avaliacaoAtividade);
            } catch (Exception e) {
            	throw new Exception(e.getMessage(), e);
            }
            
            
            
//	    } catch (ParseException e) {
//	        // TODO Auto-generated catch block
//	        e.printStackTrace();
	    } 
	    catch (NumberFormatException e) {
	    	throw new Exception(e.getMessage(), e);
        } catch (ParametroInvalidoException e) {
        	throw new Exception(e.getMessage(), e);
        }
	    
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
            formulario.setDataHoraFim(UtilDate.getHoraComoString(timesheet.getDataHoraFim()));
            formulario.setCodigoOp(timesheet.getOp().getId());
            formulario.setCodigoMetodologia(timesheet.getMetodologia().getId());
            formulario.setNomeProjeto(timesheet.getProjeto().getNome());
            formulario.setNumeroProjeto(Integer.toString(timesheet.getProjeto().getNumeroProjeto()));
            formulario.setCodigoCliente(timesheet.getCliente().getId());
            formulario.setCodigoAtividade(timesheet.getAtividade().getId());
            formulario.setCodigoProdutoServico(timesheet.getProdutoServico().getId());
            formulario.setObservacao(timesheet.getObservacao());
            formulario.setOutros(timesheet.getOutrasAtividades());
        }
        formulario.setDesabilitarCampo(false);
    }

    public void preencherFormularioInicial(AtividadesForm formulario)  throws Exception {
        formulario.setListaAtividades(getListarTodasAtividades()) ;        
        formulario.setListaClientes(getListarTodosClientes());
        formulario.setListaOPs(getListarTodasOPs());
        formulario.setListaMetodologias(getListarTodasMetodologias());
        formulario.setListaSituacaoAtividade(getListarTodasSituacaoAtividade());
    }
    
    /**
     * Cria e preenche o objeto TimeSheet com os dados da tela. 
     * 
     * @param formulario
     * @param metodologia
     * @return
     * @throws Exception 
     * @throws NumberFormatException 
     */
    public TimeSheet preencherTimeSheet(AtividadesForm formulario)
            throws NumberFormatException, Exception {
        
        TimeSheet pojo = new TimeSheet();

        try {            
            
            if(formulario.getAcao().equals(Constantes.ACAO_ALTERAR)){
                pojo.setId(formulario.getId());
            }
            
            //COMBOS
            pojo.setAtividade(getAtividadePeloID(Integer.valueOf(formulario.getCodigoAtividade())));
            pojo.setCliente(getClientePeloID(Integer.valueOf(formulario.getCodigoCliente())));
            
            Metodologia metodologia = getMetodologiaPeloID(Integer.valueOf(formulario.getCodigoMetodologia()));
            pojo.setMetodologia(metodologia);
            
            pojo.setOp(getOPPeloID(Integer.valueOf(formulario.getCodigoOp())));
            pojo.setProdutoServico(getProdutoServicoPeloID(Integer.valueOf(formulario.getCodigoProdutoServico())));
    
           
            pojo.setFuncionario(getFuncionarioPeloID(formulario.getCodigoFuncionarioLogado()));
                        
            Projeto projetoSalvo = salvarProjeto(formulario, metodologia);            
            pojo.setProjeto(projetoSalvo);
            
            //TEXTOS
            pojo.setDataHoraInicio(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraInicio() + ":00"));
            pojo.setDataHoraFim(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraFim() + ":00"));
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
     * @param formulario 
     * @param metodologia
     * @return
     * @throws Exception 
     */
    public HistoricoTimeSheet preencherHistoricoTimeSheet(TimeSheet timeSheet, String tipoOperacao, AtividadesForm formulario)throws Exception {
        
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
        
        pojo.setUsuario(getUsuarioPeloID(formulario.getCodigoUsuarioLogado()));
        
        return pojo;
    }

    
    
}
