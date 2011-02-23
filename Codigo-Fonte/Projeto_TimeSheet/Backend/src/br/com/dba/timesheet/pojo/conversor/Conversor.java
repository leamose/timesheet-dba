package br.com.dba.timesheet.pojo.conversor;

import java.io.Serializable;
import java.util.List;

import br.com.dba.timesheet.pojo.POJO;

/**
 * Interface que define o mec�nismo de convers�o entre POJO e VO. Cada POJO do sistema possuir� um
 * VO equivalente e um conversor, esse conversor ser� respons�vel convers�o de POJO para VO e 
 * vice-versa. O objetivo � reduzir a quantidade de m�todos que realizam essa tarefa e centralizar
 * essa atividade em um �nico ponto.
 * 
 * @author CGTI
 * @author Anderson Claiton Fernandes
 * @version 1.0
 */
public interface Conversor <Pojo extends POJO, Vo extends Serializable> {

    /**
     * Converto um POJO para um VO. � preciso ficar atento quanto a utiliza��o do lazy, pois no 
     * caso pojo ainda est� serializado (sess�o do hibernate ativa), ele continuar� a trazer os 
     * dados do banco. Por deve-se evitar a convers�o de atributos de cole��o do POJO.
     * 
     * @param pojo pojo a ser convertido.
     * 
     * @return inst�ncia do VO equivalente ao POJO.
     */
    public Vo converterPojoParaVo(Pojo pojo);

    /**
     * Converte um VO para um POJO.
     * 
     * @param vo vo a ser convertido.
     * 
     * @return inst�ncia do POJO equivalente ao VO.
     */
    public Pojo converterVoParaPojo(Vo vo);

    /**
     * Converte uma lista de POJOs para uma lista de VOs.
     * 
     * @param pojos lista de pojos a serem convertidos.
     * 
     * @return inst�ncia de lista contendo os VOs.
     */
    public List<Vo> converterListaPojoParaVo(List<Pojo> pojos);

    /**
     * Converte uma lista de VOs para uma lista de POJOs.
     * 
     * @param vos lista de vos a serem convertidos.
     * 
     * @return inst�ncia de lista contendo os POJOs.
     */
    public List<Pojo> converterListaVoParaPojo(List<Vo> vos);
}
