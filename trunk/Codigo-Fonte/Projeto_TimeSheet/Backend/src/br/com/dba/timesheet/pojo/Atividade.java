package br.com.dba.timesheet.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Projeto - TimeSheet
 * @author DBA Engenharia de Sistemas
 * @author CGTI
 * @author Fábio Oliveira de Pinho
 * @version 1.0
 */

@Entity
@Table(name="atividade", schema="DBA")
public class Atividade implements POJO<Integer> {

    @Id
    @Column(name="id", nullable=false)    
	private Integer id;
    
    @Column(name="atividade_original", nullable=false)  
	private Integer atividade_original;
    
    @Column(name="data_hora_inicio", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date data_hora_inicio;
    
    @Column(name="data_hora_fim", nullable=true)
    @Temporal(TemporalType.DATE)
    private Date data_hora_fim; 
    
    @Column(name="observacao")
    private String observacao;
    
    @Column(name="alteracao_data_avaliacao")    
    private Boolean alteracao_data_avaliacao;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tipo_atividade", nullable=false)    
	private Tipo_Atividade tipo_atividade;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="produto_servico", nullable=false)
	private Produto_Servico produto_servico;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="projeto")
	private Projeto projeto;		
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="metodologia", nullable=false)
	private Metodologia metodologia;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="op", nullable=false)
	private OP op;			
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="funcionario", nullable=false)
	private Funcionario funcionario;	
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente", nullable=false)
	private Cliente cliente;	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAtividade_original() {
		return atividade_original;
	}
	public void setAtividade_original(Integer atividade_original_id) {
		this.atividade_original = atividade_original_id;
	}
	public Tipo_Atividade getTipo_atividade() {
		return tipo_atividade;
	}
	public void setTipo_atividade(Tipo_Atividade tipo_atividade_id) {
		this.tipo_atividade = tipo_atividade_id;
	}
	public Produto_Servico getProduto_servico() {
		return produto_servico;
	}
	public void setProduto_servico(Produto_Servico produto_servico_id) {
		this.produto_servico = produto_servico_id;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto_id) {
		this.projeto = projeto_id;
	}
	public Metodologia getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(Metodologia metodologia_id) {
		this.metodologia = metodologia_id;
	}
	public OP getOp() {
		return op;
	}
	public void setOp(OP op_id) {
		this.op = op_id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente_id) {
		this.cliente = cliente_id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario_id) {
		this.funcionario = funcionario_id;
	}
	public Date getData_hora_inicio() {
		return data_hora_inicio;
	}
	public void setData_hora_inicio(Date data_hora_inicio) {
		this.data_hora_inicio = data_hora_inicio;
	}
	public Date getData_hora_fim() {
		return data_hora_fim;
	}
	public void setData_hora_fim(Date data_hora_fim) {
		this.data_hora_fim = data_hora_fim;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Boolean getAlteracao_data_avaliacao() {
		return alteracao_data_avaliacao;
	}
	public void setAlteracao_data_avaliacao(Boolean alteracao_data_avaliacao) {
		this.alteracao_data_avaliacao = alteracao_data_avaliacao;
	}	

}