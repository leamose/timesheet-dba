package br.com.dba.timesheet.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;

import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.RegistroJaCadastradoException;
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
import br.com.dba.timesheet.pojo.SituacaoAtividade;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.TipoAtividade;
import br.com.dba.timesheet.pojo.TotalHorasMes;
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
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.servicos.Timesheet;
import br.com.dba.timesheet.util.StringUtil;
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
     * @throws InvalidaException 
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
    public List<TimeSheet> listarTodosTimeSheetOrdenadoPorDataHoraInicio() throws ParametroInvalidoException{
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
    public List<TimeSheet> consultarTimeSheetPorDataHoraInicio(Date dataInicio, Date dataFim) throws ParametroInvalidoException{
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
     * @throws RegistroJaCadastradoException 
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public TimeSheet salvarTimeSheet(TimeSheet pojo) throws ParametroInvalidoException, RegistroJaCadastradoException{
        try {
        	
        	
        	if(pojo != null && UtilDate.data1MaiorQueData2(pojo.getDataHoraInicio(), pojo.getDataHoraFim()) == 1){
        		throw new ParametroInvalidoException("Hora final não pode ser menor que a hora inicial.");
        	}

        	if(pojo != null && UtilDate.diferencaEmMinutos(pojo.getDataHoraFim(), pojo.getDataHoraInicio()) == 0){
        		throw new ParametroInvalidoException("Hora final não pode ser a mesma que a hora inicial.");
        	}
        	
        	if(verificaAtividadeJaCadastrada(pojo)){
        		throw new RegistroJaCadastradoException();
        	}
        	
            return timeSheetDao.salvar(pojo);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @throws RegistroJaCadastradoException 
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
	public boolean verificaAtividadeJaCadastrada(TimeSheet pojo)
			throws ParametroInvalidoException {
		List<TimeSheetVO> timeSheet = timeSheetDao.getListaTimeSheet(pojo.getDataHoraInicio(), pojo.getDataHoraFim(), pojo.getFuncionario().getId());
		return !timeSheet.isEmpty();
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
    public void removerHistoricoTimeSheet(HistoricoTimeSheet pojo) throws ParametroInvalidoException{
        try {
        	
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
    public List<Configuracao> listarTodosConfiguracao() throws ParametroInvalidoException{
        try {
        	
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
    public List<Funcionario> consultaFuncionariosPeloCodigoFuncionarioChefe(Integer codigoFuncionarioChefe) throws ParametroInvalidoException{
        try {
        	
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
    public AvaliacaoAtividade getAvaliacaoAtividade(Integer id) throws ParametroInvalidoException{
    	try {
    		
    		return avaliacaoAtividadeDao.get(id);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public AvaliacaoAtividade getAvaliacaoAtividadePeloCodigoTimeSheet(Integer codigoTimesheet) throws ParametroInvalidoException{
    	try {
    		
    		return avaliacaoAtividadeDao.getAvaliacaoAtividadePeloCodigoTimeSheet(codigoTimesheet);
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
    public List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(Integer codigo) throws ParametroInvalidoException{
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
    public List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(Date data) throws ParametroInvalidoException{
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
    public void alterarTotalHorasMes(TotalHorasMes pojo) throws ParametroInvalidoException{
        try {
        	
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
    public void alterarConfiguracao(Configuracao pojo) throws ParametroInvalidoException{
        try {
        	
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
    public List<TimeSheetVO> getListaTimeSheetVO(Date dataInicio, Date dataFim, Integer codigoFuncionario) throws ParametroInvalidoException{
        try {
        	
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
    public TimeSheetVO getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(Integer codigoTimeSheet) throws ParametroInvalidoException{
    	try {
    		
    		return timeSheetDao.getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(codigoTimeSheet);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<TimeSheetVO> getListaTimeSheetVOPeloMesAno(String mes, String ano, Integer codigoFuncionario) throws ParametroInvalidoException{
        try {
        	
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
    public List<HorasAtividadeVO> getListaHorasAtividadeVO(Date data, Integer codigoFuncionario) throws ParametroInvalidoException{
        try {
        	
    		return montaListaHorasAtividade(timeSheetDao.getListaHorasAtividadeVO(UtilDate.getAno(data), UtilDate.getMes(data), codigoFuncionario));
    		
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<HorasAtividadeVO> getTotalHorasTrabalhadas(Integer ano, Integer mes, Integer codigofuncionario) throws ParametroInvalidoException{
    	try {
    		
    		return timeSheetDao.getTotalHorasTrabalhadas(ano, mes, codigofuncionario);
    		
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }
    
    /**
     * Monta uma lista com as horas preenchidas e completa com os dias que tem Atividade.
     * @param listaHorasAtividadeVOs
     * @return
     */
    private List<HorasAtividadeVO> montaListaHorasAtividade(List<HorasAtividadeVO> listaHorasAtividadeVOs) {
		
		HashMap<Integer, HorasAtividadeVO> mapa = new HashMap<Integer, HorasAtividadeVO>();
		
		HorasAtividadeVO novaAtividade = new HorasAtividadeVO();
		
		for (int i = 0; i < listaHorasAtividadeVOs.size(); i++) {
			HorasAtividadeVO vo = listaHorasAtividadeVOs.get(i);
			mapa.put(vo.getDia(), vo);
		}
		
		for (int dia = 1; dia <= UtilDate.getDiaMaximoDoMes(UtilDate.getDataAtual()); dia++) {
			
			HorasAtividadeVO vo = mapa.get(dia);
			
			//verifica se ja existe o dia no MAPA, senao cria um objeto VO para completar a lista.
			if(vo == null || dia != vo.getDia().intValue()){
				novaAtividade = new HorasAtividadeVO();
				novaAtividade.setDia(dia);
				novaAtividade.setHorasTrabalhadas("00:00");						
				novaAtividade.setIndicaSaldoDevedor(true);
				novaAtividade.setSaldoDiario("08:00");		

				listaHorasAtividadeVOs.add(novaAtividade);
			}
						
		}
		
		
		ordernarListaHorasAtividadesVO(listaHorasAtividadeVOs);
		
		List<HorasAtividadeVO> novaListaHoras = new ArrayList<HorasAtividadeVO>();
		String saldoAcumulado = "";
		int contador = 0;
		boolean primeiroDiaDevedor = false;
		boolean horaNegativa = false;
		
		for (int i = 0; i < listaHorasAtividadeVOs.size(); i++) {			
			HorasAtividadeVO horasAtividadeVO = listaHorasAtividadeVOs.get(i);
			
			if(i<listaHorasAtividadeVOs.size()){
				if(i>0){
					HorasAtividadeVO horasAtividadeProximo = listaHorasAtividadeVOs.get(contador + i);				

					if(primeiroDiaDevedor || horasAtividadeProximo.getIndicaSaldoDevedor()||horaNegativa){
						if(horaNegativa&&horasAtividadeProximo.getIndicaSaldoDevedor()){
							saldoAcumulado = UtilDate.somarHoras(saldoAcumulado, 
									horasAtividadeProximo.getSaldoDiario());
							
							horaNegativa = true;
							horasAtividadeVO.setIndicaSaldoAcumuladoDevedor(horaNegativa);							
						}else if(UtilDate.horaNegativa(horasAtividadeProximo.getSaldoDiario(), saldoAcumulado)){
							saldoAcumulado = UtilDate.subtrairHoras(saldoAcumulado, 
										horasAtividadeProximo.getSaldoDiario());
							horaNegativa = UtilDate.horaNegativa(horasAtividadeProximo.getSaldoDiario(), saldoAcumulado);
							horasAtividadeVO.setIndicaSaldoAcumuladoDevedor(horaNegativa);
						}else{
							saldoAcumulado = UtilDate.subtrairHoras(horasAtividadeProximo.getSaldoDiario(), 
										saldoAcumulado);							
							horaNegativa = UtilDate.horaNegativa(horasAtividadeProximo.getSaldoDiario(), saldoAcumulado);
							horasAtividadeVO.setIndicaSaldoAcumuladoDevedor(horaNegativa);
						}
						
						primeiroDiaDevedor = false;
					}else{						
						saldoAcumulado = UtilDate.somarHoras(saldoAcumulado, 
								horasAtividadeProximo.getSaldoDiario());
						
						horaNegativa = UtilDate.horaNegativa(horasAtividadeProximo.getSaldoDiario(), saldoAcumulado);
						horasAtividadeVO.setIndicaSaldoAcumuladoDevedor(horaNegativa);
					}
					
					horasAtividadeVO.setSaldoAcumulado(saldoAcumulado);
				}else{
					
					if(horasAtividadeVO.getIndicaSaldoDevedor()){
						primeiroDiaDevedor = true;
						horaNegativa = primeiroDiaDevedor;
						horasAtividadeVO.setIndicaSaldoAcumuladoDevedor(primeiroDiaDevedor);
					}
					
					saldoAcumulado = horasAtividadeVO.getSaldoDiario();
					horasAtividadeVO.setSaldoAcumulado(saldoAcumulado);
				}
				
			}
			
			novaListaHoras.add(horasAtividadeVO);

		}
		
		
		return novaListaHoras;
	}

    /**
     * Ordena a lista pelo dia.  
     * @param listaNova
     */
	private void ordernarListaHorasAtividadesVO(List<HorasAtividadeVO> listaNova) {
		Collections.sort(listaNova, new Comparator<HorasAtividadeVO>() {  
		    public int compare(HorasAtividadeVO p1, HorasAtividadeVO p2) {
		        return p1.getDia().compareTo(p2.getDia());
		    }   
		});
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
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    public Configuracao consultaConfiguracaoPorAnoMes(String ano, String mes)throws ParametroInvalidoException, DAOException{
    	 try {
         	
    		 String anoMes = "";
    		 
    		if(StringUtil.isNotEmpty(ano) && StringUtil.isNotEmpty(mes)){
    			anoMes = ano.concat(mes);
    		} 
    		 
     		return configuracaoDao.consultaConfiguracaoPorAnoMes(anoMes);
     	} catch (DAOException e) {
     		throw new ErroInternoException(e.getMessage(),e.getCause());
     	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    public TotalHorasMes consultaTotalHorasMesPorAnoMes(String ano, String mes)throws ParametroInvalidoException, DAOException{
    	try {
    		
    		String anoMes = "";
    		
    		if(StringUtil.isNotEmpty(ano) && StringUtil.isNotEmpty(mes)){
    			anoMes = ano.concat(mes);
    		} 
    		
    		return totalHorasMesDao.consultaTotalHorasMesPorAnoMes(anoMes);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }
    
}