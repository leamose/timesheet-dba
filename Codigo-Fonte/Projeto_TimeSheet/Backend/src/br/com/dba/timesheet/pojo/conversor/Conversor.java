package br.com.dba.timesheet.pojo.conversor;

import java.io.Serializable;
import java.util.List;

import br.com.dba.timesheet.pojo.POJO;

/**
 * Interface que define o mecânismo de conversão entre POJO e VO. Cada POJO do sistema possuirá um
 * VO equivalente e um conversor, esse conversor será responsável conversão de POJO para VO e 
 * vice-versa. O objetivo é reduzir a quantidade de métodos que realizam essa tarefa e centralizar
 * essa atividade em um único ponto.
 * 
 * @author CGTI
 * @author Anderson Claiton Fernandes
 * @version 1.0
 */
public interface Conversor <Pojo extends POJO, Vo extends Serializable> {

    /**
     * Converto um POJO para um VO. É preciso ficar atento quanto a utilização do lazy, pois no 
     * caso pojo ainda está serializado (sessão do hibernate ativa), ele continuará a trazer os 
     * dados do banco. Por deve-se evitar a conversão de atributos de coleção do POJO.
     * 
     * @param pojo pojo a ser convertido.
     * 
     * @return instância do VO equivalente ao POJO.
     */
    public Vo converterPojoParaVo(Pojo pojo);

    /**
     * Converte um VO para um POJO.
     * 
     * @param vo vo a ser convertido.
     * 
     * @return instância do POJO equivalente ao VO.
     */
    public Pojo converterVoParaPojo(Vo vo);

    /**
     * Converte uma lista de POJOs para uma lista de VOs.
     * 
     * @param pojos lista de pojos a serem convertidos.
     * 
     * @return instância de lista contendo os VOs.
     */
    public List<Vo> converterListaPojoParaVo(List<Pojo> pojos);

    /**
     * Converte uma lista de VOs para uma lista de POJOs.
     * 
     * @param vos lista de vos a serem convertidos.
     * 
     * @return instância de lista contendo os POJOs.
     */
    public List<Pojo> converterListaVoParaPojo(List<Vo> vos);
}
