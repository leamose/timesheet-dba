package br.com.dba.timesheet.pojo.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Configuracao;
import br.com.dba.timesheet.pojo.TotalHorasMes;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class TotalHorasMesDao extends AbstractHibernateDAO<TotalHorasMes, Integer> {

	protected TotalHorasMesDao(SessionFactory sf) {
		super(sf);
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<TotalHorasMes> doGetClass() {
		return TotalHorasMes.class;
	}
	
	
	public TotalHorasMes consultaTotalHorasMesPorAnoMes(String anoMes)throws ParametroInvalidoException, DAOException{
		Criteria query = getSession().createCriteria(TotalHorasMes.class);
        query.add(Restrictions.eq("id", anoMes));
        
        TotalHorasMes resultado = (TotalHorasMes) query.uniqueResult();
        
        return resultado != null ? resultado:null;
    }
    
}