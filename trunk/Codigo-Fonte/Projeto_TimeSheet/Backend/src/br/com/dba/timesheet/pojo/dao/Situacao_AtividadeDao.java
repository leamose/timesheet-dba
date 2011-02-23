package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Situacao_Atividade;
import br.com.dba.timesheet.pojo.conversor.Situacao_AtividadeConversor;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.vo.Situacao_AtividadeVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class Situacao_AtividadeDao extends AbstractHibernateDAO<Situacao_Atividade, Situacao_AtividadeVO, Integer> {

	protected Situacao_AtividadeDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Situacao_Atividade, Situacao_AtividadeVO> getConversor() {
		return new Situacao_AtividadeConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Situacao_Atividade> doGetClass() {
		return Situacao_Atividade.class;
	}
    
}