package br.com.dba.timesheet.pojo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.Configuracao;
import br.com.dba.timesheet.pojo.TimeSheet;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class ConfiguracaoDao extends AbstractHibernateDAO<Configuracao, Integer> {

	protected ConfiguracaoDao(SessionFactory sf) {
		super(sf);
	}
	

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Configuracao> doGetClass() {
		return Configuracao.class;
	}
	
    public Configuracao consultaConfiguracaoPorAnoMes(String anoMes)throws ParametroInvalidoException, DAOException{
		Criteria query = getSession().createCriteria(Configuracao.class);
        query.add(Restrictions.like("anoMes", anoMes));
        
        Configuracao resultado = (Configuracao) query.uniqueResult();
        
        return resultado != null ? resultado:null;
    }
    
}