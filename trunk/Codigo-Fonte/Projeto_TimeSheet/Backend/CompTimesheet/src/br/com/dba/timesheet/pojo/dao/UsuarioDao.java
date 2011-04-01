package br.com.dba.timesheet.pojo.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.dba.dao.hibernate.AbstractHibernateDAO;
import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.UsuarioNaoEncontradoException;
import br.com.dba.timesheet.pojo.TimeSheet;
import br.com.dba.timesheet.pojo.Usuario;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class UsuarioDao extends AbstractHibernateDAO<Usuario, Integer> {

	protected UsuarioDao(SessionFactory sf) {
		super(sf);
	}

	/**
	 * Obtém o class da entidade que está associada a Dao
	 * 
	 * @return retorna o class obtido. 
	 */
	public Class<Usuario> doGetClass() {
		return Usuario.class;
	}
	
	public Usuario consultarPorLogin(String login)
		throws DAOException, UsuarioNaoEncontradoException {
		
		List retorno = null;
		
		Criteria query = getSession().createCriteria(Usuario.class);
        query.add(Restrictions.like("login", login));
	    
        retorno = query.list();
        
		if (retorno.size() > 0) {
			return (Usuario)retorno.get(0);
		}
		else { 
			throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
		}
	}
    
}