package br.com.dba.timesheet.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.com.dba.timesheet.ejb.SegurancaDelegate;
import br.com.dba.timesheet.ejb.TimesheetDelegate;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.RegistroJaCadastradoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.struts.BaseDispatchAction;
import br.com.dba.timesheet.util.UtilDate;

public class TimeSheetComum extends BaseDispatchAction{

    private List<Atividade> listarTodasAtividades = null;
    private List<Cliente> listarTodosClientes = null;
    private List<OP> listarTodasOPs = null;
    private List<Metodologia> listarTodasMetodologias = null;
    private List<ProdutoServico> listarTodosProdutosServicos = null;
    private List<SituacaoAtividade> listarTodasSituacaoAtividade = null;
    
    //*********************************************
    //* GETTER's e SETTER's :
    //*********************************************
    /**
     * @return the listarTodasAtividades
     * @throws Exception 
     */
    public List<Atividade> getListarTodasAtividades() throws Exception {
        try {
           if (this.listarTodasAtividades == null) {
               this.listarTodasAtividades = listarTodosAtividades();
           }
        } catch (ParametroInvalidoException e) {
        	throw new Exception(e.getMessage(), e);
        }        
        return this.listarTodasAtividades;
    }

    /**
     * @return the listarTodasAtividades
     * @throws Exception 
     */
    public List<SituacaoAtividade> getListarTodasSituacaoAtividade() throws Exception {
        try {
            if (this.listarTodasSituacaoAtividade == null) {
                this.listarTodasSituacaoAtividade = listarTodasSituacaoAtividade();
            }
        } catch (ParametroInvalidoException e) {
        	throw new Exception(e.getMessage(), e);
        }        
        return this.listarTodasSituacaoAtividade;
    }

    /**
     * @param listarTodasAtividades the listarTodasAtividades to set
     */
    public void setListarTodasSituacaoAtividade(List<SituacaoAtividade> listarTodasSituacaoAtividade) {
        this.listarTodasSituacaoAtividade = listarTodasSituacaoAtividade;
    }

    /**
     * @param listarTodasAtividades the listarTodasAtividades to set
     */
    public void setListarTodasAtividades(List<Atividade> listarTodasAtividades) {
        this.listarTodasAtividades = listarTodasAtividades;
    }

    /**
     * @return the listarTodosClientes
     * @throws Exception 
     */
    public List<Cliente> getListarTodosClientes() throws Exception {
        try {
            if (listarTodosClientes == null) {
                    listarTodosClientes = listarTodosClientes();
            }
        } catch (ParametroInvalidoException e) {
        	throw new Exception(e.getMessage(), e);
        }
        return listarTodosClientes;
    }

    /**
     * @param listarTodosClientes the listarTodosClientes to set
     */
    public void setListarTodosClientes(List<Cliente> listarTodosClientes) {
        this.listarTodosClientes = listarTodosClientes;
    }

    /**
     * @return the listarTodasOPs
     * @throws Exception 
     */
    public List<OP> getListarTodasOPs() throws Exception {
        try {
            if (listarTodasOPs == null) {
                    listarTodasOPs = listarTodasOPs();
            }
        } catch (ParametroInvalidoException e) {
        	throw new Exception(e.getMessage(), e);
        }            
    
        return listarTodasOPs;
        
    }

    /**
     * @param listarTodasOPs the listarTodasOPs to set
     */
    public void setListarTodasOPs(List<OP> listarTodasOPs) {
        this.listarTodasOPs = listarTodasOPs;
    }

    /**
     * @return the listarTodasMetodologias
     * @throws Exception 
     */
    public List<Metodologia> getListarTodasMetodologias() throws Exception {
        try {
            if (listarTodasMetodologias == null) {
                    listarTodasMetodologias = listarTodasMetodologias();
            }
        } catch (ParametroInvalidoException e) {
        	throw new Exception(e.getMessage(), e);
        }            
    
        return listarTodasMetodologias;
    }

