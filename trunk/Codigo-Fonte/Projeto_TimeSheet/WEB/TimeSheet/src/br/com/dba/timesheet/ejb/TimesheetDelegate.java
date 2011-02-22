package br.com.dba.timesheet.ejb;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import br.com.dba.timesheet.servicos.Timesheet;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;
import br.gov.mj.core.exception.ParametroInvalidoException;
import br.gov.mj.core.servico.exception.ErroInternoException;



public class TimesheetDelegate implements Timesheet {
	
	private static TimesheetDelegate instancia = null;
	private Properties jndiprops = new Properties();
	private TimesheetFacade facade = null;
	 
	private TimesheetDelegate() {
        
        	try {
				jndiprops.load(this.getClass().getResourceAsStream("/jndi.properties"));
				facade = TimesheetFacadeUtil.getHome(jndiprops).create();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CreateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
	}
	
    public static TimesheetDelegate getInstancia() throws ErroInternoException {
        if (instancia == null) { 
        	instancia = new TimesheetDelegate();
        }
        return instancia;
    }

	@SuppressWarnings("unchecked")
	public List<Tipo_AtividadeVO> listarTodosTipoAtividades()throws ParametroInvalidoException {		
		try {
			return facade.listarTodosTipoAtividades();
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}
	
}