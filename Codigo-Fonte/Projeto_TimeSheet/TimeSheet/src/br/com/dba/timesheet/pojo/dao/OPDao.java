package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.conversor.OPConversor;
import br.com.dba.timesheet.vo.OPVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

public class OPDao extends AbstractHibernateDAO<OP, OPVO, Integer> {

	protected OPDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<OP, OPVO> getConversor() {
		return new OPConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<OP> doGetClass() {
		return OP.class;
	}
    
}