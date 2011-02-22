package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.Cliente;
import br.com.dba.timesheet.pojo.conversor.ClienteConversor;
import br.com.dba.timesheet.vo.ClienteVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

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