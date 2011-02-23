package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.OP;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.pojo.conversor.OPConversor;
import br.com.dba.timesheet.vo.OPVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */
public class OPDao extends AbstractHibernateDAO<OP, OPVO, Integer> {

	protected OPDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<OP, OPVO> getConversor() {
		return new OPConversor();
	}

	/**
	 * Obt�m o class da entidade que est� associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<OP> doGetClass() {
		return OP.class;
	}
    
}