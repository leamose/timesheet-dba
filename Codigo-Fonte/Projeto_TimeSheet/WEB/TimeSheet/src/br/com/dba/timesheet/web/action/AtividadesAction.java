package br.com.dba.timesheet.web.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.RegistroJaCadastradoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.Sessao;
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
    @SuppressWarnings("deprecation")
	public ActionForward inicio(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
    	AtividadesForm formulario = (AtividadesForm) form;
    	List<Funcionario> listaFuncionariosSubordinados = null;
    	boolean indicaChefe = false;
    	Integer codigoUsuario = null;
    	String retorno = "cadastro";
    	
	    try {

	    	//Seta a sessao.
    		setSessao((Sessao) request.getSession().getAttribute("sessao"));    		
    		
    		//Recupera da requisicao ou do formulario o codigo do usuario logado.
    		if(request.getAttribute("codigoUsuarioLogado")!=null){
    			codigoUsuario = (Integer)request.getAttribute("codigoUsuarioLogado");
    		}else {
    			codigoUsuario = Integer.valueOf(formulario.getCodigoUsuario());
    		}

    		populaTelaInicial(formulario, listaFuncionariosSubordinados,indicaChefe, request);
    		
		} catch (ErroInternoException e) {
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		} catch (ParametroInvalidoException e) {
			salvarMsgErro("erro.parametro.invalido", request);
			e.printStackTrace();
		} catch (SessaoInvalidaException e) {
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
		} catch (Exception e) {
			salvarMsgErro("errors.general2", request);
			e.printStackTrace();
		}
		
		atualizaSessao(request);
		
		return mapping.findForward(retorno);		
	}

    /**
     * Méto responsavel em configurar e popular o formulario para a tela inicial.
     * @param formulario
     * @param listaFuncionariosSubordinados
     * @param indicaChefe
     * @param request 
     * @throws ParametroInvalidoException
     * @throws SessaoInvalidaException
     */
	public void populaTelaInicial(AtividadesForm formulario, List<Funcionario> listaFuncionariosSubordinados, boolean indicaChefe, HttpServletRequest request)
			throws ParametroInvalidoException, SessaoInvalidaException {
		
		List<HorasAtividadeVO> listaHorasAtividadeVOs;		
		List<HorasAtividadeVO> totalHorasTrabalhadas = null;
			
		if(getSegurancaDelegate().isSessaoValida(getSessao())){
			Usuario usuarioLogado = getSessao().getUsuario();
			
			if(usuarioLogado.getFuncionario()!=null && usuarioLogado.getFuncionario().getIndicaChefe()){
				//verifica se o usuario logado é chefe.
				indicaChefe = usuarioLogado.getFuncionario().getIndicaChefe();
				
				//recupera uma lista de funcionarios colaboradores pelo codigo do usuario chefe.
				listaFuncionariosSubordinados = consultaFuncionariosPeloCodigoFuncionarioChefe(usuarioLogado);
			}	    		
			
			//recupera as horas trabalhadas.
			listaHorasAtividadeVOs = getListaHorasAtividadeVO(usuarioLogado.getFuncionario());
			
			//Preenche formulario
			formulario.setTamanhoListaHoras(listaHorasAtividadeVOs != null ? listaHorasAtividadeVOs.size():0);
			formulario.setListaHorasAtividadeVOs(listaHorasAtividadeVOs);
			formulario.setCodigoUsuario(usuarioLogado.getId());
			formulario.setUsuario(usuarioLogado);
			formulario.setCodigoFuncionarioLogado(usuarioLogado.getFuncionario()!=null ? usuarioLogado.getFuncionario().getId():null);
			formulario.setIndicaChefe(indicaChefe);
			formulario.setMesLiteral(UtilDate.getMesLiteral());
			
			formulario.setMesConsulta(Integer.toString(UtilDate.getMesAtual()));
			formulario.setAnoConsulta(Integer.toString(UtilDate.getAnoAtual()));

			//recupera as atividade do usuario logado.
			formulario.setListaTimeSheetVO(getListaTimeSheetVO(usuarioLogado.getFuncionario()));
			
			formulario.setListaFuncionariosSubordinados(listaFuncionariosSubordinados);
			
			//indica false, pois o mesmo nao pode se avaliar.
			formulario.setIndicaAvaliacao(false);
			
			if(usuarioLogado.getFuncionario() != null){
	    		totalHorasTrabalhadas = getTimeSheetDelegate().getTotalHorasTrabalhadas(UtilDate.getAnoAtual(), 
	    				UtilDate.getMesAtual(), usuarioLogado.getFuncionario().getId(), getSessao());
			}
			
			if(totalHorasTrabalhadas!=null && !totalHorasTrabalhadas.isEmpty()){
				request.setAttribute("totalCargaHoraria", "176");
				request.setAttribute("totalHorasTrabalhadas", totalHorasTrabalhadas.get(0).getHorasTrabalhadas());
				request.setAttribute("totalSaldoDiario", UtilDate.subtrairHoras("176:00", totalHorasTrabalhadas.get(0).getHorasTrabalhadas()));
			}
			
			
			
		}else{
			throw new SessaoInvalidaException();
		}
	}

	/**
	 * Responsavel em retornar a tela anterior.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
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
	@SuppressWarnings("deprecation")
	public ActionForward recuperarAtividades(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		List<TimeSheetVO> listaTimeSheet = null;
		List<HorasAtividadeVO> listaHorasAtividadeVOs = null;
		Funcionario subordinado = null;
		
		AtividadesForm formulario = (AtividadesForm) form;
		String retorno = "";
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
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		} catch (SessaoInvalidaException e) {
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
		} catch (Exception e) {
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		}
		
		return mapping.findForward(retorno);        
	}

	@SuppressWarnings("deprecation")
	public ActionForward salvar(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response) throws Exception{
	    
		HistoricoTimeSheet historicoTimeSheet = null;
		TimeSheet timeSheet = null;
		String retorno = "retorno";
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
			salvarMsgErro("MSG022", request);
			e.printStackTrace();
        }catch (ParametroInvalidoException e) {
        	salvarMsgErro("errors.custom", e.getMessage(), request);
        	e.printStackTrace();
        } catch (SessaoInvalidaException e) {
			salvarMsgErro(e.getMessage(), request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
		} catch (RegistroJaCadastradoException e) {
			salvarMsgErro("MSG023", request);
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
     * @throws SessaoInvalidaException 
     * @throws ParametroInvalidoException 
     * @throws ParametroInvalidoException
     * @throws Exception 
     */
    public Projeto salvarProjeto(AtividadesForm formulario,
            Metodologia metodologia) throws ParametroInvalidoException, SessaoInvalidaException {
    	
    	Projeto projetoSalvo = null;
	
        Projeto projeto = new Projeto();       
        projeto.setMetodologia(metodologia);
        projeto.setNome(formulario.getNomeProjeto());
        projeto.setNumeroProjeto(Integer.valueOf(formulario.getNumeroProjeto()));

		projetoSalvo = getTimeSheetDelegate().salvarProjeto(projeto, getSessao());
		
		return projetoSalvo;
    }

    /**
     * Método responsavel em excluir uma atividade.
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws SessaoInvalidaException 
     * @throws ParametroInvalidoException 
     */
	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
	    
	    AtividadesForm formulario = (AtividadesForm) form;
	    
	    TimeSheet pojo;
	    HistoricoTimeSheet historicoTimeSheet;
	    String retorno = "retorno";
        	
    	try {
			historicoTimeSheet = getTimeSheetDelegate().getHistoricoTimeSheet(formulario.getCodigoHistoricoTimeSheet(), getSessao());
	    	getTimeSheetDelegate().removerHistoricoTimeSheet(historicoTimeSheet, getSessao());
	    	
	    	AvaliacaoAtividade avaliacaoAtividade = getAvaliacaoAtividadePeloCodigoTimeSheet(formulario.getCodigoTimeSheet());
	    	
	    	if(avaliacaoAtividade!=null){
	    		removerAvaliacaoAtividade(avaliacaoAtividade);
	    	}
	    	
	        pojo = getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet()));	    
	        removerTimeSheet(pojo);
	        
    	} catch (ParametroInvalidoException e) {
    		salvarMsgErro("erro.geral2", request);	
    		e.printStackTrace();
    	} catch (SessaoInvalidaException e) {
    		salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
    	}
	    
		return mapping.findForward(retorno);        
	}

	/**
	 * Responsavel por alterar um atividade
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TimeSheetVO timesheet = null;
		
	    try {
            AtividadesForm formulario = (AtividadesForm) form;
            
            timesheet = getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(Integer.valueOf(formulario.getCodigoTimeSheet()));
            
            if(timesheet != null){
            	formulario.setListaProdutosServicos(recuperarListaProdutoServico(timesheet.getCodigoMetodologia())); 
            	
            	preencherFormularioInicial(formulario);
                preencherFormularioVO(formulario, timesheet);
            }
            
            formulario.setAcao(Constantes.ACAO_ALTERAR);
            
        } catch (IOException e) {
        	salvarMsgErro("erro.geral", request);
        	e.printStackTrace();
        } catch (ParametroInvalidoException e) {
        	salvarMsgErro("erro.geral2", request);
        	e.printStackTrace();
        }
        
		return mapping.findForward("retorno");        
	}
	

	@SuppressWarnings("deprecation")
	public ActionForward popularComboProdutoServico(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		try {
			AtividadesForm formulario = (AtividadesForm) form;
			
			preencherFormularioInicial(formulario);
			
			formulario.setListaProdutosServicos(recuperarListaProdutoServico(Integer.valueOf(formulario.getCodigoMetodologia())));
			
		} catch (ParametroInvalidoException e) {
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		} catch (IOException e) {
			salvarMsgErro("erro.geral", request);
			e.printStackTrace();
		} catch (Exception e) {
			salvarMsgErro("erro.geral2", request);
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
	@SuppressWarnings("deprecation")
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
        	salvarMsgErro("erro.geral2", request);
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
    @SuppressWarnings("deprecation")
	public ActionForward detalhar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    
	        AtividadesForm formulario = (AtividadesForm) form;
            String retorno = "retorno";
            try {
				preencherFormularioInicial(formulario);
           
				preencherFormulario(formulario, getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet())));
				            
	            formulario.setAcao(Constantes.ACAO_DETALHAR);
	            formulario.setDesabilitarCampo(true);
	            
	            request.setAttribute("sessao", getSessao());
	            
            } catch (ParametroInvalidoException e) {
            	salvarMsgErro("erro.geral2", request);
            	e.printStackTrace();
            } catch (SessaoInvalidaException e) {
            	salvarMsgErro("MSG015", request);
            	retorno = "pagina.de.erro.acesso";
            	e.printStackTrace();
            } catch (Exception e1) {
            	salvarMsgErro("erro.geral2", request);
            	e1.printStackTrace();
            }
            
            
	    
		return mapping.findForward(retorno);        
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
        List<TimeSheetVO> lista;
        String retorno = "retorno";
		List<HorasAtividadeVO> listaHorasAtividadeVOs = null;
		Funcionario funcionario = null;
		
		try {
        
			if(formulario.getCodigoFuncionario()!=null){
				//CONSULTA Funcionario Subordinado.
				funcionario = getFuncionarioPeloID(Integer.valueOf(formulario.getCodigoFuncionario()));
			}else{
				salvarMsgErro("errors.required", "Colaborador ", request);
			}
		
			if(formulario.getCodigoFuncionario()!=null){
				
				// Recupera a lista de Atividades do usuario subordinado
				lista = getListaTimeSheetVOPeloMesAno(formulario.getMesConsulta(), formulario.getAnoConsulta(),
						formulario.getCodigoFuncionario());
				
				listaHorasAtividadeVOs = getListaHorasAtividadeVO(funcionario);
				
				//Descricao do Mes : Exemplo (Março, Abril....)
    			formulario.setMesLiteral(UtilDate.getMesLiteral());
    			formulario.setCodigoFuncionarioSubordinado(funcionario.getId());
    			formulario.setSubordinado(funcionario);	    			
    			formulario.setListaHorasAtividadeVOs(listaHorasAtividadeVOs);
    			formulario.setListaTimeSheetVO(lista);
    			formulario.setIndicaAvaliacao(true);
				
				
			}else{
				//Recupera a lista de Atividades do usuario logado
				lista = getListaTimeSheetVOPeloMesAno(formulario.getMesConsulta(), formulario.getAnoConsulta(),
						formulario.getCodigoFuncionarioLogado());
			}
			
			formulario.setListaTimeSheetVO(lista);
        
			request.setAttribute("consulta", true);
        
		} catch (ParametroInvalidoException e) {
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		} catch (SessaoInvalidaException e) {
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
		} catch (Exception e) {
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		} 
        
        return mapping.findForward(retorno);       
    }

    /**
     * Responsavel por abrir PopUp.
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward abrirPopUpAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        
        AtividadesForm formulario = (AtividadesForm) form;
        
        formulario.limparFormulario();
        
        //Lista para as combos.
        preencherFormularioInicial(formulario);
        preencherFormulario(formulario, null);
        
       return mapping.findForward("retorno");      
    }


    public ActionForward retornoCadastrarAtividade(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("retorno");      
    }
    
    @SuppressWarnings("deprecation")
	public ActionForward inicioAvaliacao(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
	    	    
    	AtividadesForm formulario = (AtividadesForm) form;
	    String retorno = "retorno";
    	try {

    		formulario.setListaSituacaoAtividade(getListarTodasSituacaoAtividade());
		    formulario.setId(Integer.valueOf(formulario.getCodigoTimeSheet()));	    
	    
            TimeSheetVO timesheet;
			timesheet = getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(formulario.getId());
            preencherFormularioInicial(formulario);
            preencherFormularioVO(formulario, timesheet);
            
    	} catch (ParametroInvalidoException e) {
    		salvarMsgErro("erro.geral2", request);
    		e.printStackTrace();
    	} catch (SessaoInvalidaException e) {
    		salvarMsgErro("MSG015", request);
    		retorno = "pagina.de.erro.acesso";
    		e.printStackTrace();
    	} catch (Exception e) {
    		salvarMsgErro("erro.geral2", request);
    		e.printStackTrace();
		}
    	
		return mapping.findForward(retorno);		
	}

	@SuppressWarnings("deprecation")
	public ActionForward salvarAvaliacao(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response){
		String retorno = "retorno";
		try {
	    
	    	AtividadesForm formulario = (AtividadesForm) form;
    	    
	    	TimeSheet timeSheetPreenchido = preencherTimeSheet(formulario);	    	
	    	alterarTimeSheet(timeSheetPreenchido);
    	    
    	    AvaliacaoAtividade avaliacaoAtividade = new AvaliacaoAtividade();
	    
    	    avaliacaoAtividade.setFuncionarioAvaliador(getFuncionarioPeloID(formulario.getCodigoFuncionarioLogado()));
    	    avaliacaoAtividade.setObservacao(formulario.getObservacaoAvaliacaoAtividade());
    	    avaliacaoAtividade.setObservacaoPrivada(formulario.getObservacaoPrivada());
    	    avaliacaoAtividade.setSituacaoAtividade(getSituacaoAtividadePeloID(Integer.valueOf(formulario.getCodigoSituacaoAtividade())));
			avaliacaoAtividade.setTimeSheet(timeSheetPreenchido);
    	    
			salvarAvaliacaoAtividade(avaliacaoAtividade);
            
          //Submeter a pagina pai. 
            request.setAttribute("submiter", true);
		} catch (ParametroInvalidoException e) {
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		} catch (SessaoInvalidaException e) {
			salvarMsgErro("MSG015", request);
			retorno = "pagina.de.erro.acesso";
			e.printStackTrace();
		} catch (Exception e) {
			salvarMsgErro("erro.geral2", request);
			e.printStackTrace();
		}
            
	    
	    return mapping.findForward(retorno);		
	}

	//*********************************************
    //* METODOS AUXILIARES :
    //*********************************************
    public void preencherFormulario(AtividadesForm formulario, TimeSheet timesheet) throws ParametroInvalidoException, SessaoInvalidaException{
         
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
            formulario.setListaProdutosServicos(recuperarListaProdutoServico(timesheet.getMetodologia().getId()));
            
        }
        formulario.setDesabilitarCampo(false);
    }

    //*********************************************
    //* METODOS AUXILIARES :
    //*********************************************
    public void preencherFormularioVO(AtividadesForm formulario, TimeSheetVO timesheet) throws ParametroInvalidoException, SessaoInvalidaException{
    	
    	if(timesheet !=null){
    		formulario.setId(timesheet.getCodigoTimeSheet());
    		formulario.setData(UtilDate.getDataComoString(timesheet.getDataHoraInicio()));
    		formulario.setDataHoraInicio(UtilDate.getHoraComoString(timesheet.getDataHoraInicio()));
    		formulario.setDataHoraFim(UtilDate.getHoraComoString(timesheet.getDataHoraFim()));
    		formulario.setCodigoOp(timesheet.getCodigoOp());
    		formulario.setCodigoMetodologia(timesheet.getCodigoMetodologia());
    		formulario.setNomeProjeto(timesheet.getNomeProjeto());
    		formulario.setNumeroProjeto(Integer.toString(timesheet.getCodigoProjeto()));
    		formulario.setCodigoCliente(timesheet.getCodigoCliente());
    		formulario.setCodigoAtividade(timesheet.getCodigoAtividade());
    		formulario.setCodigoProdutoServico(timesheet.getCodigoProdutoServico());
    		formulario.setObservacao(timesheet.getObservacao());
    		formulario.setOutros(timesheet.getOutrasAtividades());
    		
    		formulario.setCodigoSituacaoAtividade(timesheet.getCodigoSituacaoAtividade());
    		formulario.setObservacaoPrivada(timesheet.getObservacaoPrivada());
    		formulario.setObservacaoAvaliacaoAtividade(timesheet.getObservacaoAvaliacaoAtividade());
    		
    		formulario.setListaProdutosServicos(recuperarListaProdutoServico(timesheet.getCodigoMetodologia()));
    		
    	}
    	formulario.setDesabilitarCampo(false);
    }

    /**
     * Responsavel em preencher o formulario os campos iniciais (COMBOs e Data atual...)
     * @param formulario
     * @throws Exception
     */
    public void preencherFormularioInicial(AtividadesForm formulario)  throws Exception {
        formulario.setListaAtividades(getListarTodasAtividades()) ;        
        formulario.setListaClientes(getListarTodosClientes());
        formulario.setListaOPs(getListarTodasOPs());
        formulario.setListaMetodologias(getListarTodasMetodologias());
        formulario.setListaSituacaoAtividade(getListarTodasSituacaoAtividade());
        formulario.setData(UtilDate.getDataComoString(UtilDate.getDataAtual()));
    }
    
    /**
     * Cria e preenche o objeto TimeSheet com os dados da tela. 
     * 
     * @param formulario
     * @param metodologia
     * @return
     * @throws Exception 
     * @throws SessaoInvalidaException 
     * @throws Exception 
     * @throws NumberFormatException 
     */
    public TimeSheet preencherTimeSheet(AtividadesForm formulario) throws SessaoInvalidaException, Exception{
        
        TimeSheet pojo = new TimeSheet();

        if(formulario.getAcao().equals(Constantes.ACAO_ALTERAR) || formulario.getAcao().equals(Constantes.ACAO_AVALIAR)){
            pojo.setId(formulario.getCodigoTimeSheet());
        }
        
        //COMBOS
        pojo.setAtividade(getAtividadePeloID(Integer.valueOf(formulario.getCodigoAtividade())));
        pojo.setCliente(getClientePeloID(Integer.valueOf(formulario.getCodigoCliente())));
        
        Metodologia metodologia = getMetodologiaPeloID(Integer.valueOf(formulario.getCodigoMetodologia()));
        pojo.setMetodologia(metodologia);
        
        pojo.setOp(getOPPeloID(Integer.valueOf(formulario.getCodigoOp())));
        pojo.setProdutoServico(getProdutoServicoPeloID(Integer.valueOf(formulario.getCodigoProdutoServico())));

        if(formulario.getAcao().equals(Constantes.ACAO_AVALIAR)){
        	pojo.setFuncionario(getFuncionarioPeloID(formulario.getCodigoFuncionarioSubordinado()));
        }else{
        	pojo.setFuncionario(getFuncionarioPeloID(formulario.getCodigoFuncionarioLogado()));
        }
                    
        Projeto projetoSalvo = salvarProjeto(formulario, metodologia);            
        pojo.setProjeto(projetoSalvo);
        
        
        pojo.setDataHoraInicio(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraInicio() + ":00"));
        pojo.setDataHoraFim(UtilDate.getDataHora(formulario.getData() + " " + formulario.getDataHoraFim() + ":00"));
        pojo.setObservacao(formulario.getObservacao());
        pojo.setOutrasAtividades(formulario.getOutros());            
        
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
        
        pojo.setUsuario(getUsuarioPeloID(formulario.getCodigoUsuario()));
        
        return pojo;
    }    
}
