package br.com.dba.timesheet.vo;

import java.io.Serializable;

/**
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */
public class Avaliacao_AtividadeVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Integer id;
    
    private String observacao;

    private String observacao_privada;
    
    private Situacao_AtividadeVO situacao_Atividade;
    
    private FuncionarioVO avaliador_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao_privada() {
        return observacao_privada;
    }

    public void setObservacao_privada(String observacao_privada) {
        this.observacao_privada = observacao_privada;
    }

    public Situacao_AtividadeVO getSituacao_Atividade() {
        return situacao_Atividade;
    }

    public void setSituacao_Atividade(Situacao_AtividadeVO situacao_Atividade) {
        this.situacao_Atividade = situacao_Atividade;
    }

    public FuncionarioVO getAvaliador_id() {
        return avaliador_id;
    }

    public void setAvaliador_id(FuncionarioVO avaliador_id) {
        this.avaliador_id = avaliador_id;
    }
	
}