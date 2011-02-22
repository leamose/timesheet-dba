package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.Projeto;
import br.com.dba.timesheet.pojo.conversor.ProjetoConversor;
import br.com.dba.timesheet.vo.ProjetoVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

public class ProjetoDao extends AbstractHibernateDAO<Projeto, ProjetoVO, Integer> {

	protected ProjetoDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Projeto, ProjetoVO> getConversor() {
		return new ProjetoConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Projeto> doGetClass() {
		return Projeto.class;
	}
    
}