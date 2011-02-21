package br.com.dba.timesheet.web.form;

import java.sql.Date;

import org.apache.struts.validator.ValidatorForm;

public class AtividadesForm extends ValidatorForm {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer atividade_original_id;
	
	private Integer tipo_atividade_id;
	
	private Integer projeto_id;
	
	private Integer metodologia_id;
	
	private Integer op_id;
	
	private Integer cliente_id;
	
	private Integer funcionario_id;
	
	private Date data_hora_inicio;
	
	private Date data_hora_fim;
		
	private String observacao;
	
	private Boolean alteracao_data_avaliacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAtividade_original_id() {
		return atividade_original_id;
	}
	public void setAtividade_original_id(Integer atividade_original_id) {
		this.atividade_original_id = atividade_original_id;
	}
	public Integer getTipo_atividade_id() {
		return tipo_atividade_id;
	}
	public void setTipo_atividade_id(Integer tipo_atividade_id) {
		this.tipo_atividade_id = tipo_atividade_id;
	}
	public Integer getProjeto_id() {
		return projeto_id;
	}
	public void setProjeto_id(Integer projeto_id) {
		this.projeto_id = projeto_id;
	}
	public Integer getMetodologia_id() {
		return metodologia_id;
	}
	public void setMetodologia_id(Integer metodologia_id) {
		this.metodologia_id = metodologia_id;
	}
	public Integer getOp_id() {
		return op_id;
	}
	public void setOp_id(Integer op_id) {
		this.op_id = op_id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Integer getFuncionario_id() {
		return funcionario_id;
	}
	public void setFuncionario_id(Integer funcionario_id) {
		this.funcionario_id = funcionario_id;
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
