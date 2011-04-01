package br.com.dba.timesheet.pojo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.pojo.ProdutoServico;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class ProdutoServicoDao extends AbstractHibernateDAO<ProdutoServico, Integer> {

	protected ProdutoServicoDao(SessionFactory sf) {
		super(sf);
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<ProdutoServico> doGetClass() {
		return ProdutoServico.class;
	}
	
	@SuppressWarnings({ "unchecked"})
    public List<ProdutoServico> getProdutoServicoPeloCodigoMetodologia(Integer codigo)throws ParametroInvalidoException, DAOException{
	    Criteria query = getSession().createCriteria(ProdutoServico.class);
	    query.add(Restrictions.eq("metodologia.id", codigo));
	    
	    List resultado = query.list();
	    
	    return resultado != null && !resultado.isEmpty() ? resultado:null;
	    
	}
    
}