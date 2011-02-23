package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.pojo.conversor.MetodologiaConversor;
import br.com.dba.timesheet.vo.MetodologiaVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class MetodologiaDao extends AbstractHibernateDAO<Metodologia, MetodologiaVO, Integer> {

	protected MetodologiaDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Metodologia, MetodologiaVO> getConversor() {
		return new MetodologiaConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Metodologia> doGetClass() {
		return Metodologia.class;
	}
    
}