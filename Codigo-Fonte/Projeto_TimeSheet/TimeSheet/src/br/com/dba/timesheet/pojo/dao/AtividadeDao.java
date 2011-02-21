package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.Atividade;
import br.com.dba.timesheet.pojo.conversor.AtividadeConversor;
import br.com.dba.timesheet.vo.AtividadeVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

public class AtividadeDao extends AbstractHibernateDAO<Atividade, AtividadeVO, Integer> {

	protected AtividadeDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Atividade, AtividadeVO> getConversor() {
		return new AtividadeConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Atividade> doGetClass() {
		return Atividade.class;
	}
    
}