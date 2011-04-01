package br.com.dba.timesheet.pojo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Funcionario;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class FuncionarioDao extends AbstractHibernateDAO<Funcionario, Integer> {

	protected FuncionarioDao(SessionFactory sf) {
		super(sf);
	}


	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Funcionario> doGetClass() {
		return Funcionario.class;
	}


	@SuppressWarnings("unchecked")
	public List<Funcionario> consultaFuncionariosPeloCodigoFuncionarioChefe(
			Integer codigoFuncionarioChefe) {

		Criteria query = getSession().createCriteria(Funcionario.class);
        query.add(Restrictions.eq("codigoFuncionarioChefe", codigoFuncionarioChefe));
        query.addOrder(Order.asc("nome"));
        
        List resultado = query.list();
        
        return resultado != null && !resultado.isEmpty() ? resultado:null;
	}
    
}