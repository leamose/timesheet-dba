/*
 * Classname:			Data.java
 * Version:				$Revision: 1.0
 * Date:				22/06/2005
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.struts.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe responsável por validar e formatar uma hora.
 *
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision: 1.1 $ $Date: 2005-11-09 18:55:33 $
 *
 */
public class Hora {

    private Hora() {
        super();
    }
    
    public static SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat formataDataHora = new SimpleDateFormat("dd/MM/yyyyHH:mm");    
    
    


    /**
     * Concatena uma data (Objeto) com uma hora (String). 
     * 
     * @param data
     * @param hora
     * 
     */      
    public static Date concatenarDataHora(Date data, String hora) throws ParseException{
        try {
            String dataString = formataData.format(data);
            Date dataHora = formataDataHora.parse(dataString + hora);
            return dataHora;
        } catch (ParseException e){
            throw new ParseException("Erro ao concatenarDataHora ", 1);
        }
    }
    
    /**
     * Concatena uma data (String) com uma hora (String). 
     * 
     * @param data
     * @param hora
     * 
     */      
    public static Date concatenarDataHora(String data, String hora) throws ParseException{
        try {
            Date dataHora = formataDataHora.parse(data + hora);
            return dataHora;
        } catch (ParseException e){
            throw new ParseException("Erro ao concatenarDataHora ", 1);
        }
    }
    
    /**
     * recupera a hora como uma String. 
     * 
     * @param data
     * @param hora
     * 
     */      
    public static String recuperaHora(Date data) throws ParseException{
        try {
            return formataHora.format(data);
        } catch (Exception e){
            throw new ParseException("Erro ao recuperar hora ", 1);
        }
    }    
    

    /**
     * Valida uma Hora. 
     * 
     * @param data 
     * 
     */          
    public static boolean validaHora(String horario) {
        try {
            if (horario == null) {
                return false;
            }
            horario = horario.replace(":", "");
            if (horario.length() > 4) {
                return false;
            }
            int hora = Integer.parseInt(horario.substring(0,2));
            int minuto = Integer.parseInt(horario.substring(2,4));
        
            if (hora < 0 || hora >= 24) {
                return false;
            } 
        
            if (minuto < 0 || minuto >= 60) {
                return false;
            }  
            
            return true;
        } catch (Exception e) {
            return false;
        }
            
    }
    
}
