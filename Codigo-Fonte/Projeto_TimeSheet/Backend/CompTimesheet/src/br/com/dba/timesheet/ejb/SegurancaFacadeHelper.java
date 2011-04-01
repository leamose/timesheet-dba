/*
 * Created on 02/06/2004
 *
 */
package br.com.dba.timesheet.ejb;


import org.hibernate.HibernateException;

import br.com.dba.timesheet.exceptions.ErroInternoException;
import br.com.dba.timesheet.exceptions.ParametroInvalidoException;
import br.com.dba.timesheet.exceptions.SessaoInvalidaException;
import br.com.dba.timesheet.exceptions.UsuarioNaoEncontradoException;
import br.com.dba.timesheet.pojo.Sessao;
import br.com.dba.timesheet.pojo.Usuario;
import br.com.dba.timesheet.pojo.dao.TimesheetDaoFactory;
import br.com.dba.timesheet.pojo.dao.UsuarioDao;
import br.com.dba.timesheet.util.UtilDate;

/**
 *
 * @author  <a href="mailto:marcel.martinelli@mj.gov.br">marcel.martinelli</a>.
 * @version $Revision$ $Date$
 *
 * <p><b>Revisions:</b>
 * <p><b>2004 marcel :</b>
 * <ul>
 * <li> Primeira implementação </li>
 * </ul> 
 *  
 * */

public final class SegurancaFacadeHelper {
	
	private static SegurancaFacadeHelper segurancaHelper;
    
    private UsuarioDao usuarioDao;
	
	private SegurancaFacadeHelper() {
		usuarioDao = TimesheetDaoFactory.getInstance().getUsuarioDao();
    }
	
	/**
	 * Método para pegar a instancia da classe.
	 * 
	 * @return UsuarioFacadeHelper
	 */
	public static SegurancaFacadeHelper getInstancia() {
		if (segurancaHelper == null) {
			segurancaHelper = new SegurancaFacadeHelper();
    	}
		return segurancaHelper;
	}
	
	/**
	 * Método que verifica os parâmetros passados para o serviço de autenticação.
	 * 
	 * @param identificador
	 * @param senha
	 * @param nomeMaquina
	 * @param ipMaquina
	 * @throws ParametroInvalidoException
	 */
	public void verificarParametros(String identificador, char[] senha) 
            throws ParametroInvalidoException {
        if (identificador == null || senha == null || senha.length == 0) {
            throw new ParametroInvalidoException("Os parâmetros informados estão incorretos");            
        }
        
		if (identificador.equals("") || senha.equals("".toCharArray())) {
			throw new ParametroInvalidoException("Os parâmetros informados estão incorretos");
		}
	}

    /**
     * Método para verificar se uma sessão ainda esta ativa.
     * 
     * @param sessao
     * @throws SessaoInvalidaException
     */
    public void verificarSessaoValida(Sessao sessao) throws SessaoInvalidaException {
        if ((sessao == null) || (sessao.getIndicaAtiva() == null) || (sessao.getUsuario() == null) ||
        		(sessao.getIndicaAtiva().equals("N")) || (sessao.getUsuario().getId() == null) ) {
            throw new SessaoInvalidaException();
        }
    }

    /**
     * Método para verificar se uma sessão ainda esta ativa.
     * 
     * @param sessao
     * @throws SessaoInvalidaException
     */
    public boolean isSessaoValida(Sessao sessao){
    	if ((sessao == null) || (sessao.getIndicaAtiva().equals("N")) || (sessao.getUsuario().getId() == null) ) {
    		return false;
    	}
    	return true;
    }
	
    /**
	 * Método responsável por criar um objeto de Sessão.
	 * 
	 * @param usuario
	 * @param nomeMaquina
	 * @param ipMaquina
	 * @param sistema
	 * @return Sessao
	 * @throws ErroInternoException
	 */
	public Sessao criarSessao(Usuario usuario) throws ErroInternoException {
		Sessao sessao = null;
		try {
			sessao = new Sessao();
			sessao.setDataLogon(UtilDate.getDataAtual());
			sessao.setUsuario(usuario);
			sessao.setIndicaAtiva("S");
	
		}
		catch (Exception e) {
			throw new ErroInternoException("Erro interno do sistema, contacte o Administrados do Sistemas ! \n Dados do erro:" + e.getMessage());
		}
		return sessao;
	}
    
    /**
	 * Método responsável pela criação de um objeto Usuario a partir dos parametros informados.
	 * 
	 * @param identificador
	 * @param ipMaquina
     * @param senha
	 * @return Usuario
	 * @throws ErroInternoException
	 */
	public Usuario criarUsuario(String login, String senha) throws ErroInternoException {
		Usuario usuario = null;
		try {
			usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
		}
		catch (Exception e) {
			throw new ErroInternoException("Erro interno do sistema, contacte o Administrados do Sistemas ! \n Dados do erro:" + e.getMessage());
		}
		return usuario;
	}
	    
    /**
     * Método para realizar um update no banco de dados com as novas informações do usuário.
     * 
     * @param usuarioVO
     * @throws ErroInternoException
     */
    public void alterarUsuario(Usuario usuarioVO) throws ErroInternoException {
        try {
            if (usuarioVO != null) {
                usuarioDao.alterar(usuarioVO);
            }
        } catch (HibernateException e) {
            throw new ErroInternoException(e.getCause()==null?e.getMessage():e.getCause().getMessage());
        }
    }

    /**
     * 
     * @param codigoUsuario
     * @return Usuario
     * @throws UsuarioNaoEncontradoException
     * @throws ErroInternoException
     */
    public Usuario verificarUsuario(Integer codigoUsuario) throws UsuarioNaoEncontradoException, ErroInternoException {
        Usuario usuario = null;
        try {
            usuario = usuarioDao.get(codigoUsuario);
            if (usuario == null) {
                throw new UsuarioNaoEncontradoException();
            }
        } catch (HibernateException e) {
            throw new ErroInternoException(e.getCause()==null?e.getMessage():e.getCause().getMessage());
        }
        return usuario;
    }

}
