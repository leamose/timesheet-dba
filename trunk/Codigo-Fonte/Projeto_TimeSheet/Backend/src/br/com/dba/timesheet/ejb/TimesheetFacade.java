/*
 * Gerado pelo XDoclet - Não edite!
 */
package br.com.dba.timesheet.ejb;

import br.com.dba.timesheet.exceptions.ParametroInvalidoException;

/**
 * Interface Remota para TimesheetFacade.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface TimesheetFacade
   extends javax.ejb.EJBObject
{

   public java.util.List listarTodosTipoAtividades(  )
      throws ParametroInvalidoException, java.rmi.RemoteException;

}
