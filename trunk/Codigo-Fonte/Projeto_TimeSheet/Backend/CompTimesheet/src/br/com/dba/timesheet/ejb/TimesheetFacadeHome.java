/*
 * Gerado pelo XDoclet - Não edite!
 */
package br.com.dba.timesheet.ejb;

/**
 * Interface Home para TimesheetFacade.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface TimesheetFacadeHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/TimesheetFacade";
   public static final String JNDI_NAME="br/com/dba/timesheet/ejb/TimesheetFacade";

   public br.com.dba.timesheet.ejb.TimesheetFacade create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
