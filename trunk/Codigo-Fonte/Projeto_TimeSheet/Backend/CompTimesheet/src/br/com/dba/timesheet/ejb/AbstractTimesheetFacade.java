package br.com.dba.timesheet.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;

import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.TipoAtividade;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.dao.AtividadeDao;
import br.com.dba.timesheet.pojo.dao.AvaliacaoAtividadeDao;
import br.com.dba.timesheet.pojo.dao.ClienteDao;
import br.com.dba.timesheet.pojo.dao.FuncionarioDao;
import br.com.dba.timesheet.pojo.dao.HistoricoTimeSheetDao;
import br.com.dba.timesheet.pojo.dao.MetodologiaDao;
import br.com.dba.timesheet.pojo.dao.OPDao;
import br.com.dba.timesheet.pojo.dao.ProdutoServicoDao;
import br.com.dba.timesheet.pojo.dao.ProjetoDao;
import br.com.dba.timesheet.pojo.dao.SituacaoAtividadeDao;
import br.com.dba.timesheet.pojo.dao.TimeSheetDao;
import br.com.dba.timesheet.pojo.dao.TimesheetDaoFactory;
import br.com.dba.timesheet.pojo.dao.TipoAtividadeDao;
import br.com.dba.timesheet.pojo.dao.UsuarioDao;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.servicos.Timesheet;


/**
 * Classe abstrata que representa o Componente Timesheet.
 *
 * @author             Fabio Oliveira de Pinho
 *
 */

/**
 * 
 * @ejb.bean description="EJB TimeSheet"
 *           display-name="TimesheetFacade"
 *           jndi-name="br/com/dba/timesheet/ejb/TimesheetFacade"
 *           name="TimesheetFacade"
 *           type="Stateless"
 *           view-type="remote"
 *           transaction-type = "Container"
 *           
 * @ejb.util generate = "physical"
 *
 */
