package br.com.dba.timesheet.pojo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.HistoricoTimeSheet;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class HistoricoTimeSheetDao extends AbstractHibernateDAO<HistoricoTimeSheet, Integer> {

	protected HistoricoTimeSheetDao(SessionFactory sf) {
		super(sf);
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<HistoricoTimeSheet> doGetClass() {
		return HistoricoTimeSheet.class;
	}
	
    @SuppressWarnings("unchecked")
	public List<HistoricoTimeSheet> getHistoricoPeloCodigoTimeSheet(Integer codigo)throws ParametroInvalidoException, DAOException{
        Criteria query = getSession().createCriteria(HistoricoTimeSheet.class);
        query.add(Restrictions.eq("codigoTimeSheet", codigo));
        
        List resultado = query.list();
        
        return resultado != null && !resultado.isEmpty() ? resultado:null;
	}

	@SuppressWarnings({ "unchecked" })
	public List<HistoricoTimeSheet> getHistoricoPelaDataOperacao(Date data)throws ParametroInvalidoException, DAOException{
	    Criteria query = getSession().createCriteria(HistoricoTimeSheet.class);
	    query.add(Restrictions.eq("dataOperacao", data));
	    
	    List resultado = query.list();
	    
	    return resultado != null && !resultado.isEmpty() ? resultado:null;
	}
    
}