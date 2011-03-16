package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

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
    
}