public abstract class AbstractTimesheetFacade implements SessionBean, Timesheet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AtividadeDao atividadeDao;
	private ClienteDao clienteDao;
	private FuncionarioDao funcionarioDao;
	private MetodologiaDao metodologiaDao;
	private OPDao opDao;
	private ProdutoServicoDao produtoServicoDao;
	private ProjetoDao projetoDao;
	private TipoAtividadeDao tipoAtividadeDao;
	private TimeSheetDao timeSheetDao;
	private HistoricoTimeSheetDao historicoTimeSheetDao;
	private UsuarioDao usuarioDao;
	private SituacaoAtividadeDao situacaoAtividadeDao;
	private AvaliacaoAtividadeDao avaliacaoAtividadeDao;
	
	/**
     * @ejb.create-method view-type = "remote"  
     */
	public void ejbCreate() throws CreateException {
		atividadeDao = TimesheetDaoFactory.getInstance().getAtividadeDao();		
		clienteDao = TimesheetDaoFactory.getInstance().getClienteDao();		
		funcionarioDao = TimesheetDaoFactory.getInstance().getFuncionarioDao();		
		metodologiaDao = TimesheetDaoFactory.getInstance().getMetodologiaDao();		
		opDao = TimesheetDaoFactory.getInstance().getOPDao();		
		produtoServicoDao = TimesheetDaoFactory.getInstance().getProdutoServicoDao();		
		projetoDao = TimesheetDaoFactory.getInstance().getProjetoDao();		
		tipoAtividadeDao = TimesheetDaoFactory.getInstance().getTipoAtividadeDao();		
		timeSheetDao = TimesheetDaoFactory.getInstance().getTimeSheetDao();		
		historicoTimeSheetDao = TimesheetDaoFactory.getInstance().getHistoricoTimeSheetDao();		
		usuarioDao = TimesheetDaoFactory.getInstance().getUsuarioDao();		
		situacaoAtividadeDao = TimesheetDaoFactory.getInstance().getSituacaoAtividadeDao();		
		avaliacaoAtividadeDao = TimesheetDaoFactory.getInstance().getAvaliacaoAtividadeDao();		
	}
	
	
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TipoAtividade> listarTodosTipoAtividades() throws ParametroInvalidoException{
        try {
        	return tipoAtividadeDao.listarTodos();
        } catch (DAOException e) {
			throw new ErroInternoException(e.getMessage(),e.getCause());
		}
	}

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<ProdutoServico> listarTodosProdutoServico() throws ParametroInvalidoException{
        try {
            return produtoServicoDao.listarTodos();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<OP> listarTodasOPs() throws ParametroInvalidoException{
        try {
            return opDao.listarTodos();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<Metodologia> listarTodasMetodologias() throws ParametroInvalidoException{
        try {
            return metodologiaDao.listarTodos();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<Cliente> listarTodosCliente() throws ParametroInvalidoException{
        try {
            return clienteDao.listarTodos();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TimeSheet> listarTodosTimeSheet() throws ParametroInvalidoException{
        try {
            return timeSheetDao.listarTodos();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<SituacaoAtividade> listarTodasSituacaoAtividade() throws ParametroInvalidoException{
        try {
            return situacaoAtividadeDao.listarTodos();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TimeSheet> listarTodosTimeSheetOrdenadoPorDataHoraInicio()throws ParametroInvalidoException{
        try {
            return timeSheetDao.listaTodosTimeSheetOrdenadoPorDataHoraInicio();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TimeSheet> consultarTimeSheetPorDataHoraInicio(Date dataInicio, Date dataFim)throws ParametroInvalidoException{
        try {
            return timeSheetDao.consultarTimeSheetPorDataHoraInicio(dataInicio, dataFim);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<Atividade> listarTodosAtividades() throws ParametroInvalidoException{
        try {
            return atividadeDao.listarTodos();
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public TimeSheet salvarTimeSheet(TimeSheet pojo) throws ParametroInvalidoException{
        try {
            return timeSheetDao.salvar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public SituacaoAtividade salvarSituacaoAtividade(SituacaoAtividade pojo) throws ParametroInvalidoException{
        try {
            return situacaoAtividadeDao.salvar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public AvaliacaoAtividade salvarAvaliacaoAtividade(AvaliacaoAtividade pojo) throws ParametroInvalidoException{
        try {
            return avaliacaoAtividadeDao.salvar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void alterarAvaliacaoAtividade(AvaliacaoAtividade pojo) throws ParametroInvalidoException{
        try {
            avaliacaoAtividadeDao.alterar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void removerAvaliacaoAtividade(AvaliacaoAtividade pojo) throws ParametroInvalidoException{
        try {
            avaliacaoAtividadeDao.remover(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public HistoricoTimeSheet salvarHistoricoTimeSheet(HistoricoTimeSheet pojo) throws ParametroInvalidoException{
        try {
            return historicoTimeSheetDao.salvar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void alterarTimeSheet(TimeSheet pojo) throws ParametroInvalidoException{
        try {
            timeSheetDao.alterar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void removerTimeSheet(TimeSheet pojo) throws ParametroInvalidoException{
        try {
            timeSheetDao.remover(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<ProdutoServico> consultarProdutoServicoPeloCodigoMetodologia(Integer codigo) throws ParametroInvalidoException{
        try {
            return produtoServicoDao.getProdutoServicoPeloCodigoMetodologia(codigo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public SituacaoAtividade getSituacaoAtividade(Integer id) throws ParametroInvalidoException{
        try {
            return situacaoAtividadeDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Funcionario getFuncionario(Integer id) throws ParametroInvalidoException{
        try {
            return funcionarioDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Cliente getCliente(Integer id) throws ParametroInvalidoException{
        try {
            return clienteDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Atividade getAtividade(Integer id) throws ParametroInvalidoException{
        try {
            return atividadeDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public OP getOP(Integer id) throws ParametroInvalidoException{
        try {
            return opDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Metodologia getMetodologia(Integer id) throws ParametroInvalidoException{
        try {
            return metodologiaDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public ProdutoServico getProdutoServico(Integer id) throws ParametroInvalidoException{
        try {
            return produtoServicoDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public TimeSheet getTimeSheet(Integer id) throws ParametroInvalidoException{
        try {
            return timeSheetDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public HistoricoTimeSheet getHistoricoTimeSheet(Integer id) throws ParametroInvalidoException{
        try {
            return historicoTimeSheetDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(Integer codigo)throws ParametroInvalidoException{
        try {
            return historicoTimeSheetDao.getHistoricoPeloCodigoTimeSheet(codigo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(Date data)throws ParametroInvalidoException{
        try {
            return historicoTimeSheetDao.getHistoricoPelaDataOperacao(data);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Usuario getUsuario(Integer id) throws ParametroInvalidoException{
        try {
            return usuarioDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<Usuario> consultarUsuario(Usuario pojo) throws ParametroInvalidoException{
    	try {
    		return usuarioDao.consultar(pojo);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Projeto salvarProjeto(Projeto pojo) throws ParametroInvalidoException{
        try {
            return projetoDao.salvar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void alterarProjeto(Projeto pojo) throws ParametroInvalidoException{
        try {
            projetoDao.alterar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void removerProjeto(Projeto pojo) throws ParametroInvalidoException{
        try {
             projetoDao.remover(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TimeSheetVO> getListaTimeSheetVO(Date dataInicio, Date dataFim) throws ParametroInvalidoException{
        try {
            return timeSheetDao.getListaTimeSheetVO(dataInicio, dataFim);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<ProdutoServico> getProdutoServicoPeloCodigoMetodologia(Integer codigo) throws ParametroInvalidoException{
    	try {
    		return produtoServicoDao.getProdutoServicoPeloCodigoMetodologia(codigo);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

}