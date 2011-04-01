/*
 * Gerado pelo XDoclet - Não edite!
 */
package br.com.dba.timesheet.ejb;

/**
 * Interface Home para SegurancaFacade.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface SegurancaFacadeHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/SegurancaFacade";
   public static final String JNDI_NAME="br/com/dba/timesheet/ejb/SegurancaFacade";

   public br.com.dba.timesheet.ejb.SegurancaFacade create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
