package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Perfil;
import br.com.dba.timesheet.pojo.conversor.PerfilConversor;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.vo.PerfilVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class PerfilDao extends AbstractHibernateDAO<Perfil, PerfilVO, Integer> {

	protected PerfilDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Perfil, PerfilVO> getConversor() {
		return new PerfilConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Perfil> doGetClass() {
		return Perfil.class;
	}
    
}