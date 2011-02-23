package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Funcionalidade;
import br.com.dba.timesheet.pojo.conversor.FuncionalidadeConversor;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.vo.FuncionalidadeVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author F�bio Oliveira de Pinho
 * @version 1.0
 */
public class FuncionalidadeDao extends AbstractHibernateDAO<Funcionalidade, FuncionalidadeVO, Integer> {

	protected FuncionalidadeDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Funcionalidade, FuncionalidadeVO> getConversor() {
		return new FuncionalidadeConversor();
	}

	/**
	 * Obt�m o class da entidade que est� associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Funcionalidade> doGetClass() {
		return Funcionalidade.class;
	}
    
}