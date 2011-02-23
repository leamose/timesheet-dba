package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Tipo_Atividade;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.pojo.conversor.TipoAtividadeConversor;
import br.com.dba.timesheet.vo.Tipo_AtividadeVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */
public class Tipo_AtividadeDao extends AbstractHibernateDAO<Tipo_Atividade, Tipo_AtividadeVO, Integer> {

	protected Tipo_AtividadeDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Tipo_Atividade, Tipo_AtividadeVO> getConversor() {
		return new TipoAtividadeConversor();
	}

	/**
	 * Obt�m o class da entidade que est� associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Tipo_Atividade> doGetClass() {
		return Tipo_Atividade.class;
	}
    
}