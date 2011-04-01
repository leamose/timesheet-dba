/*
 * Arquivo gerado automaticamente - não edite!!
 */
package br.com.dba.timesheet.ejb;

/**
 * Classe utilitária para SegurancaFacade.
 * @xdoclet-generated at ${TODAY}
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public class SegurancaFacadeUtil
{
   /** Interface Home guardada. Usa carregamento adiado para obter seu valor (carregado pelos métodos getHome()). */
   private static br.com.dba.timesheet.ejb.SegurancaFacadeHome cachedRemoteHome = null;

   private static Object lookupHome(java.util.Hashtable environment, String jndiName, Class narrowTo) throws javax.naming.NamingException {
      // Obtain initial context
      javax.naming.InitialContext initialContext = new javax.naming.InitialContext(environment);
      try {
         Object objRef = initialContext.lookup(jndiName);
         // only narrow if necessary
         if (java.rmi.Remote.class.isAssignableFrom(narrowTo))
            return javax.rmi.PortableRemoteObject.narrow(objRef, narrowTo);
         else
            return objRef;
      } finally {
         initialContext.close();
      }
   }

   // Método de busca da interface Home.

   /**
    * Obtém a interface remota a partir do contexto inicial padrão
    * @return Interface Home para SegurancaFacade. Busca usando JNDI_NAME
    */
   public static br.com.dba.timesheet.ejb.SegurancaFacadeHome getHome() throws javax.naming.NamingException
   {
      if (cachedRemoteHome == null) {
            cachedRemoteHome = (br.com.dba.timesheet.ejb.SegurancaFacadeHome) lookupHome(null, br.com.dba.timesheet.ejb.SegurancaFacadeHome.JNDI_NAME, br.com.dba.timesheet.ejb.SegurancaFacadeHome.class);
      }
      return cachedRemoteHome;
   }

   /**
    * Obtém a interface remota a partir do contexto inicial parametrizado.
    * @param environment Parâmetros a serem usados para criar o contexto inicial.
    * @return Interface Home para SegurancaFacade. Busca usando JNDI_NAME
    */
   public static br.com.dba.timesheet.ejb.SegurancaFacadeHome getHome( java.util.Hashtable environment ) throws javax.naming.NamingException
   {
       return (br.com.dba.timesheet.ejb.SegurancaFacadeHome) lookupHome(environment, br.com.dba.timesheet.ejb.SegurancaFacadeHome.JNDI_NAME, br.com.dba.timesheet.ejb.SegurancaFacadeHome.class);
   }

   /** Guardada por IP do servidor da JVM. */
   private static String hexServerIP = null;

   // inicializa a instância de SecureRandom.
   private static final java.security.SecureRandom seeder = new java.security.SecureRandom();

   /**
    * Um gerador de GUID (identificador único) de 32 bytes. Estas chaves artificiais <strong>NÃO</strong> DEVEM ser vistas pelo usuário,
    * nem modificadas pelo DBA exceto em raras exceções, apenas manipulada pelo banco do dados e pelos programas.
    *
    * Uso: adicione um campo id (tipo java.lang.String) no ser EJB, e adicione setId(XXXUtil.generateGUID(this)); no método ejbCreate.
    */
   public static final String generateGUID(Object o) {
       StringBuffer tmpBuffer = new StringBuffer(16);
       if (hexServerIP == null) {
           java.net.InetAddress localInetAddress = null;
           try {
               // obtém o endereço de internet

               localInetAddress = java.net.InetAddress.getLocalHost();
           }
           catch (java.net.UnknownHostException uhe) {
               System.err.println("SegurancaFacadeUtil: Não foi possíbel obter o endereço IP local usando InetAddress.getLocalHost()!");
               // todo: find better way to get around this...
               uhe.printStackTrace();
               return null;
           }
           byte serverIP[] = localInetAddress.getAddress();
           hexServerIP = hexFormat(getInt(serverIP), 8);
       }

       String hashcode = hexFormat(System.identityHashCode(o), 8);
       tmpBuffer.append(hexServerIP);
       tmpBuffer.append(hashcode);

       long timeNow      = System.currentTimeMillis();
       int timeLow       = (int)timeNow & 0xFFFFFFFF;
       int node          = seeder.nextInt();

       StringBuffer guid = new StringBuffer(32);
       guid.append(hexFormat(timeLow, 8));
       guid.append(tmpBuffer.toString());
       guid.append(hexFormat(node, 8));
       return guid.toString();
   }

   private static int getInt(byte bytes[]) {
       int i = 0;
       int j = 24;
       for (int k = 0; j >= 0; k++) {
           int l = bytes[k] & 0xff;
           i += l << j;
           j -= 8;
       }
       return i;
   }

   private static String hexFormat(int i, int j) {
       String s = Integer.toHexString(i);
       return padHex(s, j) + s;
   }

   private static String padHex(String s, int i) {
       StringBuffer tmpBuffer = new StringBuffer();
       if (s.length() < i) {
           for (int j = 0; j < i - s.length(); j++) {
               tmpBuffer.append('0');
           }
       }
       return tmpBuffer.toString();
   }

}

