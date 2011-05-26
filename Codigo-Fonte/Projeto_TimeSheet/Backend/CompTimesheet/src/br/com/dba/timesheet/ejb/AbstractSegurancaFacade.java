package br.com.dba.timesheet.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;

import br.com.dba.timesheet.exceptions.DAOException;
import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.IdentificadorSenhaIncorretosException;
import br.com.dba.timesheet.exceptions.LogonBloqueadoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.exceptions.UsuarioNaoEncontradoException;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.dao.TimesheetDaoFactory;
import br.com.dba.timesheet.pojo.dao.UsuarioDao;
import br.com.dba.timesheet.servicos.Seguranca;


/**
 * Classe abstrata que representa o Componente Timesheet.
 *
 * @author             Fabio Oliveira de Pinho
 *
 */

/**
 * 
 * @ejb.bean description="EJB TimeSheet"
 *           display-name="SegurancaFacade"
 *           jndi-name="br/com/dba/timesheet/ejb/SegurancaFacade"
 *           name="SegurancaFacade"
 *           type="Stateless"
 *           view-type="remote"
 *           transaction-type = "Container"
 *           
 * @ejb.util generate = "physical"
 *
 */
public abstract class AbstractSegurancaFacade implements SessionBean, Seguranca {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SegurancaFacadeHelper segurancaHelper;
	private UsuarioDao usuarioDao;
	
	
	/**
     * @ejb.create-method view-type = "remote"  
     */
	public void ejbCreate() throws CreateException {
		usuarioDao = TimesheetDaoFactory.getInstance().getUsuarioDao();		
		segurancaHelper = SegurancaFacadeHelper.getInstancia();
	}
	
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
	public Sessao autenticarUsuario(String login, String senha)
    	throws IdentificadorSenhaIncorretosException, ParametroInvalidoException, 
    		LogonBloqueadoException, ErroInternoException {
             
        try {
            
            Usuario usuario = usuarioDao.consultarPorLogin(login);
            
            if(senha == null || senha.trim().equals("")){
            	throw new ParametroInvalidoException("A senha é de preenchimento obrigatório!");
            }
            
            if (usuario.getIndicaBloqueado()!=null && usuario.getIndicaBloqueado()) {
                throw new LogonBloqueadoException("Usuário bloqueado tentando entrar no sistema!");
            }
            
            if(usuario.getIndicaAlterarSenha() != null && usuario.getIndicaAlterarSenha()){
	            usuario.setDataUltimoLogin( new Date() );
	            usuarioDao.alterar(usuario);	            
            }else{
            
	            if(!login.equals(usuario.getLogin()) && !senha.equals(usuario.getSenha())){
	            	throw new IdentificadorSenhaIncorretosException("Identificador ou senha incorretos!");
	            }
            }
            
            return segurancaHelper.criarSessao(usuario);
                
        } catch (DAOException e) {
            throw new ErroInternoException("Problemas com a conexão ao banco de dados!",e);
        } catch (UsuarioNaoEncontradoException e) {
            throw new IdentificadorSenhaIncorretosException("Identificador ou senha incorretos!");
        }
    }
    
    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public void alterarUsuario(Usuario pojo, Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		usuarioDao.alterar(pojo);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public Usuario getUsuario(Integer id,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
            return usuarioDao.get(id);
        } catch (DAOException e) {
            throw new ErroInternoException(e.getMessage(),e.getCause());
        }
    }

    /**
     * @ejb.interface-method view-type = "remote"
     * @ejb.transaction type = "Required"
     */ 
    @SuppressWarnings("deprecation")
    public List<Usuario> consultarUsuario(Usuario pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
        try {
        	segurancaHelper.verificarSessaoValida(sessao);
    		return usuarioDao.consultar(pojo);
    	} catch (DAOException e) {
    		throw new ErroInternoException(e.getMessage(),e.getCause());
    	}
    }
    
	/**
	 * @ejb.interface-method view-type = "remote"
	 * @ejb.transaction type = "Required"
	 */ 
	@SuppressWarnings("deprecation")
	public Usuario getUsuario(Usuario pojo,Sessao sessao) throws ParametroInvalidoException, SessaoInvalidaException{
	    try {
	    	segurancaHelper.verificarSessaoValida(sessao);
			List<Usuario> lista = new ArrayList<Usuario>();
			
			lista = usuarioDao.consultar(pojo);
			
			return  !lista.isEmpty() ? lista.get(0):null;
		} catch (DAOException e) {
			throw new ErroInternoException(e.getMessage(),e.getCause());
		}
    }
	
	/**
	 * @ejb.interface-method view-type = "remote"
	 * @ejb.transaction type = "Required"
	 */ 
	public boolean isSessaoValida(Sessao sessao) throws ParametroInvalidoException {		 
	     return segurancaHelper.isSessaoValida(sessao);
	}
}