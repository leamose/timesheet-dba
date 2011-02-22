package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;




/**
 * @author fabio.pinho
 * 
 * Classe responsavel pela �constru��o� da SessionFactory do hibernate e repass�-la para objetos DAO via construtor
 *
 */
public final class TimesheetDaoFactory {

    private SessionFactory sf = null;
    private static TimesheetDaoFactory instancia = null;
    
    
	public TimesheetDaoFactory() {
		sf = new AnnotationConfiguration().configure("/fct.cfg.xml").buildSessionFactory();
	}
	
	public static final TimesheetDaoFactory  getInstance() {
		if (instancia == null) {
			instancia = new TimesheetDaoFactory();			
		}		
		return instancia;
	}

	public AtividadeDao getAtividadeDao() {
    	return new AtividadeDao(sf);
    }
	
	public ClienteDao getClienteDao() {
		return new ClienteDao(sf);
	}
	
	public FuncionarioDao getFuncionarioDao() {
		return new FuncionarioDao(sf);
	}
	
	public MetodologiaDao getMetodologiaDao() {
		return new MetodologiaDao(sf);
	}
	
	public OPDao getOPDao() {
		return new OPDao(sf);
	}
	
	public Produto_ServicoDao getProduto_ServicoDao() {
		return new Produto_ServicoDao(sf);
	}
		
	public ProjetoDao getProjetoDao() {
		return new ProjetoDao(sf);
	}
	
	public  Tipo_AtividadeDao getTipo_AtividadeDao() {
		return new Tipo_AtividadeDao(sf);
	}

}