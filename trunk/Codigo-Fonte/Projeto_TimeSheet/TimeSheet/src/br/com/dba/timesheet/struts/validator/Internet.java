package br.com.dba.timesheet.struts.validator;

import org.apache.commons.validator.GenericValidator;

public class Internet {
	
    //private static Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
    //private static Pattern p = Pattern.compile("(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*");
    //private static Pattern p = Pattern.compile("/^([a-zA-Z0-9_.-+])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/");
    //                                          /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/");
    //private static Pattern p = Pattern.compile("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
	
	public static boolean isEmailValido(String email)
    {
        return GenericValidator.isEmail(email); // Esta validação é a mesma que o Struts usa. Os patterns acima não funcionam corretamente.
        
        
        /*       
        
		 //Set the email pattern string

	      //Match the given string with the pattern
	      Matcher m = p.matcher(email);

	      //check whether match is found 
	      return m.matches();
          */
	}
	
	public static boolean isIPValido(String ip)
    {
		throw new RuntimeException("Ainda nÃ£o implementado");
	}
	
	

}
