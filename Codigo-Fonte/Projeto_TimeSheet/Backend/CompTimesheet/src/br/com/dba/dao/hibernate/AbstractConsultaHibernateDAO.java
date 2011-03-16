package br.com.dba.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.dba.timesheet.exceptions.DAOException;

/**
 * Class pai para todos as DAOs do hibernate no caso de DAOs que fassam apenas consulta. 
 * Ela utiliza o esquema de sess�o do hibernate sendo gerenciado pelo Container, 
 * por esse m�tivo n�o deve ser feito nenhum tipo de commit, rollback 
 * ou fechar a sess�o dentro da implementa��o da DAO, essa atividade sempre ser� delegada ao 
 * Container de forma automatica.
 * <br>
 * Para isso o hibernate deve ser configurado (hibernate.cfg.xml) para utilizar os param�tros da 
 * session factory como definido abaixo:
 * <br>
 * <ul>
 * <li>hibernate.transaction.factory_class = org.hibernate.transaction.CMTTransactionFactory</li>
 * <li>hibernate.transaction.manager_lookup_class = org.hibernate.transaction.JBossTransactionManagerLookup</li>
 * <li>hibernate.current_session_context_class = jta</li>
 * <li>jta.UserTransaction = UserTransaction</li>
 * </ul>
 *
 * @author Uni�o Federativa do Brasil
 * @author Minist�rio da Justi�a
 * @author CGTI
 * @author Anderson Claiton Fernandes
 * @version 1.0
 */
public abstract class AbstractConsultaHibernateDAO { 

    private SessionFactory sf;

    /**
     * Construtor padr�o da DAO. A inst�ncia da DAO pressup�e sempre a exist�ncia da SessionFactory,
     * pois a DAO sempre utilizar� a sess�o corrente do hibernate gerenciado pelo Container.
     * 
     * @param sf session factory j� "constru�da" do hibernate.
     */
    protected AbstractConsultaHibernateDAO(SessionFactory sf) {
        if (sf == null) {
            throw new NullPointerException("Session factory n�o declarada.");
        }
        this.sf = sf;
    }

    /**
     * Retorna a sess�o corrente do hibernate. 
     * 
     * @return sess�o aberta do hibernate.
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
