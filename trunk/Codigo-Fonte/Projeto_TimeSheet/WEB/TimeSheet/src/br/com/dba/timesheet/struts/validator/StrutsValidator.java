package br.com.dba.timesheet.struts.validator;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;


/**
 * Classe que encapsula os m�todos necess�rio para as valida��es de campo do struts.
 *  
 */
public class StrutsValidator implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Verifica se um per�odo de datas � v�lido.
     * 
     * @param bean bean com o formul�rio do usu�rio.
     * @param va action que est� sendo validada.
     * @param field campo que est� sendo validado (n�o � usado)
     * @param errors resources de mensagens de erros.
     * @param validator configura��es de valida��o.
     * @param request requisi��o do usu�rio.
     * 
     * @return true caso seja v�lido.
     *  
     */
    public static boolean validateDatesPeriod(Object bean, ValidatorAction va, Field field, 
            ActionMessages errors, Validator validator, HttpServletRequest request) 
    {
        try
        {
            long dataInicial = Data.parseStringBrToDate(ValidatorUtils.getValueAsString(bean, field.getVarValue("startdate"))).getTime();
            long dataFinal = Data.parseStringBrToDate(ValidatorUtils.getValueAsString(bean, field.getVarValue("enddate"))).getTime();
            
            if (dataInicial <= dataFinal)
                return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
        return false;
    }
}