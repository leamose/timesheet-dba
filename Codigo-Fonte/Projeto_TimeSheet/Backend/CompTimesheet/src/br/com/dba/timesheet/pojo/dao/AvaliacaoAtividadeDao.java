package br.com.dba.timesheet.pojo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.AvaliacaoAtividade;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class AvaliacaoAtividadeDao extends AbstractHibernateDAO<AvaliacaoAtividade, Integer> {

	protected AvaliacaoAtividadeDao(SessionFactory sf) {
		super(sf);
	}	

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<AvaliacaoAtividade> doGetClass() {
		return AvaliacaoAtividade.class;
	}

	public AvaliacaoAtividade getAvaliacaoAtividadePeloCodigoTimeSheet(
			Integer codigoTimesheet)throws ParametroInvalidoException, DAOException {
		
		Criteria query = getSession().createCriteria(AvaliacaoAtividade.class);
        query.add(Restrictions.eq("timeSheet.id", codigoTimesheet));
        
        List<AvaliacaoAtividade> resultado = query.list();
        
        return resultado != null && !resultado.isEmpty() ? resultado.get(0):null;
	}
    
}