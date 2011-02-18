/*
 * Classname:           ValidadorCampos.java
 * Version:             1.0
 * Date:                22/02/2008
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */

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
 * Classe que encapsula os métodos necessário para as validações de campo do struts.
 *
 * @author União Federativa do Brasil
 * @author Ministério da Justiça
 * @author CGTI
 * @version 1.0
 */
public class StrutsValidator implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Verifica se um cpf é válido.
     * 
     * @param bean bean com o formulário do usuário.
     * @param va action que está sendo validada.
     * @param field campo que está sendo validado.
     * @param errors resources de mensagens de erros.
     * @param validator configurações de validação.
     * @param request requisição do usuário.
     * 
     * @return true caso seja válido.
     */
    public static boolean validateCpf(Object bean, ValidatorAction va, Field field, 
            ActionMessages errors, Validator validator, HttpServletRequest request) {
        String valor = ValidatorUtils.getValueAsString(bean, field.getProperty());
        boolean isValido = false;

        if (valor == null || valor.trim().equals("")) {
            return true;
        }

        isValido = CPF.validaCPF(valor);
        if(!isValido) {
            errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
        }

        return isValido;
    }
    
    /**
     * Verifica se um cnpj é válido.
     * 
     * @param bean bean com o formulário do usuário.
     * @param va action que está sendo validada.
     * @param field campo que está sendo validado.
     * @param errors resources de mensagens de erros.
     * @param validator configurações de validação.
     * @param request requisição do usuário.
     * 
     * @return true caso seja válido.
     * 
     * @author evandro.torezan
     * @since 09/04/2008 09:50
     */
    public static boolean validateCnpj(Object bean, ValidatorAction va, Field field, 
            ActionMessages errors, Validator validator, HttpServletRequest request) {
        String valor = ValidatorUtils.getValueAsString(bean, field.getProperty());
        boolean isValido = false;

        if (valor == null || valor.trim().equals("")) {
            return true;
        }

        isValido = CNPJ.validaCNPJ(valor);
        if(!isValido) {
            errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
        }

        return isValido;
    }
    
    /**
     * Verifica se um período de datas é válido.
     * 
     * @param bean bean com o formulário do usuário.
     * @param va action que está sendo validada.
     * @param field campo que está sendo validado (não é usado)
     * @param errors resources de mensagens de erros.
     * @param validator configurações de validação.
     * @param request requisição do usuário.
     * 
     * @return true caso seja válido.
     * 
     * @author evandro.torezan
     * @since 09/04/2008 09:50
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