    /**
     * @param listarTodasMetodologias the listarTodasMetodologias to set
     */
    public void setListarTodasMetodologias(List<Metodologia> listarTodasMetodologias) {
        this.listarTodasMetodologias = listarTodasMetodologias;
    }

    /**
     * @return the listarTodosProdutosServicos
     * @throws Exception 
     */
    public List<ProdutoServico> getListarTodosProdutosServicos() throws Exception {
        try {
            if (listarTodosProdutosServicos == null) {
                listarTodosProdutosServicos = listarTodosProdutoServico();            
            }
        } catch (ParametroInvalidoException e) {
        	throw new Exception(e.getMessage(), e);
        }
        return listarTodosProdutosServicos;
    }

    /**
     * @param listarTodosProdutosServicos the listarTodosProdutosServicos to set
     */
    public void setListarTodosProdutosServicos(List<ProdutoServico> listarTodosProdutosServicos) {
        this.listarTodosProdutosServicos = listarTodosProdutosServicos;
    }

    public List<Atividade> listarTodosAtividades() throws ParametroInvalidoException, SessaoInvalidaException {
        return getTimeSheetDelegate().listarTodosAtividades();
    }

    public List<Cliente> listarTodosClientes() throws ParametroInvalidoException, SessaoInvalidaException {
        return getTimeSheetDelegate().listarTodosCliente();
    }

    public List<OP> listarTodasOPs() throws ParametroInvalidoException, SessaoInvalidaException {
        return getTimeSheetDelegate().listarTodasOPs();
    }

    public List<Metodologia> listarTodasMetodologias() throws ParametroInvalidoException, SessaoInvalidaException {
        return getTimeSheetDelegate().listarTodasMetodologias();
    }

    public List<ProdutoServico> listarTodosProdutoServico()
        throws ParametroInvalidoException, SessaoInvalidaException {
        return getTimeSheetDelegate().listarTodosProdutoServico();
    }

    public List<SituacaoAtividade> listarTodasSituacaoAtividade()
        throws ParametroInvalidoException, SessaoInvalidaException {
        return getTimeSheetDelegate().listarTodasSituacaoAtividade();
    }

    
    //*********************************************
    //* CRUD's :
    //*********************************************
    public void salvarTimeSheet(TimeSheet pojo)
            throws ParametroInvalidoException, SessaoInvalidaException, RegistroJaCadastradoException {
    	getTimeSheetDelegate().salvarTimeSheet(pojo);
    }

