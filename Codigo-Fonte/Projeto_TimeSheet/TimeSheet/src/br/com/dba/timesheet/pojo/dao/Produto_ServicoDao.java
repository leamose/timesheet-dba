package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;

import br.com.dba.timesheet.pojo.Produto_Servico;
import br.com.dba.timesheet.pojo.conversor.Produto_ServicoConversor;
import br.com.dba.timesheet.vo.Produto_ServicoVO;
import br.gov.mj.core.dao.hibernate.AbstractHibernateDAO;
import br.gov.mj.core.pojo.conversor.Conversor;

public class Produto_ServicoDao extends AbstractHibernateDAO<Produto_Servico, Produto_ServicoVO, Integer> {

	protected Produto_ServicoDao(SessionFactory sf) {
		super(sf);
	}

	@Override
	protected Conversor<Produto_Servico, Produto_ServicoVO> getConversor() {
		return new Produto_ServicoConversor();
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Produto_Servico> doGetClass() {
		return Produto_Servico.class;
	}
    
}