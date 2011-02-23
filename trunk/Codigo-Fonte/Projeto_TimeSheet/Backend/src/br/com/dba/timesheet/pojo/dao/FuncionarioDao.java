package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.conversor.Conversor;
import br.com.dba.timesheet.pojo.conversor.FuncionarioConversor;
import br.com.dba.timesheet.vo.FuncionarioVO;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class FuncionarioDao extends AbstractHibernateDAO<Funcionario, FuncionarioVO, Integer> {

	protected FuncionarioDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Funcionario, FuncionarioVO> getConversor() {
		return new FuncionarioConversor();
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