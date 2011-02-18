package br.com.dba.timesheet.struts.validator;


public class Protocolo {
    
    /**
     * Esse método coloca máscara em um número de protocolo
     * @param numeroProtocolo
     * @return String
     */
	public static String colocaMascaraProtocolo(String numeroProtocolo) {
            String protocoloMascara = null;
            if (numeroProtocolo!=null){
                numeroProtocolo = numeroProtocolo.trim();
                if (numeroProtocolo.length()==17){
                    protocoloMascara = numeroProtocolo.substring(0,5)+"."+numeroProtocolo.substring(5,11)+"/"+numeroProtocolo.substring(11,15)+"-"+numeroProtocolo.substring(15,17);
                }else{
                    if (numeroProtocolo.length()==15){
                        protocoloMascara = numeroProtocolo.substring(0,5)+"."+numeroProtocolo.substring(5,11)+"/"+numeroProtocolo.substring(11,13)+"-"+numeroProtocolo.substring(13,15);
                    }else{
                        protocoloMascara = numeroProtocolo;
                    }
                }
            }
            return protocoloMascara;
    }
    
    /**
     * Esse método retira máscara em um número de protocolo
     * @param numeroProtocolo
     * @return String
     */
    public static String retiraMascaraProtocolo(String numero){
        String protocoloSemMascara = null;
        if (numero!=null){
            protocoloSemMascara = "";
            for (int i=0;i<numero.length();i++){
                if (Character.isLetterOrDigit(numero.charAt(i))){
                    protocoloSemMascara += numero.charAt(i);
                }
            }
        }
        return protocoloSemMascara;
    }        

    /**
     * Passado uma string com um numero de protocolo esse método verifica
     * se esse numero tem o digito verificar correto.
     * 
     * @param numeroProtocolo
     * @return boolean
     */
    public static boolean validaProtocolo(String numeroProtocolo){
        if (numeroProtocolo == null) {
            return false;
        }            
        boolean resposta=false;
        
        int tamanho = numeroProtocolo.length()-2;
        String aux = numeroProtocolo.substring(0,tamanho);
        
        for (int segundaVez=0;segundaVez<2;segundaVez++){
            int soma = 0;
            for (int i=0;i<tamanho;i++){
                soma += (Character.getNumericValue(aux.charAt(i)))*(tamanho-i+1);
            }
            soma= 11 - (soma % 11);
            if (soma > 9) { 
                soma -= 10; 
            }
            aux += String.valueOf(soma);
            tamanho++;
        }
        if (aux.substring(tamanho-2,tamanho).equals(numeroProtocolo.subSequence(tamanho-2,tamanho))){
            resposta=true;
        }
        return resposta;
    }
}
