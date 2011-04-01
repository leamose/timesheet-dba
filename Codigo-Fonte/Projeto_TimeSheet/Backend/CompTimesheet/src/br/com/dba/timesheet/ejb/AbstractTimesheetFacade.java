package br.com.dba.timesheet.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;

import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.IdentificadorSenhaIncorretosException;
import br.com.dba.timesheet.exceptions.LogonBloqueadoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.exceptions.UsuarioNaoEncontradoException;
import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.Configuracao;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.ProdutoServico;
import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.TipoAtividade;
import br.com.dba.timesheet.pojo.TotalHorasMes;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.dao.AtividadeDao;
import br.com.dba.timesheet.pojo.dao.AvaliacaoAtividadeDao;
import br.com.dba.timesheet.pojo.dao.ClienteDao;
import br.com.dba.timesheet.pojo.dao.ConfiguracaoDao;
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
import br.com.dba.timesheet.pojo.dao.TotalHorasMesDao;
import br.com.dba.timesheet.pojo.dao.UsuarioDao;
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.servicos.Timesheet;
import br.com.dba.timesheet.util.UtilDate;


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
	
	private SegurancaFacadeHelper segurancaHelper;
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
	private SituacaoAtividadeDao situacaoAtividadeDao;
	private AvaliacaoAtividadeDao avaliacaoAtividadeDao;
	private TotalHorasMesDao totalHorasMesDao;
	private ConfiguracaoDao configuracaoDao;
	
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
		situacaoAtividadeDao = TimesheetDaoFactory.getInstance().getSituacaoAtividadeDao();		
		avaliacaoAtividadeDao = TimesheetDaoFactory.getInstance().getAvaliacaoAtividadeDao();		
		totalHorasMesDao = TimesheetDaoFactory.getInstance().getTotalHorasMesDao();		
		configuracaoDao = TimesheetDaoFactory.getInstance().getConfiguracaoDao();		
		segurancaHelper = SegurancaFacadeHelper.getInstancia();
	}
	
	/**
     * @throws SessaoInvalidaException 
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TipoAtividade> listarTodosTipoAtividades(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<ProdutoServico> listarTodosProdutoServico(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<OP> listarTodasOPs(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<Metodologia> listarTodasMetodologias(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<Cliente> listarTodosCliente(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<TimeSheet> listarTodosTimeSheet(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<SituacaoAtividade> listarTodasSituacaoAtividade(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<TimeSheet> listarTodosTimeSheetOrdenadoPorDataHoraInicio(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<TimeSheet> consultarTimeSheetPorDataHoraInicio(Date dataInicio, Date dataFim, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<Atividade> listarTodosAtividades(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public TimeSheet salvarTimeSheet(TimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public SituacaoAtividade salvarSituacaoAtividade(SituacaoAtividade pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public AvaliacaoAtividade salvarAvaliacaoAtividade(AvaliacaoAtividade pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public void alterarAvaliacaoAtividade(AvaliacaoAtividade pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public void removerAvaliacaoAtividade(AvaliacaoAtividade pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public HistoricoTimeSheet salvarHistoricoTimeSheet(HistoricoTimeSheet pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public void alterarTimeSheet(TimeSheet pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public void removerTimeSheet(TimeSheet pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
        	if(pojo!=null){
        		timeSheetDao.remover(pojo);
        	}
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void removerHistoricoTimeSheet(HistoricoTimeSheet pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		if(pojo!=null){
    			historicoTimeSheetDao.remover(pojo);
    		}
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<ProdutoServico> consultarProdutoServicoPeloCodigoMetodologia(Integer codigo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public SituacaoAtividade getSituacaoAtividade(Integer id, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<Configuracao> listarTodosConfiguracao(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		return configuracaoDao.listarTodos();
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Funcionario getFuncionario(Integer id, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<Funcionario> consultaFuncionariosPeloCodigoFuncionarioChefe(Integer codigoFuncionarioChefe,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		return funcionarioDao.consultaFuncionariosPeloCodigoFuncionarioChefe(codigoFuncionarioChefe);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Cliente getCliente(Integer id, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public Atividade getAtividade(Integer id, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public OP getOP(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public Metodologia getMetodologia(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public ProdutoServico getProdutoServico(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public TimeSheet getTimeSheet(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public HistoricoTimeSheet getHistoricoTimeSheet(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(Date data,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public Projeto salvarProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public void alterarTotalHorasMes(TotalHorasMes pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		totalHorasMesDao.alterar(pojo);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void alterarConfiguracao(Configuracao pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		configuracaoDao.alterar(pojo);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void alterarProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public void removerProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
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
    public List<TimeSheetVO> getListaTimeSheetVO(Date dataInicio, Date dataFim, Integer codigoFuncionario,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
            return timeSheetDao.getListaTimeSheetVO(dataInicio, dataFim, codigoFuncionario);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TimeSheetVO> getListaTimeSheetVOPeloMesAno(String mes, String ano, Integer codigoFuncionario,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		return timeSheetDao.getListaTimeSheetVOPeloMesAno(mes, ano, codigoFuncionario);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<HorasAtividadeVO> getListaHorasAtividadeVO(Date data, Integer codigoFuncionario,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		return timeSheetDao.getListaHorasAtividadeVO(UtilDate.getAno(data), UtilDate.getMes(data), codigoFuncionario);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<ProdutoServico> getProdutoServicoPeloCodigoMetodologia(Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		return produtoServicoDao.getProdutoServicoPeloCodigoMetodologia(codigo);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

}