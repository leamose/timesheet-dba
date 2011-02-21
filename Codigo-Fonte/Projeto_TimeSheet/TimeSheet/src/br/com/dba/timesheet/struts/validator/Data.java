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
import java.util.Calendar;
import java.util.Date;

/**
 * Classe responsável por validar e formatar uma data.
 *
 * @author             União Federativa do Brasil
 * @author             Ministério da Justiça
 * @author             SE-SPOA-CGTI
 * @version            $Revision: 1.6 $ $Date: 2010-10-18 19:16:03 $
 *
 */
/**
 * @author anacelia.cunha
 *
 */
public class Data {

    private Data() {
        super();
    }
    
    public static SimpleDateFormat formataDataBR = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat formataCompleta = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
    public static SimpleDateFormat formataDataUSA = new SimpleDateFormat("MM/dd/yyyy");    
    
    /**
     * Verifica se os dois objetos da classe Calendar são do mesmo dia, mês e ano. 
     * 
     * @param calendar1 
     * @param calendar2
     * 
     */    
    public static boolean isSameDay(Calendar calendar1, Calendar calendar2) {
        int dia1 = calendar1.get(Calendar.DAY_OF_MONTH);
        int dia2 = calendar2.get(Calendar.DAY_OF_MONTH);
        int mes1 = calendar1.get(Calendar.MONTH);
        int mes2 = calendar2.get(Calendar.MONTH);        
        int ano1 = calendar1.get(Calendar.YEAR);
        int ano2 = calendar2.get(Calendar.YEAR);      
        if (dia1 == dia2 && mes1 == mes2 && ano1 == ano2) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Formata uma data(Date) no formato do Brasil(String). 
     * 
     * @param data 
     * 
     */     
    public static String formataDataToStringBR(Date data) {
            return formataDataBR.format(data);
    }
    
    /**
     * Formata uma data(Date) no formato completo - dd/MM/yyyy - HH:mm:ss. 
     * 
     * @param data 
     * 
     */    
    public static String formataDataHora(Date data) {
        return formataCompleta.format(data);
    }    

    /**
     * Formata uma data(Date) no formato dos EUA(String). 
     * 
     * @param data 
     * 
     */         
    public static String formataDataToStringUSA(Date data) {
        return formataDataUSA.format(data);
    }
    
    /**
     * Transforma uma String de Data (Brasil) em um objeto Date. 
     * 
     * @param data 
     * 
     */      
    public static Date parseStringBrToDate(String data) throws ParseException{
        try {
            return formataDataBR.parse(data);
        } catch (ParseException e){
            throw new ParseException("Erro ao transformar String em Date ", 1);
        }
    }

    /**
     * Transforma uma String de Data (EUA) em um objeto Date. 
     * 
     * @param data 
     * 
     */      
    public static Date parseStringUsaToDate(String data) throws ParseException {
        try {
            return formataDataUSA.parse(data);
        } catch (ParseException e){
            throw new ParseException("Erro ao transformar String em Date ", 1);
        }
    }    
    
    /**
     * Dado um certo mês, retorna este mês por estenso. 
     * 
     * @param mes
     * 
     */      
    public static String mesPorExtenso(Integer mes) throws ParseException {
        String mesExtenso = null;
        switch (mes) {
        case 1: mesExtenso = "Janeiro"; break;
        case 2: mesExtenso = "Fevereiro"; break;
        case 3: mesExtenso = "Março"; break;

        case 4: mesExtenso = "Abril"; break;
        case 5: mesExtenso = "Maio"; break;
        case 6: mesExtenso = "Junho"; break;
        
        case 7: mesExtenso = "Julho"; break;
        case 8: mesExtenso = "Agosto"; break;
        case 9: mesExtenso = "Setembro"; break;
        
        case 10: mesExtenso = "Outubro"; break;
        case 11: mesExtenso = "Novembro"; break;
        case 12: mesExtenso = "Dezembro"; break;
        default: mesExtenso = null;
            
        }
        return mesExtenso;
    }      
    
    /**
     * Valida uma Data no formato do Brasil. 
     * 
     * @param data 
     * 
     */          
    public static boolean validaDataBR(String data) {
        try {
            data = data.replace("/", "");
            data = data.replace("-", "");        
            int dia = Integer.parseInt(data.substring(0,2));
            int mes = Integer.parseInt(data.substring(2,4));
            int ano = Integer.parseInt(data.substring(4));
        
            if (ano < 1755 || ano > 9999) {
                return false;
            } 
        
            if (mes < 1 || mes > 12) {
                return false;
            }         
        
            if (mes == 2 || mes == 02) {
                if (ano%4 == 0) {
                    if (dia<1 || dia>29) {
                        return false;
                    }                
                } else {
                    if (dia<1 || dia>28) {
                        return false;
                    }                
                }
            }else if (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes == 12) {
                if (dia < 1 || dia > 31) {
                    return false;
                }
            } else if (mes==4 || mes==6 || mes==9 || mes==11) {
                if (dia<1 || dia>30) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
            
    }
    
    /**
     * Valida uma Data no formato dos Eua. 
     * 
     * @param data 
     * 
     */          
    public static boolean validaDataUSA(String data) {
        try {
            data = data.replace("/", "");
            data = data.replace("-", "");        
            int mes = Integer.parseInt(data.substring(0,2));
            int dia = Integer.parseInt(data.substring(2,4));
            int ano = Integer.parseInt(data.substring(4));
        
            if (ano < 1755 || ano > 9999) {
                return false;
            } 
        
            if (mes < 1 || mes > 12) {
                return false;
            }         
        
            if (mes == 2 || mes == 02) {
                if (ano%4 == 0) {
                    if (dia<1 || dia>29) {
                        return false;
                    }                
                } else {
                    if (dia<1 || dia>28) {
                        return false;
                    }                
                }
            }else if (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes == 12) {
                if (dia < 1 || dia > 31) {
                    return false;
                }
            } else if (mes==4 || mes==6 || mes==9 || mes==11) {
                if (dia<1 || dia>30) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
            
    }
    
    /**
     * Retorna a data final de um periodo, de acordo com uma data inicial e a quantidade de dias úteis do período
     * @param dataInicial Data inicial do período
     * @param diasUteis Quantidade de dias úteis a serem utilizados no cálculo da data final do período
     * @return Data final do período
     */
    public static Date getDataFinalPeriodoDiasUteis(Date dataInicial, int diasUteis){
        if (dataInicial == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicial);
        if (diasUteis >= 0){
            for(int contDias = 0; contDias < diasUteis; ){
                calendar.add(Calendar.DATE, 1);
                if (calendar.get(Calendar.DAY_OF_WEEK)!=1 && calendar.get(Calendar.DAY_OF_WEEK)!=7){
                    contDias++;
                }
            }
        } else {
            for(int contDias = 0; contDias > diasUteis; ){
                calendar.add(Calendar.DATE, -1);
                if (calendar.get(Calendar.DAY_OF_WEEK)!=1 && calendar.get(Calendar.DAY_OF_WEEK)!=7){
                    contDias--;
                }
            }
        }
        return calendar.getTime();
    }
    
    /**
     * Retorna a data final de um periodo, de acordo com uma data inicial e a quantidade de dias corridos do período
     * @param dataInicial Data inicial do período
     * @param diasCorridos Quantidade de dias corridos a serem utilizados no cálculo da data final do período
     * @return Data final do período
     */
    public static Date getDataFinalPeriodoDiasCorridos(Date dataInicial, int diasCorridos){
        if (dataInicial == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicial);
        calendar.add(Calendar.DATE, diasCorridos);               
        return calendar.getTime();
    }
}

