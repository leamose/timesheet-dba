package br.com.dba.timesheet.teste;

public class TesteHoras {
   
    public static void main(String args[]){  
   
       String hora1    = "23:05:46";  
       String hora2    = "00:00:00";  
   
       String horas    = "00";  
       String minutos  = "00";  
       String segundos = "00";  
         
       int sub       = 0;  
       int subHoras    = 0;  
       int subMinutos    = 0;  
   
       int segundos1    = (Integer.parseInt(hora1.substring(0,2))*3600)+(Integer.parseInt(hora1.substring(3,5))*60)+Integer.parseInt(hora1.substring(6,8));     
       int segundos2    = (Integer.parseInt(hora2.substring(0,2))*3600)+(Integer.parseInt(hora2.substring(3,5))*60)+Integer.parseInt(hora2.substring(6,8));     
         
       if (segundos1 > segundos2)  {  
          sub = segundos1 + segundos2;  
       }else if (segundos2 > segundos1){  
          sub = segundos2 + segundos1;  
       }else{  
          sub = 0;  
       }  
   
       if ( sub >= 3600){  
          subHoras = (sub-(sub%3600))/3600;  
          sub = sub - (subHoras*3600);  
          if (subHoras < 10){  
             horas = "0"+Integer.toString(subHoras);  
          }else{  
             horas = Integer.toString(subHoras);  
          }  
       }  
   
       if ( sub >= 60){  
          subMinutos = (sub-(sub%60))/60;  
          sub = sub - (subMinutos*60);  
          if (subMinutos < 10){  
             minutos = "0"+Integer.toString(subMinutos);  
          }else{  
             minutos = Integer.toString(subMinutos);  
          }  
       }  
   
   
       if (sub < 10){  
          segundos = "0"+Integer.toString(sub);  
       }else{  
          segundos = Integer.toString(sub);  
       }  
   
       System.out.println("HH:MM:SS : "+horas+":"+minutos+":"+segundos);  
     
    }	  
}
