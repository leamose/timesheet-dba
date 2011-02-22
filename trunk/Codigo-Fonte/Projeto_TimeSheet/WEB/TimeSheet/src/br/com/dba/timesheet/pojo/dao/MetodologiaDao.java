package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.Metodologia;
import br.com.dba.timesheet.pojo.conversor.MetodologiaConversor;
import br.com.dba.timesheet.vo.MetodologiaVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

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