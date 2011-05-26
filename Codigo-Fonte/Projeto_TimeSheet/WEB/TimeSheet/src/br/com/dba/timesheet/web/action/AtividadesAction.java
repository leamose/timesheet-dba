package br.com.dba.timesheet.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.RegistroJaCadastradoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.TotalHorasMes;
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
    	String retorno = "cadastro";
    	
	    try {
	    	formulario.setUsuario(getSessao(request).getUsuario());
	    	
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
		
		List<HorasAtividadeVO> listaHorasAtividadeVOs = null;		
		List<HorasAtividadeVO> listaTotalHorasTrabalhadas = null;
		String totalCargaHoraria = null;
		String totalHorasTrabalhadas = null;
		String totalSaldoDiario = null;
		String totalSaldoAcumulado = null;
			
		if(formulario.getUsuario()!=null &&  formulario.getUsuario().getFuncionario()!=null && formulario.getUsuario().getFuncionario().getIndicaChefe()){
			//verifica se o usuario logado é chefe.
			indicaChefe = formulario.getUsuario().getFuncionario().getIndicaChefe();
			formulario.setIndicaChefe(indicaChefe);
			
			//recupera uma lista de funcionarios colaboradores pelo codigo do usuario chefe.
			listaFuncionariosSubordinados = consultaFuncionariosPeloCodigoFuncionarioChefe(formulario.getUsuario());
			formulario.setListaFuncionariosSubordinados(listaFuncionariosSubordinados);
		}	    		
		
		//recupera as HORAS trabalhadas do usuario logado.
		listaHorasAtividadeVOs = getListaHorasAtividadeVO(formulario.getUsuario().getFuncionario());
		
		//Preenche formulario(TELA)
		formulario.setTamanhoListaHoras(listaHorasAtividadeVOs != null ? listaHorasAtividadeVOs.size():0);
		formulario.setListaHorasAtividadeVOs(listaHorasAtividadeVOs);
		formulario.setCodigoUsuario(formulario.getUsuario().getId());		
		formulario.setCodigoFuncionarioLogado(formulario.getUsuario().getFuncionario()!=null ? formulario.getUsuario().getFuncionario().getId():null);
		formulario.setMesLiteral(UtilDate.getMesLiteral());
		formulario.setMesConsulta(Integer.toString(UtilDate.getMesAtual()));
		formulario.setAnoConsulta(Integer.toString(UtilDate.getAnoAtual()));

		//recupera as ATIVIDADES do usuario logado.
		formulario.setListaTimeSheetVO(getListaTimeSheetVO(formulario.getUsuario().getFuncionario()));
		
		if(formulario.getUsuario() != null && formulario.getUsuario().getFuncionario() != null){
    		listaTotalHorasTrabalhadas = getTimeSheetDelegate().getTotalHorasTrabalhadas(UtilDate.getAnoAtual(), 
    				UtilDate.getMesAtual(), formulario.getUsuario().getFuncionario().getId());
		}
		
		if(!listaTotalHorasTrabalhadas.isEmpty()){
			TotalHorasMes totalHorasMes = getTimeSheetDelegate().consultaTotalHorasMesPorAnoMes(Integer.toString(UtilDate.getAnoAtual()), Integer.toString(UtilDate.getMesAtual()));
			
			if(totalHorasMes!=null && totalHorasMes.getTotalHorasMes()!=null){				
				totalCargaHoraria = Integer.toString(totalHorasMes.getTotalHorasMes());
			}
			
			totalHorasTrabalhadas = listaTotalHorasTrabalhadas.get(0).getHorasTrabalhadas();
			totalSaldoDiario = UtilDate.subtrairHoras(totalCargaHoraria!=null? totalCargaHoraria.toString() + ":00":"", listaTotalHorasTrabalhadas.get(0).getHorasTrabalhadas());
		}

		
		
		formulario.setTotalCargaHoraria(totalCargaHoraria);
		formulario.setTotalHorasTrabalhadas(totalHorasTrabalhadas);
		formulario.setTotalSaldoDiario(totalSaldoDiario);
		formulario.setTotalSaldoAcumulado(totalSaldoAcumulado);
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
    	    
    	    if(validarCampos(formulario, request)){
    	    
	    	    
	    	    timeSheet = preencherTimeSheet(formulario);    	    
	    	    
	    	    salvarTimeSheet(timeSheet);
	    	    
	    	    historicoTimeSheet = preencherHistoricoTimeSheet(timeSheet, "I", formulario, request);            
	            salvarHistoricoTimeSheet(historicoTimeSheet);
	            
	            //Submeter a pagina pai. 
	            request.setAttribute("submiter", true);
    	    }else{
    	    	//Submeter a pagina pai. 
	            request.setAttribute("preencherCombo", true);
	            request.setAttribute("codigoProdutoServico", formulario.getCodigoProdutoServico());
	            request.getSession().setAttribute("msg", formulario.getMessages());
    	    }    	    
            
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
    
    public boolean validarCampos(AtividadesForm form, HttpServletRequest request) {
    	
    	List<String> erros = new ArrayList<String>();
    	
    	if(form.getCodigoOp() == null || StringUtils.equals(form.getCodigoOp().toString(), "#")){
			erros.add("OP");
		}
    	
    	if(form.getCodigoCliente() == null || StringUtils.equals(form.getCodigoCliente().toString(), "#")){
    		erros.add("Cliente");
    	}
    	
    	if(form.getCodigoMetodologia() == null || StringUtils.equals(form.getCodigoMetodologia().toString(), "#")){
    		erros.add("Metodologia");
    	}
    	
    	if(form.getCodigoProdutoServico() == null || StringUtils.equals(form.getCodigoProdutoServico().toString(), "#")){
    		erros.add("Produto/Servico");
    	}
    	
    	if(form.getCodigoAtividade() == null || StringUtils.equals(form.getCodigoAtividade().toString(), "#")){
    		erros.add("Atividade");
    	}

    	if(StringUtils.isEmpty(form.getNomeProjeto())){
    		erros.add("Nome do Projeto");
    	}

    	if(StringUtils.isEmpty(form.getNumeroProjeto())){
    		erros.add("Número do Projeto");
    	}
    	
    	
    	if(erros.size()>0){
			 Object[] o = new Object[erros.size()+1];
			 o[0]="Erro! Favor preencher todos os Campos Obrigatórios.";
			 int i =1;
			 for(String m:erros){
				 o[i]=m;
				 i++;
			 }
			 
			 form.setMessages(salvarMsgErro(request,"errors.generico", o)); 
			 return false;
		}else{
	    	if(form.getData().length()<10){
	    		form.setMessages(salvarMsgErro(request,"errors.required", new Object[]{"Data Atividade","data"}));
				 return false;
			}
			try {
				Date data = UtilDate.getData(form.getData());
				Date dataAutal = UtilDate.getHoraZero(UtilDate.getDataAtual());
				if(data.getTime()> dataAutal.getTime()){
					form.setMessages(salvarMsgErro(request,"errors.generico", new Object[]{"Data deve ser menor que data atual.","data"}));
					 return false;
				}
			} catch (Exception e) {
				form.setMessages(salvarMsgErro(request,"errors.date", new Object[]{"","data"}));
				 return false;
			}
		}
    	
    	form.setMessages(null);
		return true;
	}
    
    public boolean validarCamposAvaliacao(AtividadesForm form, HttpServletRequest request) {
    	
    	List<String> erros = new ArrayList<String>();
    	
    	validarCampos(form, request);
    	
    	if(form.getCodigoSituacaoAtividade() == null || StringUtils.equals(form.getCodigoSituacaoAtividade().toString(), "#")){
			erros.add("Situação");
		}

    	if(StringUtils.isEmpty(form.getObservacaoAvaliacaoAtividade().toString())){
    		erros.add("Observações Chefia");
    	}
    	
    	if(erros.size()>0){
			 Object[] o = new Object[erros.size()+1];
			 o[0]="Erro! Favor preencher todos os Campos Obrigatórios.";
			 int i =1;
			 for(String m:erros){
				 o[i]=m;
				 i++;
			 }
			 salvarMsgErro(request,"errors.generico", o);
			 return false;
		}
    	
		return true;
	}

    public boolean validarCamposConsulta(AtividadesForm form, HttpServletRequest request) {
    	
    	List<String> erros = new ArrayList<String>();
    	
    	validarCampos(form, request);
    	
    	if(form.getCodigoFuncionario() == null || StringUtils.equals(form.getCodigoFuncionario().toString(), "#")){
    		erros.add("Colaborador");
    	}
    	
    	if(StringUtils.isEmpty(form.getMesConsulta().toString())){
    		erros.add("Mês");
    	}

    	if(StringUtils.isEmpty(form.getAnoConsulta().toString())){
    		erros.add("Ano");
    	}
    	
    	if(erros.size()>0){
    		Object[] o = new Object[erros.size()+1];
    		o[0]="Erro! Favor preencher todos os Campos Obrigatórios.";
    		int i =1;
    		for(String m:erros){
    			o[i]=m;
    			i++;
    		}
    		salvarMsgErro(request,"errors.generico", o);
    		return false;
    	}
    	
    	return true;
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

		projetoSalvo = getTimeSheetDelegate().salvarProjeto(projeto);
		
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
			historicoTimeSheet = getTimeSheetDelegate().getHistoricoTimeSheet(formulario.getCodigoHistoricoTimeSheet());
	    	getTimeSheetDelegate().removerHistoricoTimeSheet(historicoTimeSheet);
	    	
	    	AvaliacaoAtividade avaliacaoAtividade = getAvaliacaoAtividadePeloCodigoTimeSheet(formulario.getCodigoTimeSheet(), request);
	    	
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
			
			ActionMessages msg = (ActionMessages) request.getSession().getAttribute("msg");
			formulario.setCodigoProdutoServico(formulario.getCodigoProdutoSelecionadoAnteriormente());
			if(msg!=null){
				saveErrors(request, msg);
				request.getSession().setAttribute("msg", null);
			}
				
			preencherFormularioInicial(formulario);
			
			formulario.setListaProdutosServicos(formulario.getCodigoMetodologia()!=null?recuperarListaProdutoServico(Integer.valueOf(formulario.getCodigoMetodologia())):getListarTodosProdutosServicos());
			
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
        
            historicoTimeSheet = preencherHistoricoTimeSheet(timeSheet, "A", formulario, request);            
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
           
				preencherFormularioComObjetoDoBanco(formulario, getTimeSheetPeloID(Integer.valueOf(formulario.getCodigoTimeSheet())));
				            
	            formulario.setAcao(Constantes.ACAO_DETALHAR);
	            formulario.setDesabilitarCampo(true);
	            
	            
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
        List<TimeSheetVO> lista = new ArrayList<TimeSheetVO>();
        String retorno = "retorno";
		List<HorasAtividadeVO> listaHorasAtividadeVOs = null;
		Funcionario funcionario = null;
		
		try {
        
			if(validarCamposConsulta(formulario, request)){
				//CONSULTA Funcionario Subordinado.
				funcionario = getFuncionarioPeloID(Integer.valueOf(formulario.getCodigoFuncionario()));
		
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
					
					
				}
			}
			
			formulario.setListaTimeSheetVO(lista);
			formulario.setMostraConsulta(true);
			formulario.setConsulta(false);
        
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

	public ActionForward inicioConsultar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		AtividadesForm formulario = (AtividadesForm)form;
		String retorno = "retorno";

		formulario.setListaTimeSheetVO(new ArrayList<TimeSheetVO>());
		formulario.setCodigoFuncionario(null);
		
		
		formulario.setMostraConsulta(true);
		formulario.setConsulta(false);			
		
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
        preencherFormularioComObjetoDoBanco(formulario, null);
        
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
			
			formulario.limparFormulario();
			
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
    	    
	    	if(validarCamposAvaliacao(formulario, request)){
	    	
		    	TimeSheet timeSheetPreenchido = preencherTimeSheet(formulario);	
		    	
		    	alterarTimeSheet(timeSheetPreenchido);
	    	    
	    	    AvaliacaoAtividade avaliacaoAtividade = new AvaliacaoAtividade();
		    
	    	    if(formulario.getCodigoAvaliacao()!=null && formulario.getCodigoAvaliacao()!=0){
	    	    	avaliacaoAtividade.setId(formulario.getCodigoAvaliacao());
	    	    }
	    	    
	    	    avaliacaoAtividade.setFuncionarioAvaliador(getFuncionarioPeloID(formulario.getCodigoFuncionarioLogado()));
	    	    avaliacaoAtividade.setObservacao(formulario.getObservacaoAvaliacaoAtividade());
	    	    avaliacaoAtividade.setObservacaoPrivada(formulario.getObservacaoPrivada());
	    	    avaliacaoAtividade.setSituacaoAtividade(getSituacaoAtividadePeloID(Integer.valueOf(formulario.getCodigoSituacaoAtividade())));
				avaliacaoAtividade.setTimeSheet(timeSheetPreenchido);
	    	    
				getTimeSheetDelegate().alterarAvaliacaoAtividade(avaliacaoAtividade);

				//Submeter a pagina pai. 
				request.setAttribute("submiter", true);				
				
    	    }
            
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
    public void preencherFormularioComObjetoDoBanco(AtividadesForm formulario, TimeSheet timesheet) throws ParametroInvalidoException, SessaoInvalidaException{
         
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
    		formulario.setCodigoAvaliacao(timesheet.getCodigoAvaliacaoTimeSheet());
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
        formulario.setConsulta(false);
        
        if(StringUtils.isEmpty(formulario.getData()))
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
            pojo.setId(formulario.getCodigoTimeSheet()!=null?formulario.getCodigoTimeSheet():formulario.getId());
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
	public HistoricoTimeSheet preencherHistoricoTimeSheet(TimeSheet timeSheet,
			String tipoOperacao, AtividadesForm formulario, HttpServletRequest request) throws Exception {
        
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
        
        pojo.setUsuario(getUsuarioPeloID(formulario.getCodigoUsuario(), request));
        
        return pojo;
    }    
}
