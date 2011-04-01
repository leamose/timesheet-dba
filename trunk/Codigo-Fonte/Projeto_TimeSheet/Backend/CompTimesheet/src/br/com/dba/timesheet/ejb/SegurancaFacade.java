/*
 * Gerado pelo XDoclet - Não edite!
 */
package br.com.dba.timesheet.ejb;

/**
 * Interface Remota para SegurancaFacade.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface SegurancaFacade
   extends javax.ejb.EJBObject
{

   public br.com.dba.timesheet.pojo.Sessao autenticarUsuario( java.lang.String login,java.lang.String senha )
      throws br.com.dba.timesheet.exceptions.IdentificadorSenhaIncorretosException, br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.LogonBloqueadoException, br.com.dba.timesheet.exceptions.ErroInternoException, java.rmi.RemoteException;

   public void alterarUsuario( br.com.dba.timesheet.pojo.Usuario pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.Usuario getUsuario( java.lang.Integer id,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public java.util.List consultarUsuario( br.com.dba.timesheet.pojo.Usuario pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public br.com.dba.timesheet.pojo.Usuario getUsuario( br.com.dba.timesheet.pojo.Usuario pojo,br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, br.com.dba.timesheet.exceptions.SessaoInvalidaException, java.rmi.RemoteException;

   public boolean isSessaoValida( br.com.dba.timesheet.pojo.Sessao sessao )
      throws br.com.dba.timesheet.exceptions.ParametroInvalidoException, java.rmi.RemoteException;

}
