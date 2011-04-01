package br.com.dba.timesheet.ejb;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.IdentificadorSenhaIncorretosException;
import br.com.dba.timesheet.exceptions.LogonBloqueadoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.servicos.Seguranca;

public class SegurancaDelegate implements Seguranca {
	
	private static SegurancaDelegate instancia = null;
	private Properties jndiprops = new Properties();
	private SegurancaFacade facade = null;
	 
	private SegurancaDelegate() {
        
        	try {
				jndiprops.load(this.getClass().getResourceAsStream("/jndi.properties"));
				facade = SegurancaFacadeUtil.getHome(jndiprops).create();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CreateException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}
         
	}
	
    @SuppressWarnings("deprecation")
    public static SegurancaDelegate getInstancia() throws ErroInternoException {
        if (instancia == null) { 
        	instancia = new SegurancaDelegate();
        }
        return instancia;
    }

	public void alterarUsuario(Usuario pojo, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			facade.alterarUsuario(pojo,sessao);
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
		
	}

	public Sessao autenticarUsuario(String login, String senha)
			throws IdentificadorSenhaIncorretosException,
			ParametroInvalidoException, LogonBloqueadoException,
			ErroInternoException {
		try {
			return facade.autenticarUsuario(login, senha);
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}

	public List<Usuario> consultarUsuario(Usuario pojo, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.consultarUsuario(pojo, sessao);
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}

	public Usuario getUsuario(Integer id, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.getUsuario(id, sessao);
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}

	public Usuario getUsuario(Usuario pojo, Sessao sessao)
			throws ParametroInvalidoException, SessaoInvalidaException {
		try {
			return facade.getUsuario(pojo, sessao);
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}

	public boolean isSessaoValida(Sessao sessao)
			throws ParametroInvalidoException {
		try {
			return facade.isSessaoValida(sessao);
		} catch (RemoteException e) {			
			throw new ErroInternoException(e.getMessage(), e);
		}
	}

}