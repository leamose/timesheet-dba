package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.Tipo_Atividade;
import br.com.dba.timesheet.pojo.conversor.TipoAtividadeConversor;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

public class Tipo_AtividadeDao extends AbstractHibernateDAO<Tipo_Atividade, Tipo_AtividadeVO, Integer> {

	protected Tipo_AtividadeDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Tipo_Atividade, Tipo_AtividadeVO> getConversor() {
		return new TipoAtividadeConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Tipo_Atividade> doGetClass() {
		return Tipo_Atividade.class;
	}
    
}