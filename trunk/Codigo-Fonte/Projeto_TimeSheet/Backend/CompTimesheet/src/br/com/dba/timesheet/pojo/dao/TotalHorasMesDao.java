package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.TotalHorasMes;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */
public class TotalHorasMesDao extends AbstractHibernateDAO<TotalHorasMes, Integer> {

	protected TotalHorasMesDao(SessionFactory sf) {
		super(sf);
	}

	/**
	 * Obt�m o class da entidade que est� associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<TotalHorasMes> doGetClass() {
		return TotalHorasMes.class;
	}
    
}