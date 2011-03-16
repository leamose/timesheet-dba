package br.com.dba.timesheet.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="avaliacaoAtividade", schema="TS")
public class AvaliacaoAtividade implements POJO<Integer> {

    @Id
    @Column(name="codigoAvaliacaoAtividade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name="observacao")
    private String observacao;

    @Column(name="observacaoPrivada")
    private String observacaoPrivada;
    
    @Column(name="dataInicio")
    private Date dataInicio;
    
    @Column(name="dataFim")
    private Date dataFim; 
    
    @ManyToOne
    @JoinColumn(name="codigoTimeSheet")
	private TimeSheet timeSheet;

    @ManyToOne
    @JoinColumn(name="codigoSituacaoAtividade")
    private SituacaoAtividade situacaoAtividade;
	
    @ManyToOne
    @JoinColumn(name="codigoFuncionarioAvaliador")
	private Funcionario funcionarioAvaliador;

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

    public String getObservacaoPrivada() {
        return observacaoPrivada;
    }

    public void setObservacaoPrivada(String observacao_privada) {
        this.observacaoPrivada = observacao_privada;
    }

    public SituacaoAtividade getSituacaoAtividade() {
        return situacaoAtividade;
    }

    public void setSituacaoAtividade(SituacaoAtividade situacao_Atividade) {
        this.situacaoAtividade = situacao_Atividade;
    }

    public Funcionario getFuncionarioAvaliador() {
        return funcionarioAvaliador;
    }

    public void setFuncionarioAvaliador(Funcionario avaliador_id) {
        this.funcionarioAvaliador = avaliador_id;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the timeSheet
     */
    public TimeSheet getTimeSheet() {
        return timeSheet;
    }

    /**
     * @param timeSheet the timeSheet to set
     */
    public void setTimeSheet(TimeSheet timeSheet) {
        this.timeSheet = timeSheet;
    }
	
	
		

}