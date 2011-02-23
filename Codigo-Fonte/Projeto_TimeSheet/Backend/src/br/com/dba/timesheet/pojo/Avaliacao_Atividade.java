package br.com.dba.timesheet.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */

@Entity
@Table(name="avaliacao_Atividade", schema="DBA")
public class Avaliacao_Atividade implements POJO<Integer> {

    @Id
    @Column(name="atividade_id", nullable=false)    
	private Integer id;
    
    @Column(name="observacao")
    private String observacao;

    @Column(name="observacao_privada")
    private String observacao_privada;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="situacao_Atividade", nullable=false)
	private Situacao_Atividade situacao_Atividade;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="avaliador_id")
	private Funcionario avaliador_id;

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

    public Situacao_Atividade getSituacao_Atividade() {
        return situacao_Atividade;
    }

    public void setSituacao_Atividade(Situacao_Atividade situacao_Atividade) {
        this.situacao_Atividade = situacao_Atividade;
    }

    public Funcionario getAvaliador_id() {
        return avaliador_id;
    }

    public void setAvaliador_id(Funcionario avaliador_id) {
        this.avaliador_id = avaliador_id;
    }
	
	
		

}