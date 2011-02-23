package br.com.dba.timesheet.ejb;

import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;

import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.dao.AtividadeDao;
import br.com.dba.timesheet.pojo.dao.ClienteDao;
import br.com.dba.timesheet.pojo.dao.FuncionarioDao;
import br.com.dba.timesheet.pojo.dao.MetodologiaDao;
import br.com.dba.timesheet.pojo.dao.OPDao;
import br.com.dba.timesheet.pojo.dao.Produto_ServicoDao;
import br.com.dba.timesheet.pojo.dao.ProjetoDao;
import br.com.dba.timesheet.pojo.dao.TimesheetDaoFactory;
import br.com.dba.timesheet.pojo.dao.Tipo_AtividadeDao;
import br.com.dba.timesheet.servicos.Timesheet;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;


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
	private Produto_ServicoDao produto_ServicoDao;
	private ProjetoDao projetoDao;
	private Tipo_AtividadeDao tipo_AtividadeDao;
	
	/**
     * @ejb.create-method view-type = "remote"  
     */
	public void ejbCreate() throws CreateException {
		atividadeDao = TimesheetDaoFactory.getInstance().getAtividadeDao();		
		clienteDao = TimesheetDaoFactory.getInstance().getClienteDao();		
		funcionarioDao = TimesheetDaoFactory.getInstance().getFuncionarioDao();		
		metodologiaDao = TimesheetDaoFactory.getInstance().getMetodologiaDao();		
		opDao = TimesheetDaoFactory.getInstance().getOPDao();		
		produto_ServicoDao = TimesheetDaoFactory.getInstance().getProduto_ServicoDao();		
		projetoDao = TimesheetDaoFactory.getInstance().getProjetoDao();		
		tipo_AtividadeDao = TimesheetDaoFactory.getInstance().getTipo_AtividadeDao();		
	}
	
	
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    public List<Tipo_AtividadeVO> listarTodosTipoAtividades() throws ParametroInvalidoException{
        try {
        	return tipo_AtividadeDao.listarTodos();
        } catch (DAOException e) {
			throw new ErroInternoException(e.getMessage(),e.getCause());
		}
	}

}