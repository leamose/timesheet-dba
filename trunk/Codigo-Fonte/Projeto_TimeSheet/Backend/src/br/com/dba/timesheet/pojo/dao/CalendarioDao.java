package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Calendario;
import br.com.dba.timesheet.pojo.conversor.CalendarioConversor;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.vo.CalendarioVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class CalendarioDao extends AbstractHibernateDAO<Calendario, CalendarioVO, Integer> {

	protected CalendarioDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Calendario, CalendarioVO> getConversor() {
		return new CalendarioConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Calendario> doGetClass() {
		return Calendario.class;
	}
    
}