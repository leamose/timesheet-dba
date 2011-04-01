package br.com.dba.timesheet.pojo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



/**
 * Classe responsavel pela “construção” da SessionFactory do hibernate 
 *      e repassá-la para objetos DAO via construtor
 *      
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public final class TimesheetDaoFactory {

    private SessionFactory sf = null;
    private static TimesheetDaoFactory instancia = null;
    
    
	public TimesheetDaoFactory() {
		sf = new AnnotationConfiguration().configure("/timesheet.cfg.xml").buildSessionFactory();
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
	
	public ProdutoServicoDao getProdutoServicoDao() {
		return new ProdutoServicoDao(sf);
	}
		
	public ProjetoDao getProjetoDao() {
		return new ProjetoDao(sf);
	}
	
	public  TipoAtividadeDao getTipoAtividadeDao() {
		return new TipoAtividadeDao(sf);
	}
	
	public  TimeSheetDao getTimeSheetDao() {
        return new TimeSheetDao(sf);
    }
	
	public HistoricoTimeSheetDao getHistoricoTimeSheetDao() {
	    return new HistoricoTimeSheetDao(sf);
	}

	public  UsuarioDao getUsuarioDao() {
	    return new UsuarioDao(sf);
	}

	public SituacaoAtividadeDao getSituacaoAtividadeDao() {
	    return new SituacaoAtividadeDao(sf);
	}

    public AvaliacaoAtividadeDao getAvaliacaoAtividadeDao() {
        return new AvaliacaoAtividadeDao(sf);
    }

	public TotalHorasMesDao getTotalHorasMesDao() {
		return new TotalHorasMesDao(sf);
	}

	public ConfiguracaoDao getConfiguracaoDao() {
		return new ConfiguracaoDao(sf);
	}

}
