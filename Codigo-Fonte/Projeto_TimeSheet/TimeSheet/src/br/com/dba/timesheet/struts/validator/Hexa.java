package br.com.dba.timesheet.struts.validator;

public class Hexa {
    public static String byteArrayToHex(byte[] bytes) {
        String retorno = "";
        if (bytes==null || bytes.length==0) {
         return retorno;
        }
        for (int i=0; i<bytes.length; i++) {
         byte valor = bytes[i];
         int d1 = valor & 0xF;
         d1 += (d1 < 10) ? 48 : 55;
         int d2 = (valor & 0xF0) >> 4;
         d2 += (d2 < 10) ? 48 : 55;
         retorno = retorno + (char)d2 + (char)d1;
        }
        return retorno;
    }
    public static byte[] hexToByteArray(String hexa)  {
        if (hexa == null) {
            
        }
        if ((hexa.length() % 2) != 0) {
            
        }
        int tamArray = hexa.length() / 2;
        byte[] retorno = new byte[tamArray];
        for (int i=0; i<tamArray; i++) {
            retorno[i] = hexToByte(hexa.substring(i*2,i*2+2));
        }
        return retorno;
    }
    private static byte hexToByte(String hexa) {
        if (hexa == null) {

        }
        if (hexa.length() != 2) {
        
        }
        byte[] b = hexa.getBytes();
        byte valor = (byte) (hexDigitValue((char)b[0]) * 16 +
                                hexDigitValue((char)b[1]));
        return valor;
    }
    private static int hexDigitValue(char c)  {
        int retorno = 0;
        if (c>='0' && c<='9') {
            retorno = (int)(((byte)c) - 48);
        }
        else if (c>='A' && c<='F') {
            retorno = (int)(((byte)c) - 55);
        }
        else if (c>='a' && c<='f') {
            retorno = (int)(((byte)c) - 87);
        }

        return retorno;
    }
    public static String byteArrayToString(byte[] bytes){
        String retorno ="";
        for(int x=0; x<bytes.length;x++){
            char t = (char) bytes[x];
            retorno = retorno + t;
        }
        return retorno;
    }

}
