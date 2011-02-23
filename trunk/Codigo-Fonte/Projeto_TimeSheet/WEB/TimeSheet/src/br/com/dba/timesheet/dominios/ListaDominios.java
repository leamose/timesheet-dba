/*
 * Classname:			ListaDominios.java
 * Version:				$Revision: 1.0
 * Date:				11/07/2005
 * 
 * Ministério da Justiça - Todos os direitos reservados
 */
package br.com.dba.timesheet.dominios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class ListaDominios {

    private final String DIAS_SEMANA = "/br/com/dba/timesheet/dominios/properties/diasSemana.properties"; 
    private final String TIPO_ATIVIDADES = "/br/com/dba/timesheet/dominios/properties/tipoAtividades.properties";    
    private final String ATIVIDADES = "/br/com/dba/timesheet/dominios/properties/atividades.properties";    
    
	/**
     * @return lista de Dias da semana 
     * @throws IOException 
     */
    public final List<Dominio> getListaDiasDaSemana() throws IOException {
        return geraLista(loadProperties(DIAS_SEMANA));
    }
    /**
     * @return lista de TipoAtividades 
     * @throws IOException 
     */
    public final List<Dominio> getListaTipoAtividades() throws IOException {
        return geraLista(loadProperties(TIPO_ATIVIDADES));
    }
    /**
     * @return lista de Atividades 
     * @throws IOException 
     */
    public final List<Dominio> getListaAtividades() throws IOException {
        return geraLista(loadProperties(ATIVIDADES));
    }
    
    private Properties loadProperties(String nomeArquivoProperties) throws IOException {
    	Properties arqProperties = new Properties();
        arqProperties.load(this.getClass().getResourceAsStream(nomeArquivoProperties));   
        return arqProperties;
    }

    @SuppressWarnings("unchecked")
    public static List<Dominio> geraLista(Properties arqProperties) {
    	List<Dominio> retorno = new ArrayList<Dominio>();
        for (Iterator it=arqProperties.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry)it.next();
            Dominio dominio = new Dominio();
            dominio.setCodigo(entry.getKey().toString());
            dominio.setDescricao(entry.getValue().toString());
            retorno.add(dominio);
        }
        Collections.sort(retorno);
        return retorno; 
    }    
   
}
