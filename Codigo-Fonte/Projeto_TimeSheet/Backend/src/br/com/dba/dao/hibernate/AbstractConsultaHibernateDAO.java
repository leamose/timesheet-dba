package br.com.dba.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.dba.timesheet.exceptions.DAOException;

/**
 * Class pai para todos as DAOs do hibernate no caso de DAOs que fassam apenas consulta. 
 * Ela utiliza o esquema de sessão do hibernate sendo gerenciado pelo Container, 
 * por esse mótivo não deve ser feito nenhum tipo de commit, rollback 
 * ou fechar a sessão dentro da implementação da DAO, essa atividade sempre será delegada ao 
 * Container de forma automatica.
 * <br>
 * Para isso o hibernate deve ser configurado (hibernate.cfg.xml) para utilizar os paramêtros da 
 * session factory como definido abaixo:
 * <br>
 * <ul>
 * <li>hibernate.transaction.factory_class = org.hibernate.transaction.CMTTransactionFactory</li>
 * <li>hibernate.transaction.manager_lookup_class = org.hibernate.transaction.JBossTransactionManagerLookup</li>
 * <li>hibernate.current_session_context_class = jta</li>
 * <li>jta.UserTransaction = UserTransaction</li>
 * </ul>
 *
 * @author União Federativa do Brasil
 * @author Ministério da Justiça
 * @author CGTI
 * @author Anderson Claiton Fernandes
 * @version 1.0
 */
public abstract class AbstractConsultaHibernateDAO { 

    private SessionFactory sf;

    /**
     * Construtor padrão da DAO. A instância da DAO pressupõe sempre a existência da SessionFactory,
     * pois a DAO sempre utilizará a sessão corrente do hibernate gerenciado pelo Container.
     * 
     * @param sf session factory já "construída" do hibernate.
     */
    protected AbstractConsultaHibernateDAO(SessionFactory sf) {
        if (sf == null) {
            throw new NullPointerException("Session factory não declarada.");
        }
        this.sf = sf;
    }

    /**
     * Retorna a sessão corrente do hibernate. 
     * 
     * @return sessão aberta do hibernate.
     * 
     * @throws DAOException
     */
    protected Session getSession() throws DAOException {
        try {
            return sf.getCurrentSession();
        } catch (HibernateException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
