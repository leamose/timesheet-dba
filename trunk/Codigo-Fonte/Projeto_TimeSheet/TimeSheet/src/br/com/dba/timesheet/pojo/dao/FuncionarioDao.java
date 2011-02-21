package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.Funcionario;
import br.com.dba.timesheet.pojo.conversor.FuncionarioConversor;
import br.com.dba.timesheet.vo.FuncionarioVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

public class FuncionarioDao extends AbstractHibernateDAO<Funcionario, FuncionarioVO, Integer> {

	protected FuncionarioDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Funcionario, FuncionarioVO> getConversor() {
		return new FuncionarioConversor();
	}

	/**
	 * Obt�m o class da entidade que est� associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Funcionario> doGetClass() {
		return Funcionario.class;
	}
    
}