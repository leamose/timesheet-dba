package br.com.dba.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.com.dba.timesheet.exceptions.DAOException;

/**
 * Class pai para todos as DAOs do hibernate. Ela utiliza o esquema de sess�o do hibernate sendo 
 * gerenciado pelo Container, por esse m�tivo n�o deve ser feito nenhum tipo de commit, rollback 
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
 * @author Anderson Claiton Fernandes
 * @version 1.0
 */
public abstract class AbstractHibernateDAO <Pojo, Id extends Serializable> { 

    private SessionFactory sf;

    /**
     * Construtor padr�o da DAO. A inst�ncia da DAO pressup�e sempre a exist�ncia da SessionFactory,
     * pois a DAO sempre utilizar� a sess�o corrente do hibernate gerenciado pelo Container.
     * 
     * @param sf session factory j� "constru�da" do hibernate.
     */
    protected AbstractHibernateDAO(SessionFactory sf) {
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

    /**
     * Salva um POJO.
     * 
     * @param pojo pojo a ser salvo.
     * @return pojo salva e serializado pelo hibernate.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public Pojo salvar(Pojo pojo)  throws DAOException {
        try {
            getSession().save(pojo);
            return pojo;
        } catch (HibernateException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Altera um POJO.
     * 
     * @param pojo pojo a ser alterado.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public void alterar(Pojo pojo)  throws DAOException {
        try {
            getSession().saveOrUpdate(pojo);
        } catch (HibernateException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Exclu� um POJO.
     * 
     * @param pojo pojo a ser exclu�do.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public void remover(Pojo pojo) throws DAOException {
        try {
            getSession().delete(doGetClass().getCanonicalName(), pojo);
        } catch (HibernateException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Lista todas os POJOs de um mesmo tipo.
     * 
     * @return lista de POJOs.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public List<Pojo> listarTodos() throws DAOException  {
        try {
            Query query = getSession().createQuery("from " + doGetClass().getCanonicalName());
            return query.list(); 
        } catch (HibernateException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Efetua uma consulta utilizando como param�tro os dados contidos no POJO. A consulta ser� 
     * feita utilizando Criteria.
     * 
     * @param pojo pojo encapsulando os parametros de consulta..
     * @return pojo salva e serializado pelo hibernate.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public List<Pojo> consultar(Pojo pojo) throws DAOException {
        try {
            Criteria criteria = getSession().createCriteria(pojo.getClass());
            Example example = Example.create(pojo).enableLike(MatchMode.START).ignoreCase();
            criteria.add(example);
            return criteria.list();
        } catch (HibernateException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Efetua um consulta com o HQL informado e o parametro. Na consulta dever� ser previsto a 
     * utiliza��o do param�tro (utilizando as interroga��es). Ela ser� montada 
     * substituindo a interroga��o pelo param�tro informado.
     * <BR>
     * Exemplo: select e from Entidade e where e.codigo = ?  
     * 
     * @param hql consulta a ser realizada.
     * @param parametro param�tro da consulta.
     * 
     * @return lista com o resultado da consulta ou lista vazia.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public List<Pojo> consultar(String hql, Object parametro) throws DAOException {
        return consultar(hql, new Object[]{parametro});
    }

    /**
     * Efetua um consulta com o HQL informado e os parametros. Na consulta dever� ser previsto a 
     * utiliza��o dos param�tros (utilizando as interroga��es). Ela ser� montada 
     * substituindo as interroga��es pelos param�tros informados.
     * <BR>
     * Exemplo: select e from Entidade e where e.codigo = ? and e.nome = "XYZ"  
     * 
     * @param hql consulta a ser realizada.
     * @param parametros param�tros da consulta.
     * 
     * @return lista com o resultado da consulta ou lista vazia.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public List<Pojo> consultar(String hql, Object [] parametros) throws DAOException {
        Query query = sf.getCurrentSession().createQuery(hql);

        for (int i = 0; i < parametros.length; i++) {
            query.setParameter(i, parametros[i]);
        }

        return query.list();
    }
    
    /**
     * Efetua um consulta com o HQL informado. N�o prev� a utiliza��o de param�tros na consulta.
     * <BR>
     * Exemplo: select e from Entidade e where e.codigo = 10  
     * 
     * @param hql consulta a ser realizada.
     * 
     * @return lista com o resultado da consulta ou lista vazia.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public List<Pojo> consultar(String hql) throws DAOException {
        Query query = sf.getCurrentSession().createQuery(hql);

        return query.list();
    }

    /**
     * Efetua uma consulta pela chave prim�ria do POJO.
     * 
     * @param id chave prim�ria do objeto.
     * 
     * @return objeto encontrado ou nulo.
     * 
     * @throws DAOException poss�veis problemas de conex�o.
     */
    @SuppressWarnings("unchecked")
    public Pojo get(Id id) throws DAOException {
        try {
            return (Pojo) getSession().get(doGetClass(), id);
        } catch (HibernateException e) {
            throw new DAOException(e.getMessage());
        }
    }

    /**
     * Indica para o AbstractDao a classe do POJO com quem ela estar� associada.
     * 
     * @return classe do Pojo.
     */
    protected abstract Class<Pojo> doGetClass();

}