    public void salvarHistoricoTimeSheet(HistoricoTimeSheet pojo)
            throws ParametroInvalidoException, SessaoInvalidaException {
                getTimeSheetDelegate().salvarHistoricoTimeSheet(pojo);
            }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public OP getOPPeloID(Integer id) throws Exception , SessaoInvalidaException {
        OP pojo = null;
        try{    
            pojo = getTimeSheetDelegate().getOP(id);
        } catch (Exception e) {
        	throw new Exception(e.getMessage(), e);
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public Usuario getUsuarioPeloID(Integer id, HttpServletRequest request) throws Exception {
        Usuario pojo = null;
        try{    
            pojo = getSegurancaDelegate().getUsuario(id,getSessao(request));
        } catch (Exception e) {
        	throw new Exception(e.getMessage(), e);
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public ProdutoServico getProdutoServicoPeloID(Integer id) throws Exception, SessaoInvalidaException {
        ProdutoServico pojo = null;
        try{    
            pojo = getTimeSheetDelegate().getProdutoServico(id);
        } catch (Exception e) {
        	throw new Exception(e.getMessage(), e);
        }
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public Cliente getClientePeloID(Integer id) throws Exception, SessaoInvalidaException {
        Cliente pojo = null;
        pojo = getTimeSheetDelegate().getCliente(id);
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public Atividade getAtividadePeloID(Integer id) throws Exception, SessaoInvalidaException {
        Atividade pojo = null;
        pojo = getTimeSheetDelegate().getAtividade(id);
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public Metodologia getMetodologiaPeloID(Integer id) throws Exception, SessaoInvalidaException {
        Metodologia pojo = null;
        pojo = getTimeSheetDelegate().getMetodologia(id);
        return pojo;
    }    

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public Funcionario getFuncionarioPeloID(Integer id) throws Exception, SessaoInvalidaException {
        Funcionario pojo = null;
        pojo = getTimeSheetDelegate().getFuncionario(id);
        return pojo;
    }

    /**
     * Recupera um objeto pelo id.
     * @param id
     * @return 
     * @throws Exception 
     */
    public SituacaoAtividade getSituacaoAtividadePeloID(Integer id) throws Exception, SessaoInvalidaException {
        SituacaoAtividade pojo = null;
        try {
            pojo = getTimeSheetDelegate().getSituacaoAtividade(id);
        } catch (Exception e) {
        	throw new Exception(e.getMessage(), e);
        }
        return pojo;
    }
    
    public TimeSheet getTimeSheetPeloID(Integer id)
        throws ParametroInvalidoException, SessaoInvalidaException {
        return getTimeSheetDelegate().getTimeSheet(id);
    }

    public TimeSheetVO getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(Integer id)
    throws ParametroInvalidoException, SessaoInvalidaException {
    	return getTimeSheetDelegate().getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(id);
    }
    
  //*********************************************
    //* DELEGATES :
    //*********************************************
    public TimesheetDelegate getTimeSheetDelegate() {
        return TimesheetDelegate.getInstancia();
    }

    public SegurancaDelegate getSegurancaDelegate() {
    	return SegurancaDelegate.getInstancia();
    }

    public void alterarTimeSheet(TimeSheet pojo) throws Exception, SessaoInvalidaException {
        try {
            getTimeSheetDelegate().alterarTimeSheet(pojo);
        } catch (Exception e) {
        	throw new Exception(e.getMessage(), e);
        }
    }

	public List<Usuario> constultarUsuario(Usuario usuario, HttpServletRequest request)
			throws ParametroInvalidoException, SessaoInvalidaException {
				return getSegurancaDelegate().consultarUsuario(usuario, getSessao(request));
			}

	public Usuario getUsuario(Usuario usuario, HttpServletRequest request) throws ParametroInvalidoException, SessaoInvalidaException {
		return getSegurancaDelegate().getUsuario(usuario, getSessao(request));
	}

	/**
	 * Recupera a lista com as horas das atividades(TIMESHEETs) pelo codigo funcionario.
	 * @param subordinado
	 * @return
	 * @throws ParametroInvalidoException
	 */
	protected List<HorasAtividadeVO> getListaHorasAtividadeVO(Funcionario subordinado) throws ParametroInvalidoException, SessaoInvalidaException {
		return getTimeSheetDelegate().getListaHorasAtividadeVO(UtilDate.getDataAtual(), subordinado.getId());
	}
	
	/**
	 * Recupera a lista de atividades por funcionario.
	 * @param funcionario
	 * @return
	 * @throws ParametroInvalidoException
	 */
	protected List<TimeSheetVO> getListaTimeSheetVO(Funcionario funcionario)throws ParametroInvalidoException, SessaoInvalidaException {
		//Data do primeiro dia do mes atual.
		String data1 = UtilDate.getDataComoString(UtilDate.getCalendarPrimeiroDoMesAtual().getTime());
		
		//Data do ultimo dia do mes atual.
		String data2 = UtilDate.getDataComoString(UtilDate.getDataNoUltimoDiaDoMes(UtilDate.getDataAtual()));
		
		return getTimeSheetDelegate().getListaTimeSheetVO(UtilDate.getDataComHoraZero(data1),
				UtilDate.getDataComHoraZero(data2), funcionario.getId());
	}

	/**
	 * Recupera a lista de Funcionario Subordinado pelo codigo do chefe.
	 * @param usuarioLogado
	 * @return
	 * @throws ParametroInvalidoException
	 */
	protected List<Funcionario> consultaFuncionariosPeloCodigoFuncionarioChefe(Usuario usuarioLogado)
			throws ParametroInvalidoException, SessaoInvalidaException {
				return getTimeSheetDelegate().consultaFuncionariosPeloCodigoFuncionarioChefe(usuarioLogado.getFuncionario().getId());
			}

	protected void removerTimeSheet(TimeSheet pojo)
			throws ParametroInvalidoException, SessaoInvalidaException {
				getTimeSheetDelegate().removerTimeSheet(pojo);
			}

	public List<ProdutoServico> recuperarListaProdutoServico(Integer codigoMetodologia)
			throws ParametroInvalidoException, SessaoInvalidaException {
				return getTimeSheetDelegate().getProdutoServicoPeloCodigoMetodologia(Integer.valueOf(codigoMetodologia));
	}

	public AvaliacaoAtividade salvarAvaliacaoAtividade(AvaliacaoAtividade avaliacaoAtividade)
			throws ParametroInvalidoException, SessaoInvalidaException {
				return getTimeSheetDelegate().salvarAvaliacaoAtividade(avaliacaoAtividade);
			}

	public List<TimeSheetVO> getListaTimeSheetVOPeloMesAno(String mesConsulta, String anoConsulta,
			Integer codigoFuncionarioLogado) throws ParametroInvalidoException,
			SessaoInvalidaException {
				return getTimeSheetDelegate().getListaTimeSheetVOPeloMesAno(mesConsulta, anoConsulta, codigoFuncionarioLogado);
			}

	public void removerAvaliacaoAtividade(AvaliacaoAtividade avaliacaoAtividade)
			throws ParametroInvalidoException, SessaoInvalidaException {
				getTimeSheetDelegate().removerAvaliacaoAtividade(avaliacaoAtividade);
			}

	public AvaliacaoAtividade getAvaliacaoAtividadePeloCodigoTimeSheet(Integer codigoTimeSheet, HttpServletRequest request)
			throws ParametroInvalidoException, SessaoInvalidaException {
				return getTimeSheetDelegate().getAvaliacaoAtividadePeloCodigoTimeSheet(codigoTimeSheet);
			}

	protected Sessao getSessao(HttpServletRequest request) {
		return (Sessao) request.getSession().getAttribute(TimeSheetComum.SESSAO_EJB);		
	}
	
	
    /**
	 * Atualização da mensagem de erro para exibição em tela.
	 * 
	 * Sem necessidade de lançar o NegocioException.
	 * 
	 * @param req
	 * @param chaveMensagem
	 * @param args
	 * @return
	 */
    public ActionMessages salvarMsgErro(HttpServletRequest req, String chaveMensagem, Object[] args) {
        ActionMessages msgs = new ActionMessages();
		msgs.add(chaveMensagem, new ActionMessage(chaveMensagem, args));
		saveErrors(req, msgs);
		
		return msgs;
    }
    
    public ActionMessages salvarMsgErro(HttpServletRequest req, String chaveMensagem) {
        ActionMessages msgs = new ActionMessages();
		msgs.add(chaveMensagem, new ActionMessage(chaveMensagem));
		saveErrors(req, msgs);

		return msgs;
    }
    
    /**
     * Atualização das mensagens de sucesso, para quando tiver mais argumentos para serem passados.
     * 
     * @param req
     * @param chaveMensagem
     * @param args
     * @return ActionMessages
     */
    public ActionMessages salvarMsgSucesso(HttpServletRequest req, String chaveMensagem, Object[] args) {
        ActionMessages msgs = new ActionMessages();
		msgs.add(chaveMensagem, new ActionMessage(chaveMensagem, args));
		saveMessages(req, msgs);
		
		return msgs;
    }

}
