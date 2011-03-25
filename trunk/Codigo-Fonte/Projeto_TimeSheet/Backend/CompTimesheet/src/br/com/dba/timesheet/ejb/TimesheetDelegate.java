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
	public List<TipoAtividade> listarTodosTipoAtividades()throws ParametroInvalidoException {		
		try {
			return facade.listarTodosTipoAtividades();
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}

    @SuppressWarnings("deprecation")
    public TimeSheet salvarTimeSheet(TimeSheet pojo)
            throws ParametroInvalidoException {
        try {
            return facade.salvarTimeSheet(pojo);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public void alterarTimeSheet(TimeSheet pojo)
            throws ParametroInvalidoException {
        try {
            facade.alterarTimeSheet(pojo);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
        
    }

    @SuppressWarnings("deprecation")
    public void removerTimeSheet(TimeSheet pojo)
            throws ParametroInvalidoException {
        try {
            facade.removerTimeSheet(pojo);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
        
    }
    
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<TimeSheet> listarTodosTimeSheet()
            throws ParametroInvalidoException {
        try {
            return facade.listarTodosTimeSheet();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Cliente> listarTodosCliente()
            throws ParametroInvalidoException {
        try {
            return facade.listarTodosCliente();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public Cliente getCliente(Integer id) throws ParametroInvalidoException {
        try {
            return facade.getCliente(id);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }       
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Atividade> listarTodosAtividades()
            throws ParametroInvalidoException {
        try {
            return facade.listarTodosAtividades();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }      
    }

    @SuppressWarnings("deprecation")
    public Atividade getAtividade(Integer id)
            throws ParametroInvalidoException {
        try {
            return facade.getAtividade(id);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }      
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<OP> listarTodasOPs() throws ParametroInvalidoException {
        try {
            return facade.listarTodasOPs();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<Metodologia> listarTodasMetodologias()
            throws ParametroInvalidoException {
        try {
            return facade.listarTodasMetodologias();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public OP getOP(Integer id) throws ParametroInvalidoException {
        try {
            return facade.getOP(id);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }    
    }

    @SuppressWarnings("deprecation")
    public Metodologia getMetodologia(Integer id)
            throws ParametroInvalidoException {
        try {
            return facade.getMetodologia(id);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }    
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<ProdutoServico> listarTodosProdutoServico()
            throws ParametroInvalidoException {
        try {
            return facade.listarTodosProdutoServico();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<ProdutoServico> consultarProdutoServicoPeloCodigoMetodologia(
            Integer codigo) throws ParametroInvalidoException {
        try {
            return facade.consultarProdutoServicoPeloCodigoMetodologia(codigo);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public ProdutoServico getProdutoServico(Integer id)
            throws ParametroInvalidoException {
        try {
            return facade.getProdutoServico(id);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public Projeto salvarProjeto(Projeto pojo)
            throws ParametroInvalidoException {
        try {
            return facade.salvarProjeto(pojo);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("deprecation")
    public void alterarProjeto(Projeto pojo) throws ParametroInvalidoException {
        try {
            facade.alterarProjeto(pojo);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
        
    }

    @SuppressWarnings("deprecation")
    public void removerProjeto(Projeto pojo) throws ParametroInvalidoException {
        try {
             facade.removerProjeto(pojo);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }        
    }

    @SuppressWarnings({ "deprecation" })
    public Funcionario getFuncionario(Integer id)
            throws ParametroInvalidoException {
        try {
            return facade.getFuncionario(id);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation" })
    public TimeSheet getTimeSheet(Integer id) throws ParametroInvalidoException {
       try {
            return facade.getTimeSheet(id);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(
            Integer codigo) throws ParametroInvalidoException {
        try {
            return facade.getHistoricoPeloCodigoTimeSheet(codigo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation" })
    public HistoricoTimeSheet getHistoricoTimeSheet(Integer id)
            throws ParametroInvalidoException {
        try {
            return facade.getHistoricoTimeSheet(id);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation" })
    public Usuario getUsuario(Integer id) throws ParametroInvalidoException {
        try {
            return facade.getUsuario(id);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings({ "deprecation" })
    public HistoricoTimeSheet salvarHistoricoTimeSheet(HistoricoTimeSheet pojo)
            throws ParametroInvalidoException {
       try {
            return facade.salvarHistoricoTimeSheet(pojo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    public List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(
            Date data) throws ParametroInvalidoException {
//        try {
//            return facade.getHistoricoPelaDataOperacao(data );
//       } catch (RemoteException e) {           
//           throw new ErroInternoException(e.getMessage(), e);
//       }
        return null;
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<TimeSheet> listarTodosTimeSheetOrdenadoPorDataHoraInicio()
            throws ParametroInvalidoException {
        try {
            return facade.listarTodosTimeSheetOrdenadoPorDataHoraInicio();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<TimeSheet> consultarTimeSheetPorDataHoraInicio(
            Date dataInicio, Date dataFim) throws ParametroInvalidoException {
        try {
            return facade.consultarTimeSheetPorDataHoraInicio(dataInicio, dataFim);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<SituacaoAtividade> listarTodasSituacaoAtividade()
            throws ParametroInvalidoException {
        try {
            return facade.listarTodasSituacaoAtividade();
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }   
    }

    @SuppressWarnings({ "deprecation" })
    public SituacaoAtividade getSituacaoAtividade(Integer id)
            throws ParametroInvalidoException {
        try {
            return facade.getSituacaoAtividade(id);
        } catch (RemoteException e) {           
            throw new ErroInternoException(e.getMessage(), e);
        }
    }

    @SuppressWarnings({ "deprecation" })
    public SituacaoAtividade salvarSituacaoAtividade(SituacaoAtividade pojo)
            throws ParametroInvalidoException {
       try {
            return facade.salvarSituacaoAtividade(pojo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings("deprecation")
    public AvaliacaoAtividade salvarAvaliacaoAtividade(AvaliacaoAtividade pojo)
            throws ParametroInvalidoException {
       try {
            return facade.salvarAvaliacaoAtividade(pojo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

    @SuppressWarnings("deprecation")
    public void alterarAvaliacaoAtividade(AvaliacaoAtividade pojo)
            throws ParametroInvalidoException {
        try {
            facade.alterarAvaliacaoAtividade(pojo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
        
    }

    @SuppressWarnings("deprecation")
    public void removerAvaliacaoAtividade(AvaliacaoAtividade pojo)
            throws ParametroInvalidoException {
        try {
            facade.removerAvaliacaoAtividade(pojo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
        
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<TimeSheetVO> getListaTimeSheetVO(Date dataInicio, Date dataFim, Integer codigoFuncionario)
            throws ParametroInvalidoException {
        try {
            return facade.getListaTimeSheetVO(dataInicio, dataFim, codigoFuncionario);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
    }

	/* (non-Javadoc)
	 * @see br.com.dba.timesheet.servicos.Timesheet#getProdutoServicoPeloCodigoMetodologia(java.lang.Integer)
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ProdutoServico> getProdutoServicoPeloCodigoMetodologia(Integer codigo) throws ParametroInvalidoException {
		try {
            return facade.getProdutoServicoPeloCodigoMetodologia(codigo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Usuario> consultarUsuario(Usuario pojo)
			throws ParametroInvalidoException {		
	   try {
            return facade.consultarUsuario(pojo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
	}

	@SuppressWarnings("deprecation")
	public Usuario getUsuario(Usuario pojo) throws ParametroInvalidoException {
		try {
            return facade.getUsuario(pojo);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
	}

	@SuppressWarnings("deprecation")
	public void alterarUsuario(Usuario pojo) throws ParametroInvalidoException {
		try {
            facade.alterarUsuario(pojo);
	   } catch (RemoteException e) {           
	       throw new ErroInternoException(e.getMessage(), e);
	   }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<HorasAtividadeVO> getListaHorasAtividadeVO(Date data, Integer codigoFuncionario)
			throws ParametroInvalidoException {
	   try {
            return facade.getListaHorasAtividadeVO(data, codigoFuncionario);
       } catch (RemoteException e) {           
           throw new ErroInternoException(e.getMessage(), e);
       }
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Funcionario> consultaFuncionariosPeloCodigoFuncionarioChefe(
			Integer id) throws ParametroInvalidoException {
		 try {
	           return facade.consultaFuncionariosPeloCodigoFuncionarioChefe(id);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
	}

	public List<TimeSheetVO> getListaTimeSheetVOPeloMesAno(String mes,
			String ano, Integer codigoFuncionario)
			throws ParametroInvalidoException {
		 try {
	           return facade.getListaTimeSheetVOPeloMesAno(mes, ano, codigoFuncionario);
	     } catch (RemoteException e) {           
	           throw new ErroInternoException(e.getMessage(), e);
	     }
	}
	
}