package br.com.dba.timesheet.ejb;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.RegistroJaCadastradoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
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
import br.com.dba.timesheet.pojo.vo.HorasAtividadeVO;
import br.com.dba.timesheet.pojo.vo.TimeSheetVO;
import br.com.dba.timesheet.servicos.Timesheet;

public class TimesheetDelegate implements Timesheet {
	
	private static TimesheetDelegate instancia = null;
	private Properties jndiprops = new Properties();
	private TimesheetFacade facade = null;
	 
	private TimesheetDelegate() {
        
        	try {
				jndiprops.load(this.getClass().getResourceAsStream("/jndi.properties"));
				facade = TimesheetFacadeUtil.getHome(jndiprops).create();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CreateException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}
         
	}
	
    @SuppressWarnings("deprecation")
    public static TimesheetDelegate getInstancia() throws ErroInternoException {
        if (instancia == null) { 
        	instancia = new TimesheetDelegate();
        }
        return instancia;
    }

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<TipoAtividade> listarTodosTipoAtividades(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{		
		try {
			return facade.listarTodosTipoAtividades(sessao);
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}

    @SuppressWarnings("deprecation")
    public TimeSheet salvarTimeSheet(TimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException, RegistroJaCadastradoException{
        try {
            return facade.salvarTimeSheet(pojo,sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public void alterarTimeSheet(TimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            facade.alterarTimeSheet(pojo,sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
        
    }

    @SuppressWarnings("deprecation")
    public void removerTimeSheet(TimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            facade.removerTimeSheet(pojo, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
        
    }
    
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<TimeSheet> listarTodosTimeSheet(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.listarTodosTimeSheet(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Cliente> listarTodosCliente(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException {
        try {
            return facade.listarTodosCliente(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public Cliente getCliente(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getCliente(id, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }       
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Atividade> listarTodosAtividades(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.listarTodosAtividades(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }      
    }

    @SuppressWarnings("deprecation")
    public Atividade getAtividade(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException {
        try {
            return facade.getAtividade(id, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }      
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<OP> listarTodasOPs(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.listarTodasOPs(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<Metodologia> listarTodasMetodologias(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.listarTodasMetodologias(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public OP getOP(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getOP(id, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }    
    }

    @SuppressWarnings("deprecation")
    public Metodologia getMetodologia(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getMetodologia(id, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }    
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<ProdutoServico> listarTodosProdutoServico(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.listarTodosProdutoServico(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<ProdutoServico> consultarProdutoServicoPeloCodigoMetodologia(
            Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.consultarProdutoServicoPeloCodigoMetodologia(codigo, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public ProdutoServico getProdutoServico(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getProdutoServico(id, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public Projeto salvarProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.salvarProjeto(pojo, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public void alterarProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            facade.alterarProjeto(pojo, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
        
    }

    @SuppressWarnings("deprecation")
    public void removerProjeto(Projeto pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
             facade.removerProjeto(pojo, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }        
    }

    @SuppressWarnings({ "deprecation" })
    public Funcionario getFuncionario(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getFuncionario(id, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation" })
    public TimeSheet getTimeSheet(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
       try {
            return facade.getTimeSheet(id, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(
            Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getHistoricoPeloCodigoTimeSheet(codigo, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation" })
    public HistoricoTimeSheet getHistoricoTimeSheet(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getHistoricoTimeSheet(id, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation" })
    public HistoricoTimeSheet salvarHistoricoTimeSheet(HistoricoTimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
       try {
            return facade.salvarHistoricoTimeSheet(pojo, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    public List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(
            Date data,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getHistoricoPelaDataOperacao(data, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<TimeSheet> listarTodosTimeSheetOrdenadoPorDataHoraInicio(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.listarTodosTimeSheetOrdenadoPorDataHoraInicio(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<TimeSheet> consultarTimeSheetPorDataHoraInicio(
            Date dataInicio, Date dataFim,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.consultarTimeSheetPorDataHoraInicio(dataInicio, dataFim, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<SituacaoAtividade> listarTodasSituacaoAtividade(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.listarTodasSituacaoAtividade(sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }   
    }

    @SuppressWarnings({ "deprecation" })
    public SituacaoAtividade getSituacaoAtividade(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getSituacaoAtividade(id, sessao);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation" })
    public SituacaoAtividade salvarSituacaoAtividade(SituacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
       try {
            return facade.salvarSituacaoAtividade(pojo, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings("deprecation")
    public AvaliacaoAtividade salvarAvaliacaoAtividade(AvaliacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
       try {
            return facade.salvarAvaliacaoAtividade(pojo, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings("deprecation")
    public void alterarAvaliacaoAtividade(AvaliacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            facade.alterarAvaliacaoAtividade(pojo, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
        
    }

    @SuppressWarnings("deprecation")
    public void removerAvaliacaoAtividade(AvaliacaoAtividade pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            facade.removerAvaliacaoAtividade(pojo, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
        
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<TimeSheetVO> getListaTimeSheetVO(Date dataInicio, Date dataFim, Integer codigoFuncionario,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
            return facade.getListaTimeSheetVO(dataInicio, dataFim, codigoFuncionario, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ProdutoServico> getProdutoServicoPeloCodigoMetodologia(Integer codigo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
		try {
            return facade.getProdutoServicoPeloCodigoMetodologia(codigo, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<HorasAtividadeVO> getListaHorasAtividadeVO(Date data, Integer codigoFuncionario,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
	   try {
            return facade.getListaHorasAtividadeVO(data, codigoFuncionario, sessao);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Funcionario> consultaFuncionariosPeloCodigoFuncionarioChefe(
			Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
		 try {
	           return facade.consultaFuncionariosPeloCodigoFuncionarioChefe(id, sessao);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<TimeSheetVO> getListaTimeSheetVOPeloMesAno(String mes,
			String ano, Integer codigoFuncionario,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
		 try {
	           return facade.getListaTimeSheetVOPeloMesAno(mes, ano, codigoFuncionario, sessao);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Configuracao> listarTodosConfiguracao(Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
		try {
	           return facade.listarTodosConfiguracao(sessao);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
	}

	@SuppressWarnings("deprecation")
	public void alterarConfiguracao(Configuracao pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
		try {
	           facade.alterarConfiguracao(pojo, sessao);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
	}

	@SuppressWarnings("deprecation")
	public void alterarTotalHorasMes(TotalHorasMes pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
		try {
	           facade.alterarTotalHorasMes(pojo, sessao);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
	}

	public void removerHistoricoTimeSheet(HistoricoTimeSheet pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
		try {
	           facade.removerHistoricoTimeSheet(pojo, sessao);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
		
	}

	public TimeSheetVO getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(
			Integer codigoTimeSheet, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.getTimeSheetEAvaliacaoAtividadePorIdTimeSheet(codigoTimeSheet, sessao);
	    } catch (RemoteException e) {           
	    	throw new ErroInternoException(e.getMessage(), e);
	    }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean verificaAtividadeJaCadastrada(TimeSheet pojo, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.verificaAtividadeJaCadastrada(pojo, sessao);
	    } catch (RemoteException e) {           
	    	throw new ErroInternoException(e.getMessage(), e);
	    }
	}

	@SuppressWarnings({ "deprecation" })
	public AvaliacaoAtividade getAvaliacaoAtividade(Integer id, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.getAvaliacaoAtividade(id, sessao);
	    } catch (RemoteException e) {           
	    	throw new ErroInternoException(e.getMessage(), e);
	    }
	}

	@SuppressWarnings({ "deprecation" })
	public AvaliacaoAtividade getAvaliacaoAtividadePeloCodigoTimeSheet(
			Integer codigoTimesheet, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.getAvaliacaoAtividadePeloCodigoTimeSheet(codigoTimesheet, sessao);
	    } catch (RemoteException e) {           
	    	throw new ErroInternoException(e.getMessage(), e);
	    }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<HorasAtividadeVO> getTotalHorasTrabalhadas(Integer ano, Integer mes, Integer codigofuncionario,Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.getTotalHorasTrabalhadas(ano, mes, codigofuncionario, sessao);
	    } catch (RemoteException e) {           
	    	throw new ErroInternoException(e.getMessage(), e);
	    }
	}

}