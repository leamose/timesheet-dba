package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.conversor.ClienteConversor;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.vo.ClienteVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class ClienteDao extends AbstractHibernateDAO<Cliente, ClienteVO, Integer> {

	protected ClienteDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Cliente, ClienteVO> getConversor() {
		return new ClienteConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Cliente> doGetClass() {
		return Cliente.class;
	}
    
}